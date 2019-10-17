package com.test.valid.parens;

class Solution {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {

		String replacerParen = null;
		while ((replacerParen = getReplacerParen(s)) != null) {
			s = replaceGoodParens(s, replacerParen);
		}

		return s.length() == 0;
	}

	public static String getReplacerParen(String s) {
		String result = null;
		if (s.indexOf("()") > -1) {
			result = "()";
		} else if (s.indexOf("[]") > -1) {
			result = "[]";
		} else if (s.indexOf("{}") > -1) {
			result = "{}";
		}

		return result;
	}

	public static String replaceGoodParens(String s, String parens) {
		String result = s;
		if (s.indexOf(parens) > -1) {
			result = s.replace(parens, "");
			replaceGoodParens(result, parens);
		}
		return result;
	}
}