import java.util.*;

public class B1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] arr = new int[X+1];
        arr[1] = 0;
        for (int i = 2; i < X+1; i++) {
            int temp = arr[i-1];
            if(i%3==0){
                temp = Math.min(temp, arr[i/3]);
            }
            if(i%2==0){
                temp = Math.min(temp, arr[i/2]);
            }
            arr[i] = temp+1;
        }
        System.out.println(arr[X]);
    }
}
