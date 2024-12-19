package io.github.raemerrr;

import java.text.NumberFormat;
import java.util.Locale;

public class DefaultCurrencyFormatter implements CurrencyFormatter {

	@Override
	public String format(Locale locale, Object currency) throws IllegalArgumentException {
		if (locale == null || currency == null) {
			throw new IllegalArgumentException("Locale and currency must not be null.");
		}
		var currencyFormat = NumberFormat.getCurrencyInstance(locale);
		var parsedCurrency = parseCurrency(currency);

		return currencyFormat.format(parsedCurrency);
	}

	private double parseCurrency(Object currency) throws IllegalArgumentException {
		try {
			if (currency instanceof Number number) {
				return number.doubleValue();
			} else {
				return Double.parseDouble(currency.toString());
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Currency must be a valid number.");
		}
	}
}
