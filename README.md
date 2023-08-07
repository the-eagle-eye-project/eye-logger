# eye-logger

This repository will host the API that will store and retrieve logs into ElasticSearch.

## Meta Logs Index Mapping

```
# Log Index
PUT /eye-logs-idx
{ 
  "mappings": {
    "properties": {
      "transaction_id": {
        "type": "keyword"
      },
      "integration_id": {
        "type" : "keyword"
      },
      "e2e_transaction_id": {
        "type" : "keyword"
      },
      "event_timestamp": {
        "type": "date",
        "format": "yyyy-MM-dd'T'HH:mm:ss.SSS"
      },
      "request_body": {
        "type": "text"
      },
      "request_uri": {
        "type": "text"
      },
      "source_host": {
        "type": "text"
      },
      "transaction_status": {
        "type": "text"
      },
      "transaction_execution_time_ms": {
        "type" : "integer"
      },
      "transaction_status_code": {
        "type": "keyword"
      },
      "transaction_message": {
        "type": "text"
      }
    }
  }
}

GET /meta-logs-idx/_search
{
  "query": {
    "match_all": {}
  }
}

# Activate a specific integration id
GET meta-eye-idx/_search
{
  "query": {
    "terms": {
      "_id": [ "86a4dfb0-6811-44d9-bcfd-921612921270" ] 
    }
  }
}

POST meta-eye-idx/_update/86a4dfb0-6811-44d9-bcfd-921612921270
{
  "doc": {
    "is_active": true
  }
}
```