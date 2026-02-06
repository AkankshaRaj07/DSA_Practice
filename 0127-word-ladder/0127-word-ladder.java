class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        if(words.contains(beginWord)) words.remove(beginWord);
        int level=0;
        while(!q.isEmpty()){
            int currLev= q.size();
            for(int i =0; i<currLev; i++){
                String word = q.poll();
                if(word.equals(endWord)) return level+1;
                else{
                    List<String> neighbours = getNeighbours(word, words);
                    for(String neighbour: neighbours){
                        q.offer(neighbour);
                        words.remove(neighbour);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    public List<String> getNeighbours(String word, Set<String> words){
        List<String> neighbours = new ArrayList<>();
        for(int j =0; j<word.length(); j++){
            for(char i ='a'; i<='z'; i++){
                String newWord= word.substring(0,j) + i + word.substring(j+1,word.length());
                if(words.contains(newWord)) neighbours.add(newWord);
            }
        }
        return neighbours;
    }
}