Final: Question 3
=================

**Problem:**

Let's take the following code, where URI is a connection to your Atlas cluster using an SRV record.

```
MongoClientSettings settings = MongoClientSettings.builder() \
    .applyConnectionString(new ConnectionString(URI)).build();
MongoClient mongoClient = MongoClients.create(settings);

// TODO do a read on the cluster to ensure you are connected

SslSettings sslSettings = settings.getSslSettings();
ReadPreference readPreference = settings.getReadPreference();
ReadConcern readConcern = settings.getReadConcern();
WriteConcern writeConcern = settings.getWriteConcern();
```

<details> 
  <summary>Which of the following variables contained the associated value?</summary>
   Answer: (X) readConcern.asDocument().toString() = "{ }"
           (X) readPreference.toString() = "primary"
           (X) writeConcern.asDocument().toString() = "{ w : 1 }"

   Comments:
           (X) writeConcern.asDocument().toString() = "{ w : 1 }"
           Although the Write Concert default of MongoDB is *w: 1*, the code doesn't print as above but "{ }". Not sure about this one.
           See https://docs.mongodb.com/manual/reference/write-concern/
</details>


