class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < 2; i++) res.add(new ArrayList<>());

        for(int col : colsum) {
            if(col == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
                upper--;
                lower--;
            } else if(col == 1) {
                if(upper >= lower) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                } else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                    lower--;
                }
            } else if(col == 0) {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }

        if (upper != 0 || lower != 0)
            return new ArrayList<>();
        return res;
    }
}