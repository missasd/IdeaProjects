package exam.xiecheng.test1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 订单系统工作流路径解析
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 1. 背景: 订单系统的业务逻辑处理，通过采用工作流的方式进行处理，基于面向配置编程以利于后续扩展与维护.
 *
 * 2. 要求: 当前需要根据工作流的配置解析和找出所有工作流路径, 可能存在循环依赖路径.
 *
 * 3. 说明: 空格隔开的字符串每一个字母都代表一个节点. 比如a bc e, 表示a的下一个节点为b或者c， 输出为:abe, ace.
 *
 * 4. 举例: 有3个分支，
 *
 *             输入,
 *
 *                  a bc df gh
 *
 *             输出如下， 结果输出根据单个字符的下标index排序:  Comparator.naturalOrder().
 *
 *                  abdg
 *
 *                  abdh
 *
 *                  abfg
 *
 *                  abfh
 *
 *                  acdg
 *
 *                  acdh
 *
 *                  acfg
 *
 *                  acfh
 *
 *
 *
 *
 * 输入描述
 * 输入工作流程配置(可能存在循环依赖路径)
 *
 * 输出描述
 * 找出所有的路径, 正常路径与循环依赖路径,  并且必须标识出循环依赖路径(后缀为--circular dependency),  当前实例题仅为2个分支场景. 3个或3个以上分支请见上面举例
 *
 *
 * 样例输入
 * a bc d eag f
 * 样例输出
 * abdef
 * abdaf--circular dependency
 * abdgf
 * acdef
 * acdaf--circular dependency
 * acdgf
 *
 * 提示
 * 约束: 1个字母代表下一个节点.
 * abae: 由于a最终会流转回a, 证明这个是错误的配置即循环依赖路径， 输出带后缀说明: abae--circular dependency
 *
 * 根据单个字符的下标index排序， 结果的排序:  Comparator.naturalOrder()
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提
 */
public class Solution2 {
    public static void main(String[] args) {
        // 获取一行输入并保存
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String[] s = word.split(" ");



        System.out.println(word);
    }
}
