package io.github.raemerrr;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;
import org.junit.jupiter.api.Test;

class CurrencyFormatterTest {

	private static final CurrencyFormatter DEFAULT_CURRENCY_FORMATTER = new DefaultCurrencyFormatter();

	@Test
	void format_shouldFormatCurrencyForLocale() {
		assertEquals("₩123,457", DEFAULT_CURRENCY_FORMATTER.format(Locale.KOREA, 123456.789));
		assertEquals("$123,456.79", DEFAULT_CURRENCY_FORMATTER.format(Locale.US, 123456.789));
		assertEquals("￥123,457", DEFAULT_CURRENCY_FORMATTER.format(Locale.JAPAN, 123456.789));
	}

	@Test
	void format_shouldThrowExceptionWhenLocaleIsNull() {
		var exception = assertThrows(IllegalArgumentException.class, () ->
				DEFAULT_CURRENCY_FORMATTER.format(null, 123456.789)
		);
		assertEquals("Locale and Currency must not be null.", exception.getMessage());
	}

	@Test
	void format_shouldThrowExceptionWhenCurrencyIsNull() {
		var exception = assertThrows(IllegalArgumentException.class, () ->
				DEFAULT_CURRENCY_FORMATTER.format(Locale.US, null)
		);
		assertEquals("Locale and Currency must not be null.", exception.getMessage());
	}

	@Test
	void format_shouldThrowExceptionForInvalidStringCurrency() {
		var exception = assertThrows(IllegalArgumentException.class, () ->
				DEFAULT_CURRENCY_FORMATTER.format(Locale.US, "invalid Currency")
		);
		assertEquals("Currency must be a valid number.", exception.getMessage());
	}

	@Test
	void format_shouldFormatIntegerCurrency() {
		assertEquals("₩123,456", DEFAULT_CURRENCY_FORMATTER.format(Locale.KOREA, 123456));
	}

	@Test
	void format_shouldParseStringCurrency() {
		assertEquals("$123,456.79", DEFAULT_CURRENCY_FORMATTER.format(Locale.US, "123456.789"));
	}

	@Test
	void format_shouldFormatDoubleCurrency() {
		assertEquals("123 456,79 €", DEFAULT_CURRENCY_FORMATTER.format(Locale.FRANCE, 123456.789));
	}

	@Test
	void format_shouldFormatFloatCurrency() {
		assertEquals("£123,456.79", DEFAULT_CURRENCY_FORMATTER.format(Locale.UK, 123456.789f));
	}
}
