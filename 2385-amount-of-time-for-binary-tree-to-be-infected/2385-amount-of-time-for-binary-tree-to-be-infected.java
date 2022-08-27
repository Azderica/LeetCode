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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        createGraph(root, graph);
        return maxDistance(graph, new HashSet<>(), start, 0, 0);
    }

    private void createGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        List<Integer> adjacent = graph.computeIfAbsent(root.val, x -> new ArrayList<>());

        if(root.left != null) {
            graph.computeIfAbsent(root.left.val, x -> new ArrayList<>()).add(root.val);
            adjacent.add(root.left.val);
            createGraph(root.left, graph);
        }
        if(root.right != null) {
            graph.computeIfAbsent(root.right.val, x -> new ArrayList<>()).add(root.val);
            adjacent.add(root.right.val);
            createGraph(root.right, graph);
        }
    }

    private int maxDistance(Map<Integer, List<Integer>> graph, Set<Integer> visited, int currentNode, int maxDistance, int currentDistance) {
        if (!visited.contains(currentNode)) {
            visited.add(currentNode);
            maxDistance = Math.max(maxDistance, currentDistance);

            for(int neighbor : graph.get(currentNode)) {
                maxDistance = Math.max(maxDistance(graph, visited, neighbor, maxDistance, currentDistance + 1), maxDistance);
            }
        }
        return maxDistance;
    }
}