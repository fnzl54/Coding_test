import java.util.*;

class Solution {
    static boolean[] check;
    static List<String> allAirportSequence = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        check = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(allAirportSequence);
        
        answer = allAirportSequence.get(0).split(" ");
        
        return answer;
    }
    
    private void dfs(int depth, String start, String airportSequence, String[][] tickets) {
        if (depth == tickets.length) {
            allAirportSequence.add(airportSequence);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !check[i]) {
                check[i] = true;
                dfs(depth + 1, tickets[i][1], airportSequence + " " + tickets[i][1], tickets);
                check[i] = false;
            }
        }
    }
}