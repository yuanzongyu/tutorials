package xin.clips;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws  Exception{
        Socket socket = new Socket("localhost",9010); //IP地址+端口号
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter  = new PrintWriter(outputStream);
        printWriter.println("服务器端你好，我是袁宗宇");
        printWriter.flush(); //刷新流
        socket.shutdownOutput();

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info="";
        String temp =null;
        while((temp=bufferedReader.readLine())!=null){
            info+=temp;
            System.out.println("客户端收到服务器端的信息："+info);
        }
        bufferedReader.close();
        inputStreamReader.close();
        outputStream.close();
        socket.close();
    }
}
