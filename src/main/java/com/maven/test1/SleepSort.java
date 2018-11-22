package com.maven.test1;

/**
 * 休眠排序
 * @author lulu
 */
public class SleepSort implements Runnable{
    private int number;

    public static void main(String[] args) {
        //沙雕休眠排序
        int[] sortArray = new int[]{1,2,5,6,7,75,25,88};
        for(int temp : sortArray){
            new Thread(new SleepSort(temp)).start();
        }
    }

    public SleepSort(int number){
        this.number = number;
    }

    @Override
    public void run() {
        try {
            //线程休眠number毫秒
            Thread.sleep(number);
            System.out.println(number);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
