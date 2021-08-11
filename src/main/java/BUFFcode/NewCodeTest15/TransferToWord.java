package BUFFcode.NewCodeTest15;

/**
 *阿拉伯数字转换汉字
 */
public class TransferToWord {
    public static void main(String[] args) {
        test(12233300+"");
        StringBuilder sb=new StringBuilder("123456");
    }
    public static void test(String s) {
//         String[] str = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String[] str = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
//        String ss[] = new String[] { "元", "拾", "佰bai", "仟", "万", "拾", "佰", "仟", "亿" };
        String ss[] = new String[] { "", "十", "百", "千", "万", "十", "百", "千", "亿" };
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb = sb.append(str[Integer.parseInt(s.charAt(i)+"")]);
        }
        int len=sb.length();
        for (int j = len,i=0; j > 0; j--) {
            sb = sb.insert(j, ss[i++]);
        }
        System.out.println(sb);
    }
}
