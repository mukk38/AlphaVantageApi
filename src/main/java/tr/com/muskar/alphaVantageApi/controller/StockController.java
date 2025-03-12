package tr.com.muskar.alphaVantageApi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.muskar.alphaVantageApi.model.balanceSheet.BalanceSheetResponse;
import tr.com.muskar.alphaVantageApi.model.cashFlow.CashFlowResponse;
import tr.com.muskar.alphaVantageApi.model.enums.StockTimePeriod;
import tr.com.muskar.alphaVantageApi.model.gainersLosers.StockDataDto;
import tr.com.muskar.alphaVantageApi.model.globalQuote.GlobalQuoteDto;
import tr.com.muskar.alphaVantageApi.model.historicalOptions.HistoricalOptionsResponse;
import tr.com.muskar.alphaVantageApi.model.incomeStatements.CompanyFinancials;
import tr.com.muskar.alphaVantageApi.model.insiderTransactions.InsiderTransactionResponse;
import tr.com.muskar.alphaVantageApi.service.AlphaVantageService;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class StockController {

    private final AlphaVantageService alphaVantageService;

    @GetMapping(value = "/top-gainers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDataDto> topGainersAndLosers(){
        return new ResponseEntity<>(alphaVantageService.topGainersAndLosers(), HttpStatus.OK);
    }

    @GetMapping(value = "/historical-options",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HistoricalOptionsResponse> historicalOptionsOfStock(@RequestParam(name = "stockCode") String stockCode){
        return new ResponseEntity<>(alphaVantageService.fetchData(stockCode,"HISTORICAL_OPTIONS", HistoricalOptionsResponse.class), HttpStatus.OK);
    }

    @GetMapping(value = "/global-quote",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GlobalQuoteDto> globalQuoteData(@RequestParam(name = "stockCode") String stockCode){
        return new ResponseEntity<>(alphaVantageService.fetchData(stockCode,"GLOBAL_QUOTE", GlobalQuoteDto.class), HttpStatus.OK);
    }

    @GetMapping(value = "/stock-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> timeSeriesDaily(@RequestParam(name = "stockCode") String stockCode, @RequestParam StockTimePeriod stockTimePeriod){
        return new ResponseEntity<>(alphaVantageService.timeSeriesTimePeriod(stockCode,stockTimePeriod), HttpStatus.OK);
    }
    @GetMapping(value = "/stock-intraday",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> timeSeriesIntraday(@RequestParam(name = "stockCode") String stockCode,String interval){
        return new ResponseEntity<>(alphaVantageService.timeSeriesIntraday(stockCode,interval), HttpStatus.OK);
    }

    @GetMapping(value = "/insider-transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InsiderTransactionResponse> insiderTransactionsOfStock(@RequestParam(name = "stockCode") String stockCode){
        return new ResponseEntity<>(alphaVantageService.fetchData(stockCode,"INSIDER_TRANSACTIONS", InsiderTransactionResponse.class),HttpStatus.OK);
    }

    @GetMapping(value = "/income-statement", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyFinancials> companyFinancialResult(@RequestParam(name = "stockCode") String stockCode){
        return new ResponseEntity<>(alphaVantageService.fetchData(stockCode,"INCOME_STATEMENT", CompanyFinancials.class), HttpStatus.OK);
    }

    @GetMapping(value = "/balance-sheet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceSheetResponse> balanceSheetResult(@RequestParam(name = "stockCode") String stockCode){
        return new ResponseEntity<>(alphaVantageService.fetchData(stockCode,"BALANCE_SHEET", BalanceSheetResponse.class), HttpStatus.OK);
    }

    @GetMapping(value = "/cash-flow", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CashFlowResponse> cashFlowResponse(@RequestParam(name = "stockCode") String stockCode){
        return new ResponseEntity<>(alphaVantageService.fetchData(stockCode,"CASH_FLOW", CashFlowResponse.class), HttpStatus.OK);
    }
}
