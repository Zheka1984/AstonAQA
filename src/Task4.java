
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task4 {

	static Deque<Character> stack = new ArrayDeque<Character>();
	static Deque<Character> stack1 = new ArrayDeque<Character>();
	static List<Character> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String brackets = sc.nextLine();
		list = brackets.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		for (int i = 0; i < list.size(); i++) {
			compareBrackets(list.get(i));
		}
		if (stack.size() == 0)
			System.out.println("последовательность правильная");
		else
			System.out.println("последовательность неправильная");
		for (int i = 0; i < list.size(); i++) {
			compareBrackets1(list.get(i), i);
		}
		stack1.forEach(t -> {
			if (t.equals('('))
				System.out.println("нужно добавить элемент" + ")" + "на крайнюю справа позицию");
			if (t.equals('['))
				System.out.println("нужно добавить элемент" + "]" + "на крайнюю справа позицию");
		});
		sc.close();
	}

	static void compareBrackets1(Character ch, int index) {
		if (ch.equals('(') || ch.equals('[')) {
			stack1.push(ch);
		}
		if (stack1.peek() != null && stack1.peek().equals('[') && ch.equals(')')) {
			System.out.println("нужно добавить элемент " + "]" + " на позицию с индексом " + index);
			stack1.poll();
		}
		if (stack1.peek() != null && stack1.peek().equals('(') && ch.equals(']')) {
			System.out.println("нужно добавить элемент " + ")" + " на позицию с индексом " + index);
			stack1.poll();
		}
		if (ch.equals(')') && stack1.peek() != null && stack1.peek().equals('(')) {
			stack1.poll();
		} else if (stack1.isEmpty() && list.get(index).equals(')')) {
			System.out.println("нужно добавить элемент " + "(" + " на позицию с индексом " + index);
		}
		if (ch.equals(']') && stack1.peek() != null && stack1.peek().equals('[')) {
			stack1.poll();
		} else if (stack1.isEmpty() && list.get(index).equals(']')) {
			System.out.println("нужно добавить элемент " + "[" + " на позицию с индексом " + index);
		}
	}

	static void compareBrackets(Character ch) {
		if (ch.equals('(') || ch.equals('[')) {
			stack.push(ch);
		} else if (ch.equals(')') && stack.peek() != null && stack.peek().equals('(')) {
			stack.poll();
		} else if (ch.equals(']') && stack.peek() != null && stack.peek().equals('[')) {
			stack.poll();
		} else if ((ch.equals(')') || ch.equals(']')) && stack.isEmpty()) {
			stack.push('*');
		}
	}
}
