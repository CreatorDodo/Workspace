package javaz.util;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.add("red"); System.out.println(stack);
		stack.push("mon"); System.out.println(stack);
		stack.push("tue"); System.out.println(stack);
		stack.push("wed"); System.out.println(stack);
		
		System.out.println();
		
		System.out.println(stack.get(1) + " " + stack);
		System.out.println(stack.peek() + " " + stack);
		System.out.println(stack.pop() + " " + stack);
		
		System.out.println(stack.search("red"));
		System.out.println(stack.search("mon"));
		System.out.println(stack.search("tue"));
		System.out.println(stack.search("레드"));
	}

}
