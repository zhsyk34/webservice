package com.cat.hprose;

import hprose.common.HproseContext;
import hprose.common.InvokeHandler;
import hprose.common.NextInvokeHandler;
import hprose.util.concurrent.Promise;

import java.util.Arrays;

public class LogHandler implements InvokeHandler {
    @Override
    public Promise<Object> handle(String name, Object[] args, HproseContext context, NextInvokeHandler next) {
        System.out.println("before invoke: " + name + ", " + Arrays.deepToString(args));
        Promise<Object> result = next.handle(name, args, context);
        result.then((Object value) -> System.out.println("after invoke: " + name + ", " + Arrays.deepToString(args) + ", " + value));
        return result;
    }
}