import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.Spring;

import net.sf.json.JSONObject;

public class aa2 {

	
	
	
	
	
	public static void main(String[] args) throws IOException{
		
		
		for(int twp=0;twp<1000;twp++){
		String urlStr="http://api.map.baidu.com/geocoder/v2/?ak=aj7h7FcKBlpwoAeADYnfYmDt9u7b1kxF&location=31.298247284063569,120.66298796130684&output=json&pois=0";
		
		                       
        //链接URL  
        URL url=new URL(urlStr);  
        //返回结果集  
        StringBuffer document = new StringBuffer();  
        //创建链接  
       URLConnection conn = url.openConnection();  
       //读取返回结果集  
       BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));  
       String line = null;  
       while ((line = reader.readLine()) != null){  
             document.append(line);  
       }     
           reader.close();  
       System.out.println(document);     
       JSONObject json =JSONObject.fromObject(document.toString());  
       //查看json格式  
      // System.out.println(json.toString());  
			 
		        //查看json格式  
		        //System.out.println(json.toString());  
		        //获取json中某个对象  
		        JSONObject obj = (JSONObject) json.get("result");  
		        //System.out.println(obj.toString());  
		        //获取对象中某个属性的值  
		        JSONObject obj2 = (JSONObject) obj.get("location"); 
		        //JSONObject obj3 = (JSONObject) obj2.get("lng"); 
		        String val = obj2.getString("lng");  
		      //  System.out.println(val);   
		        
	}
	}
	
}
	
	
	

