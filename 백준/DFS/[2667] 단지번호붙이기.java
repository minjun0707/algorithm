import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	int n;
	int table[][];
	boolean visit[][];
	int count =0;
	List list = new ArrayList<Integer>();
	int[] dirX = {1, -1, 0, 0};
	int[] dirY = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		table = new int[n][n];

		String str;
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < n; j++) {
				table[i][j] = str.charAt(j) - '0';
			}
		}

		visit = new boolean[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {

				if(visit[i][j]== false && table[i][j] == 1) {
					dfs(i, j);
					list.add(count);
					count = 0;
				}

			}

		Collections.sort(list);
		System.out.println(list.size());
		for (Object o : list) {
			System.out.println(o);
		}
	}

	void dfs(int y, int x) {
		//탈출조건//방문했을시
		//
		visit[y][x] =  true;
		count++;
		// 반복조건
		//방향체크 있을시 dfs
		for (int i = 0; i < 4; i++) {

			if((x == n-1 && i ==0) || (y == n-1 && i ==2) ||(x == 0 && i ==1) || (y == 0 && i ==3)){
				continue;
			}

			//오른쪽
			int nowDirX = x + dirX[i];
			int nowDirY = y + dirY[i];

			if (visit[nowDirY][nowDirX] == false && table[nowDirY][nowDirX] == 1 ) {
				dfs(nowDirY , nowDirX);
			}

		}

	}

}
