

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;

import net.sf.json.JSONObject;

  
public class TestRead {  
      
    /** 
     * ����csv�ļ���������ת����sql��� 
     * @param csv 
     * @return 
     * @throws FileNotFoundException  
     */ 
	/**
	 *                    _ooOoo_
	 *                   o8888888o
	 *                   88" . "88
	 *                   (| -_- |)
	 *                    O\ = /O
	 *                ____/`---'\____
	 *              .   ' \\| |// `.
	 *               / \\||| : |||// \
	 *             / _||||| -:- |||||- \
	 *               | | \\\ - /// | |
	 *             | \_| ''\---/'' | |
	 *              \ .-\__ `-` ___/-. /
	 *           ___`. .' /--.--\ `. . __
	 *        ."" '< `.___\_<|>_/___.' >'"".
	 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
	 *         \ \ `-. \_ __\ /__ _/ .-` / /
	 * ======`-.____`-.___\_____/___.-`____.-'======
	 *                    `=---='
	 *
	 * .............................................
	 *          ���汣��             ����BUG
	 */
	static class streettable{
		String streetname;
		int []number=new int[96];
		streettable(){
			streetname="";
			for(int ewq=0;ewq<96;ewq++){
				number[ewq]=0;
			}
		}
		public void changename(String p){
			this.streetname=p;
		}
	}
	
	
	
	static class car2{
	
		long id;
		String streetname;
		int number;
		
	}
	
	public static class CabInformation {
		 long newId;
		 int listId;
		 String carName;
		 long carId;
		 long detailTime;
		 double longitude;
		 double latitude;
		 String streetBegin;
		 String streetEnd;
		 int speed;
		 int angle;
		 int status;
		 int event;
		 String altitude;
		 public CabInformation() {
			super();
			// TODO Auto-generated constructor stub
		 }
		 public CabInformation(long newId, int listId, String carName, long carId,
					long detailTime, double longitude, double latitude,
					String streetBegin, String streetEnd, int speed, int angle,
					int status, int event, String altitude) {
				super();
				this.newId = newId;
				this.listId = listId;
				this.carName = carName;
				this.carId = carId;
				this.detailTime = detailTime;
				this.longitude = longitude;
				this.latitude = latitude;
				this.streetBegin = streetBegin;
				this.streetEnd = streetEnd;
				this.speed = speed;
				this.angle = angle;
				this.status = status;
				this.event = event;
				this.altitude = altitude;
			}
	}
    public static List<String> csv2sql(String csv) throws FileNotFoundException {  
  
        //�洢sql���  
        List<String> sqls = new ArrayList<String>();  
          
        //ȡ��csv�ļ����ƣ�csv�ļ����ƣ���������  
        File csvfile = new File(csv);  
        String table_name = csvfile.getName();  
          
        //ȥ���ļ���׺  
        if (table_name.contains(".")) {  
            table_name = table_name.substring(0, table_name.indexOf("."));  
        }  
          
        //ɨ�������������б���csv�ļ����ݣ�������jdk5��ʼ�ṩ��  
        //����ȷָ�����룬����������ʱ������������ȡ��  
        Scanner scanner = new Scanner(csvfile,"GBK");  
          
        //����ɨ�����ķָ������粻���ã�Ĭ��ʹ�ÿո���зָ  
        //�˴����÷ָ���Ϊ�����з���,��һ�ζ�һ�С�  
        scanner.useDelimiter("\\n");  
  
        //��������  
        String column_names[] = null;  
        int column_count = 0;  
          
        //ÿ��sqlǰ�벿������ͬ�ġ�  
//        StringBuilder header = new StringBuilder("insert into " + table_name + " ("); 
        StringBuilder header = new StringBuilder("");  

  
        //��ȡ��һ�У���һ����������  
//        if(scanner.hasNext()){  
//            String first_line = scanner.next();  
//            column_names = first_line.split(",");  
//            column_count = column_names.length;  
//            for (int j = 0; j < column_names.length; j++) {  
//                header.append(column_names[j].trim()).append(",");  
//            }  
//            header.deleteCharAt(header.length() - 1);  
//            header.append(")");  
//          
//        }  
        //����ɨ�������������  
        while (scanner.hasNext()) {  
            StringBuilder sql = new StringBuilder(header);  
            String line = scanner.next();  
            String values[] = line.split(",");  
              
            // ��ǰ�������в��������ţ��ָ������⣩�������������´����  
            if (column_count == values.length) {  
//                sql.append(" values(");  
                for (int j = 0; j < values.length; j++) {  
                    String value = values[j];  
                      
                    // ÿ�����һ��Ԫ�أ�ȥ��ĩ�˻��з�(\r\n)  
                    if (j == column_count - 1) {  
                        value = value.replaceAll("\r|\n", "");  
                    }  
                    sql.append(value);  
                    sql.append(",");  
                }  
                sql.deleteCharAt(sql.length() - 1);  
//                sql.append(")");  
            } else {  
                // ��ǰ����������Ҳ�������ŵĳ���  
//                sql.append(" values(");  
                for (int j = 0; j < values.length; j++) {  
                    String true_value = null;  
                    String value = values[j];  
                      
                    // ���һ��Ԫ�أ�ȥ��ĩ�˻��з�(\r\n)  
                    if (j == values.length - 1) {  
                        value = value.replaceAll("\r|\n", "");  
                    }  
                      
                    //�����ǰԪ�ص�ֵ��˫���Ŵ�ͷ����Ҫ��һ��ϸ������  
                    if (value.startsWith("")) {  
                          
                        //�����ǰԪ�ص�ֵҲ��"��β��������\"��β�����Ԫ�ص�ֵ����Ϊ��������ֵ��  
                        if (value.endsWith("") && !value.endsWith("\\")) {  
                            true_value = value;  
                        } else {  
                            //����...  
                            while (true) {  
                                j++;  
                                if (j == values.length) {  
                                    break;  
                                }  
                                value = value + "," + values[j];  
                                  
                                // ���һ��Ԫ�أ�ȥ��ĩ�˻��з�(\r\n)  
                                if (j == values.length - 1) {  
                                    value = value.replaceAll("\r|\n", "");  
                                }  
                                  
                                if (values[j].endsWith("") && !value.endsWith("\\")) {  
                                    true_value = value;  
                                    break;  
                                }  
                            }  
                        }  
                    } else {  
                        //�����ǰԪ�ص�ֵ����˫���Ŵ�ͷ�����Ԫ�ص�ֵһ����������ֵ��  
                        true_value = value;  
                    }  
                    sql.append(true_value);  
                    sql.append(",");  
                }  
                sql.deleteCharAt(sql.length() - 1);  
//                sql.append(")"); 
                sql.append("");
            }  
            sqls.add(sql.toString());  
        }  
        // �ر�ɨ����  
        if (scanner != null) {  
            scanner.close();  
        }  
        return sqls;  
    }  
      
    public static void main(String[] args) throws IOException {  
         
   
    	
    	
    	
    	
    	
        String path = "/Users/guoyihao/Desktop/testdata/chart5.csv";  
        List<String> sqls = csv2sql(path);
//        System.out.print(sqls.get(0));
//        String tmp1=sqls.get(0);
//        String tmp3=tmp1.substring(0,1);
//        System.out.print(tmp3+"mmm");
        CabInformation []save=new  CabInformation[1000]; 
        for(int n=0;n<1000;n++){	
			save[n]=new CabInformation();
		}
        
        for(int tmwp=0;tmwp<200;tmwp++){
        	String ppw="";
        String tmp1=sqls.get(tmwp);
       
    int number=0;
        for(int tmp2=0;tmp2<tmp1.length();tmp2++){
        	String tmp3=tmp1.substring(tmp2, tmp2+1);
        	if(tmp3.equals(",")){
        		if(number==0){
            		save[tmwp].listId=Integer.valueOf(ppw);
            	}
        		if(number==1){
            		//save[tmwp].newId=Long.valueOf(ppw);
            	}
        		if(number==2){
            		save[tmwp].carId=Long.valueOf(ppw);
            	}
        		if(number==3){
            		save[tmwp].detailTime=Long.valueOf(ppw);
            	}
        		if(number==4){
            		save[tmwp].longitude=Double.valueOf(ppw);
            	}
        		if(number==5){
            		save[tmwp].latitude=Double.valueOf(ppw);
            	}
        		if(number==6){
            		save[tmwp].streetBegin=ppw;
            	}
        		if(number==7){
        			save[tmwp].streetEnd=ppw;
            	}
        		if(number==8){
            		save[tmwp].speed=Integer.valueOf(ppw);
            	}
        		if(number==9){
            		save[tmwp].angle=Integer.valueOf(ppw);
            	}
        		if(number==10){
            		save[tmwp].status=Integer.valueOf(ppw);
            	}
        		if(number==11){
            		save[tmwp].event=Integer.valueOf(ppw);
            	}
        		if(number==12){
            		save[tmwp].altitude=ppw;
            	}
        		number++;
        		ppw="";
        	}
        	if(!tmp3.equals(",")){
        		
        	
        	ppw+=tmp3;
        	}
        	System.out.println(ppw);
        	
        	
        	 
        }
        
        }
       
        
        
      /////  
       // car []save=new car[10000];
		car2 []save2=new car2[1000];
		
		//save[0]=new car(;
		//car付初始值
		
		int allnumber=0;
		for(int n=0;n<1000;n++){	
			save2[n]=new car2();
		}
		
		//car变car1//煸锅煸锅煸锅煸锅
		for(int qwp=0;qwp<100 ;qwp++){
		String tmp1=Double.toString(save[qwp].longitude);
		String tmp2=Double.toString(save[qwp].latitude);
		String tmp3="http://api.map.baidu.com/geocoder/v2/?ak=aj7h7FcKBlpwoAeADYnfYmDt9u7b1kxF&location=";
		String tmp4="&output=json&pois=0";
		String urlStr=tmp3+tmp2+","+tmp1+tmp4;
		System.out.println("号"+qwp);
		System.out.println("经:"+save[qwp].longitude);
		System.out.println(save[qwp].latitude);
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
		if(!val.equals("")){
		        
		  save2[allnumber].id=save[qwp].carId;      
		  save2[allnumber].streetname=val;
		  String qpw=String.valueOf(save[qwp].detailTime);
		  String ppp=qpw.substring(8,12);
		  System.out.println("时间"+ppp);  
		  save2[allnumber].number=Integer.parseInt(ppp);
		  
		  
		  
		   int ppp3=Integer.valueOf(qpw.substring(8,10));
		   int ppp1=Integer.valueOf(qpw.substring(10,12));
		  
		    save2[allnumber].number=ppp3*4+ppp1/15;  
		    
		    System.out.println(save2[allnumber].streetname);      
		    System.out.println(save2[allnumber].number);   
		    allnumber++;
		}
		}
		//煸锅煸锅煸锅煸锅
		for(int oip=1;oip<allnumber;oip++){
			System.out.println("街道men："+save2[oip].streetname+"号码加一men："+save2[oip].number); 
		}
		long oldid=0;
		String oldstreet="";
		int oldnumber=-1;	
		
		
		streettable []save3=new streettable[2000];
		   for(int n=0;n<2000;n++){	
				save3[n]=new streettable();
			}
		    	int allstreetnumber=0;
		    	
	for(int yew=0;yew<allnumber;yew++){
	
	if(oldid!=save2[yew].id||oldstreet!=save2[yew].streetname||oldnumber!=save2[yew].number){
	int rewq=0;
	for(int ppo=0;ppo<(allstreetnumber+1);ppo++){
		if(save2[yew].streetname.equals(save3[ppo].streetname)){
			break;
		}
			rewq++;
		}
	if(rewq==(allstreetnumber+1)){
		allstreetnumber++;
		save3[allstreetnumber].changename(save2[yew].streetname);
		save3[allstreetnumber].number[save2[yew].number]++;
		 System.out.println("街道："+save3[allstreetnumber].streetname+"第几个"+save2[yew]+"号码为："+save3[allstreetnumber].number[save2[yew].number]);    
		 System.out.println(allstreetnumber);
	}
	if(rewq!=(allstreetnumber+1)){
		save3[rewq].number[save2[yew].number]++;
		System.out.println("街道："+save3[allstreetnumber].streetname+"第几个"+save2[yew].number+"号码为："+save3[allstreetnumber].number[save2[yew].number]); 
		 System.out.println(allstreetnumber);
	}
	}
	
	
    oldid=save2[yew].id;
	oldstreet=save2[yew].streetname;
	oldnumber=save2[yew].number;
		
	}
	System.out.println(allstreetnumber);
	
	
	for(int ret9=1;(ret9<allstreetnumber+1);ret9++){
		System.out.println(save3[ret9].streetname);
    	for(int ret8=0;ret8<96;ret8++){
    		System.out.println(save3[ret9].number[ret8]);
    		
    	}
    	System.out.println("\n");
    }
	
	
	
	try {    
        
		 PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/Users/guoyihao/Desktop/file4.csv")),true);     
//        reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉   
        
        String last="";
      
        
        for(int ret=1;ret<(allstreetnumber+1);ret++){
        	last+=save3[ret].streetname+",";
        	for(int ret2=0;ret2<96;ret2++){
        		last+=String.valueOf(save3[ret].number[ret2])+",";
        	}
        	//last+="\n";
       //	System.out.println(last); 
    	pw.println(last);
      	last="";
       }
       
       
        
        
      
      //BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加   
      // 添加新的数据行   
     // bw.write(last); 
      //bw.newLine();
      
          
            
    } catch (Exception e) {    
        e.printStackTrace();    
    }
		
		
		
    
    }
        
        
        
        
        
        
        
        
        
      
    
public static int f(CabInformation a){
		
		double Longitude=a.longitude;
		double Latitude =a.latitude;
		int speed=a.speed;
		int state=a.status;
		
		
		//�������ʵ�㣬
		double b1=118;//����
		double b2=114;//��С
		double c1=45;//γ��
		double c2=35;//γС
		
		if(Longitude>b1||Longitude<=b2||Latitude>=c1||Latitude<=c2)
		{
			return 0;
		}
		
		//���ٵ㣨>90km/h)
		if(speed>=90){
			return 0;
		}
		//��ʻ
//		if(state==0){
//			return 0;
//		}
//		
		//
		
		return 1;
		
		
	}
}  