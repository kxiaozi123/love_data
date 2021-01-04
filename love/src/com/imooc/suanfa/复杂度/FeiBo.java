package com.imooc.suanfa.复杂度;

/**
 * 0 1 1 2 3 5 8
 * 0 1 2 3 4 5 6
 * 复杂度比较 O1<Ologn<On<Onlogn<On^2<On^3<o2^2<On!<On^n
 * something interesting
 * 我是一个斐波那契程序员 因为我每天都在改昨天和前天的bug
 */
public class FeiBo {
    //时间复杂度O(2^n)
    public static int fibo(int n)
    {
        if(n<=1) return n;
        return fibo(n-2)+fibo(n-1);
    }
    //时间复杂度 O(n)
    public static int fibo2(int n)
    {
        if(n<=1) return n;
        int first=0;
        int second=1;
        for (int i = 1; i <= n-1; i++) {
            int sum=first+second;
            first=second;
            second=sum;
        }
        return second;
    }
    public static int fibo3(int n)
    {
        if(n<=1) return n;
        int first=0;
        int second=1;
       while (n-->1){
           second+=first;
           first=second-first;
        }
        return second;
    }
    public static void main(String[] args) {
//        System.out.println(fibo(0));
//        System.out.println(fibo(1));
//        System.out.println(fibo(2));
//        System.out.println(fibo(3));
//        System.out.println(fibo(4));
        Times.test("fibo1", () -> {
            System.out.println(fibo(30));
        });
        Times.test("fibo2", () -> {
            System.out.println(fibo2(30));
        });
        Times.test("fibo3", () -> {
            System.out.println(fibo3(30));
        });



    }
}
