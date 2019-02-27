Ticket: Handling Errors
=========================

**Problem:**

**Task**

For this ticket, you'll be required to modify the following methods:

_MovieDao.java_

**- validIdValue**

_CommentDao.java_

**- addComment**
**- deleteComment**
**- updateComment**

_UserDao.java_

**- addUser**
**- createUserSession**
**- deleteUser**
**- updateUserPreferences**

Ensure that all of these methods are more robust and account for potential exceptions when executed.

---

**MFlix Functionality**

Once this ticket is completed, the app will be able to handle incorrect movie id values and various write exceptions without breaking or throwing an error within the application.

---

**Testing and Running the Application**

If the application is already running, **stop the application** and run the unit tests for this ticket by executing the following command:

```
mvn test -Dtest=HandlingErrorsTest
```

Once the unit tests are passing, run the application with:

```
mvn spring-boot:run
```

Or deploy the application from your IDE.

Now proceed to the status page to run the full suite of integration tests and get your validation code.

To have the application use the changes that you implemented for this ticket, make sure to **restart the application** after you completed those changes. Also, only refresh the status page to see the new results of the tests, after the application has been restarted.

<details> 
  <summary>After passing the relevant tests, what is the validation code for Error Handling?</summary>
   Answer: 5ae9b76a703c7c603202ef22
</details>