package 자바알고리즘문제풀이.섹션2;

import java.util.*;
class q5 {
  public int solution(int n){
    int cnt=0;
    int[] ch = new int[n+1];

    for(int i=2; i<=n; i++){
      if(ch[i]==0){
        cnt++;
        for(int j=i; j<=n; j=j+i) ch[j]=1;
      }
    }
    return cnt;
  }
  public static void main(String[] args){
    q5 T = new q5();
    Scanner kb = new Scanner(System.in);
    int n=kb.nextInt();
    System.out.println(T.solution(n));
  }
}