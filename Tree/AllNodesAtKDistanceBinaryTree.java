public class AllNodesAtKDistanceBinaryTree {
     
        
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        List<Integer> result = new ArrayList<>();
        
        if(root == null || target == null)
            return result;
        
        dfs(root, target, K, result);
        
        return result;
    }
    
    private int dfs(TreeNode node, TreeNode target, int k, List<Integer> result) {
        
        if(node == null)
            return -1;
        
        if(node == target) {
            nodesAtK(node, 0, k, result);
            return 0;
        }
            
        int left = dfs(node.left, target, k, result);
        
        if(left != -1) {
            
            if(left + 1 == k) {
                result.add(node.val);
            } else {
                nodesAtK(node.right, 0, k-left-2, result);    
            }
            
            return left+1;
            
        }
        
        int right = dfs(node.right, target, k, result);
        
        if(right != -1) {
            if(right+1 == k) {
                result.add(node.val);
            } else {
                nodesAtK(node.left, 0, k-right-2, result);
            }
            
            return right+1;
        }
        
        return -1;
    }
    
    
    private void nodesAtK(TreeNode node, int index, int k, List<Integer> result) {
        
        if(node == null)
            return;
        
        if(index == k) {
            System.out.println(node.val + " " + k);
            result.add(node.val);
            return;
        }
        
        nodesAtK(node.left, index + 1, k, result);
        nodesAtK(node.right, index + 1, k, result);
    }   
}
