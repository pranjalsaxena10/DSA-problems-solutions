/**
 * https://practice.geeksforgeeks.org/problems/word-break-part-2/0
 * 
 * Problem:
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

    Return all such possible sentences.

    For example, given
    s = "snakesandladder",
    dict = ["snake", "snakes", "and", "sand", "ladder"].

    A solution is ["snakes and ladder",
            "snake sand ladder"].
    
    Exapmle:
    Input:
    1
    5
    lr m lrm hcdar wk
    hcdarlrm

    Output:
    (hcdar lr m)(hcdar lrm)
*/

/**
 * Approach:
 * 1. Implementing Trie in order to search better to generate all possible Strings
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Trie {
    class TrieNode {
        
        Map<Character, TrieNode> children;
        boolean endOfWord;
        TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    
    private TrieNode root = new TrieNode();
    
    public void insert(String input) {
        insertUtil(0, root, input);
    }
    
    private void insertUtil(int index, TrieNode parent, String input) {
        
        if(index == input.length()) {
            parent.endOfWord = true;
            return;
        }
        
        char ch = input.charAt(index);
        TrieNode node = parent.children.get(ch);
        
        if(node == null) {
            node = new TrieNode();
            parent.children.put(ch, node);
        }
        
        insertUtil(index + 1, node, input);
    }
    
    public boolean search(String input) {
        return searchUtil(0, root, input);
    }
    
    private boolean searchUtil(int start, TrieNode parent, String input) {
        
        if(start == input.length()) {
            return parent.endOfWord;    
        }
        
        char ch = input.charAt(start);
        TrieNode node = parent.children.get(ch);
        
        if(node == null)
            return false;
            
        return searchUtil(start + 1, node, input);
    }
}
class Solution
 {
    private static PriorityQueue<String> result;
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int t=Integer.parseInt(sc.nextLine());
	    while(t-->0)
	    {
	        int n = Integer.parseInt(sc.nextLine());
	        String[] dictionary = sc.nextLine().split(" ");
	        String input = sc.nextLine();
	        result = new PriorityQueue<>();
	        
	        Trie trie = new Trie();
	        
	        for(int i=0; i<dictionary.length; i++) {
	            trie.insert(dictionary[i]);
	        }
	        result = backtrack(trie, input, "");
	        while(!result.isEmpty()) {
	            System.out.print("(" + result.poll() + ")");
	        }
	        System.out.println("");

	    }
	 }
	 
	 
	 private static PriorityQueue<String> backtrack(Trie trie, String input, String tempResult) {
	     
	     for(int i=1; i<=input.length(); i++) {
	         
	         String prefix = input.substring(0, i);
	         
	         if(trie.search(prefix)) {
	             
	             if(i == input.length()) {
	                 tempResult += prefix;
        	         result.add(tempResult);
        	         return result;
        	     }
	             backtrack(trie, input.substring(i, input.length()), tempResult + prefix + " ");
	         }
	         
	     }
	     
	     return result;
	 }
}