Ticket: Migration
=================

**Problem:**

**Task**

For this ticket, you'll be completing a script that performs field data type migrations. The script main class implementation is **src/main/java/mflix/Migrator.java**.

Things always change, and a requirement has come down that the _lastupdated_ value in each document of the _movies_ collection needs to be stored as an **ISODate** rather than a **String**.

Apart from the _lastupdated_ field, we also want to clean up the different data types that currently define the field _imdb.rating_, where in some cases it is set as of **Number** type, and in other cases set as **String**. Given that this field represents a numeric value, this field should be set as a number in all documents.

Complete the script so it updates the values using the bulk API.

To perform the migration, run the following command:

```
mvn clean compile exec:java -Dexec.mainClass="mflix.Migrator"
```

or run the _Migrator.java_ class from your IDE.

---

**Testing and Running the Application**

If the application is already running, **stop the application** and run the unit tests for this ticket by executing the following command:

```
mvn test -Dtest=MigrationTest
```

Once the unit tests are passing, run the application with:

```
mvn spring-boot:run
```

Or run the _Application.java_ from your IDE.

Now proceed to the status page to run the full suite of integration tests and get your validation code.

To have the application use the changes that you implemented for this ticket, make sure to **restart the application** after you completed those changes. Also, only refresh the status page to see the new results of the tests, after the application has been restarted.

<details> 
  <summary>After passing the relevant tests, what is the validation code for Migration?</summary>
   Answer: 5ad9f6a64fec134d116fb06f
</details>