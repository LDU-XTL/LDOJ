package com.llwwlql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class CodeSubmit {
	/**
	 * problem_id:题号 language:语言（0、1、2....） ;
	 * source:代码 ;
	 * submit:提交，值为(Submit);
	 * encoded:未知; 
	 */
	private String problem_id;
	private String language;
	private String source;
	private static String submit = "Submit";
	private static String encoded="1";
	private static String SCHARSET = "GB2312";
	private static String STATUSUTL="http://poj.org/status?problem_id=&user_id=";
	private static HttpClient httpclient = new DefaultHttpClient();

	public String getProblem_id() {
		return problem_id;
	}

	public void setProblem_id(String problemId) {
		problem_id = problemId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSource() {
		return source;
	}
	/**
	 * 
	 * @param fileName
	 * 从文件中获取Source源码
	 */
	public CodeSubmit() {
		// TODO Auto-generated constructor stub
		super();
	}
	public CodeSubmit(String problem_id,String language) {
		// TODO Auto-generated constructor stub
		super();
		setProblem_id(problem_id);
		setLanguage(language);
	}

	public void setSource(String fileName) {
		StringBuffer Source = new StringBuffer();
		try {
			String temp = null;
		    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));  
		    while ((temp = br.readLine()) != null) {  
		    	Source.append(temp);
		    	Source.append('\n');
		    }
		    br.close();
		    this.source = UseBase64.encode(Source.toString().getBytes());
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param URL
	 * @throws ClientProtocolException
	 * @throws IOException
	 * 根据URL提交代码
	 */
	
	public void Submit(String URL) throws ClientProtocolException, IOException {
		HttpPost httpost = new HttpPost(URL);
		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
		nvp.add(new BasicNameValuePair("problem_id", this.problem_id));
		nvp.add(new BasicNameValuePair("language", this.language));
		nvp.add(new BasicNameValuePair("source", this.source));
		nvp.add(new BasicNameValuePair("submit", this.submit));
		nvp.add(new BasicNameValuePair("encoded", this.encoded));
		httpost.setEntity(new UrlEncodedFormEntity(nvp, this.SCHARSET));
		HttpResponse response = httpclient.execute(httpost);
		if(response.getStatusLine().getStatusCode()==302)
		{
			System.out.println("提交代码成功！");
		}
		else
		{
			System.out.println("提交代码失败！");
		}
		httpost.abort();
	}
	/**
	 * @return 返回网页源码字符串，获取失败时返回null
	 * @param Url
	 * @throws ClientProtocolException
	 * @throws IOException
	 * 获取提交结果的网页源码，存到fileName文件里
	 * fileName默认路径为：\GetSubmitResult\GetResult.txt
	 */
	public String GetResult(String Url) throws ClientProtocolException, IOException{
		HttpGet httpget = new HttpGet(Url);
		HttpResponse response = httpclient.execute(httpget);
		String strResult = null;
		if(response!=null)
		{
			HttpEntity entity = response.getEntity();
			strResult = EntityUtils.toString(entity,"UTF-8");
			EntityUtils.consume(entity);
		}
		else
		{
			System.out.println("获取失败！");
		}
		httpget.abort();
		return strResult;
	}

	public static String getSTATUSUTL() {
		return STATUSUTL;
	}

	public static void setSTATUSUTL(String sTATUSUTL) {
		STATUSUTL = sTATUSUTL;
	}
}
