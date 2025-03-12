package tr.com.muskar.alphaVantageApi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tr.com.muskar.alphaVantageApi.model.enums.StockTimePeriod;
import tr.com.muskar.alphaVantageApi.model.gainersLosers.StockDataDto;
import tr.com.muskar.alphaVantageApi.model.globalQuote.GlobalQuoteDto;
import tr.com.muskar.alphaVantageApi.model.historicalOptions.HistoricalOptionsResponse;
import tr.com.muskar.alphaVantageApi.model.incomeStatements.CompanyFinancials;
import tr.com.muskar.alphaVantageApi.model.insiderTransactions.InsiderTransactionResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlphaVantageService {

    private final RestTemplate restTemplate;
    @Value("${alpha.vantage.url}")
    private String alphaVantageUrl;
    @Value("${alpha.vantage.api.key}")
    private String alphaVantageApiKey;


    private String createTimeSeriesUrl(String symbol,String interval) {
        return UriComponentsBuilder.fromHttpUrl(alphaVantageUrl)
                .queryParam("function", "TIME_SERIES_INTRADAY")
                .queryParam("symbol", symbol)
                .queryParam("interval", "5min")
                .queryParam("apikey", alphaVantageApiKey)
                .toUriString();
    }

    public StockDataDto topGainersAndLosers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        StockDataDto stockDataDto = null;
        try {
            ResponseEntity<StockDataDto> response = restTemplate.getForEntity(alphaVantageUrl + "function=TOP_GAINERS_LOSERS&apikey=" + alphaVantageApiKey, StockDataDto.class, entity);
            if (response.getStatusCode() == HttpStatusCode.valueOf(200) || response.getStatusCode() == HttpStatusCode.valueOf(201)) {
                stockDataDto = response.getBody();
            }

        } catch (Exception e) {
            log.error(e.getMessage() + " when requesting TOP_GAINERS_LOSERS");
        }
        return stockDataDto;
    }


    public Object timeSeriesTimePeriod(String stockCode , StockTimePeriod stockTimePeriod) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Object result = null;
        String timeParameter = "TIME_SERIES_DAILY";
        if(stockTimePeriod == StockTimePeriod.WEEKLY){
            timeParameter = "TIME_SERIES_WEEKLY";
        }
        String url = alphaVantageUrl+"function="+timeParameter+"&symbol="+stockCode+"&outputsize=full&apikey="+alphaVantageApiKey;
        try{
            ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class, entity);
            if (response.getStatusCode() == HttpStatusCode.valueOf(200) || response.getStatusCode() == HttpStatusCode.valueOf(201)) {
                result = response.getBody();
            }
        }catch (Exception e){
            log.error(e.getMessage()+" when requesting TIME_SERIES_DAILY");
        }
        return result;
    }

    public Object timeSeriesIntraday(String stockCode, String interval) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Object result = null;
        try{
            ResponseEntity<Object> response = restTemplate.getForEntity(createTimeSeriesUrl(stockCode,interval), Object.class, entity);
            if (response.getStatusCode() == HttpStatusCode.valueOf(200) || response.getStatusCode() == HttpStatusCode.valueOf(201)) {
                result = response.getBody();
            }
        }catch (Exception e){
            log.error(e.getMessage()+" when requesting TIME_SERIES_INTRADAY");
        }
        return result;
    }

    public <T> T fetchData(String stockCode, String function, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = alphaVantageUrl + "function=" + function + "&symbol=" + stockCode + "&apikey=" + alphaVantageApiKey;

        try {
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
            if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
                return response.getBody();
            }
        } catch (Exception e) {
            log.error("Error fetching data for function: " + function + " -> " + e.getMessage());
        }

        return null;
    }




}
