import java.util.*;

public class B1043 {
    public static int[][] map = new int[51][51];
    public static HashSet<Integer> hashSet = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int t = sc.nextInt();
        int answer = M;
        int[] bans = new int[t];
        for (int i = 0; i < t; i++) {
            int j = sc.nextInt();
            bans[i] = j;
        }
        int[][] party = new int[M][N];
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            int before = sc.nextInt();
            party[i][0] = before;
            for (int j = 1; j < num; j++) {
                int k = sc.nextInt();
                party[i][j] = k;
                map[before][k] = k;
                map[k][before] = before;
                before = k;
            }
        }

        for (int i = 0; i < t; i++) {
            dfs(bans[i], N);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(party[i][j]==0){
                    break;
                }
                if(hashSet.contains(party[i][j])){
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int n, int size){
        hashSet.add(n);
        for (int i = 1; i <= size; i++) {
            if(map[n][i]!=0 && !hashSet.contains(i)){
                dfs(i, size);
            }
        }
    }
}
