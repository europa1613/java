package com.test;

public class PairImpl implements Pair<Integer, String> {

	private Integer key;
	private String value;

	public PairImpl(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}
