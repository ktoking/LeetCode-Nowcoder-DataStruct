package BUFFcode.NewCodeTest13;

import java.math.BigInteger;
import java.util.Scanner;

public class LongNumberAdd {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String next = scanner.next();
            String next1 = scanner.next();
            String s = LongNumberAdd.AddLongInteger2(next, next1);
            System.out.println(s);
        }

    }

    /**
     *  调用javaAPI
     * @param addend 加数
     * @param augend 被加数
     * @return
     */
    public static String AddLongInteger(String addend, String augend)
    {
        BigInteger bigInteger=new BigInteger(addend);
        BigInteger bigInteger1=new BigInteger(augend);
        return bigInteger.add(bigInteger1).toString();
    }

    public static String AddLongInteger2(String addend, String augend){
        if(addend.equals("")){
            return augend;
        }else if(augend.equals("")){
            return  addend;
        }
        StringBuilder sb=new StringBuilder(addend);
        StringBuilder sb1=new StringBuilder(augend);

        int len=sb.length()>=sb1.length()?sb.length():sb1.length();

        int arr[]=new int[len];
        int arr1[]=new int[len];
        for (int i = 0; i < sb.length(); i++) {
            arr[i]=  Integer.parseInt(sb.charAt(sb.length()-1-i)+"") ;
        }
        for (int i = 0; i < sb1.length(); i++) {
            arr1[i]=  Integer.parseInt(sb1.charAt(sb1.length()-1-i)+"") ;
        }
        StringBuilder sb2=new StringBuilder();
        int jin=0;
        for (int i = 0; i < len; i++) {
            int num1=arr[i]+arr1[i]+jin;
            int a=num1%10;
            sb2.append(a);
            jin=num1/10;
        }
        if(jin>0){
            sb2.append(jin);
        }

        return sb2.reverse().toString();

    }


    /**
     *  反转字符串
     * @param addend 加数
     * @param augend 被加数
     * @return
     */
    public static String AddLongInteger1(String addend, String augend)
    {
        String s1 = addend;
        String s2 = augend;

        //反转字符串
        String n1 = new StringBuffer(s1).reverse().toString();
        String n2 = new StringBuffer(s2).reverse().toString();
        int l1 = n1.length();
        int l2 = n2.length();
        int maxL = l1>l2?l1:l2;

        //补齐0
        if (l1 < l2) {
            for (int i = l1; i < l2; i++) {
                n1 += "0";
            }
        }else {
            for (int i = l2; i < l1; i++) {
                n2 += "0";
            }
        }
        //System.out.println(n1);//test
        //System.out.println(n2);//test
        StringBuffer res = new StringBuffer();//存放的结果
        int c = 0;//进位

        for (int i = 0; i < maxL; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + c;
            int ap = nSum%10;
            res.append(ap);
            c = nSum/10;
        }
        if (c>0) {
            res.append(c);
        }
        return res.reverse().toString();
    }

}
