Simple Crypto Converter. 
Implements .csv file /resources/rates.csv on application startup.

```http
API GET /exchangerates  Get all available rates
API GET /convert/{from}/{to} Convert from to || *PathVariables {from}.{to} requestParam 'amount'
```
