import java.util.*;

public class B1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = sc.nextInt();
            }
            //j번째를 선택하는 경우는 이전에 j번째를 선택하지 않았던 경우에 최소값과의 합만 찾으면 된다.
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3])+arr[j];
            }
        }
        //마지막까지 dp순회한 이후 최소값을 찾는다.
        System.out.println(Math.min(dp[N][0],Math.min(dp[N][1],dp[N][2])));
    }
}
