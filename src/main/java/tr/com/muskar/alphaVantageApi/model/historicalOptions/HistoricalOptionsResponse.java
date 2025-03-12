package tr.com.muskar.alphaVantageApi.model.historicalOptions;

import lombok.Data;

import java.util.List;

@Data
public class HistoricalOptionsResponse {

    private String endpoint;
    private String message;
    private List<HistoricalOptionData> data;
}
