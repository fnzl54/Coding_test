import java.util.*;

class Solution {
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static int[] check;
    static int maxV = Integer.MIN_VALUE, answer = 0;
    
    public int solution(int n, int[][] edge) {
        
        for (int[] e : edge) {
            List<Integer> temp = map.getOrDefault(e[0], new ArrayList());
            temp.add(e[1]);
            map.put(e[0], temp);
            temp = map.getOrDefault(e[1], new ArrayList());
            temp.add(e[0]);
            map.put(e[1], temp);
        }
        
        check = new int[n+1];
        bfs(); 
            
        for (int i : check) {
            if (maxV == i) {
                answer++;
            }
        }

        return answer;
    }
    
    private void bfs() {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {1, 1});
        check[1] = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int point = now[0];
            int count = now[1];
            
            maxV = Math.max(maxV, count);
            
            for (int i = 0; i < map.getOrDefault(point, new ArrayList()).size(); i++) {
                int next = map.get(point).get(i);
                
                if (check[next] == 0) {
                    check[next] = count+1;
                    q.add(new int[] {next, count+1});
                }
            }
        }
    }
    
}