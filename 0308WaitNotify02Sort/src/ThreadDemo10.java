
/**
 * ��10���̰߳�˳���ӡ��0123456789
 * @author Administrator
 *
 */
public class ThreadDemo10 {
	
	static int orderNum = 0;
	static int endNum = 10;
	
	static Object object= new Object();
	
	static class MyPrinter implements Runnable {
		
		int printNum;
	
		
		public MyPrinter(int printNum) {
			this.printNum = printNum;
		}

		@Override
		public void run() {
			//����˳���
			//System.out.println(Thread.currentThread().getName() + " : " + printNum);
			
			//��˳���
			synchronized(object){
				while(orderNum < endNum){
					if(orderNum == printNum){
						System.out.println(Thread.currentThread().getName() + " : " + printNum);
						
						orderNum++;
						object.notifyAll();
					}else{

						try {
							object.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}	
		}
	}

	public static void main(String[] args){
		
		for(int i=0; i < 10; i++){
			new Thread(new MyPrinter(i)).start();;
		}
	}
}


