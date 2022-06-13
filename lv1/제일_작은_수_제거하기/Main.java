package lv1.제일_작은_수_제거하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = Arrays.toString(sol.solution(new int[]{4,3,2,1}));
        System.out.println(str);
    }
}
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int min = arr[0];
        
        //가장 작은 수를 골라내는 로직
        for (int i = 0; i < arr.length; i++){
            if(arr[i]< min){
                min = arr[i];
            }
        }
        
        //단, 가장 작은 수가 2개 이상일수 있다.
        String str = "";
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == min) continue;
            str += arr[i]+",";
        }
        str = str.substring(0,str.length()-1);
        String[] str_arr = str.split(",");
        answer = new int[str_arr.length];
        
        for (int i =0; i < str_arr.length; i++){
            answer[i] = Integer.parseInt(str_arr[i]);
        }
        
        return answer;
    }
}