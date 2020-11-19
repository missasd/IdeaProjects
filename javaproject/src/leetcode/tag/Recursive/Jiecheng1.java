package leetcode.tag.Recursive;

public class Jiecheng1 {
    // 2. 这个函数用来干什么
    public static int solution(int n){
        // 1. base case
        if (n <= 1) return 1;
        return n * solution(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
