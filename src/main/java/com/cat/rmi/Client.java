package com.cat.rmi;

public class Client {
    private String name;
    private String hostURL;
    private String obj;

    public Client(String name) {
        this.name = name;
        hostURL = "rmi://" + Config.SERVER_IP + ":" + Config.PORT + "/";
        this.obj = Config.OBJECT_NAME;
    }

    public static void main(String[] args) {
        Client c1 = new Client("Monica");
        c1.callRMethod();
        Client c2 = new Client("Joy");
        c2.callRMethod();
        Client c3 = new Client("Ross");
        c3.callRMethod();
        Client c4 = new Client("Chandler");
        c4.callRMethod();
    }

    public void callRMethod() {
        try {
            UserService rm = (UserService) java.rmi.Naming.lookup(hostURL + obj);
            rm.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}