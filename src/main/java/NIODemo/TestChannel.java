package NIODemo;

import BUFFcode.NewCodeTest11.TestDemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {

    //使用通道完成文件的复制(非直接缓冲区)
    public static void test1(){
        long start=System.currentTimeMillis();

        FileInputStream fis=null;
        FileOutputStream fos=null;
        //获取通道
        FileChannel inchannel = null;
        FileChannel outchannel = null;

        try {
            fis = new FileInputStream("E:\\image/1.jpg");
            fos = new FileOutputStream("E:\\image/4.jpg");
            inchannel = fis.getChannel();
            outchannel = fos.getChannel();
            //设置非直接缓冲区大小
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            while(inchannel.read(byteBuffer)!=-1){ //将通道里的数据存入缓冲区
                byteBuffer.flip(); //切换读取模式;
                outchannel.write(byteBuffer); // //将缓冲区中的数据写入通道中
                byteBuffer.clear(); ////清空缓冲区
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(outchannel!=null){
                try {
                    outchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inchannel!=null){
                try {
                    inchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start));//耗费时间：1094
    }

    ///使用直接缓冲区完成文件的复制(内存映射文件)
    public static void test2() throws IOException {
        long start=System.currentTimeMillis();
        //通过静态方法 open()创建通道
        FileChannel inChannel=FileChannel.open(Paths.get("E:\\image/1.jpg"), StandardOpenOption.READ); //读模式
        FileChannel outChannel=FileChannel.open(Paths.get("E:\\image/4.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE); //读写模式;存在就覆盖,不存在就创建
        //内存映射文件
        MappedByteBuffer inMappedBuf=inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuf=outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());
        //进行写操作
        byte[] bytes=new byte[inMappedBuf.limit()];
        inMappedBuf.get(bytes);
        outMappedBuf.put(bytes);
        //关闭通道
        inChannel.close();
        outChannel.close();
        long end=System.currentTimeMillis();
        System.out.println("耗时: "+(end-start));
    }

    //通道之间的传输(直接缓冲区)
    public static void test3() throws IOException {
        long start=System.currentTimeMillis();
        FileChannel inChannel=FileChannel.open(Paths.get("E:\\image/1.jpg"), StandardOpenOption.READ); //读模式
        FileChannel outChannel=FileChannel.open(Paths.get("E:\\image/4.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE); //读写模式;存在就覆盖,不存在就创建
        inChannel.transferTo(0,inChannel.size(),outChannel);
        inChannel.close();
        outChannel.close();
        long end=System.currentTimeMillis();
        System.out.println("耗时: "+(end-start));
    }

    //分散和聚集
    public static void test4() throws IOException {
        RandomAccessFile raf=new RandomAccessFile("E:\\image/1234.txt","rw");
        //建立通道
        FileChannel inChannel = raf.getChannel();
        //创建缓存区数组 ->分散读取
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer1=ByteBuffer.allocate(100);
        ByteBuffer[] buffers={byteBuffer,byteBuffer1};
        //读取到缓存区
        inChannel.read(buffers);
        for (ByteBuffer buffer : buffers) {
            buffer.flip(); //切换为读模式
        }
        //查看各自通道有多少
        System.out.println(new String(buffers[0].array(),0,buffers[0].limit()));
        System.out.println("****************************************************");
        System.out.println(new String(buffers[1].array(),0,buffers[1].limit()));

        //聚集写入
        RandomAccessFile raf2=new RandomAccessFile("E:\\image/12345.txt","rw");
        FileChannel outChannel = raf2.getChannel();
        outChannel.write(buffers);
        inChannel.close();
        outChannel.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("使用通道完成文件的复制(非直接缓冲区)");
        TestChannel.test1();
        System.out.println("使用直接缓冲区完成文件的复制(内存映射文件)");
        TestChannel.test2();
        System.out.println("使用通道复制完成文件的复制");
        TestChannel.test3();
        System.out.println("使用分散读取");
        TestChannel.test4();
    }
}
