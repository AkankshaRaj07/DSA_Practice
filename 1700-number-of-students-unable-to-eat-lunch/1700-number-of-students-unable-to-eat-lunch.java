class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int cir =0, s = 0;
        for(int a : students){
            if(a==1) s++;
            else cir++;
        }
        for(int i: sandwiches){
            if(i==0 && cir<=0) return s;
            else if(i==1 && s<=0) return cir;
            else if(i==0) cir--;
            else s--;
        }
        return 0;
    }
}