/**
 * https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
 * 
 * Problem: 
 * 
 * Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

    Example 1:

    Input:
    N = 4
    M = 3
    E = 5
    Edges[] = {(1,2),(2,3),(3,4),(4,1),(1,3)}
    Output: 1
    Explanation: It is possible to colour the
    given graph using 3 colours.
 */

/**
 * Approach:
 * 1. Start from 1st vertex
 * 2. Assign first color to it
 * 3. Check by assigning this color is Valid and backtracking for next vertex result are both true
 * 4. If it is then return true else revert back previous color assignment
 * 5. When vertex reaches V return true
 * 
 * Time Complexity: O(m^V), m=> no Of Colors and V=> No of vertices
 * Space Complexity: O(V) to store colors
 */

class Solution {

    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
        
        
        return backtrack(G, color, i, G.length, C);
    }
    
    private static boolean backtrack(List<Integer>[] graph, int[] color, int vertex, int V, int C) {
        
        if(vertex == V) {
            return true;
        }
        
        for(int i=1; i<=C; i++) {
            color[vertex] = i;
            
            if(isValidColor(graph, color, vertex, i) && backtrack(graph, color, vertex + 1, V, C))
               return true;
                
            color[vertex] = -1;
                
        }
        
        return false;
    }
    
    private static boolean isValidColor(List<Integer>[] graph, int[] color, int vertex, int choiceOfColor) {
        List<Integer> neighbors = graph[vertex];
        
        for(int i=0; i<neighbors.size(); i++) {
            if(color[neighbors.get(i)] == choiceOfColor)
                return false;
        }
        
        return true;
    }
}
