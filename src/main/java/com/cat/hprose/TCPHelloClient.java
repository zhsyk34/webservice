package com.cat.hprose;

import hprose.client.HproseTcpClient;

interface IHello {
    String hello(String name);
}

public class TCPHelloClient {
    public static void main(String[] args) throws Throwable {
        System.out.println("START");
        HproseTcpClient client = new HproseTcpClient("tcp://localhost:4321");
        IHello helloClient = client.useService(IHello.class);
        System.out.println(helloClient.hello("World"));

        System.out.println(client.invoke("hello", new Object[]{"HPROSE"}, String.class));
        System.out.println("END");
    }
}