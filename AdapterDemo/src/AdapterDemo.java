
//�ʺ���ģʽ
public class AdapterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerA powerA=new PowerAImpl();
		start(powerA);
		
		//PowerB powerB=new PowerBImpl();
		//start(powerB);
		
		PowerB powerB=new PowerBImpl();
		PowerAAdapter adapterA=new PowerAAdapter(powerB);
		start(adapterA);
	}
	public static void start(PowerA p){
		//��������...
		p.insert();
		//��������...
	}
	/*
	public static void start(PowerB p){
		//��������...
		p.connect();
		//��������...
	}*/

}
//�ʺ���
class PowerAAdapter implements PowerA{
	private PowerB powerB;
	public PowerAAdapter(PowerB p){
		powerB=p;
	}
	public void insert(){
		powerB.connect();
	}
}

interface PowerA{
	void insert();
}
class PowerAImpl implements PowerA{
	public void insert(){
		System.out.println("insert");
	}
}

interface PowerB{
	void connect();
}
class PowerBImpl implements PowerB{
	public void connect(){
		System.out.println("connect");
	}
}

