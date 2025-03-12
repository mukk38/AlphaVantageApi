package tr.com.muskar.alphaVantageApi.model.cashFlow;

import lombok.Data;

import java.util.List;

@Data
public class CashFlowResponse {

    private String symbol;
    private List<CashFlowReport> annualReports;
}
