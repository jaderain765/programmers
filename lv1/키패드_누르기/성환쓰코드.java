package lv1.키패드_누르기;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder answer_Builder = new StringBuilder();
        
        Point leftThumb = new Point(3, 0);
        Point rightThumb = new Point(3, 2);
        
        int[][] keyPad = new int[][] {
           {1, 2, 3},
           {4, 5, 6},
           {7, 8, 9},
           {10,0,10}
        };
        
        for(int number : numbers) {
           Point target;
           boolean trueL_falasR;
           
           if(number == 0) target = new Point(3, 1);
           else target = new Point((number-1)/3, (number-1)%3);
           
           switch(number) {
           case 1: case 4: case 7:
              trueL_falasR = true;
             break;
           case 3: case 6: case 9:
              trueL_falasR = false;
             break;
          default:
             int leftThumb_distance = leftThumb.distance(target);
             int rightThumb_distance = rightThumb.distance(target);
             
             if(leftThumb_distance > rightThumb_distance) 
                trueL_falasR = false;
             else if(leftThumb_distance < rightThumb_distance) 
                trueL_falasR = true;
             else
                if(hand.equals("left"))
                   trueL_falasR = true;
                else
                   trueL_falasR = false;
           }
           
           if(trueL_falasR) {
              leftThumb = target;
              answer_Builder.append("L");
           } else {
              rightThumb = target;
              answer_Builder.append("R");
           }
        }
        
        answer = answer_Builder.toString();
        
        return answer;
    }
}

class Point{
   int x, y;

   public Point(int x, int y) {
      super();
      this.x = x;
      this.y = y;
   }
   
   public int distance(Point t) {
      return Math.abs(this.x - t.x) + Math.abs(this.y - t.y);
   }
}