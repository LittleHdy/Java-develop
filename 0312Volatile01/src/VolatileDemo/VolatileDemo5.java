package VolatileDemo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 */
public class VolatileDemo5 {
    public static AtomicInteger num = new AtomicInteger(0);
    //ʹ��CountDownLatch���ȴ������߳�ִ����
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
        //����30���߳̽����ۼӲ���
        for(int i=0;i<30;i++){
            new Thread(){
                public void run(){
                    for(int j=0;j<10000;j++){
                    	num.incrementAndGet();//ԭ���Ե�num++,ͨ��ѭ��CAS��ʽ
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //�ȴ������߳�ִ����
        countDownLatch.await();
        //Thread.sleep(1000); //��ʹ��CountDownLatchҲ����,ֻҪ�����㹻ʱ�������߳�������ɾͿ���
        System.out.println(num);
    }
}