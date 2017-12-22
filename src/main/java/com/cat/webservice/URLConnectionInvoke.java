package com.cat.webservice;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class URLConnectionInvoke {

    private static String s = PublishServer.host + "hello?wsdl";

    private static void test1() throws MalformedURLException {
        URL url = new URL(s);

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://webservice.cat.com/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("goodbye"));
    }

    public static void main(String[] args) throws IOException {
        URL url = new URL(s);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);   //要往服务器接收
        connection.setDoOutput(true);     //要往服务器传送数据，必须设置为true

        connection.setRequestProperty("Content-Type", "text/xml;charset=utf-8");

        connection.setRequestMethod("POST");

        OutputStream outputStream = connection.getOutputStream();

//        outputStream.write("1".getBytes());

        InputStream inputStream = connection.getInputStream();
        System.out.println(read(inputStream));

    }

    private static String read(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
}
