class Solution {
    public int maxNumberOfBalloons(String text) {
        int a=0, b=0, l=0, n=0, o=0;
        for(int i: text.toCharArray()){
            if(i=='a') a++;
            else if(i=='b') b++;
            else if(i=='l') l++;
            else if(i=='o') o++; 
            else if(i=='n') n++;
        }
        int ans = 0; 
        while(b>=1 && a>=1 && l>=2 && o>=2 && n>=1){
            ans++;
            b--;
            a--;
            n--;
            o=o-2;
            l=l-2;
        }
        return ans;
    }
}