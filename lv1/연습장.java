package programmers.lv1;

public class 연습장 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int str = sol.solution("1D2S#10S");
        System.out.println(str);
    }
}
class Solution {
    public int solution(String dartResult) {
        int answer = 0, count_num = 0;
        int[] score = new int[3];
        
        //
        for(int i = 0; i < dartResult.length(); i++){
            int n = 0;
            //숫자가 10일때
            if(dartResult.charAt(i)=='1' && dartResult.charAt(i+1)=='0'){
                n = 10;
                i+=2;
            }else if(dartResult.charAt(i)>='0' && dartResult.charAt(i)<='9'){
                n = dartResult.charAt(i)-48;
                i++;
            }
            // System.out.println(n);
            // S? D? T?
            if(dartResult.charAt(i)=='D') n*=n;
            else if(dartResult.charAt(i)=='T') n= n*n*n;
            score[count_num] = n;
            count_num++;
            if(i == dartResult.length() || i == dartResult.length()-1) break;
            // *?
            if(dartResult.charAt(i+1)=='*'){
                score[count_num-1] *= 2;
                if(count_num-2 >= 0){
                    score[count_num - 2] *= 2;
                }
                i++;
            }else if(dartResult.charAt(i+1)=='#' && count_num!=0){
                score[count_num-1] *= -1;
                i++;
            }
        }
        for(int i : score){
            System.out.println(i);
            answer += i;
        }
        
        
        return answer;
    }
}