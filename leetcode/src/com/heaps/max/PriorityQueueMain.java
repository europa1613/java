package com.heaps.max;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueMain {

	public static void main(String[] args) {

		PriorityQueue<Integer> pqMin = new PriorityQueue<>();

		pqMin.add(25);
		pqMin.add(-22);
		pqMin.add(1343);
		pqMin.add(0);
		pqMin.add(-3452);
		pqMin.add(54);
		pqMin.add(429);

		Iterator<Integer> iterator = pqMin.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
			System.out.print(", ");
		}
		System.out.println();

		PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> {
			if (o1 < o2) {
				return 1;
			} else if (o1 > o2) {
				return -1;
			} else {
				return 0;
			}
		});

		pqMax.add(25);
		pqMax.add(-22);
		pqMax.add(1343);
		pqMax.add(0);
		pqMax.add(-3452);
		pqMax.add(54);
		pqMax.add(429);

		System.out.println(pqMax.poll());
		Iterator<Integer> itr = pqMax.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next());
			System.out.print(", ");
		}

	}

}
