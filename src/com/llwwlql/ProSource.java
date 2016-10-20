package com.llwwlql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ProSource {

	private static HttpClient httpclient = new DefaultHttpClient();

	private String Url = null;

	public ProSource() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ProSource(String URL) {
		super();
		this.Url = URL;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	/**
	 * 
	 * @param url
	 * @param fileName
	 * @throws ClientProtocolException
	 * @throws IOException
	 * 用于获取网页题目源码
	 */
	public void doGetPro(String url,String fileName) throws ClientProtocolException,
			IOException {
		Url = url;
		HttpGet httget = new HttpGet(Url);
		HttpResponse response = httpclient.execute(httget);
		if (response != null) {
			HttpEntity entity = response.getEntity();
			String strResult = EntityUtils.toString(entity, "UTF-8");
			//System.out.println(strResult);
			OutputStreamWriter pw = null;
			pw = new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8");
			pw.write(strResult);
			pw.close();
			EntityUtils.consume(entity);
		} else {
			System.out.println("获取失败！");
		}
		httget.abort();
	}
}
