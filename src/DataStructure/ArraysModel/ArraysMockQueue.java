package DataStructure.ArraysModel;




class QueueDemo  {
    private int maxVal;  //数组最大容量
    private int left;       //左下标 控制取出
    private int right;      //右下标  控制插入
    private int arr[];      //数组模拟队列

    public QueueDemo(int maxVal) {
        this.maxVal = maxVal;
        this.left = -1;
        this.right = -1;
        arr=new int[maxVal];
    }

    public boolean ifFull(){
        return right==maxVal-1;
    }

    public boolean ifEmpty(){
        return left==right;
    }

    public void add(int num){
        if(this.ifFull())
            throw new  RuntimeException("队列满了,禁止插入");
        arr[++right]=num;
    }

    public int get(){
        if(this.ifEmpty())
            throw new  RuntimeException("队列为空");
        return arr[++left];
    }

    public void showQueue(){
        if(this.ifEmpty()) System.out.println("队列为空");
        for (int i = left+1; i <= right; i++) {
            System.out.printf("第%d个数,值为%d",i,arr[i]);
            System.out.println();
        }
    }

}
public class ArraysMockQueue {

    public static void main(String[] args) {



        QueueDemo queueDemo=new QueueDemo(3);
        queueDemo.add(1);
        queueDemo.add(2);
        queueDemo.add(3);
        queueDemo.showQueue();
        queueDemo.get();
        queueDemo.showQueue();
    }



}
