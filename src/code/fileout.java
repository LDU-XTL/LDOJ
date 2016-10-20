package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class fileout {
	public fileout() {
		// TODO Auto-generated constructor stub
	}
	public fileout(String str,String url,int count)
	{	
		OutputStreamWriter pw = null;
		try {
		    File file =new File(url);    
		    if  (!file .exists()  && !file .isDirectory())      
		    {       
		        file .mkdir();    
		    }  
		    url=url+"/"+String.valueOf(count+1)+".txt";
			pw = new OutputStreamWriter(new FileOutputStream(url),"UTF-8");
			pw.write(str);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	  public static String readTxtFile(String filePath){
		  String lineTxt = null;
	        try {
	        		
	                String encoding="utf-8";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //判断文件是否存在
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file),encoding);//考虑到编码格式
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    while((bufferedReader.readLine()) != null){
	                      
	                    }
	                    read.close();
	                
	        }else{
	            System.out.println("找不到指定的文件");
	        }
	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
	        return lineTxt;
	     
	    }
}
