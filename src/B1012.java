import java.util.Scanner;
//유기농 배추
public class B1012 {
    // 배추밭의 크기는 50이내이므로 미리 선언한다.
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
            //map 초기화
            for (int j = 0; j < K; j++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                map[Y][X] = 1;
            }
            //map을 처음부터 순회하여 1이 나오면 dfs를 하고 answer를 증가시킨다.
            for (int j = 0; j < M*N; j++) {
                if(map[j/M][j%M]==1) {
                    dfs(j%M, j/M);
                    answer++;
                }
            }
            //출력
            System.out.println(answer);
        }
    }
    //dfs 재귀함수
    public static void dfs(int x, int y){
        //해당 구역에 들어왔을 때 빈공간이면 나가고 그렇지 않으면 0으로 바꾸어 이미 지나간 배추밭임을 표시
        if(map[y][x]==0){
            return;
        }
        else{
            map[y][x]=0;
        }

        //상하좌우로 이동하여 dfs를 재귀적으로 실행한다.
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
