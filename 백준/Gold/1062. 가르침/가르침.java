import java.io.*;
import java.util.*;

public class Main {

  static String words[];
  static boolean learnAlphabat[];
  static int maxCnt=0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    learnAlphabat=new boolean[26];
    learnAlphabat[0]=true;
    learnAlphabat[2]=true;
    learnAlphabat[8]=true;
    learnAlphabat[13]=true;
    learnAlphabat[19]=true;
    
    st=new StringTokenizer(br.readLine());
    int n=Integer.parseInt(st.nextToken());
    int r=Integer.parseInt(st.nextToken());
    words=new String[n];
    for(int i=0;i<n;i++) {
      String word=br.readLine();
      words[i]=word.substring(4,word.length()-4);
    }
    dfs(0,0,r-5);
    System.out.println(maxCnt);
  }
  public static void dfs(int depth,int start,int max) {
    if(depth==max) {
      int count=0;
      for(int i=0;i<words.length;i++) {
        boolean status=true;
        for(int j=0;j<words[i].length();j++) {
          int val=words[i].charAt(j)-'a';
          if(!learnAlphabat[val]) {
            status=false;
            break;
          }
        }
        if(status)
          count++;

      }
      maxCnt=Math.max(count,maxCnt);
      return;
    }

    for(int i=start;i<learnAlphabat.length;i++) {
      if(i==0||i==2||i==8||i==13||i==19) continue;
      if(!learnAlphabat[i]) {
        learnAlphabat[i]=true;
        dfs(depth+1,i+1,max);
        learnAlphabat[i]=false;
      }
    }

  }
}
