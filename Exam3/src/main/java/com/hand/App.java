package com.hand;


import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class App
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        new ReadByPost().start();
    }
}

class ReadByPost extends Thread{
    public void run() {
        try {
            URL url=new URL("http://hq.sinajs.cn/list=sh601006");
            //打开连接
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            //设置访问参数
            connection.addRequestProperty("encoding","UTF-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            //指定连接方式
            connection.setRequestMethod("POST");

            //定义输入流
            InputStream is=connection.getInputStream();
            //读取输入流
            InputStreamReader isr=new InputStreamReader(is,"UTF-8");//防止乱码
            //加缓冲
            BufferedReader br=new BufferedReader(isr);

            //定义输出流
            OutputStream os=connection.getOutputStream();
            //读取输出流
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");//防止乱码
            //加缓冲
            BufferedWriter bw=new BufferedWriter(osw);

            bw.write("1111");
            bw.flush();//强制输出

            String line;
            StringBuffer builder=new StringBuffer();
            while((line=br.readLine())!=null){
                builder.append(line);
            }
            //关闭流
            bw.close();
            osw.close();
            os.close();
            br.close();
            isr.close();;
            is.close();
            //打印输出builder中的内容
            System.out.println(builder.toString());
//            JSONObject object=new JSONObject();
//            JSONArray array=new JSONArray();
//
////            JSONObject object =new JSONObject();
////            JSONArray array=new JSONArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class TestXML extends Thread{

    @Override
    public void run() {
        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document=builder.newDocument();



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

}

class TestJson extends Thread{
    @Override
    public void run() {
        JSONParser parser=new JSONParser();
        try {
            Object object=parser.parse(new FileReader("tmp/股票编码.Json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
