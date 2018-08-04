package com.currencyformat;

import java.math.RoundingMode;
import java.util.Locale;

/**
 * @author 
 *
 */
public class NumberFormatMain {
	
	/*
	 * OUPUT
	 	-----------------
			23,244,535.34
			5,757,577
			23,244,535.35
			56,768,898
			23,244,535.00
			9,876,790
			0.00
			0
			-----------------
			23 244 535,34
			23 244 535,35
			23 244 535,00
			0,00
			-----------------
			23.244.535,34
			23.244.535,35
			23.244.535,00
			0,00
		-----------------
	*/

	public static void main(String[] args) {
		System.out.println("-----------------");
		
		System.out.println(NumberFomatUtils.format("23244535.3445", Locale.US, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("5757577", Locale.US, RoundingMode.HALF_UP, 2, false));
		
		System.out.println(NumberFomatUtils.format("23244535.349", Locale.US, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("56768898.34", Locale.US, RoundingMode.HALF_UP, 2, false));
		
		System.out.println(NumberFomatUtils.format("23244535", Locale.US, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("9876789.98769", Locale.US, RoundingMode.HALF_UP, 2, false));
		
		System.out.println(NumberFomatUtils.format("0", Locale.US, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("0", Locale.US, RoundingMode.HALF_UP, 2, false));
		
		System.out.println("-----------------");
		
		System.out.println(NumberFomatUtils.format("23244535.3445", Locale.FRANCE, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("23244535.349", Locale.FRANCE, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("23244535", Locale.FRANCE, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("0", Locale.FRANCE, RoundingMode.HALF_UP, 2, true));
		
		System.out.println("-----------------");
		
		System.out.println(NumberFomatUtils.format("23244535.3445", Locale.GERMANY, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("23244535.349", Locale.GERMANY, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("23244535", Locale.GERMANY, RoundingMode.HALF_UP, 2, true));
		System.out.println(NumberFomatUtils.format("0", Locale.GERMANY, RoundingMode.HALF_UP, 2, true));
		
		System.out.println("-----------------");
	}

}
