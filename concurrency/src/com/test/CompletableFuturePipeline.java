package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuturePipeline {

  MultiplyBy multiplier = new MultiplyBy();

  public CompletableFuture<List<Integer>> process(CompletableFuture<List<Integer>> future) {
    return future
        .thenApply(multiplier::two)
        .thenApply(multiplier::three);
  }

  public static void main(String[] args) {
    System.out.println("--1--");
    CompletableFuture<List<Integer>> cf = new CompletableFuture<>();
    cf.completeOnTimeout(Collections.emptyList(), 3000, TimeUnit.MILLISECONDS);
    System.out.println("--2--");
    CompletableFuturePipeline pipeline = new CompletableFuturePipeline();
    CompletableFuture<List<Integer>> futures = pipeline.process(cf);
    System.out.println("--3--");
    cf.complete(Arrays.asList(1, 2, 3));
    System.out.println("--4--");
    try {
      System.out.println("--6--");
      List<Integer> integers = futures.get();
      System.out.println("--7--");
      //integers.stream().forEach(System.out::println);
      System.out.println(integers);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("--8--");
  }

}
