package com.corejava;

public class ObjectInStaticBlockDemo {

	static ObjectInStaticBlockDemo obj2;

	static {
		ObjectInStaticBlockDemo obj = new ObjectInStaticBlockDemo();
		System.out.println("obj: " + obj);

		System.out.println("obj2 Before instantiation: " + ObjectInStaticBlockDemo.obj2);
		ObjectInStaticBlockDemo.obj2 = new ObjectInStaticBlockDemo();
		System.out.println("obj2 after instantiation: " + ObjectInStaticBlockDemo.obj2);
		
		ObjectInStaticBlockDemo.init();
	}

	public static void main(String[] args) {
		System.out.println("obj2 main: " + ObjectInStaticBlockDemo.obj2);
	}
	
	static void init() {
		ObjectInStaticBlockDemo.obj2 = new ObjectInStaticBlockDemo();
	}
}
