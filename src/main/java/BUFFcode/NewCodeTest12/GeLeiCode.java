package BUFFcode.NewCodeTest12;

public class GeLeiCode {
    public static String[] getGray(int n) {
        String[] resStrs = null;
        if(n == 1){
            resStrs = new String[]{"0","1"};
        }else{
            String[] strs = getGray(n-1);
            resStrs = new String[2*strs.length];
            for(int i=0; i<strs.length; i++){
                resStrs[i] = "0"+strs[i];
                resStrs[resStrs.length-1-i] = "1"+strs[i];
            }
        }
        return resStrs;
    }

    public static void main(String[] args) {
        String[] gray = getGray(3);
        for (String s : gray) {
            System.out.println(s);
        }
    }
}
