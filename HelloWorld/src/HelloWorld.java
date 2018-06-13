import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {

	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("入力して下さい");
				String t=br.readLine();
				System.out.println(t);
		// TODO 自動生成されたメソッド・スタブ

	}

}
