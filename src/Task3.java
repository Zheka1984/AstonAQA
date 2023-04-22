import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		String[] input = sc.nextLine().split(" ");
		for (String s : input) {
			list.add(Integer.parseInt(s));
		}
		list.forEach(t -> {
			if (t % 3 == 0)
				System.out.println(t);
		});
		sc.close();
	}
}
