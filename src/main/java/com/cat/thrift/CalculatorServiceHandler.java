package com.cat.thrift;

import org.apache.thrift.TException;

public class CalculatorServiceHandler implements CalculatorService.Iface {
    public void ping() throws TException {
        System.out.println("ping");
    }

    public int add(int num1, int num2) throws TException {
        return num1 + num2;
    }
}