package tr.com.muskar.alphaVantageApi.model.gainersLosers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StockDto {

    private String ticker;
    private String price;
    @JsonProperty("change_amount")
    private String changeAmount;
    @JsonProperty("change_percentage")
    private String changePercentage;
    private String volume;
}
