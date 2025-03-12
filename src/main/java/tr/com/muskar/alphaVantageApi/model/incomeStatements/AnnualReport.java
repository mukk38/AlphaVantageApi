package tr.com.muskar.alphaVantageApi.model.incomeStatements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnnualReport {

    private String fiscalDateEnding;
    private String reportedCurrency;
    private String grossProfit;
    private String totalRevenue;
    private String costOfRevenue;
    @JsonProperty("costofGoodsAndServicesSold")
    private String costOfGoodsAndServicesSold;
    private String operatingIncome;
    private String sellingGeneralAndAdministrative;
    private String researchAndDevelopment;
    private String operatingExpenses;
    private String investmentIncomeNet;
    private String netInterestIncome;
    private String interestIncome;
    private String interestExpense;
    private String nonInterestIncome;
    private String otherNonOperatingIncome;
    private String depreciation;
    private String depreciationAndAmortization;
    private String incomeBeforeTax;
    private String incomeTaxExpense;
    private String interestAndDebtExpense;
    private String netIncomeFromContinuingOperations;
    private String comprehensiveIncomeNetOfTax;
    private String ebit;
    private String ebitda;
    private String netIncome;
}
