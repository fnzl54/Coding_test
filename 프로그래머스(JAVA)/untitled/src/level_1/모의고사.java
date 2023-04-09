package level_1;

import java.util.ArrayList;

public class 모의고사 {
    public static void main(String[] args) {

        int[] answers = {1,2,3,4,5};

        ArrayList<Integer> answer = new ArrayList<>();

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5]) score[0]++;
            if(answers[i] == two[i%8]) score[1]++;
            if(answers[i] == three[i%10]) score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        for (int i  = 0; i < 3; i++) {
            if (max == score[i]) answer.add(i+1);
        }

        System.out.println(answer);

    }
}
