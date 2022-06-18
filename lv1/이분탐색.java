package lv1;

// For Algorithm submit template
import java.util.Scanner;

class Main {
    private static int binarySearch(int[] arr, int target, int left, int right) {
        
        if (left <= right) {
                int mid = (left + right) / 2;
                System.out.println("arr[중간값 :"+mid+"] : " + arr[mid]+ " 타겟은 : "+ target);

                if (arr[mid] == target) {
                    System.out.println("동작");
                    return mid;
                }

                if (target < arr[mid]) {
                    binarySearch(arr, target, left, mid - 1);
                }

                if (target > arr[mid]) {
                    binarySearch(arr, target, mid + 1, right);
                }
        }

        return -1;
    }

    // private static int binarySearch(int[] arr, int target, int left, int right) {
        
    //     if(left > right) return -1;
        
    //     int mid = (left + right) / 2;
    //     System.out.println("arr[중간값 :"+mid+"] : " + arr[mid]+ " 타겟은 : "+ target);

    //     if (arr[mid] == target) {
    //         System.out.println("동작");
    //         return mid;
    //     }

    //     if (target < arr[mid])
    //         return binarySearch(arr, target, left, mid - 1);

    //     return binarySearch(arr, target, mid + 1, right);
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < a; i++) {
                arr[i] = scanner.nextInt();
        }
        // System.out.println(Arrays.toString(arr));
        
        int b = scanner.nextInt();
        int[] target = new int[b];
        
        for (int i = 0; i < b; i++) {
            target[i] = scanner.nextInt();
            System.out.println(binarySearch(arr, target[i], 0, a - 1) + " ");
        }
        // System.out.println(Arrays.toString(target));

        scanner.close();

    }
}