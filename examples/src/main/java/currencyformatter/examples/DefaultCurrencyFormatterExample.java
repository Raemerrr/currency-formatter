package currencyformatter.examples;

import io.github.raemerrr.DefaultCurrencyFormatter;

import java.util.Locale;

public class DefaultCurrencyFormatterExample {

    public static void main(String[] args) {
        var formatter = new DefaultCurrencyFormatter();

        System.out.println(formatter.format(Locale.KOREA, 123456.789)); // ₩123,457
        System.out.println(formatter.format(Locale.US, "123456.789")); // $123,456.79
        System.out.println(formatter.format(Locale.JAPAN, 123456));   // ￥123,456
    }
}
