class Solution {
    public String removeStars(String s) {
        // StringBuilder stack=new StringBuilder();
        // for (char ch : s.toCharArray()) {
        //     if (ch == '*') {
        //         stack.deleteCharAt(stack.length() - 1);
        //     } else {
        //         stack.append(ch);
        //     }
        // }

        // return stack.toString();

        char arr[]= s.toCharArray();
        int w=0;
        for(int i=0;i<arr.length; i++){
            if(arr[i]=='*'){
                w--;
            }else{
                arr[w]=arr[i];
                w++;
            }
        }


        return new String(arr,0,w);
    }
}