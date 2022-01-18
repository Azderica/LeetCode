class Solution {
    public List<Integer> partitionLabels(String s) {
        // initialzie
        int ALPHABET_MAX = 26;
        
        List<Integer> list = new ArrayList<>();
        int start = 0, end = 0;
        int[] lastIndex = new int[ALPHABET_MAX];
        
        // find alphabet last index
        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // make partion
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            
            if(i == end) {
                list.add(end - start + 1);
                start = i + 1;
            }
        }

        return list;
    }
}