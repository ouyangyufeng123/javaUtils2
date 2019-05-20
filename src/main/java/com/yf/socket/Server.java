package com.yf.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ouyangyufeng
 * @date 2019/4/24
 */
public class Server {

    public static void main(String[] args) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        Socket client = null;
        ServerSocket serv = null;
        try {
            System.out.println("------服务器------");
            serv = new ServerSocket(10086);
            System.out.println("服务器搭建完毕 ! ");
            //等待客户端连接
            client = serv.accept(); //阻塞
            System.out.println("客户端已连接....");

            //从服务器端发送一条欢迎语句到客户端程序那边
            in = client.getInputStream(); //网络输入流
            out = client.getOutputStream(); //网络输出流
            Scanner scanner = new Scanner(System.in);

            //发送
            out.write(scanner.next().getBytes());

            byte[] b = new byte[1024];
            int i = in.read(b);
            while(i != -1){
                System.out.println("客户端说: " + new String(b, 0, i));
                i = in.read(b);
            }
        }catch (Exception ex){

        }finally {
            in.close();
            out.close();
            client.close();
            serv.close();
            System.out.println("程序结束!");
        }

    }

}
