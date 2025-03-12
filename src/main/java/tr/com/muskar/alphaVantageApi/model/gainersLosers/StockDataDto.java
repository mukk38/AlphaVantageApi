package tr.com.muskar.alphaVantageApi.model.gainersLosers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StockDataDto {

    private String metadata;
    private String lastUpdated;
    @JsonProperty("top_gainers")
    private List<StockDto> topGainers;
    @JsonProperty("top_losers")
    private List<StockDto> topLosers;
    @JsonProperty("most_actively_traded")
    private List<StockDto> mostActivelyTraded;
}
