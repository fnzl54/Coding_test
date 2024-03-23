import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int nowWeight = 1;
    int thinkWeght = 1;

    ArrayList<Integer> result = new ArrayList<>();

    while (true){
      int diff = nowWeight * nowWeight - thinkWeght * thinkWeght;
      if(nowWeight - thinkWeght == 1 && diff > n){
        break;
      }

      if(diff < n){
        nowWeight ++;
      }
      else{
        thinkWeght ++;
      }

      if(diff == n){
        result.add(nowWeight);
      }
    }

    if(result.size() != 0){
      for(int item : result){
        System.out.println(item);
      }
    }
    else{
      System.out.println(-1);
    }

  }

}