package src.BUFFcode.WrittenTest.MeiTuan;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main6 {

    static List<String> res1 = new LinkedList<>();
    static LinkedList<String> duan = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String substring = s.substring(1, s.length() - 1);
            List<String> fuyuan = fuyuan(substring);
            StringBuilder sb=new StringBuilder();
            sb.append("[");
            for (String s1 : fuyuan) {
                sb.append("\"");
                sb.append(s1);
                sb.append("\"");
                sb.append(",");
            }
            sb.delete(sb.length()-1,sb.length());
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    public static List<String> fuyuan(String s) {
        huisu(s,0);
        return res1;
    }
    public static void huisu(String str,int index){
        if(duan.size()==4&&index==str.length()){ //满四段且用完了字符串,拼成ip加入结果集
            StringBuilder sb=new StringBuilder();
            for (String s : duan) {
                sb.append(s).append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            res1.add(sb.toString());
            return;
        }
        if(index < str.length() && duan.size() == 4)return; //满四段且没用完直接返回
        for (int i = 1; i <=3 ; i++) {                      // 三种长度的选择
            if(index+i-1>=str.length()) return;             //如果超出选择,返回
            if(i!=1&&str.charAt(index)=='0') return;        //如果长度不是第一段且选0 会出现255.01.001这种,直接返回
            String s=str.substring(index,index+i);           //将选出来的截取出来
            if(i==3&&Integer.parseInt(s)>255) return;       //长度为3的话,就要判断是否>255
            duan.add(s);
            huisu(str,index+i);
            duan.remove(duan.size()-1);
        }
    }
}
