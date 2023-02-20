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
	int[] dirX = {1, -1, 0, 0};
	int[] dirY = {0, 0, 1, -1};

	int answer = 1;
	int count = 0;
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		table = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int height = 1; height < 100 ; height ++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(visit[i][j] == false && table[i][j] > height){
						dfs(i,j,height);
						count++;
					}
				}
			}

			answer = Math.max(answer,count);
			count = 0;
			visit = new boolean[n][n];
		}

		System.out.print(answer);

	}

	void dfs(int y, int x, int height) {

		visit[y][x] = true;
		//탐색진행
		for(int i = 0 ; i < 4 ; i++){

			if((x == n -1 && i == 0) || (x == 0 && i == 1) || (y == n -1 && i == 2) || (y == 0 && i == 3)) {
				continue;
			}

			int nowDirX = x + dirX[i];
			int nowDirY = y + dirY[i];

			if(visit[nowDirY][nowDirX] == false && table[nowDirY][nowDirX] > height) {
				dfs(nowDirY,nowDirX,height);
			}

		}
	}

}
