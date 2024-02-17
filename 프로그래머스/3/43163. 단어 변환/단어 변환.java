import java.util.*;

class Solution {
    private String endWord;
    private int answer = Integer.MAX_VALUE;
    private boolean[] check;
    
    
    public int solution(String begin, String target, String[] words) {
        endWord = target;
        check = new boolean[words.length];
        
        dfs(0, begin, words);
        
        if (answer == Integer.MAX_VALUE) {
            return 0;
        } else {
            return answer;   
        }
    }
    
    private void dfs (int depth, String nowWord, String[] words) {
        if (depth == words.length+1) {
            return;
        }
        
        if (nowWord.equals(endWord)) {
            answer = Math.min(depth, answer);
            return;
        } else {
            for (int i = 0; i < words.length; i++) {
                if (!check[i] && checkWordOneDiff(nowWord, words[i])) {
                    check[i] = true;
                    dfs (depth+1, words[i], words);
                    check[i] = false;
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