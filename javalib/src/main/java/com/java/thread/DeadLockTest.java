package com.java.thread;

/**
 * Created by Administrator on 2018/5/10.
 * 测试死锁
 */

public class DeadLockTest {


    public static void main(String[] args){

        final DeadLock deadLock = new DeadLock();
        Thread thread1 =new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag = 1;
                deadLock.go();
            }
        });

        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag = 2;
                deadLock.go();
            }
        });

        thread1.start();
        thread2.start();

    }
}
