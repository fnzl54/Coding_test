class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        int maxV = Math.max(w, h);
        int minV = Math.min(w, h);
        
        while (minV != 0) {
            int temp = maxV % minV;
            
            maxV = minV;
            minV = temp;
        }
        
        answer = ((long)w*h) - ((w/maxV) + (h/maxV) - 1) * maxV;
        
   
        return answer;
    }
}