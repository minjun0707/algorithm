import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 완전 탐색
 * 서로 다른 3장의 카드를 뽑는다 -> 조합 !
 * N(3 <= N <= 100) 이므로 N이 최대일때 경우의 수는
 * 100 C 3  = 100 * 99 * 98 / 6 = 약 200만 이다
 * */

public class Main {

	static final int CARD_NUM = 3;
	int n;
	int m;
	int arr[];
	boolean visit[];
	int selected[];
	int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		arr = new int[n];
		visit = new boolean[n];
		selected = new int[CARD_NUM];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);
		System.out.println(answer);
	}

	public void dfs(int depth) {
		//탈출 조건
		if (depth == CARD_NUM) {
			int sum = getSum();
			if (sum <= m) {
				answer = Math.max(sum, answer);
			}

			return;
		}

		//반복 조건
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				selected[depth] = arr[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}

	public int getSum() {
		int sum = 0;
		for (int i = 0; i < CARD_NUM; i++) {
			sum = sum + selected[i];
		}

		return sum;
	}
}
