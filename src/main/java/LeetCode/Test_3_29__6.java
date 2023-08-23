package LeetCode;


public class Test_3_29__6 {

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 9);
        System.out.println(paypalishiring);
    }
    public static String convert(String s, int numRows) {
        int count=s.length(),col=0;
        while (count>0){
            if(count<=numRows){
                col++;
                break;
            }
            count-=numRows;
            col++;
            if(count>=numRows-2){
                col=col+numRows-2;
            }else {
                col+=count;
                break;
            }
        }

        Character[][] arr=new Character[numRows][numRows==1?s.length():col];

        int r=0,c=0,i=0;
        while (i<s.length()){
            if(r==numRows){
                r--;
                while (i<s.length()&&r-->1){
                    arr[r][++c]=s.charAt(i++);
                }
                if(numRows==1)r++;
                c++;
            }
            if(i>=s.length()) break;
            arr[r++][c]=s.charAt(i++);
        }

        StringBuilder sb=new StringBuilder();
        for (Character[] characters : arr) {
            for (int a = 0; a < arr[0].length; a++) {
                if (characters[a] != null)
                    sb.append(characters[a]);
            }
        }

        return sb.toString();
    }
}
