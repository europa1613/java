package com.corejava;

public class NonStaticMembersDemo {

	int num;

	public NonStaticMembersDemo() {
		System.out.println("Inside contructor");
	}

	{
		System.out.println("Inside non static block");
	}

	public static void main(String[] args) {
		System.out.println("Inside main");
		new NonStaticMembersDemo();
	}
}
