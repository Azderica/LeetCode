class Solution {
    
    public int minimumCost(int n, int[][] connections) {
        int res = 0;
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
    
        UnionFind uf = new UnionFind(n);
        
        for(int[] connection : connections) {
            if(uf.find(connection[0]) != uf.find(connection[1])) {
                uf.union(connection[0], connection[1]);
                res += connection[2];
            }
            
            if(uf.count == 1) {
                return res;
            }
        }
    
        return -1;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int count;
    
    UnionFind(int n) {
        this.parent = new int[n + 1];
        this.size = new int[n + 1];
        for(int i = 0; i <=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        this.count = n;
    }
    
    protected int find(int i) {
        if(i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    
    protected void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if(size[i] > size[j]) {
            parent[j] = i;
            size[i] += size[j];
        } else {
            parent[i] = j;
            size[j] += size[i];
        }
        this.count--;
    }
}