class Solution {
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();
        int result = 0, tmp = num;

        while(tmp > 0) {
            list.add(tmp % 10);
            tmp /= 10;
        }
        Collections.reverse(list);

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 6) {
                list.set(i, 9);
                break;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            result += list.get(i);
            if(i != list.size() - 1) {
                result *= 10;
            }
        }

        return result;
    }
}