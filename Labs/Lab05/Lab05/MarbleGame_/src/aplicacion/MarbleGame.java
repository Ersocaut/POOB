package aplicacion;
import java.util.*;

public class MarbleGame {
	private String[][] table;
	
	public MarbleGame(int N, int M, int B) {
		table = new String[N][N];
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				table[i][j] = "_";
			}
		}
		Random r = new Random();
		for (int i = 0; i != M;i++){
			int row = r.nextInt(N);
			int column = r.nextInt(N);
		}
	}
	public static void main(String[] args) {
		MarbleGame nn = new MarbleGame(5,5,5);
	}
}
