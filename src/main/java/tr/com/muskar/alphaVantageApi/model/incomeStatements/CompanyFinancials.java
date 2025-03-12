package tr.com.muskar.alphaVantageApi.model.incomeStatements;

import java.util.List;

public record CompanyFinancials(String symbol, List<AnnualReport> annualReports) {
}
