/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        
        getHeight(root);
        
        return result;
    }
    
    private int getHeight(TreeNode root) {
        if(root == null) return -1;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int curHeight = Math.max(leftHeight, rightHeight) + 1;
        
        if(result.size() == curHeight) {
            result.add(new ArrayList<>());
        }
        
        result.get(curHeight).add(root.val);
        return curHeight;
    }
}