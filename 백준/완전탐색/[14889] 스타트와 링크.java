import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	int n;
	int[][] arr;
	int answer = Integer.MAX_VALUE;
	boolean[] visit;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	public void solution() throws IOException {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		visit = new boolean[n];


		dfs(0,0);
		System.out.println(answer);
	}

	public void dfs(int depth, int idx) {
		//탈출조건
		if (depth == n / 2) {

			int start = 0;
			int link = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(visit[i] && visit[j]) start += arr[i][j];
					if(!visit[i] && !visit[j]) link += arr[i][j];
				}
			}


			answer = Math.min(Math.abs(start-link),answer);
			if(answer == 0) {
				System.out.println(answer);
				System.exit(0);
			}
			return;
		}

		//반복조건
		for (int i = idx; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(depth + 1,i+1);
				visit[i] = false;
			}
		}
	}
}
