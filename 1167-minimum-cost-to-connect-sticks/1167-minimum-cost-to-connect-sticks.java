class Solution {
    public int connectSticks(int[] sticks) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int stick : sticks) {
            pq.add(stick);
        }
        
        while(pq.size() > 1) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            
            result += stick1 + stick2;
            pq.add(stick1 + stick2);
        }
        
        return result;
    }
}