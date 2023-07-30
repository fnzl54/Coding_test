import java.util.*;

// 시간 24개 분 60분 초 60초

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        String first = "", second = "", third = "";
        int answer = 0;
        
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int r = 0; r < 60; r++) {
                    
                    if ( i < 10 ) {
                        first = "0" + String.valueOf(i);
                    } else {
                        first = String.valueOf(i);
                    }
                    
                    if ( j < 10 ) {
                        second = "0" + String.valueOf(j);
                    } else {
                        second = String.valueOf(j);
                    }
                    
                    if ( r < 10 ) {
                        third = "0" + String.valueOf(r);
                    } else {
                        third = String.valueOf(r);
                    }
                    
                    String temp = first + second + third;
                    
                    if (temp.contains(String.valueOf(K)) ) {
                       answer++; 
                    }  
                }
            }
        }
        System.out.print(answer);
    }
}