class Solution {
    public int minFlipsMonoIncr(String s) {
        // initialize
        int[] counts = new int[2];
        int answer = 0;
        
        for(char ch : s.toCharArray()) {
            if(ch == '0')
                counts[0]++;
        }
        
        answer = counts[0];
        for(char ch : s.toCharArray()) {
            if(ch == '0')
                counts[0]--;
            else
                counts[1]++;
            
            answer = Math.min(answer, counts[0] + counts[1]);
        }
        
        return answer;
    }
}