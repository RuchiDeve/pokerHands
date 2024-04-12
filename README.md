This project implements a poker hand evaluator in Java, allowing users to determine the ranking of poker hands and compare them to determine winners.

Components:
 HandValue Class: Defines methods for evaluating poker hands, including determining the rank of a hand, checking for specific hand combinations (e.g., Royal Flush, Four of a Kind), and comparing high cards.
 Main Class: Provides a command-line interface for reading poker hands from a file, evaluating them using the HandValue class, and determining the winner based on hand ranks and high card comparisons.
 Card Class: Represents a playing card with a value and a suit. Used to construct hands and perform comparisons.
 DeckBuilder Class: Provides functionality for parsing hands from a text representation and organising them into appropriate data structures for evaluation.
 Enum:
 The project includes an enum named Rank to represent the possible ranks of poker hands.
 Each rank is assigned a numerical value to facilitate comparisons.
 The enum provides clarity and maintainability by encapsulating the different hand ranks in the poker game.

 Testing:
 Unit tests have been written for each method in the HandValue class to verify its correctness.
 Test cases cover various hand combinations, including edge cases and boundary conditions.
 Additional tests have been written for the DeckBuilder class to ensure proper parsing of hands from the input file.
 All tests pass successfully, indicating that the implementation behaves as expected.

Usage:
 Compile the Java files and ensure they are in the same directory.
Place a file named "poker.txt" containing poker hands in the specified format (e.g., "5H 5C 6S 7S KD 2C 3S 8S 8D TD") in the resources directory.
 Run the Main class to evaluate the poker hands and determine the winner.

Author:
  Uruchi Okezie


