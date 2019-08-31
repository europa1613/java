package com.test.runnable;

public class RunnableTest {

  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("I am running in thread: " + name);
      }
    };

    runnable.run();

    Thread t1 = new Thread(runnable);
    t1.start();

    Runnable runnable1 = () -> {
      String name = Thread.currentThread().getName();
      System.out.println("I am running in thread: " + name);
    };

    Thread t2 = new Thread(runnable1);
    t2.start();


  }

}
