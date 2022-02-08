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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean isRight = false;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return new ArrayList<>();
        
        q.add(root);
        do {
            Queue<TreeNode> tmp = new LinkedList<>();
            List<Integer> level = new ArrayList<>();

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) tmp.add(cur.left);
                if (cur.right != null) tmp.add(cur.right);
            }

            if (isRight) {
                Collections.reverse(level);
            }
            result.add(level);
            isRight = !isRight;

            q.addAll(tmp);
        } while (!q.isEmpty());

        return result;
    }
}