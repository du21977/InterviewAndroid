package com.java.thread;

/**
 * Created by Administrator on 2018/5/10.
 * 死锁
 */

public class DeadLock {
    public  int flag;
    Object obj1 = "obj1";  //资源
    Object obj2 = "obj2";  //资源

    public void go() {
        if (flag == 1) {
            synchronized (obj1) {        //锁住资源
                System.out.println("locking  " + obj1);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println(" obj1--->obj2 ");
                }
            }

        } else if (flag == 2) {
            synchronized (obj2) {        //锁住资源
                System.out.println("locking  " + obj2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println(" obj2--->obj1 ");
                }

            }

        }
    }
}
