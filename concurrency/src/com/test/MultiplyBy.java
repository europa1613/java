package com.test;

import java.util.List;
import java.util.stream.Collectors;

public class MultiplyBy {

  public List<Integer> two(List<Integer> data) {
    return data.stream().map(item -> item * 2).collect(Collectors.toList());
  }

  public List<Integer> three(List<Integer> data) {
    return data.stream().map(item -> item * 3).collect(Collectors.toList());
  }
}
