//package com.hngcteng;

import java.util.Scanner;

public class MyRunnable extends Thread{
    static int x;
    static int y;

    static class OddNumber implements Runnable{

        public void run(){

            for(int i=x; i<=y; i++){
                if (i % 2 != 0) {
                    try {
                        System.out.println(i);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //odd[count]=i;
                }
            }
        }
    }

    static class EvenNumber implements Runnable{

        public void run(){

            for (int j=x; j<=y; j++) {
                if (j % 2 == 0) {
                    try {
                        System.out.println(j);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //even[count]=i;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner input= new Scanner(System.in);
        System.out.print("Please input X: ");
        x = input.nextInt();

        System.out.print("Please input Y: ");
        y = input.nextInt();
        System.out.println();

        OddNumber comp1 = new OddNumber();
        EvenNumber comp2 = new EvenNumber();

        // creation of child thread
        Thread t1 = new Thread(comp1);
        Thread t2 = new Thread(comp2);

        // moving child thread to runnable state
        t1.start();
        t2.start();

    }
}