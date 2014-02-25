public class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] height = new int[h.length + 1];
        for(int i = 0; i < h.length; i++)
            height[i] = h[i];
        height[h.length] = 0;
        int result = 0;
        int i = 0;
        for(; i < height.length; ) {
            if(stack.empty() || height[i] > height[stack.peek()]) {
                stack.push(i++);
            } else {
                int tmp = stack.pop();
                result = Math.max(result, height[tmp] * (stack.empty()? i : i - stack.peek() - 1));
            }
        }
        return result;
    }
}