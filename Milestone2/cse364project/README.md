# This is the second project of CSE36401 course

# Algorithm
1. Calculates the weight for each factor: if the factor is omitted, it receives factor 0, therwise 1.
2. Construct the ordered mapping of users to their significance, which is calculated as S = L1 * F1 + L2 * F2 + L3 * F3 ( if same factor i, L_i = 0.333; otherwise 0); 
3. Construct the ordered mapping of movie to their relative rating, which is calculated as R = r * (S+1)
4. Recommend movies with top 10 relative rating


# Important
We need to think more about algorithm
Current implementation might be buggy and inefficient.
