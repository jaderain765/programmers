

import java.util.Arrays;

class 로또의_최고_순위와_최저_순위{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = sol.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        System.out.println(Arrays.toString(arr));
    }
}


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int correct_num = 0;
        int zero_count = 0;

        //0이 몇개이며, 얼마나 맞았는지 확인
        for(int i : lottos){
            if(i==0) zero_count++;
            for (int j : win_nums){
                if(i == j){
                    correct_num++;
                    break;
                }
            }
        }
        answer = new int[]{score(correct_num+zero_count),score(correct_num)};

        return answer;
    }
    static int score(int num){
        if(num<2) return 6;
        return 7-num;
    }
}