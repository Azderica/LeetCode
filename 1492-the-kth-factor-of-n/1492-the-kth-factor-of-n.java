class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(i * i == n) {
                list.add(i);
            } else if(n % i == 0) {
                list.add(i);
                list.add(n / i);
            }
        }

        Collections.sort(list);
        if(k > list.size())
            return -1;
        return list.get(k - 1);   
    }
}