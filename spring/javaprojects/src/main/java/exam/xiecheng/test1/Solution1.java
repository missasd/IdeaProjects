package exam.xiecheng.test1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 敏感词替换
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 考虑实现一个敏感词过滤的功能，给定指定的敏感单词、句子、替换词，把句子中的敏感单词词全部替换成替换词。
 *
 * 注意替换过程中敏感词需要忽略字母顺序，例如you这个敏感词，句子里如果出现oyu、uyo等，也同样需要进行替换，以免有人利用不影响人类理解的错误字母顺序钻空子。
 *
 *
 *
 * 输入描述
 * 输入为三行内容：
 *
 * 第一行是敏感单词
 *
 * 第二行是待检测的句子
 *
 * 第三行是替换的目标词
 *
 * 输出描述
 * 输出替换好敏感词的句子
 *
 *
 * 样例输入
 * you
 * i love you,oyu love me
 * jack
 * 样例输出
 * i love jack,jack love me
 *
 * 规则
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String line = sc.nextLine();
        String replace = sc.nextLine();



    }

    public static boolean check(String line, String target, String replace){
        // 得到敏感词每个字符出现次数，并存入HashMap中
        HashMap<Character, Integer> first = new HashMap<Character, Integer>();
        for (char c : target.toCharArray()){
            if (first.get(c) == null){
                first.put(c, 0);
            }else {
                first.put(c, first.get(c)+1);
            }
        }

        // 找出句子中分割的字符
        return true;
    }


}
