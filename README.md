# random-number-frequency-analyzer
Random Number Frequency Analyzer written in Java 

This application generates a series of random integers between 0‐999, inclusive, and then provides a
variety of metrics on those values. The user specifies the number of random values to
be generated, and they are presented with a sorted list of the actual values generated, a histogram of
those values, and some numerical statistics (maximum, minimum, average, median, etc).

The interface restricts the user from choosing to generate more than 5,000 values. 
It alsos gives the user control over the number of values to be printed per line (again with the restriction that no more than 12 values can be listed per line)

The interface allows users to enter a number less than 1 for the number of numbers - in that case, the object will generate 100 numbers.

This application was developed for CS6311 of the MS in Applied Comp Sci at the University of West Georgia
