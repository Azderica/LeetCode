class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int steps = 0;
        char[] genetics = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String node = queue.remove();
                if(node.equals(end)) {
                    return steps;
                }

                for(char ch : genetics) {
                    for(int j = 0; j < node.length(); j++) {
                        String neighbor = node.substring(0, j) + ch + node.substring(j + 1);
                        if(!visited.contains(neighbor) && bankSet.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}