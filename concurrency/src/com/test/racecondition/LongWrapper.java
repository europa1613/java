package com.test.racecondition;

public class LongWrapper {

  private Object key = new Object();

  private long l;

  public LongWrapper(long l) {
    this.l = l;
  }

  public long getValue() {
    return l;
  }

  public void incrementValue() {
    synchronized (key) {
      l = l + 1; // read followed by a write operation
    }
  }

}
