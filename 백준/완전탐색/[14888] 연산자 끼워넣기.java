import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int n;
	int arr[];
	int operator[] = new int[4];
	int visit[];
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		visit = new int[n];
		dfs(0, arr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	void dfs(int depth, int num) {
		if (depth == n -1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (operator[i] > 0) {

				operator[i]--;

				switch (i) {
					case 0: dfs(depth + 1, num+arr[depth+1]); break;
					case 1: dfs(depth + 1, num-arr[depth+1]); break;
					case 2: dfs(depth + 1, num*arr[depth+1]); break;
					case 3: dfs(depth + 1, num/arr[depth+1]); break;
				}
				operator[i]++;

			}

		}

	}


}
