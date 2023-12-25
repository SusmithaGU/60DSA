import java.util.LinkedList;

public class MinStack {
  

    class Node{
        int val;
        int minval;
        Node(int val){
            this.val=val;
            this.minval=Integer.MAX_VALUE;
        }
    }
    LinkedList<Node> stack;
    Node prev;
    public MinStack() {
        stack=new LinkedList<Node>();
        prev=new Node(-1);
    }
    
    public void push(int val) {
        Node a=new Node(val);
        if(val<prev.minval){
         a.minval=val;
        }
        else{
          a.minval=prev.minval;  
        }
        stack.push(a);
        prev=a;
    }
    
    public void pop() {
        stack.pop();
        Node b=stack.peek();
        prev=b;
        System.out.println(" ");
    }
    
    public int top() {
        Node a=stack.peek();
        return a.val;
    }
    
    public int getMin() {
        return prev.minval;
    }

    public static void main(String[] args) {
        MinStack m=new MinStack();
        m.push(-2);
        m.push(0);
        // m.push(-3);
        // m.pop();
        System.out.println(m.getMin());

    }
}

