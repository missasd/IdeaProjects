package exam.xiaomi.test1;
import java.lang.Character.*;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            System.out.println(helper(str));
        }
    }

    public static int helper(String str){
        int right = 0;
        int len_err = 1;
        int type_err = 2;
        if (str.length() < 8 || str.length() > 120) return len_err;
        // 类型不符合
        int num_count = 0;
        int ch_count = 0;
        int upper_count = 0;
        int lower_count = 0;
        for (char c : str.toCharArray()){
            if (Character.isDigit(c)){
               num_count++;
            }
            if (Character.isUpperCase(c)){
                upper_count++;
            }
            if (Character.isLowerCase(c)){
                lower_count++;
            }
            if (Character.isDefined(c)){
                ch_count++;
            }
            if (Character.isWhitespace(c)){
                continue;
            }
        }
        if (num_count < 1 || ch_count < 1 || upper_count < 1|| lower_count < 1)
        {
            return type_err;
        }
        return right;
    }
}
