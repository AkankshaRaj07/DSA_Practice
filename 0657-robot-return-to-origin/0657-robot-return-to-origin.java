class Solution {
    public boolean judgeCircle(String moves) {
        int [] pos = {0,0};
        for(char a: moves.toCharArray()){
            if(a=='R')pos[1]++;
            else if(a=='L') pos[1]--;
            else if(a=='U') pos[0]--;
            else pos[0]++;
        }
        return pos[0]==0 && pos[1]==0;
    }
}