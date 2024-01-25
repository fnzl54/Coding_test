// enroll - 민호를 제외한 구성원 이름(조직에 참여한 순서), referral - enroll 순서로 조직에 참여시킨 사람의 이름
// seller, amount - 판매한 집계 데이터

import java.util.*;

class Solution {
    
    static Map<String, String> parentsMap = new HashMap<>();
    static Map<String, Integer> moneyMap = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int nameCount = 0;
        
        for (int i = 0; i < enroll.length; i++) {
            parentsMap.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            calculator(seller[i], amount[i] * 100);
        }
        
        for (String s : enroll) {
            answer[nameCount++] = moneyMap.getOrDefault(s, 0);
        }
        
        return answer;
    }
    
    void calculator (String nowPerson, int nowMoney) {
        int parentMoney = nowMoney / 10;
        int childMoney = nowMoney - parentMoney;
        moneyMap.put(nowPerson, moneyMap.getOrDefault(nowPerson, 0) + childMoney);
        
        if (parentMoney > 0 && parentsMap.containsKey(nowPerson)) {
            calculator(parentsMap.get(nowPerson), parentMoney);
        }
    }

}