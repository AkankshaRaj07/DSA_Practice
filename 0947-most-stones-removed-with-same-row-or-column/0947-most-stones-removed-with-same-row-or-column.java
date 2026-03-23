class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int i =0; i<n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DSU ds = new DSU(maxRow + maxCol + 2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow +1;
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow,1);
            map.put(nodeCol,1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if(ds.find(it.getKey()) == it.getKey()) count++;
        }
        return n-count;
    }
}
class DSU {
    int[] parent;
    int[] rank;
    int[] size;
    int components;
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        components = n;
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }
    public int find(int x) {     // Path Compression
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public boolean unionByRank(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return false;
        if(rank[pu] < rank[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else if(rank[pu] > rank[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else {
            parent[pv] = pu;
            rank[pu]++;
            size[pu] += size[pv];
        }
        components--;
        return true;
    }
    public boolean unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return false;
        if(size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        components--;
        return true;
    }
    public int getSize(int x) {
        int px = find(x);
        return size[px];
    }
    public int getComponents() {
        return components;
    }
}