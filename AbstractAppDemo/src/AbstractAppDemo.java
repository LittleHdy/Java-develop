
/**
 * ������: abstract
 * 1.�����಻һ��Ҫ�г��󷽷�
 * 2.��������������Ժ;��巽��ʵ��
 * 3.���󷽷�:ֻ������,û��ʵ��
 * 4.�����಻�ܱ�ʵ����
 * 5.�ǳ�����̳г��������ʵ�����г��󷽷�
 * 
 * �������Ӧ��
 * ���ģʽ:ģ�巽�����ģʽ
 * ����:����һ��ҵ�����̵�������,��һЩϸ�ڲ����ӳٵ�������ʵ��
 * ������ǿɱ��ϸ�ڲ���
 * @author Administrator
 *
 */

public class AbstractAppDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Palace s=new Shemale("hh");
		s.action();
	}

}
abstract class Palace{
	//ģ�巽�����ģʽ
	public void action(){
		if(competition()){
			System.out.println("sucess");
		}else{
			System.out.println("fail");
		}
	}
	
	abstract boolean competition();
}
class Shemale extends Palace{
	private String name;
	public Shemale(String name){
		this.name=name;
	}
	
	public boolean competition(){
		System.out.println("I am "+ name);
		return true;
	}
}