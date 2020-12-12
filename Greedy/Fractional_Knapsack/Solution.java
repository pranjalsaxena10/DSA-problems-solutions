/**
 * https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 * 
 * Problem: 
 * Fractional Knapsack
 * 
 * Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
    Note: Unlike 0/1 knapsack, you are allowed to break the item. 

    

    Example 1:

    Input:
    N = 3, W = 50
    values[] = {60,100,120}
    weight[] = {10,20,30}
    Output: 240.00
    Explanation: Total maximum value of item
    we can have is 240.00 from the given
    capacity of sack. 
 */

/**
 * Approach:
 * 1. Sort on the basis of value / weight ratio in decreasing order
 * 2. Keep taking full element after sorting
 * 3. If full can't be taken, take fraction of it
 * 
 * Time Complexity: O(n * log N)
 * Space Complexity: O(1) 
 */
class Solution {
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        
        Arrays.sort(arr, (Item item1, Item item2) -> {
            
            double ratio1 = (double) item1.value / (double) item1.weight;
            double ratio2 = (double) item2.value / (double) item2.weight;
            
            if (ratio1 < ratio2)
                return 1;
                
                else 
                    if (ratio1 > ratio2)
                        return -1;
                        
                        else
                            return 0;
        });
        
        double profit = 0d;
        
        for (int i=0; i<arr.length; i++) {
            
            if (arr[i].weight <= W) {
                
                profit += arr[i].value;
                W -= arr[i].weight;
            }
            
            else {
                
                double fraction = (double) W / (double) arr[i].weight;
                profit += (fraction * arr[i].value);
                
                W -= (fraction * arr[i].weight);
                
                
            }
        }
        
        return profit;
    }    
}
