package com.test.producer.consumer.syncflawed;

public class ProducerConsumer {

  private static Object lock = new Object();
  private static int[] buffer;
  private static int count;

  static class Producer {

    void produce() {
      synchronized (lock) {
        while (isFull(buffer)) {
        }
        buffer[count++] = 1;
      }
    }
  }

  static class Consumer {

    void consume() {
      synchronized (lock) {
        while (isEmpty(buffer)) {
        }
        buffer[--count] = 0;
      }
    }
  }

  static boolean isEmpty(int[] buffer) {
    return count == 0;
  }

  static boolean isFull(int[] buffer) {
    return count == buffer.length;
  }

  public static void main(String[] args) throws InterruptedException {
    buffer = new int[10];
    count = 0;

    Producer producer = new Producer();
    Consumer consumer = new Consumer();

    Runnable produceTask = () -> {
      for (int i = 0; i < 50; i++) {
        producer.produce();
      }
      System.out.println("Done producing!");
    };

    Runnable consumeTask = () -> {
      for (int i = 0; i < 50; i++) {
        consumer.consume();
      }
      System.out.println("Done consuming!");
    };

    Thread consumerThread = new Thread(consumeTask);
    Thread produceThread = new Thread(produceTask);

    consumerThread.start();
    produceThread.start();

    consumerThread.join();
    produceThread.join();

    System.out.println("Data in the buffer: " + count);

  }

}
