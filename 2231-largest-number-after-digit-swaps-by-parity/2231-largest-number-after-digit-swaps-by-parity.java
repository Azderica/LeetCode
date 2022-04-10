class Solution {
    public int largestInteger(int num) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        int cur = num;

        while(cur > 0) {
            if((cur % 10) % 2 == 0) even.add(cur % 10);
            else odd.add(cur % 10);
            numList.add(cur % 10);
            cur /= 10;
        }
        even.sort(Collections.reverseOrder());
        odd.sort(Collections.reverseOrder());
        Collections.reverse(numList);

        int eIndex = 0, oIndex = 0, answer = 0;
        for(int d : numList) {
            if(d % 2 == 0) answer = answer * 10 + even.get(eIndex++);
            else answer = answer * 10 + odd.get(oIndex++);
        }
        return answer;
    }
}