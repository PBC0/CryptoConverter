Simple Crypto Converter. 
Implements .csv file /resources/rates.csv on application startup.

```http
GET /exchangerates  Get all available rates
GET /convert/{from}/{to} Convert from to || *PathVariables {from}.{to} requestParam 'amount'
```
