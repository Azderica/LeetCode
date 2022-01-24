class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int[] courses : prerequisites) {
            int end = courses[0];
            int start = courses[1];
            adjacencyList.get(start).add(end);
            indegree[end]++;
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            
            for(int child : adjacencyList.get(cur)) {
                indegree[child]--;
                
                if(indegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        
        if(result.size() == numCourses) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[0];
        }
        
        
    }
}