import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastScanner {
	BufferedReader br;
	StringTokenizer st;

	public FastScanner(File f) {
		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public FastScanner(InputStream f) {
		br = new BufferedReader(new InputStreamReader(f));
	}

	public String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}
