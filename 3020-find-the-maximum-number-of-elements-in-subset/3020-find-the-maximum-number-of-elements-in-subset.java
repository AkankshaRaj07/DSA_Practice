class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> count = new HashMap<>();
        for(int i : nums){
            count.put((long)i, count.getOrDefault((long)i,0)+1);
        }
        int ans = 0;
        if(count.containsKey(1L)) {
            int temp = count.get(1L);
            if(temp%2 == 0) temp--;
            ans = Math.max(temp,ans);
            count.remove(1L);
        }
        for (long num : count.keySet()) {
    int freq = count.get(num);

    if (freq == 1) {
        ans = Math.max(ans, 1);
        continue;
    }

    int len = 2;
    long curr = num;

    while (true) {
        if (curr > 1000000000L / curr) break;

        curr = curr * curr;

        if (!count.containsKey(curr)) break;

        if (count.get(curr) >= 2)
            len += 2;
        else {
            len++;
            break;
        }
    }

    if (len % 2 == 0) len--;
    ans = Math.max(ans, len);
}
        return ans;
    }
}