package 프로그래머스.lv1.신규_아이디_추천;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(sol.solution("z-+.^."));
        System.out.println(sol.solution("=.="));
        System.out.println(sol.solution("123_.def"));
        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
class Solution {
    public String solution(String new_id) {
        //완성된 아이디(리턴값)
        String answer = "";

        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환한다.
        String new_str = "";
        for(int i = 0; i < new_id.length(); i++){
            if(new_id.charAt(i)>'A' && new_id.charAt(i)<='Z'){
                new_str += (char)(new_id.charAt(i)+32);
                continue;
            }
            new_str += new_id.charAt(i);
        }
        new_id = new_str;
        //디버그용 출력문
        // System.out.println("1단계 : "+new_id);

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_str = "";
        for(int i = 0; i < new_id.length(); i++){
            if(new_id.charAt(i)>='0' && new_id.charAt(i)<='9'  || new_id.charAt(i)>='a' && new_id.charAt(i)<='z' || new_id.charAt(i)=='-' || new_id.charAt(i)=='_' || new_id.charAt(i)=='.'){
                new_str += new_id.charAt(i);
            }
        }
        new_id = new_str;
        //디버그용 출력문
        // System.out.println("2단계 : "+new_id);

        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_str = "";
        while(new_str != new_id.replace("..", ".")){
            new_str = new_id.replace("..", ".");
            new_id = new_str;
        }
        //디버그용 출력문
        // System.out.println("3단계 : "+new_id);

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(new_id.length() !=0 && new_id.charAt(0)=='.'){ new_id = new_id.substring(1); }
        if(new_id.length() !=0 && new_id.charAt(new_id.length()-1)=='.'){ new_id = new_id.substring(0,new_id.length()-1); }
        //디버그용 출력문
        // System.out.println("4단계 : "+new_id);

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        // new_id = "";
        if(new_id.length()==0) new_id = "a";
        //디버그용 출력문
        // System.out.println("5단계 : "+new_id);

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        // new_id = "0123456789ABCDEFGHIJK";
        if (new_id.length() >=16){
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(14)=='.'){
                new_id = new_id.substring(0,14);
            }
        }
        //디버그용 출력문
        // System.out.println("6단계 : "+new_id);
        
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        // new_id = "a";
        while(new_id.length() < 3){
            new_id += new_id.charAt(new_id.length()-1);
        }
        //디버그용 출력문
        // System.out.println("7단계 : "+new_id);
        answer = new_id;
        return answer;
    }
}