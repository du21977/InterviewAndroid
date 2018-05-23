package com.java.thread;

/**
 * Created by Administrator on 2018/5/10.
 * 先让一个线程执行完，再执行另外一个
 */

public class DeadLockTestSolve1 {

    public static void main(String[] args){

        final DeadLock deadLock = new DeadLock();
        final Thread thread1 =new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag = 1;
                deadLock.go();
            }
        });

        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();//先让线程1执行完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                deadLock.flag = 2;
                deadLock.go();
            }
        });

        thread1.start();
        thread2.start();

    }

}
