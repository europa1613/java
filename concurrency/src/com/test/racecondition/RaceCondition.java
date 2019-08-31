package com.test.racecondition;

public class RaceCondition {

  public static void main(String[] args) throws InterruptedException {
    LongWrapper longWrapper = new LongWrapper(0L);

    Runnable r = () -> {
      for (int i = 0; i < 1_000; i++) {
        longWrapper.incrementValue();
      }
    };

    Thread t = new Thread(r);
    t.start();

    t.join();

    System.out.println("Value = " + longWrapper.getValue());
  }
}
