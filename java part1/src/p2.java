import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class p2 {
	static class car{
		long id;
		double  longitude;
		double  latitude;
		String time;
		
	}
	
	static class car2{
	
		long id;
		String streetname;
		int number;
		
	}
	
	 
	
	
	
	public static void main(String[] args) throws IOException{
		car []save=new car[10000];
		car2 []save2=new car2[10000];
		
		//save[0]=new car(;
		//car付初始值
		for(int n=0;n<10000;n++){	
			save[n]=new car();
		}
		
		for(int n=0;n<10000;n++){	
			save2[n]=new car2();
		}
		
		//car变car1
		save[0].longitude=116.9001846;
		save[0].latitude=40.1061974;
		save[0].id=111;
		save[0].time="111111112222";
		String tmp1=Double.toString(save[0].longitude);
		String tmp2=Double.toString(save[0].latitude);
		String tmp3="http://api.map.baidu.com/geocoder/v2/?ak=EB77c29b7b9800e5804ef458fbf3ac67&location=";
		String tmp4="&output=json&pois=0";
		String urlStr=tmp3+tmp2+","+tmp1+tmp4;
		
        
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
       System.out.println(json.toString());  
			 
		        //查看json格式  
		        System.out.println(json.toString());  
		        //获取json中某个对象  
		        JSONObject obj = (JSONObject) json.get("result");  
		        System.out.println(obj.toString());  
		        //获取对象中某个属性的值  
		        JSONObject obj2 = (JSONObject) obj.get("addressComponent"); 
		        //JSONObject obj3 = (JSONObject) obj2.get("lng"); 
		        String val = obj2.getString("street");  
		        System.out.println(val);   
		
		        
		  save2[0].id=save[0].id;      
		  save2[0].streetname=val;
		  String ppp=save[0].time.substring(9,12);
		  save2[0].number=Integer.parseInt(ppp);
		   int ppp1=save2[0].number%10;    
		   int ppp2= (save2[0].number/10)%10;      
		   int ppp3= (save2[0].number/100)%10;
		   int ppp4= (save2[0].number/1000)%10;
		   ppp1=(ppp1+ppp2*10)/15;
		   ppp3=ppp3+ppp4*10;
		    save2[0].number=ppp3*4+ppp1;  
		    
		        
		        
	}
		
		
		
	
}
