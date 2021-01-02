package com.reactortest;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {

  @Test
  public void firstMono() {
    Mono.just("A")
        .log()
        .subscribe()
    ;
  }

  @Test
  public void monoWithConsumer() {
    Mono.just("A")
        .log()
        .subscribe(s -> System.out.println(s));
  }

  @Test
  public void monoWithDoOn() {
    Mono.just("A")
        .log()
        .doOnSubscribe(subscription -> System.out.println("Subscribed: " + subscription))
        .doOnRequest(value -> System.out.println("Request: " + value))
        .doOnNext(s -> System.out.println("onNext: " + s))
        .doOnSuccess(s -> System.out.println("Complete: " + s))
        .subscribe(System.out::println);
  }

  @Test
  public void emptyMono() {
    Mono.empty()
        .log()
        .subscribe(System.out::println);
  }

  @Test
  public void emptyCompleteConsumerMono() {
    Mono.empty()
        .log()
        .subscribe(System.out::println,
            null,
            () -> System.out.println("Done!"));
  }
  @Test
  public void errorRTEMono() {
    Mono.error(new RuntimeException())
        .log()
        .subscribe();
  }


  @Test
  public void errorExceptionMono() {
    Mono.error(new Exception())
        .log()
        .subscribe();
  }

  @Test
  public void errorConsumerMono() {
    Mono.error(new Exception("Mono Error"))
        .log()
        .subscribe(System.out::println,
            e -> System.out.println("Error: "+ e),
            () -> System.out.println("Done"));;
  }

  @Test
  public void doOnErrorMono() {
    Mono.error(new Exception("mONoooo Error"))
        .doOnError(throwable -> System.out.println("Errorrrr: " + throwable))
        .log()
        .subscribe();
  }

  @Test
  public  void errorOnResumeMono() {
    Mono.error(new Exception("mOnO error"))
        .onErrorResume(throwable -> {
          System.out.println("Caught: " + throwable);
          return Mono.just("B");
        })
        .log()
        .subscribe(System.out::println);
  }

  @Test
  public void onErrorReturnMono() {
    Mono.error(new Exception("Mono Error"))
        .onErrorReturn("B")
        .log()
        .subscribe(System.out::println);
  }

}
