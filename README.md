# Project Title: Concurrent Bank Account Transaction System
# Course Code: CSC2044 (Concurrent Programming in Java)

## BY Chew Zhan Hong, Student 2, Student 3.

--- 

# How to Compile the Project:

---


1. Open your terminal or command-line interface.
2. Navigate directly into the root folder containing the four extracted source files.
3. Execute the standard Java compiler command to compile all files at once:

```java
   javac SequentialBanking.java ConcurrentBanking.java RCBanking.java SynchroBanking.java
```

--- 

# How to Run Each Module:

---

Execute the desired target program class file using the standard Java runtime command:

To execute Task 2 (Sequential Pipeline Verification):
```java
java SequentialBanking
```

To execute Task 3 (Concurrent Thread Interleaving Simulation):
```java
java ConcurrentBanking
```

To execute Task 5 (Unsafe Race Condition Demonstration):
```java
java RCBanking
```

To execute Task 6 (Synchronized Mutual Exclusion Verification):
```java
java SynchroBanking
```

---

# Technical Implementation Notes:

---

- No external frameworks or third-party dependencies are required; the system
  runs entirely on standard Java Development Kit (JDK) libraries.
- The console tracking order inside 'ConcurrentBanking' and the exact data loss
  deficit in 'RCBanking' will vary naturally between runs due to dynamic
  operating system thread scheduling.
