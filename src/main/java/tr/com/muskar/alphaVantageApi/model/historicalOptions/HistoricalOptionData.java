package tr.com.muskar.alphaVantageApi.model.historicalOptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HistoricalOptionData {
    @JsonProperty("contractID")
    private String contractId;
    private String symbol;
    private String expiration;
    private String strike;
    private String type;
    private String last;
    private String mark;
    private String bid;
    @JsonProperty("bid_size")
    private String bidSize;
    private String ask;
    @JsonProperty("ask_size")
    private String askSize;
    private String volume;
    @JsonProperty("open_interest")
    private String openInterest;
    private String date;
    @JsonProperty("implied_volatility")
    private String impliedVolatility;
    private String delta;
    private String gamma;
    private String theta;
    private String vega;
    private String rho;
}
