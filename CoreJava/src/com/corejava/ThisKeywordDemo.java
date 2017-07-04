package com.corejava;

public class ThisKeywordDemo {

	int x;

	public ThisKeywordDemo() {
		System.out.println(this);
		System.out.println(this.x);
	}

	public static void main(String[] args) {
		new ThisKeywordDemo();
		new ThisKeywordDemo();
	}

}
