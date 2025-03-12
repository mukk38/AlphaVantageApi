package tr.com.muskar.alphaVantageApi.model.balanceSheet;

import java.util.List;

public record BalanceSheetResponse(String symbol, List<BalanceSheet> annualReports) {
}
