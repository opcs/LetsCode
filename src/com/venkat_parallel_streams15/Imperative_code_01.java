package venkat_parallel_streams15;

import java.util.ArrayList;
import java.util.List;

import venkat_parallel_streams15.common.StockInfo;
import venkat_parallel_streams15.common.StockUtil;
import venkat_parallel_streams15.common.Tickers;
import venkat_parallel_streams15.common.Timeit;

public class Imperative_code_01 {

	public static void processImperative(List<String> symbols) {
		List<StockInfo> stocks = new ArrayList<>();

		for (String symbol : symbols) {
			stocks.add(StockUtil.getPrice(symbol));
		}

		List<StockInfo> stocksLT500 = new ArrayList<>();
		for (StockInfo stock : stocks) {
			if (StockUtil.isPriceLessThan(500).test(stock))
				stocksLT500.add(stock);
		}

		StockInfo highPriced = dummy;
		for (StockInfo stock : stocksLT500) {
			highPriced = StockUtil.pickHigh(stock, highPriced);
		}

		System.out.println(highPriced);
	}

	static StockInfo dummy = new StockInfo("", 0.0);

	public static void main(String[] args) {
		// Given a list of ticker symbols, get me the ticker and the price for the
		// highest priced ticker, but only those less than $500.

		Timeit.code(() -> processImperative(Tickers.symbols));
	}

}
