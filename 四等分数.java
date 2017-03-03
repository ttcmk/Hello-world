import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 
    四等分数 输入 2 5 1 1 1 1 4 1 7 3 7 0 输出true
**/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static boolean resolve(int[] A) {
        int m1, m2, m3 = 0;
        int length = A.length;
        for(int i = 0; i < length; i++){
            for(int j = i+1; j<length; j++){
                for(int k = j+1; k < length; k++){
                    if(A[i] < 0 || A[j] < 0 || A[k] < 0){
                        return false;
                    }
                    if(sumArray(A,0,i) == sumArray(A,i+1,j) && sumArray(A,0,i) == sumArray(A,j+1,k) && sumArray(A,0,i)== sumArray(A,k+1,length)){
                        m1 = i;
                        m2 = j;
                        m3 = k;
                        System.out.println("m1 = " + m1 + "m2 = " + m2 + "m3 =" + m3);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int sumArray(int[] A, int p, int q) {
        int sum = 0;
        for(int i=p;i<q;i++){
            sum = sum + A[i];
        }
        return sum;

    }

    public static void main(String[] args){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
