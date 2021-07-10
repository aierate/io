package com.guet.testTread;

import javax.sound.midi.SoundbankResource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Conway
 * @date 2021/3/18 20:34
 */
public class TestTread {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i=0;i<10;i++){

            exec.execute(()->{
                // 循环调用方法，参数需要finnal
                for (int j=0; j < 10; j++){
                    System.out.println( j);
                }
            });
        }
        //关闭线程池
        exec.shutdown();
        //线程执行完毕，再关闭主线程
        while (true){
            if (exec.isTerminated()){
                break;
            }
        }


    }
}
