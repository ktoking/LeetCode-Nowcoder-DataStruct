package BUFFcode.WrittenTest.YueWenTest;

import java.util.Scanner;

public class DateDemoTest {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String date1 = scanner.nextLine(); //2020-02-01 12:00:00
            String date2 = scanner.nextLine();//2020-02-01 12:01:00

            String[] s1 = date1.split(" ");
            String[] hms1 = s1[1].split(":");
            int ss1=Integer.parseInt(hms1[0])*Integer.parseInt(hms1[1])*Integer.parseInt(hms1[2])*3600;

            String[] s2 = date2.split(" ");
            String[] hms2 = s2[1].split(":");
            int ss2=Integer.parseInt(hms2[0])*Integer.parseInt(hms2[1])*Integer.parseInt(hms2[2])*3600;

            int count = ss2 - ss1;
            int min=0;
            while(true){
                if(count==0) break;
                count=count/60;
                min++;
            }

            System.out.println(min);
        }
    }
}
