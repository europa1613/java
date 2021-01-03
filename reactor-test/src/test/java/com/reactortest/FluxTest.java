package com.reactortest;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class FluxTest {

  @Test
  public void firstFlux() {
    Flux.just("A", "B", "C")
        .log()
        .subscribe();
  }

  @Test
  public void fluxFromIterable_wrong() {
    Flux.just(Arrays.asList("A", "B", "C")) // all the elements are passed at once to the subscriber
        .log()
        .subscribe(System.out::println);
  }

  @Test
  public void fluxFromIterable_correct() {
    Flux.fromIterable(Arrays.asList("A", "B", "C")) // passed one at a time, multiple onNext calls
        .log()
        .subscribe(System.out::println);
  }

  @Test
  public void fluxFromRange() {
    Flux.range(10, 5)
        .log()
        .subscribe();
  }

  @Test
  public void fluxFromInterval_no_output() throws InterruptedException {
    Flux.interval(Duration.ofSeconds(1))
        .log()
        .subscribe();
  }

  @Test
  public void fluxFromInterval() throws InterruptedException {
    Flux.interval(Duration.ofSeconds(1))
        .log()
        .subscribe();
    Thread.sleep(
        10000);// keeping the main thread waiting will allow for Subscriber to get onNextEvents until main thread resumes and terminates.
    //onComplete method never get called
  }

  @Test
  public void fluxFromInterval_take_values() throws InterruptedException {
    Flux.interval(Duration.ofSeconds(1))
        .log()
        .take(2)
        .subscribe(); // subscriber takes 2 and Publisher cancels the subscription after emitting 2 values
    Thread.sleep(
        10000);
  }

  @Test
  public void fluxRequestInitialData() {
    Flux.range(1, 5)
        .log()
        .subscribe(null, null, null, s -> s.request(3));
  }

  @Test
  public void fluxCustomSubscriber() {
    Flux.range(1, 10)
        .log()
        .subscribe(new BaseSubscriber<Integer>() {
          int eToProcess = 3;
          int counter = 0;

          @Override
          protected void hookOnSubscribe(Subscription subscription) {
            //super.hookOnSubscribe(subscription);
            System.out.println("Subscribed");
            this.request(eToProcess);
          }

          @Override
          protected void hookOnNext(Integer value) {
            //super.hookOnNext(value);
            counter++;
            if (counter == eToProcess) {
              counter = 0;
              Random random = new Random();
              eToProcess = random.ints(1, 4).findFirst().getAsInt();
              this.request(eToProcess);
            }
          }
        });
  }

  @Test//Same as ABOVE, without having to implement a {Base}Subscriber
  public void fluxLimitRate() {
    Flux.range(1, 5)
        .log()
        .limitRate(3)
        .subscribe();
  }

}
