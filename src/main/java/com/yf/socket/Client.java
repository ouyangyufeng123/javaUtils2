package com.yf.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author ouyangyufeng
 * @date 2019/4/24
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("------客户端------");
        Socket s = new Socket("127.0.0.1", 10086);

        InputStream in = s.getInputStream(); //网络输入流
        OutputStream out = s.getOutputStream(); //网络输出流
        byte[] b = new byte[1024];
        int i = in.read(b);
        while(i != -1){
            System.out.println("客户端说: " + new String(b, 0, i));
            i = in.read(b);
        }

        out.write("您好, 服务端 ! ".getBytes());
        out.close();
        in.close();
        s.close();

    }

}
