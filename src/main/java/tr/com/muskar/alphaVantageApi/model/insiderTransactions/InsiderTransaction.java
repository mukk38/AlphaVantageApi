package tr.com.muskar.alphaVantageApi.model.insiderTransactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InsiderTransaction {

    @JsonProperty("transaction_date")
    private String transactionDate;

    private String ticker;

    private String executive;

    @JsonProperty("executive_title")
    private String executiveTitle;

    @JsonProperty("security_type")
    private String securityType;

    @JsonProperty("acquisition_or_disposal")
    private String acquisitionOrDisposal;

    private String shares;

    @JsonProperty("share_price")
    private String sharePrice;
}
