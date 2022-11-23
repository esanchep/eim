package com.eim;

public interface Runnable<T> extends java.lang.Runnable {

    @Override
    T run() throws Exception;

}
