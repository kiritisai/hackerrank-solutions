# Question URL: https://www.hackerrank.com/challenges/equal
"""
There was no need of any sort of dynamic programming for this exercise.
The main help in solving the problem was the following assumption:
    Giving all except one is equal to taking from the chosen one.
    Hence, the problem becomes reduction of all numbers to a same minimal
    number.
The numbers are reduced by 5 and then reduced further using 2 and 1 ops.
"""
import copy

T = int(input().strip())

def ops_required(a):
    """
    The array should contain elements in the range of [0-4]
    Returns no.of ops needed to convert the array to all 0s.
    """
    required_ops = {0:0, 1:1, 2:1, 3:2, 4:2}

    total_ops = sum([required_ops[i]*a.count(i) for i in range(5)])
    return total_ops

def reduce_list(a):
    """
    Reduce the array by repeatedly diving with 5;
    Call ops_required on the reduced_list
    and return the list and the no.of ops required.
    """
    total_ops = 0
    duplicate_list = copy.deepcopy(a)
    # Creating a temporary list in order to preserve the original list
    # For each number in the list
    for i in range(len(duplicate_list)):
        total_ops += duplicate_list[i]//5
        duplicate_list[i] = duplicate_list[i]%5

    total_ops += ops_required(duplicate_list)
    return total_ops

for _ in range(T):
    N = int(input().strip())
    initial = [int(n) for n in input().strip().split()]

    # Subtract the minimum value from everything
    initial_min = min(initial)
    initial = [n - initial_min for n in initial]
    #print(initial)

    # Calculate for the original list, increase by 1 and increase by 2
    candidates = []
    candidates.append(reduce_list(initial))
    candidates.append(reduce_list([n+1 for n in initial]))
    candidates.append(reduce_list([n+2 for n in initial]))

    print(min(candidates))
