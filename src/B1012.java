import java.util.Scanner;

public class B1012 {
    static int[][] map = new int[50][50];
    static int N;
    static int M;
    public static void main(String[] args) {
        int answer;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            answer = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();
            for (int j = 0; j < K; j++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                map[Y][X] = 1;
            }
            for (int j = 0; j < M*N; j++) {
                if(map[j/M][j%M]==1) {
                    dfs(j%M, j/M);
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
    public static void dfs(int x, int y){
        if(map[y][x]==0){
            return;
        }
        else{
            map[y][x]=0;
        }
        if(x>0){
            dfs(x-1, y);
        }
        if(y>0){
            dfs(x, y-1);
        }
        if(x<M-1){
            dfs(x+1, y);
        }
        if(y<N-1){
            dfs(x, y+1);
        }
    }
}