package com.hand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main() {
            try {
                ServerSocket ss = new ServerSocket(12345);
                while (true) {
                    Socket s = ss.accept();//连接
                    System.out.println("connected!");

                    FileInputStream fis=new FileInputStream("Exam1/tmp/SampleChapter1.pdf");
                    BufferedInputStream bis=new BufferedInputStream(fis);
                    DataInputStream dis = new DataInputStream(bis);

                    //输出流
                    OutputStream os = s.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeUTF("Hello , " + s.getInetAddress() + " ports " + s.getPort());
                    dis.close();
                    dos.close();
                    s.close();
                    System.out.println("closed!");
                }

                } catch(IOException e){
                    e.printStackTrace();
                }

    }

    }
