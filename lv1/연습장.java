package lv1;

import java.util.*;

public class 연습장 {
    public static void main(String[] args) {
        // Solution sol = new Solution();
        // int[] str = sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}});
        // System.out.println(str);

        String[] str = new String[]{"아 에 이 오 우","가 나 다 라 마","이 히 리", "     "};
        String[][] str2 = new String[str.length][];
        
        for(int i = 0; i < str.length; i++){
            str2[i] = str[i].split(" ");
        }
        for(int i = 0; i < str2.length; i++){
            System.out.println(Arrays.toString(str2[i]));
        }
 


    }
}


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        System.out.println(K_number(array, commands[0]));
        
        return answer;
    }
    
    static int K_number(int[] array1, int[] array2){
        
        if(array2[0] > array2[1]){
            int tem = array2[0];
            array2[0] = array2[1];
            array2[1] = tem;
        }
        
        int[] arr = new int[array2[1]-array2[0]+1];
        
        for(int i = array2[0]-1; i < array2[1]; i++){
            arr[i - (array2[0]-1)] = array1[i];
        }
        Arrays.sort(arr);
        
        return arr[array2[2]-1];
    }
}