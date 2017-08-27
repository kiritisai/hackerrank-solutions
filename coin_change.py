# Print out all the subsets that sum to a particular number
import copy

coins = [int(n) for n in input().strip().split()]
target = int(input())

solution = []

# Returns the number of subsets satisfying the change
def count(remainder, coins):
    if remainder == 0:
        return 1

    if remainder<0 or len(coins) == 0:
        return 0

    return count(remainder, coins[1:]) + count(remainder-coins[0], coins)


# Prints out the subsets
def subsets(remainder, coins, solution):
    if remainder == 0:
        print(solution, id(solution))
        return 1

    if remainder<0 or len(coins) == 0:
        return 0

    return subsets(remainder-coins[0], coins, solution + [coins[0]]) + subsets(remainder, coins[1:], solution) 
    

print(count(target, coins))
print(subsets(target, coins, solution))

