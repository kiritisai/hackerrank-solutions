## Dynamic Programming
Dynamic Programming is an algorithmic paradigm that solves a given complex problem by breaking it into subproblems and stores the results of subproblems to avoid computing the same results again.

## Principles
The following are two main principles that can be used to find out if a problem can be solved using Dynamic Programming.
### Overlapping subproblems
Dynamic programming is only useful when solutions to the sub-problems are used again and again. If the sub problems are not overlapping, then there is no use of doing dynamic programming. If the sub-problems are overlapping, the results are memorized in a table to prevent repeated calculations.
#### Memoization (Top Down)
Memoization is similar to the actual recursion formuation, just that we look into the table at the start of each call, to check if the value has been computed already.
The steps are as follows:
* If the table value is not NIL, return `table[i]`
* If the table is NIL and the base condition is satisfied, update the `table[i]` and return the solution.
* If the table is NIL and base condition is also not satisfied, split-up the problem and calculate the result. Then, update `table[i]` and return the result.

**Tip**: Memoization is more intuitive to write, but the drawback might be function call overhead, when most of the values being computed.

#### Tabulation (Bottom Up)
The tabulated program for a given problem builds a table in bottom up fashion and returns the last entry from table. For example, for the same Fibonacci number, we first calculate fib(0) then `fib(1)` then `fib(2)` then `fib(3)` and so on. So literally, we are building the solutions of subproblems bottom-up.
The steps are as follows:
* Initialize the base condition values.
* Iterate over the remaining values of the parameters. 
	* At every iteration, update the entry by combining it's sub-problems from the table.
	* Return the corresponding table entry.

**Tip**: Use it when most of the values in the problem space have to be computed to get the result. It is somewhat not intuitive but it'll be faster since there is no function call overhead.

### Optimal substructure
A problem has optimal substructure property if optimal solution to the problem is a combination of the optimal solution to its subproblems.

### How to recognize a DP?
* Check if the solution has a recursive property, based on some parameters.
* Find out if there is a frequent reuse of the results of recursion.
* If yes, come up with the parameters to cache and implement either memoization or tabulation.