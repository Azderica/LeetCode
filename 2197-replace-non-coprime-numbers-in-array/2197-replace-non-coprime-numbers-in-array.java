class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for(int num : nums) {
            while (!deque.isEmpty()) {
                int gca = gca(num, deque.peek());
                if(gca > 1) {
                    int pre = deque.pop();
                    num = num / gca * pre;
                } else {
                    break;
                }
            }
            deque.push(num);
        }
        while (!deque.isEmpty()) {
            result.add(deque.pollLast());
        }
        return result;
    }

    private int gca(int a, int b) {
        return b == 0 ? a : gca(b, a % b);
    }
}