import java.util.Stack;

public class LongestValidParenthesis {
	public static void main(String[] args){
		LongestValidParenthesis ans = new LongestValidParenthesis();
		int x= ans.longestValidParentheses("()(((((())())((()())(())");
		System.out.println(x);
	}
	public int longestValidParentheses(String a) {
	    int l = a.length();
	    if(l<=1){
	        return 0;
	    }
	    Stack<Character> stack = new Stack<Character>();
	    int cur=0, max=0;
	    for(int i=0;i<l;i++){
	        char ch=a.charAt(i);
	        if(ch=='('){
	            stack.push(ch);
	        }else{
	            if(!stack.empty()){
	                char re=stack.pop();
	                
	                cur=cur+2;
	                if(max<cur){
	                	max=cur;
	                }
	            }else{
	                if(max<cur){
	                    max=cur;
	                }
	                cur=0;
	            }
	        }
	        System.out.println(stack+" "+max);
	    }
	    return max;
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
