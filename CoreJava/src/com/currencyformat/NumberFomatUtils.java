package com.currencyformat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFomatUtils {

	private NumberFomatUtils() {

	}

	public static String format(final String input, final Locale locale, final RoundingMode mode, final int scale,
			final boolean isCurrency) {
		final Double doubleVal = Double.valueOf(input);
		final BigDecimal value = BigDecimal.valueOf(doubleVal).setScale(scale, mode);
		final NumberFormat formatter = NumberFormat.getNumberInstance(locale);
		if (isCurrency) {
			formatter.setMaximumFractionDigits(scale);
			formatter.setMinimumFractionDigits(scale);
		} else {
			formatter.setMaximumFractionDigits(0);
			formatter.setMinimumFractionDigits(0);
		}
		return formatter.format(value);
	}

}
