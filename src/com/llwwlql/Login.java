package com.llwwlql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Login {
	/**
	 * user_id1:�û���;
	 * password1:���� ;
	 * B1:post״̬��login��;
	 * url:post���ӣ�submit?problem_id=1166��Ϊhost�����url��Ĭ��BASEURL+problem_id;
	 * problem_id:���;
	 * SCHARSET:Ĭ��post�ַ���;
	 * BASEURL:Ĭ�ϵ�ַ;
	 * ��ֵ��Ҫ���룬�û������������ż���
	 */
	private String user_id1;
	private String password1;
	private String url;
	private String loginUrl;
	private String problem_id;
	private static String B1= "login";
	private static String BASEURL = "submit?problem_id=";
	private static String BASELOGINURL = "http://poj.org/login?problem_id=";
	private static String SCHARSET = "GB2312";
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String problem_id) {
		this.loginUrl = BASELOGINURL + problem_id;
	}
	public String getUser_id1() {
		return user_id1;
	}
	public void setUser_id1(String userId1) {
		user_id1 = userId1;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String problem_id) {
		this.url = BASEURL + problem_id;
	}
	public void setProblem_id(String problem_id) {
		this.problem_id = problem_id;
		setLoginUrl(problem_id);
		setUrl(problem_id);
	}
	public String getProblem_id() {
		return problem_id;
	}
	/**
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * �û��ĵ�¼���������ص�½����ת����ҳ
	 */
	public Login() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Login(String user_id , String password_id,String problem_id){
		super();
		setUser_id1(user_id);
		setPassword1(password_id);
		setProblem_id(problem_id);
	}
	public String PostLogin() throws ClientProtocolException, IOException{
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(loginUrl);
		List <NameValuePair> nvp = new ArrayList<NameValuePair>();
		nvp.add(new BasicNameValuePair("user_id1", this.user_id1));
		nvp.add(new BasicNameValuePair("password1", this.password1));
		nvp.add(new BasicNameValuePair("B1", this.B1));
		nvp.add(new BasicNameValuePair("url", this.url));
		httpost.setEntity(new UrlEncodedFormEntity(nvp,this.SCHARSET));
		HttpResponse response = httpclient.execute(httpost);
		String location = null;
		if(response.getStatusLine().getStatusCode()==302)
		{
			location = response.getFirstHeader("Location").getValue();
		}
		else
		{
			System.out.println("��¼ʧ�ܣ�");
		}
		httpost.abort();
		return location;
	}
}
