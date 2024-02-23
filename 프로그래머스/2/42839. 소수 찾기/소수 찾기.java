import java.util.*;

// 배 length 문 length() col size()
// System.out.println();

class Solution {
    static List<Character> numberList = new ArrayList<>();
    static Set<Integer> NumberSet = new HashSet<>();
    static int answer = 0;
    static boolean[] check;
    
    public int solution(String numbers) {
        
        for (int i = 0; i < numbers.length(); i++) {
            numberList.add(numbers.charAt(i));
        }
        
        check = new boolean[numbers.length()];
        dfs(0, "");
        
        System.out.println(NumberSet);
        
        for (int i : NumberSet) {
            if (possible(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int depth, String now) {
        if (depth == numberList.size()) {
            if (now.length() != 0 && now.charAt(0) != '0') {
                NumberSet.add(Integer.parseInt(now));
            }
            return;
        }
        
        for (int i = 0; i < numberList.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(depth+1, now+numberList.get(i));
                check[i] = false;
                dfs(depth+1, now);
            }
            
        }
    }
    
    private boolean possible(int num) {
        
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;

    }
}




