
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * volatile���ܱ�֤ԭ�Ӳ���
 * 
 * һЩͬѧ���ܻ�����ɻ������volatile���εĹ���������Ա�֤�ɼ��ԣ���ô�����Ӧ����300000ô?

        ����ͳ���num++��������ϣ���Ϊnum++���Ǹ�ԭ���ԵĲ��������Ǹ����ϲ��������ǿ��Լ򵥽�����������Ϊ�����������:

����1.��ȡ

����2.��һ

����3.��ֵ

�������ԣ��ڶ��̻߳����£��п����߳�A��num��ȡ�������ڴ��У���ʱ�����߳̿����Ѿ���num�����˺ܶ࣬
       �߳�A��Ȼ�Թ��ڵ�num�����Լӣ�����д�������У����յ�����num�Ľ������Ԥ�ڣ�����С��30000��
 */
public class Counter {
    public static volatile int num = 0;
    //ʹ��CountDownLatch���ȴ������߳�ִ����
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
        //����30���߳̽����ۼӲ���
        for(int i=0;i<30;i++){
            new Thread(){
                public void run(){
                	
                    for(int j=0;j<10000;j++){
                        num++;//�ԼӲ���
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //�ȴ������߳�ִ����
        countDownLatch.await();
        System.out.println(num);
    }
}