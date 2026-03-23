class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU ds = new DSU(n);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)) map.put(mail, i);
                else ds.unionBySize(i, map.get(mail));
            }
        }
        HashMap<Integer, TreeSet<String>> merged = new HashMap<>();
        for(String mail : map.keySet()){
            int parent = ds.find(map.get(mail));
            merged.putIfAbsent(parent, new TreeSet<>());
            merged.get(parent).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int parent : merged.keySet()){
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(parent).get(0)); // name
            temp.addAll(merged.get(parent));
            ans.add(temp);
        }
        return ans;
    }
}
class DSU {
    int[] parent;
    int[] size;
    public DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void unionBySize(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}