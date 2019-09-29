package com.test;

import java.util.ArrayList;
import java.util.List;

public class OrderedPairMain {

	public static void main(String[] args) {
		OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
		OrderedPair<String, String> p2 = new OrderedPair<>("hello", "world");

		List<OrderedPair<?, ?>> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		System.out.println(list.get(0).getKey());
	}

}
