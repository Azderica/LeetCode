/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> result;
    private TreeNode target;
    private int K;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        result = new ArrayList<>();
        this.target = target;
        this.K = k;
        
        dfs(root);
        
        return result;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        } else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int left = dfs(node.left), right = dfs(node.right);
            if(left != -1) {
                if(left == K) result.add(node.val);
                subtree_add(node.right, left + 1);
                return left + 1;
            } else if(right != -1) {
                if(right == K) result.add(node.val);
                subtree_add(node.left, right + 1);
                return right + 1;
            } else {
                return -1;
            }
        }
    }
    
    private void subtree_add(TreeNode node, int dist) {
        if(node == null) return;
        if(dist == K)
            result.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}