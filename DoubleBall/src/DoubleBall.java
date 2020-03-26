import java.util.Random;
import java.util.Scanner;

public class DoubleBall {
	public static void main(String[] args){
		int sysBuleBallNumber;
		int[] sysRedBallNumber=new int[6];
		int userBlueBallNumber;
		int[] userRedBallNumber=new int[6];
		
		Random r=new Random();
		Scanner input=new Scanner(System.in);
		
		int[] redNumber={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		
		sysBuleBallNumber=r.nextInt(16)+1;
		
		for(int i=0; i<sysRedBallNumber.length;i++){
			while(true){
				int index=r.nextInt(33);
				if(redNumber[index] != 0){
					sysRedBallNumber[i]=redNumber[index];
					redNumber[index]=0;
					break;
				}
			}
		}
		
		System.out.print("������1����ɫ��:");
		userBlueBallNumber=input.nextInt();
		System.out.println("������6����ɫ�� :");
		for(int i=0;i<userRedBallNumber.length;i++){
			userRedBallNumber[i]=input.nextInt();
		}
		
		int blueBall=0;
		int redBall=0;
		if(userBlueBallNumber==sysBuleBallNumber){
			blueBall=1;
		}
		for(int i=0;i<userRedBallNumber.length;i++){
			for(int j=0;j<sysRedBallNumber.length;j++){
				if(userRedBallNumber[i]==sysRedBallNumber[j]){
					redBall++;
					break;
				}
			}
		}
		
		if(blueBall==1&&redBall==6){
			System.out.println("��ϲ��,����һ�Ƚ� 500��.");
		}else if(redBall==6){
			System.out.println("��ϲ��,���˶��Ƚ�.");
		}else if(blueBall==1&&redBall==5){
			System.out.println("��ϲ��,�������Ƚ� 3000Ԫ.");
		}else if(redBall==5||(blueBall==1&&redBall==4)){
			System.out.println("��ϲ��,�����ĵȽ� 200Ԫ.");
		}else if(redBall==4||(blueBall==1&&redBall==3)){
			System.out.println("��ϲ��,������Ƚ� 10Ԫ.");
		}else if(blueBall==1){
			System.out.println("��ϲ��,�������Ƚ� 5Ԫ.");
		}else{
			System.out.println("���ź�,��û���н�.");
		}
		
		int temp;
		System.out.println("�����н�����:");
		System.out.println("��ɫ��: "+sysBuleBallNumber);
		for(int i=0;i<sysRedBallNumber.length-1;i++){
			for(int j=0;j<sysRedBallNumber.length-i-1;j++){
				if(sysRedBallNumber[j]>sysRedBallNumber[j+1]){
					temp=sysRedBallNumber[j];
					sysRedBallNumber[j]=sysRedBallNumber[j+1];
					sysRedBallNumber[j+1]=temp;
				}
			}
		}
		System.out.print("��ɫ��: ");
		for(int i=0;i<sysRedBallNumber.length;i++){
			System.out.print(sysRedBallNumber[i]+" ");
		}
	}
}
