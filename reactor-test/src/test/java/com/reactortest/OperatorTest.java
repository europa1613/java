package com.reactortest;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OperatorTest {

  @Test
  public void map() {
    Flux.range(1, 5)
        .log()
        .map(i -> i * 2)
        .subscribe(System.out::println);
  }

  @Test
  public void flatMap_return_mono() {
    Flux.range(1, 10)
        //.log()
        .flatMap(integer -> Mono.just(integer * 2))
        .subscribe(System.out::println);
  }

  @Test
  public void flatMap_return_flux() {
    Flux.range(1, 10)
        //.log()
        .flatMap(integer -> Flux.just(integer * 2))
        .subscribe(System.out::println);
  }

  @Test
  public void flatMap_return_flux_2() {
    Flux.range(1, 5)
        //.log()
        .flatMap(integer -> Flux.range(integer * 10, 2))
        .subscribe(System.out::println);
  }

  @Test
  public void flatMapMany() {
    Mono.just(3)
        .flatMapMany(i -> Flux.range(1, i))
        .subscribe(System.out::println);
  }

  @Test
  public void concat() throws InterruptedException {
    Flux<Integer> sixToTen = Flux.range(6, 5)
        .log()
        .delayElements(Duration.ofMillis(400));
    Flux<Integer> oneToFive = Flux.range(1, 5)
        .log()
        .delayElements(Duration.ofMillis(200));

    Flux.concat(oneToFive, sixToTen)
        .log()
        .subscribe(System.out::println);

    //Another way to concat
//    oneToFive.concatWith(sixToTen)
//        .subscribe(System.out::println);

    Thread.sleep(5000);

  }

  @Test
  public void merge() throws InterruptedException {
    Flux<Integer> sixToTen = Flux.range(6, 5)
        //.log()
        .delayElements(Duration.ofMillis(400));
    Flux<Integer> oneToFive = Flux.range(1, 5)
        //.log()
        .delayElements(Duration.ofMillis(200));

    Flux.merge(oneToFive, sixToTen)
        //.log()
        .subscribe(System.out::println);

    //Another way to concat
//    oneToFive.mergeWith(sixToTen)
//        .subscribe(System.out::println);

    Thread.sleep(5000);

  }

  @Test
  public void zip() throws InterruptedException {
    Flux<Integer> oneToFive = Flux.range(1, 5)
        .delayElements(Duration.ofMillis(200));
    Flux<Integer> sixToTen = Flux.range(1, 5)
        .delayElements(Duration.ofMillis(400));

    Flux.zip(oneToFive, sixToTen)
        .subscribe(tuples -> System.out.println("Flux.zip(oneToFive, sixToTen):" + tuples));
    System.out.println("------------------------");
    Flux.zip(oneToFive, sixToTen, (item1, item2) -> item1 + "," + item2)
        .subscribe(s -> System.out.println("Flux.zip(oneToFive, sixToTen, (item1, item2): " + s));
    oneToFive.zipWith(sixToTen)
        .subscribe(objects -> System.out.println("oneToFive.zipWith(sixToTen):" + objects));

    Thread.sleep(5000);
  }

}
