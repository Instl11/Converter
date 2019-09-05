package com.c.currency.onverter.domen;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ParserCurrency {

    public static List<CurrenciesRate> getCurrenciesRate() throws IOException {
        Document page = Jsoup.parse(new URL("https://www.banki.ru/products/currency/"), 3000);

        Element table = page.select("table[class=cb-current-rates__list]").first();

        Element dollar = table.selectFirst("tr[data-currency-id=840]");
        String d = dollar.text().replaceAll(".*(\\d{2},\\d{4}).+", "$1").replaceAll(",", ".");
        Double dollarRate = Double.parseDouble(d);
        System.out.println(dollarRate);

        Element euro = table.selectFirst("tr[data-currency-id=978]");
        String e = euro.text().replaceAll(".*(\\d{2},\\d{4}).+", "$1").replaceAll(",", ".");
        Double euroRate = Double.parseDouble(e);
        System.out.println(euroRate);

        Element gbp = table.selectFirst("tr[data-currency-id=826]");
        String g = gbp.text().replaceAll(".*(\\d{2},\\d{4}).+", "$1").replaceAll(",", ".");
        Double gbpRate = Double.parseDouble(g);
        System.out.println(gbpRate);

        List<CurrenciesRate> list = Arrays.asList(
                new CurrenciesRate(Currency.DOLLAR, dollarRate),
                new CurrenciesRate(Currency.EURO, euroRate),
                new CurrenciesRate(Currency.GBP, gbpRate)
        );
        return list;

    }
}








//    public Element getTable(Document page){
//        Element table = page.select("table[class=wt]").first();
//        return table;
//    }
//
//
//    public Elements getNamesFromTable(Element table){
//        Elements names = table.select("tr[class=wth]");
//        return names;
//    }
//
//
//    public String getDateFromNamesByIndex(Elements names, int index) {
//        String firstDate = names.get(index).select("th[id=dt]").text().replaceAll("(\\d{2}\\.\\d{2}).*", "$1");
//        return firstDate;
//    }
//
//
//    public Elements getValuesFromTable(Element table) {
//        Elements values = table.select("tr[valign=top]");
//        return values;
//    }