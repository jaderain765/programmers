
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10));
    }
}
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0, num = x;
        while(num != 0){
            sum += num%10;
            num /= 10;
        }
        if(x%sum!=0) answer = false;
        return answer;
    }
}