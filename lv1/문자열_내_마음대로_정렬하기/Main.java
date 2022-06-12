package programmers.lv1.문자열_내_마음대로_정렬하기;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] str = sol.solution(new String[]{"sun", "bed", "car"}, 1);
        System.out.println(Arrays.toString(str));
    }
}

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        int count1 = 0;
        for(int i = 'a'; i <= 'z'; i++){
            String str = "";

            int count2 = 0;
            for(int j = 0; j < strings.length; j++){
                if(strings[j].charAt(n)==i){
                    str += strings[j]+" ";
                    count2++;
                }
            }
            if(str.length() == 0) continue;
            String[] arr_str = str.split(" ");
            Arrays.sort(arr_str);

            for(int j = 0; j < count2; j++){
                answer[count1] = arr_str[j];
                count1++;
            }
        }

        return answer;
    }
}