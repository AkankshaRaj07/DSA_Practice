class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dir = 0;
        for(char a : instructions.toCharArray()){
            if(a=='G'){
                if(dir==0) y++;
                else if (dir==1) x++;
                else if(dir == 2) y--;
                else x--;
            }
            else if(a =='L') dir = (dir+3)%4;
            else dir = (dir+1) % 4;
        }
        return (x==0 && y==0) || dir!=0;

    }
}