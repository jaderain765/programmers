package lv1.실패율;

import java.util.*;

public class Main {
    
}

class Solution {
    public int[] solution(int N, int[] stages) {
        // N = 5;
        int[] answer = new int[N];
        // stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        
        //실패율 = 도달한 플래이어 / 클리어 플래이어
        
        int[][] fail = new int[N][3];
        double[] fail_arr = new double[N];
        
        for(int i = 0; i < stages.length; i++){
            for(int j = 0; j < fail.length; j++){
                //스테이지에 도달한사람
                fail[j][0]++;
                if(j+1 == stages[i]) break;
                //스테이지를 클리어한사람
                fail[j][1]++;
            }
            
        }
        for(int i = 0; i < fail.length; i++){
            if(fail[i][0] == 0){
                fail_arr[i] = 0;
                continue;
            }
            fail_arr[i] = (double)(fail[i][0]-fail[i][1]) / (double)fail[i][0];
        }
        
        
        for(int i = 0; i < fail.length; i++){
            System.out.print(fail[i][0]);
        }
        
        System.out.println();
        
        for(int i = 0; i < fail.length; i++){
            System.out.print(fail[i][1]);
        }
        
        System.out.println();
        
        for(int i = 0; i < fail.length; i++){
            System.out.print(fail_arr[i]+" ");
        }
        
        
        
        for(int i = 0; i < N; i++){
            double max_fail = -1;
            int n = 0;
            for(int j = 0; j < fail_arr.length; j++){
                if(fail_arr[j] > max_fail){
                    max_fail = fail_arr[j];
                    n = j;
                }
            }
            answer[i] = n+1;
            fail_arr[n] = -1;
        }
        
        
        
        return answer;
    }
}