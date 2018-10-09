
import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;

import p2.car;  
  
public class c3 {  
	public class CabInformation {
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
		
			
		}
    
    public static List<String> csv2sql(String csv) throws FileNotFoundException {  
  
     
        List<String> sqls = new ArrayList<String>();  
        CabInformation []save=new  CabInformation[1000]; 
        for(int n=0;n<1000;n++){	
			save[n]=new CabInformation();
		}
        
        File csvfile = new File(csv);  
        String table_name = csvfile.getName();  
          
      
        if (table_name.contains(".")) {  
            table_name = table_name.substring(0, table_name.indexOf("."));  
        }  
          
        Scanner scanner = new Scanner(csvfile,"GBK");  
       
        scanner.useDelimiter("\\n");  
  
        String column_names[] = null;  
        int column_count = 0;  
          
      ; 
        StringBuilder header = new StringBuilder("");  
  
         
        while (scanner.hasNext()) {  
            StringBuilder sql = new StringBuilder(header);  
            String line = scanner.next();  
            String values[] = line.split(",");  
          
            if (column_count == values.length) {  

                for (int j = 0; j < values.length; j++) {  
                    String value = values[j];  
                      
                    if (j == column_count - 1) {  
                        value = value.replaceAll("\r|\n", "");  
                    }  
                    sql.append(value);  
                    sql.append(",");  
                }  
                sql.deleteCharAt(sql.length() - 1);
            } else {  
               
                for (int j = 0; j < values.length; j++) {  
                    String true_value = null;  
                    String value = values[j];  
                      
                   
                    if (j == values.length - 1) {  
                        value = value.replaceAll("\r|\n", "");  
                    }  
                      
                   
                    if (value.startsWith("")) {  
                          
                      
                        if (value.endsWith("") && !value.endsWith("\\")) {  
                            true_value = value;  
                        } else {  
                           
                            while (true) {  
                                j++;  
                                if (j == values.length) {  
                                    break;  
                                }  
                                value = value + "," + values[j];  
                              
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
      
        if (scanner != null) {  
            scanner.close();  
        }  
        return sqls;  
    }  
      
    public static void main(String[] args) throws IOException {  
          
        String path = "E:/Datas/demo/datas/13301214000.csv";  
        List<String> sqls = csv2sql(path);
        CabInformation []save=new  CabInformation[1000]; 
        for(int n=0;n<1000;n++){	
			save[n]=new CabInformation();
		}
        
        for(int tmwp=0;tmwp<1000;tmwp++){
        	String ppw="";
        String tmp1=sqls.get(tmwp);
       
    int number=0;
        for(int tmp2=0;tmp2<sqls.size();tmp2++){
        	String tmp3=tmp1.substring(tmp2, tmp2+1);
        	ppw+=tmp3;
        	if(tmp3.equals(",")){
        		if(number==0){
            		save[tmwp].listId=Integer.valueOf(ppw);
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
        	
        	
        	 
        }
        
        }
        System.out.print(save[0].listId);
        
        

    }  
}  
