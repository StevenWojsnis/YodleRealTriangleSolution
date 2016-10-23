# YodleRealTriangleSolution
Attempted solution to the Yodle RealTriangle question

Solves the triangle problem by finding the highest adjacent element in the row directly above
a given element. That adjacent element is then added to the given element. This process is continued
until the bottom row is reached, which will contain the total sums, which can then be cycled through
to find the highest.


The question is no longer posted on the Yodle website, but it posed the problem:

Given an input file, find the path (starting from the top of the triangle) to the base level of the triangle, such that
the summation of numbers that were travelled on is the maximum possible summation for all possible paths.

For example, given the triangle input:

5 <br>
9 6 <br>
4 6 8 <br>
0 7 1 5 <br>

The program should output 27, as this is the path from top to bottom that gives the highest sum (5+9+6+7).

<b>The answer to the provided triangle input file included in the repository is : 732506.</b>

