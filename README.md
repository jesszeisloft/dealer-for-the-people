# Dealer for the People

### Overview

An application to uncover the most over-enthusiastic car dealership reviews.

### Running the Application 

In Terminal, from project root directory:
```
$ ./gradlew clean build run
```

### Running Tests

In Terminal, from project root directory:
```
$ ./gradlew test
```

### Review Evaluation Criteria

Evaluation is based on the following two factors:
1. Number of exclamation points
2. Length of review

The first will be applied first. The second will be taken into account if there is a tie. Subsequent ties will be in the order in which they appear on the webpage. 

Evaluation logic is designed to be iterated upon to be extended to include more fine-tuned criteria.


