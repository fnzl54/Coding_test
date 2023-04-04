class 최소직사각형 {
    public int solution(int[][] sizes) {

        int max_low = 0;
        int max_col = 0;

        for (int i = 0; i < sizes.length; i++) {

            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }

            max_low = max_low < sizes[i][0] ? sizes[i][0] : max_low;
            max_col = max_col < sizes[i][1] ? sizes[i][1] : max_col;
        }

        int answer = max_low * max_col;
        return answer;
    }
}