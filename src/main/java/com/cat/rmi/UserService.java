package com.cat.rmi;

import java.rmi.Remote;

public interface UserService extends Remote {
    void save();
}
