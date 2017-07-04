package com.corejava;

public class StaticMembersDemo {

	static int num;
	
	public static void main(String[] args) {
		System.out.println("Main method!");
		StaticMembersDemo.method();
		System.out.println("Static Variable, num: "+ StaticMembersDemo.num);
	}

	static {
		System.out.println("Static block 2.");
	}

	static {
		System.out.println("Static block 1.");
		StaticMembersDemo.method();
	}

	static void method() {
		System.out.println("Static Method!");
	}
}
