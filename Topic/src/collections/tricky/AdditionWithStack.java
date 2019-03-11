package collections.tricky;

class Stack {

	int stackSize;
	int stackArr[];
	int top;

	public Stack(int num) {
		stackSize = num;
		stackArr = new int[num];
		top = -1;
	}

	public void push(int ele) {
		stackArr[++top] = ele;
	}

	public int pop() {
		return stackArr[top--];
	}

	boolean isEmpty() {
		return (top == -1);
	}

}

public class AdditionWithStack {

	static int sum;
	static Stack myStack;
	static int ans;

	public static void main(String[] args) {
		int num = 50;
		stackAddition(num);
		System.out.println("answer : "+ans);
	}

	private static void stackAddition(int num) {
		myStack = new Stack(num);
		while(num>0){
			myStack.push(num--);
		}
		while(!myStack.isEmpty()){
			ans += myStack.pop();
		}
		
	}

}
