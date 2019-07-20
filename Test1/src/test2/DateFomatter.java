package test2;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/6/21
 */
public class DateFomatter {
    public static void Date(){
        Scanner in =new Scanner(System.in);
        String str=in.nextLine();
        StringBuffer sb=new StringBuffer();
        Date date=new Date();
        if (str.contains("yyyy")==true||str.contains("yy")==true){
            String year=Integer.toString(date.getYear());
            if (year.length()==4){
                sb.append(year);
            } else if(year.length()==1){
                sb.append("000"+year);
            } else if (year.length()==2){
                sb.append("00"+year);
            } else if (year.length()==3){
                sb.append("0"+year);
            }else {
                sb.append(year);
            }
        }if (str.contains("MM")==true||str.contains("M")){

        }
    }

    public static String StrFomatter(String str1 ){
        if (str1.length()==2){
            return str1;
        }else {
            return "0"+str1;
        }
    }
    public static void main(String[] args) {
        Date();
    }
}
