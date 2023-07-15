package 자바알고리즘문제풀이.섹션3;

import java.util.*;
public class p6 {
  public int solution(int n, int k, int[] arr){
    int answer=0, cnt=0, lt=0;
    for(int rt=0; rt<n; rt++){
      if(arr[rt]==0) cnt++;
      while(cnt>k){
        if(arr[lt]==0) cnt--;
        lt++;
      }
      answer=Math.max(answer, rt-lt+1);
    }
    return answer;
  }

  public static void main(String[] args){
    p6 T = new p6();
    Scanner kb = new Scanner(System.in);
    int n=kb.nextInt();
    int k=kb.nextInt();
    int[] arr=new int[n];
    for(int i=0; i<n; i++){
      arr[i]=kb.nextInt();
    }
    System.out.print(T.solution(n, k, arr));
  }
}