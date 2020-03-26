
public class Singleton {

	private volatile static Singleton uniqueInstance;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		//���ж϶����Ƿ��Ѿ�ʵ������û��ʵ�������Ž����������
		if(uniqueInstance == null){
			//��������
			synchronized(Singleton.class){
				uniqueInstance = new Singleton();
			}
		}
		return uniqueInstance;
	}
	
	public static void print(){
		System.out.println("����ģʽ");
	}
}

//���⣬��Ҫע�� uniqueInstance ���� volatile �ؼ�������Ҳ�Ǻ��б�Ҫ��
//
//uniqueInstance ���� volatile �ؼ�������Ҳ�Ǻ��б�Ҫ�ģ� uniqueInstance = new Singleton(); ��δ�����ʵ�Ƿ�Ϊ����ִ�У�
//
// 1.Ϊ uniqueInstance �����ڴ�ռ�
// 2.��ʼ�� uniqueInstance
// 3.�� uniqueInstance ָ�������ڴ��ַ
//�������� JVM ����ָ�����ŵ����ԣ�ִ��˳���п��ܱ�� 1->3->2��ָ�������ڵ��̻߳����²���������⣬
//�����ڶ��̻߳����»ᵼ��һ���̻߳�û�û�г�ʼ����ʵ�������磬�߳� T1 ִ���� 1 �� 3����ʱ T2 ���� getUniqueInstance() ���� uniqueInstance ��Ϊ�գ�
//��˷��� uniqueInstance������ʱ uniqueInstance ��δ����ʼ����
//
//ʹ�� volatile ���Խ�ֹ JVM ��ָ�����ţ���֤�ڶ��̻߳�����Ҳ���������С�
