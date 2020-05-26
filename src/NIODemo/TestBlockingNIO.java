package NIODemo;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO {

    public void client() throws IOException{
        //获取通道
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9777));
        //文件通道
        FileChannel fileChannel=FileChannel.open(Paths.get("E:\\image/1.jpg"), StandardOpenOption.READ);
        //缓冲区
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        //读取缓冲区
        while (fileChannel.read(byteBuffer)!=-1){
            byteBuffer.flip(); //切换读模式
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //获取服务端信息
        int len=0;
        while((len=socketChannel.read(byteBuffer))!=-1){
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(),0,len));
            byteBuffer.clear();
        }

        socketChannel.close();
        fileChannel.close();

    }

}
