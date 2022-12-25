class Solution {
    public int addRungs(int[] rungs, int dist) {
        Arrays.sort(rungs);
        int curRung = 0, i = 0, answer = 0;
        while(i < rungs.length) {
            if(curRung + dist >= rungs[i]) {
                // valid
                curRung = rungs[i];
                i++;
            } else {
                // unvalid
                answer += (rungs[i] - curRung - 1) / dist;
                curRung = rungs[i];
            }
        }
        return answer;
    }

    // input : [3]
}