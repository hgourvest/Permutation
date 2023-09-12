This project is an experiment with different algorithms for finding a combinatorial numerical system. These algorithms are based on the system known as Factoradic. I don't know what kind of problem this can solve, but I find it interesting.

## There are currently 3 algorithms:

### Heap
Heap algorithm is well known and consists in exchanging only two positions to move on to the next iteration. It's efficient for quickly generating unique combinations, but complicated to manipulate for simple mathematical operations.

### Rotate
This algorithm performs a rotation of the combination corresponding to the position and value of the factorial base. 
This algorithm have no advantages, I can only increment and decrement a combination, but at least the combinations are unique.

### Mirror
The Mirror algorithm consists in exchanging several pairs concentrically according to their position in the factorial base. 
Mirror algorithm is the most promising, it's easy to manipulate for mathematical operations and it's the only one that lets me deduce the index of a combination.
