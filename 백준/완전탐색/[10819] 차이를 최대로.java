import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int n;
	int[] arr;
	boolean[] visit;
	int[] selectedArr;
	int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.solution();

	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[n];
		visit = new boolean[n];
		selectedArr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);
		System.out.println(answer);

	}

	void dfs(int count) {
		//탈출조건
		if (count == n) {
			int sum = getSum();
			answer = Math.max(sum, answer);
			return;
		}
		//수행동작
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				selectedArr[count] = arr[i];
				dfs(count + 1);
				visit[i] = false;
			}
		}
	}

	int getSum() {
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum = sum + Math.abs(selectedArr[i] - selectedArr[i + 1]);
		}

		return sum;
	}

}



