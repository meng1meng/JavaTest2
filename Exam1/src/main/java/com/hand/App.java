package com.hand;

import java.io.*;
import java.net.URL;

public class App {
    public static void main(String[] args) {
        download("http://192.168.11.205:18080/trainning/SampleChapter1.pdf","Exam1/tmp","SampleChapter1.pdf");

//        System.out.println("Hello World!");
    }

    public static void download(String url, String saveDirectory, String fileName) {
        BufferedOutputStream bos = null;
        InputStream is = null;
        int count = 0;
        byte[] b = new byte[10000];
        try {
            is = new URL(url).openStream();
            File f = new File(saveDirectory, fileName);
            f.getParentFile().mkdirs();
            bos = new BufferedOutputStream(new FileOutputStream(f));
            while ((count = is.read(b)) != -1) {
                bos.write(b, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(is!=null){
                try {
                    is.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


