public class Stack {
    private int top;
    private int capacity = 0;
    private int[] arr;

    Stack(int size) {
        capacity = size;
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack is full.");
            return;
        }

        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            System.exit(1);;
        }

        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            System.exit(1);;
        }

        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public void printStack() {
        System.out.print("The stack element: ");
        for (int i = 0; i <= top;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        stack.printStack();
    }
}