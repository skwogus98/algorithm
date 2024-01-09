import java.util.*;

public class B1107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int t = sc.nextInt();
            arr.remove(Integer.valueOf(t));
        }
        int answer = Math.abs(N - 100);
        int[] num = new int[6];
        for (num[0] = -1; num[0] < arr.size(); num[0]++) {
            for (num[1] = (num[0] < 0 ? -1 : 0); num[1] < arr.size(); num[1]++) {
                for (num[2] = (num[1] < 0 ? -1 : 0); num[2] < arr.size(); num[2]++) {
                    for (num[3] = (num[2] < 0 ? -1 : 0); num[3] < arr.size(); num[3]++) {
                        for (num[4] = (num[3] < 0 ? -1 : 0); num[4] < arr.size(); num[4]++) {
                            for (num[5] = 0; num[5] < arr.size(); num[5]++) {
                                int now = 0;
                                int log = 6;
                                for (int i = 0; i < 6; i++) {
                                    if (num[i] > -1) {
                                        now += (int) (Math.pow(10, 5 - i) * arr.get(num[i]));
                                    } else {
                                        log--;
                                    }
                                }
                                int localAnswer = Math.abs(now - N) + log;
                                answer = Math.min(localAnswer, answer);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
