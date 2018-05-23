package com.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/5/10.
 * ReentrantLock
 * 加锁时限（线程尝试获取锁的时候加上一定的时限，超过时限则放弃对该锁的请求，并释放自己占有的锁）
 */

public class DeadLockTestSolve2 {
    public static void main(String[] args){

        final Lock lock  = new ReentrantLock();
        final DeadLock deadLock = new DeadLock();
        Thread thread1 =new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag = 1;
                try {
                    if(lock.tryLock(5000, TimeUnit.MILLISECONDS)){
                        System.out.println("thread1 get lock ");
                    }else{
                        System.out.println("thread1 dont get lock ");
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    deadLock.go();
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
        });

        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag = 2;
                try {
                    if(lock.tryLock(5000, TimeUnit.MILLISECONDS)){
                        System.out.println("thread2 get lock ");
                    }else{
                        System.out.println("thread2 dont get lock ");
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    deadLock.go();
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
