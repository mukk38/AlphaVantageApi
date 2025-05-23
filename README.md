# Alpha Vantage Stock API

This project is a Spring Boot REST API that integrates with the **Alpha Vantage API** to provide stock market data, financial reports, and insider transactions.

## Features
- Fetch **top gainers and losers**
- Retrieve **historical options data**
- Get **global stock quotes**
- Access **daily and intraday stock status**
- View **insider transactions**
- Retrieve **income statements, balance sheets, and cash flow reports**

## Prerequisites
- Java 17+
- Maven

## Configuration
Update the `application.properties` file with your **Alpha Vantage API Key**:

```properties
alpha.vantage.api.key=YOUR_API_KEY
alpha.vantage.url=https://www.alphavantage.co/query?
```

## Running the Application
```sh
mvn spring-boot:run
```

## API Endpoints
All endpoints are accessible via **Swagger UI** after starting the application:

**Swagger URL:** [http://localhost:8295/swagger-ui/index.html](http://localhost:8295/swagger-ui/index.html)

### Available Endpoints
| Method | Endpoint                                                  | Description                 |
|--------|-----------------------------------------------------------|-----------------------------|
| GET    | `/stock/top-gainers`                                      | Get top gainers and losers  |
| GET    | `/stock/historical-options?stockCode=IBM`                 | Get historical options data |
| GET    | `/stock/global-quote?stockCode=IBM`                       | Get global quote data       |
| GET    | `/stock/stock-status?stockCode=IBM&stockTimePeriod=DAILY` | Get stock status            |
| GET    | `/stock/stock-intraday?stockCode=IBM&interval=5min`       | Get intraday stock data     |
| GET    | `/stock/insider-transactions?stockCode=IBM`               | Get insider transactions    |
| GET    | `/stock/income-statement?stockCode=IBM`                   | Get income statement        |
| GET    | `/stock/balance-sheet?stockCode=IBM`                      | Get balance sheet           |
| GET    | `/stock/cash-flow?stockCode=IBM`                          | Get cash flow statement     |

## Example Request
```sh
curl -X GET "http://localhost:8295/stock/global-quote?stockCode=IBM" -H "Content-Type: application/json"
```



