# eye-logger
This repository will host the API that will store and retrieve logs into ElasticSearch.

## Meta Logs Index Mapping
```
PUT /meta-logs-idx
{ 
  "mappings": {
    "properties": {
      "transaction_id": {
        "type": "text"
      },
      "integration_id": {
        "type" : "keyword"
      },
      "application_name": {
        "type": "text"
      },
      "application_step": {
        "type": "text"
      },
      "event_timestamp": {
        "type": "date"
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
```