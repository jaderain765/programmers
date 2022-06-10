
class Main{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("01020612714"));
    }
}

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        for(int i = 0; i < phone_number.length();i++){
            //012345 6자리
            answer += ((phone_number.length()-i > 4)? "*":phone_number.charAt(i));
        }
        return answer;
    }
}