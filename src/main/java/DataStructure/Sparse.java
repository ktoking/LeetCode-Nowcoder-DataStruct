package DataStructure;

/**
 * 稀疏数组
 */
public class Sparse {

    public static void main(String[] args) {

        int arr[][] =new int[5][5];
        arr[2][1]=1;
        arr[3][2]=2;
        arr[3][3]=2;


        for (int[] row : arr) {
            for (int i : row) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

        int allNumber=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]!=0){
                    allNumber++;
                }
            }
        }
        System.out.println("一共存在几个数字:"+allNumber);
        int count=1;
        int xishu[][]=new int[allNumber+1][3];
        xishu[0][0]=arr.length;
        xishu[0][1]=arr.length;
        xishu[0][2]=allNumber;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(arr[i][j]!=0){
                    xishu[count][0]=i;
                    xishu[count][1]=j;
                    xishu[count][2]=arr[i][j];
                    count++;
                }
            }
        }

        System.out.println("稀疏数组为:");

        for (int i = 0; i < xishu.length; i++) {
            System.out.printf("%d\t%d\t%d\t",xishu[i][0],xishu[i][1],xishu[i][2]);
            System.out.println();
        }


    //稀疏数组转化回去
        int newArr[][]=new int[xishu[0][0]][xishu[0][1]];
        for (int i = 1; i <= xishu[0][2]; i++) { //这里要遍历的是稀疏数组里的所有行除去第一行,把值赋给还原数组里面
          newArr[xishu[i][0]][xishu[i][1]]=xishu[i][2];
        }

        System.out.println("稀疏数组转化为原数组为:");

        for (int[] row : newArr) {
            for (int i : row) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }


//        int xishu[][]=new int[][]
    }
}
