package lv1.숫자_문자열과_영단어;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = sol.solution("one4seveneight");
        System.out.println(num);
        num = sol.solution("23four5six7");
        System.out.println(num);
        num = sol.solution("2three45sixseven");
        System.out.println(num);
        num = sol.solution("123");
        System.out.println(num);
    }
}

class Solution {
    public int solution(String s) {
        String answer = "";
        String[] num_arr = {"zero", "one","two","three","four", "five", "six","seven","eight","nine"};

        for (int i = 0; i < s.length(); i++){
            //마주한 문자자 숫자일경우엔 그냥추가
            if(s.charAt(i)>=48 && s.charAt(i)<=57) {
                answer += s.charAt(i);
                continue;
            }
            //마주한 문자가 영단어 일겨우
            for(int j = 0; j < num_arr.length; j++){
                if(num_arr[j].length() <= s.substring(i , s.length()).length() && num_arr[j].equals(s.substring(i , i+num_arr[j].length()))) {
                    answer += j;
                    i+=num_arr[j].length()-1;
                    break;
                }
            }
        }
        if(answer.equals("")) return 0;
        return Integer.parseInt(answer);
    }
}