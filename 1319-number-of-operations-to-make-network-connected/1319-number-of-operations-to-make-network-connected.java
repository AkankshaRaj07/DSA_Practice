class Solution {
    public int makeConnected(int n, int[][] edge) {
        DSU dsu = new DSU(n);
        int extra=0;
        int m = edge.length;
        for(int  i = 0; i< m; i++){
            int u = edge[i][0];
            int v = edge[i][1];
            if(dsu.find(u)==dsu.find(v)) extra++;
            else dsu.unionBySize(u,v);
        }
    
    int count = 0;
    for(int i = 0; i<n; i++) if(dsu.parent[i] == i) count++;
    if(extra>=count-1) return count-1;
    return -1;
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