class Solution {
    public int minMaxGame(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);

        while (list.size() > 1) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < list.size() / 2; i++) {
                if(i % 2 == 0 ) temp.add(Math.min(list.get(2 * i), list.get(2 * i + 1)));
                else temp.add(Math.max(list.get(2 * i), list.get(2 * i + 1)));
            }
            list = temp;
        }

        return list.get(0);
    }
}