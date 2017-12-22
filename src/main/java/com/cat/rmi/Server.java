package com.cat.rmi;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

//TODO:AccessControlException
public class Server {
    public Server() {
        if (null == System.getSecurityManager()) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            try {
                LocateRegistry.createRegistry(Config.PORT);
            } catch (java.rmi.server.ExportException ex) {
                System.out.println("Register the port failed:\n" + ex.getMessage());
            }
            UserService rm = new UserServiceImpl();
            String objAddr = "rmi://" + Config.SERVER_IP
                    + ":" + Config.PORT
                    + "/" + Config.OBJECT_NAME;
            java.rmi.Naming.rebind(objAddr, rm);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println("Server startup failed!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}