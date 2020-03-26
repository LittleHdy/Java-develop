import java.util.concurrent.CountDownLatch;

/**
 * ˾���͹��ˣ����˱���ȵ�˾�����˲���װ���ϳ���˾������õȵ����й��˰ѻ���װ�ϳ���֮����ܰѳ����ߡ�
 * 
 * @author Administrator
 *
 */
public class CountDownLatch3 {

	static int workerNum = 30;
	static CountDownLatch driverLatch = new CountDownLatch(1);
	static CountDownLatch workerLatch =  new CountDownLatch(workerNum);
	
	public static void main(String[] args) throws InterruptedException{
		for (int i = 0; i < workerNum; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						driverLatch.await();//���˵�˾��
						System.out.println(Thread.currentThread().getName() + "������ʼ�ɻ�...");
						workerLatch.countDown();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}).start();
		}
		
		System.out.println("˾������...");
		driverLatch.countDown();
		
		System.out.println("���˿�ʼ�ɻ�...");
		
		workerLatch.await();
		System.out.println("���й��˸������...˾���ѳ�����");
	}
}
