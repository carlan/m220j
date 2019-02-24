Ticket: Durable Writes
======================

**Correct answers:**

**WriteConcern.W2 and WriteConcern.MAJORITY**

n a 3-node replica set, these two Write Concerns will both wait until 2 nodes have applied a write. This is because 2 out of 3 nodes is a majority, and waiting for 2 nodes to apply a write is **more durable** than only waiting for 1 node to apply it.

**Incorrect answers:**

_WriteConcern.W1_

This is already the default Write Concern in MongoDB, so it does not represent a higher durability than the default.

_WriteConcern.UNACKNOWLEDGED_

This will not wait for any nodes to apply a write before sending an acknowledgement, so it is a less durable write than the default value of **WriteConcern.W1**.

**Updated addUser method (using w: majority ):**

```
/**
* @return Success or failure
*/
public boolean addUser(User user) {
    usersCollection.withWriteConcern(WriteConcern.MAJORITY).insertOne(user);
    return true;
}
```
