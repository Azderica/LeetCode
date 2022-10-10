class SetUnion {
    int[] parent;

    public SetUnion(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int i) {
        if(parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    // not weighted union
    public void union(int i, int j) {
        parent[find(i)] = find(j);
    }
}

class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;
        Map<String, Integer> index = new HashMap<>();
        int count = 0;
        SetUnion set = new SetUnion(2 * similarPairs.size());

        for(List<String> similarPair : similarPairs) {
            for(String pair : similarPair) {
                if(!index.containsKey(pair))
                    index.put(pair, count++);
            }
            set.union(index.get(similarPair.get(0)), index.get(similarPair.get(1)));
        }

        for(int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i], w2 = sentence2[i];
            if(w1.equals(w2)) continue;;
            if(!index.containsKey(w1) || !index.containsKey(w2)) return false;
            if(set.find(index.get(w1)) != set.find(index.get(w2))) return false;
        }
        return true;
    }
}