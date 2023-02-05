#!/bin/bash
#curl -d '{  "name":"test", "description":"test", "createDate":"test", "changeDate":"12/12//2012", "unitPrice": 1.0, "creator": "creat" }' -H 'Content-Type: application/json' http://localhost:8080/product
curl -d '{  "customerId":"123", "quoteDate":"11/07/2022", "billingAddress":"722 Main St", "billingCity":"San Jose", "billingState": "CA", "billingCountry": "USA", "billingPostalCode": "95035", "total" : 123, "quoteLines" : [{"quoteId" : 1, "product" : {"name":"test", "description":"test", "createDate":"test", "changeDate":"12/12//2012", "unitPrice": 1.0, "creator": "creat" }, "unitPrice": 12, "quantity" : 1}]}' -H 'Content-Type: application/json' http://localhost:8080/quote

