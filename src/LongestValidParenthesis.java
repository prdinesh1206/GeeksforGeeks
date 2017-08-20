import java.util.Stack;

public class LongestValidParenthesis {
	public static void main(String[] args){
		LongestValidParenthesis ll = new LongestValidParenthesis();
		int x = ll.longestValidParentheses("(())))");
		System.out.println(x);
	}
	public int longestValidParentheses(String a) {
	    int l = a.length();
	    if(l<=1){
	        return 0;
	    }
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(-1);
	    int cur=0, max=0;
	    for(int i=0;i<l;i++){
	        char ch=a.charAt(i);
	        if(ch=='('){
	            stack.push(i);
	        }else{
	            stack.pop();
	            if(!stack.empty()){
	                max = Math.max(max, i-stack.peek());
	            }else{
	                stack.push(i);
	            }
	        }
	    }
	    return max;
	}
	public int nextIndex(int l, String a){
	    for(int i=l;i>=0;i--){
	        if(a.charAt(i)==')'){
	            return i;
	        }
	    }
	    return -1;
	}
	public void printList(int[][] list, int l){
	    for(int i=0;i<l+1;i++){
	        for(int j=0;j<l+1;j++){
	            System.out.print(list[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
}
