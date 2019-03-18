package xin.clips;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9010); //服务器端监听9010端口
        Socket socket = serverSocket.accept(); //阻塞，等待客户端的连接,3次握手成功后，返回socket实例

        InputStream inputStream = socket.getInputStream(); //准备读客户端的信息
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = null;
        String info = "";
        while ((temp = bufferedReader.readLine()) != null) {
            info += temp;
            System.out.println("已接收客户端的链接");
            System.out.println("服务器端接收到客户端信息" + info + "当前客户端IP" + socket.getInetAddress().getHostAddress());
        }
        //准备返回给客户端
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println("您好，服务器已经收到您的信息");
        printWriter.flush();
        socket.shutdownOutput(); //关闭输出流
        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStream.close();
        socket.close();
    }

}
