package NIODemo;

import java.nio.ByteBuffer;

public class TestBuffer {


    public static void noneDirectBuffer(){
        //分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String s=new String("abcde");
        //缓冲区存数据
        System.out.println("PUT操作");
        byteBuffer.put(s.getBytes());
        System.out.println(byteBuffer.position()); //5
        System.out.println(byteBuffer.limit());  //1024
        System.out.println(byteBuffer.capacity()); //1024
        System.out.println("***************************");

        System.out.println("filp操作");
        byteBuffer.flip();
        System.out.println(byteBuffer.position()); //0
        System.out.println(byteBuffer.limit());    //5
        System.out.println(byteBuffer.capacity()); //1024
        System.out.println("***************************");

        System.out.println("get操作");
        byte[] b=new byte[byteBuffer.limit()];
        byteBuffer.get(b,0,4);
        if(byteBuffer.hasRemaining()){ //判断缓冲区是否有剩余
            System.out.println("缓冲区还有几个剩余的: "+byteBuffer.remaining());
        }
        System.out.println(byteBuffer.position()); //5
        System.out.println(byteBuffer.limit());    //5
        System.out.println(byteBuffer.capacity()); //1024
        System.out.println("***************************");

        System.out.println("rwind操作可重复读"); //又把position置于开头
        byteBuffer.rewind();
        System.out.println(byteBuffer.position()); //0
        System.out.println(byteBuffer.limit());    //5
        System.out.println(byteBuffer.capacity()); //1024
        System.out.println("***************************");


        System.out.println("mark操作记录当前的position位置"); //又把position置于开头
        byteBuffer.mark();
        byte[] bytes=new byte[1024];
        byteBuffer.get(bytes,0,2); //取走前两个,position为2
        System.out.println("取走前两个,position为"+byteBuffer.position()); //2
        byteBuffer.reset(); //恢复到mark位置的position 为0
        System.out.println("恢复到mark位置的position 为"+byteBuffer.position()); //0
        System.out.println("***************************");

        System.out.println("clear操作清空(非真清空,相当于把position和limit恢复开始状态)数组中的数据依然存在"); //又把position置于开头
        byteBuffer.clear();
        System.out.println(byteBuffer.position()); //0
        System.out.println(byteBuffer.limit());    //1024
        System.out.println(byteBuffer.capacity()); //1024
        System.out.println("***************************");

        //获取第一个bytez转化为char还是能输出
        System.out.println("获取第一个bytez转化为char还是能输出"+(char)byteBuffer.get());

        if(byteBuffer.hasRemaining()){ //判断缓冲区是否有剩余
            System.out.println("缓冲区还有几个剩余的: "+byteBuffer.remaining());
        }
    }

    public static void directBuffer(){
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());//判断是否为直接缓冲区
    }

    public static void main(String[] args) {
//        TestBuffer.directBuffer();
    }
}
