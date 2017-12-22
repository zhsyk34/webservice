package com.cat.dubbo;

import java.rmi.Remote;

public interface UserService extends Remote {
    void save();
}
