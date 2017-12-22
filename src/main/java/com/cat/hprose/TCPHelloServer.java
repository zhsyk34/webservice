package com.cat.hprose;

import hprose.server.HproseTcpServer;

public class TCPHelloServer {
    public static String hello(String name) {
        return "Hello " + name + "!";
    }

    public static void main(String[] args) throws Exception {
        HproseTcpServer server = new HproseTcpServer("tcp://localhost:4321");
        server.add("hello", TCPHelloServer.class);
        server.start();
        System.out.println("START");
        System.in.read();
        server.stop();
        System.out.println("STOP");
    }
}