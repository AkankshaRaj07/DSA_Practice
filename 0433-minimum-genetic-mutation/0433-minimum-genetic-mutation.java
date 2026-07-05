class Solution {
    public int minMutation(String s, String e, String[] b) {
        HashSet<String> st = new HashSet<>();
        for(String x: b) st.add(x);
        if(!st.contains(e)) return -1;
        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.offer(s);
        vis.add(s);
        char[] ch = {'A', 'C', 'G', 'T'};
        int ans = 0 ;
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                String cur = q.poll();
                if(cur.equals(e)) return ans;
                char[] a = cur.toCharArray();
                for(int i = 0; i<8; i++){
                    char old = a[i];
                    for(char c: ch){
                        if(c==old) continue;
                        a[i]=c;
                        String nxt = new String(a);
                        if(st.contains(nxt) && !vis.contains(nxt)){
                            vis.add(nxt);
                            q.offer(nxt);
                        }
                    }
                    a[i] = old;
                }
            }
            ans++;
        }
        return -1;
        
    }
}