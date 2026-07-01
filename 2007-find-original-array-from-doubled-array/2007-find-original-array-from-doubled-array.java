class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2!=0) return new int[] {};
        Arrays.sort(changed);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: changed){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int [] result = new int[n/2];
        int i = 0;
        for(int key : changed){
            int twice = 2*key;
            if(map.get(key)==0) continue;
            if (key == 0) {
                if (map.get(0) < 2) return new int[]{};
            } else {
                if (map.getOrDefault(twice, 0) == 0) return new int[]{};
            }
            result[i++] = key;
            map.put(key,map.get(key)-1);
            map.put(twice,map.get(twice)-1);
        }
        return result;

    }
}