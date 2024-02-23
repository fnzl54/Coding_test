import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        bfs(begin, target, words);
        
        return answer;
    }
    
    private void bfs(String begin, String target, String[] words) {
        Queue<Object[]> q = new LinkedList<>();
        boolean[] check = new boolean[words.length];
        q.add(new Object[] {begin, 0});
        
        while(!q.isEmpty()) {
            Object[] now = q.poll();
            String nowWord = (String)now[0];
            int count = (int)now[1];
            if (nowWord.equals(target)) {
                answer = count;
                q.clear();
                break;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!check[i] && checkWordOneDiff(nowWord, words[i])) {
                
                    check[i] = true;
                    q.add(new Object[] {words[i], count+1});
                }
            }
        }
        
    }
    
    private boolean checkWordOneDiff(String nowWord, String s) {
        int diffCount = 0;
        
        for (int i = 0; i < nowWord.length(); i++) {
            if (nowWord.charAt(i) != s.charAt(i)) {
                diffCount++;
            }
        }
        
        if (diffCount == 1) {
            return true;
        } else {
            return false;
        }
    }
}

