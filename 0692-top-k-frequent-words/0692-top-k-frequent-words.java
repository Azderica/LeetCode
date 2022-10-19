class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String word: words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (f1, f2) -> freq.get(f1).equals(freq.get(f2)) ? f2.compareTo(f1) : freq.get(f1) - freq.get(f2)
        );

        for(String word: freq.keySet()) {
            pq.offer(word);
            if (pq.size() > k) pq.poll();
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty())
            result.add(pq.poll());
        Collections.reverse(result);
        return result;
        
    }
}