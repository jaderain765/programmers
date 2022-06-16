package lv2.주차_요금_계산;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] out = sol.solution(fees, records);
        System.out.println(Arrays.toString(out));
    }
}

/*
쓸대없이 객체지향으로 한다 헸다가 개고생중...
*/


class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        //입력된 배열의 문자열을 새로운 문자열 이중배열로 변환
        String[][] newreco = new String[records.length][];
        
        for(int i = 0; i < records.length; i++){
            newreco[i] = records[i].split(" ");
            
            //잘입력되었는지 확인문 (나중에 주석처리할것!!!)
            if(i == 0) System.out.println("새로 만든 이중배열(newreco)");
            System.out.println(Arrays.toString(newreco[i]));
        }
        
        //차량 객체 생성 후 newreco의 값에 따라 인스턴스 생성 및 메서드 사용
        Car[] car = new Car[newreco.length];
        
        for(int i = 0; i < newreco.length; i++){
            int hour = 0, minute = 0;
            
            //23시 59에 입차할 경우엔 무시한다.
            if(newreco[i][0].equals("23:59")) continue;
            
            //입차처리 : 기록(newreco[i][2])이 "IN"일 경우
            else if(newreco[i][2].equals("IN")){
                //시,분을 정수로 바꿈
                hour = Integer.parseInt(newreco[i][0].substring(0,2));
                minute = Integer.parseInt(newreco[i][0].substring(3,5));
                //인스턴스에 생성자를 이용하여 값을 변경
                car[i] = new Car(new int[]{hour,minute}, newreco[i][1]);
            }
            //출차처리 : 기록(newreco[i][2])이 "OUT"인 경우
            else if(newreco[i][2].equals("OUT")){
                //출차 시간 시,분을 정수로 바꿈
                hour = Integer.parseInt(newreco[i][0].substring(0,2));
                minute = Integer.parseInt(newreco[i][0].substring(3,5));
                
                //car 클라스 배열을 뒤에서 부터 차량번호를 조사해서 입차시간을 찾는다.
                for(int j = car.length-1; j >= 0; j--){
                    //차량 객체가 없을 경우 넘기기
                    if(car[j] == null) continue;
                    //차량번호가 같다면 출차시간을 통해 소모시간을 추가
                    if(car[j].car_num.equals(newreco[i][1])){
                        car[j].parking_time(new int[]{hour, minute});
                        break;
                    }
                }
            }
        }
        
        //출차 기록이 없는 차를 조사해서 23시59분에 나갔다고 처리한다.
        for(int i = 0; i < car.length; i++){
            //차량 객체가 없을 경우 넘기기
            if(car[i] == null) continue;
            //주차시간이 0일경우
            if(car[i].save_time == 0){
                car[i].parking_time(new int[]{23, 59});
                break;
            }
        }
        
        //차량번호가 같을 기록이 있을시 합친다.
        for(int i = 0; i < car.length; i++){
            //빈객체의 경우 건너뜀
            if(car[i] == null) continue;
            //반복문을 돌려 차량번호가 같을 경우 합치기
            for(int j = 0; j < car.length; j++){
                if(car[j] == null) continue;
                else if(car[i].car_num.equals(car[j].car_num)){
                    car[i].save_time += car[j].save_time;

                    //IDE 돌려보니까 여기서 오류 나는디 왜이럼;;
                    car[j] = null;
                }
            }
        }
        
        //
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < car.length; i++){
            if(car[i] == null) continue;
            list.add(car[i].save_time);
        }
        
        //저장한 시간에 따라 요금을 계산
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = Car.money(fees, list.get(i));
        }
        
        return answer;
    }
}

class Car{
    int[] time_in = new int[2]; // 입차시간 : 시, 분
    int save_time = 0;          //주차한 시간
    String car_num = ""; //차량번호
    
    
    //차량 생성자
    Car(){}
    
    Car(int[] time_in, String car_num){
        this.time_in = time_in;
        this.car_num = car_num;
    }
    
    
    
    //출차시간을 넣을시 시간계산하여 총 사용 시간을 반환
    int parking_time(int[] time_out){
        int result = 0;
        
        // 시간 32-56
        int H = time_out[0] - time_in[0];
        int M = time_out[1] - time_in[1];
        
        //
        if(M < 0){
            H--;
            M = 60 + M;
        }
        
        result = (H * 60) + M;
        
        this.save_time += result;
        
        System.out.println(this.car_num + "의 주차시간 : " + result);
        return save_time;
    }
    
    //요금계산 메서드
    static int money(int[] fees ,int save_time){
        
        int result = 0;
        
        //기본시간 이하로 주차시 기본요금 
        if(save_time <= fees[0]){
            return fees[1];
        }
        
        result += fees[1] + Math.ceil((double)(save_time - fees[0]) / fees[2]) * fees[3];
        System.out.println(""+result);
        
        return 0;
    }
}