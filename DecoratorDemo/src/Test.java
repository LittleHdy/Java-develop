/**
 * װ�������ģʽ
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		// ���ɶ���
		Drink soya = new SoyaBeanMilk();
		// ��������
		SugarDecorator sugarSoya = new SugarDecorator(soya);
		// �����Ӻڶ�
		BlackBeanDecorator blackSugarSoya = new BlackBeanDecorator(sugarSoya);
		// �����Ӽ���
		EggDecorator eggBlackSugarSoya = new EggDecorator(blackSugarSoya);

		// ����
		System.out.println(eggBlackSugarSoya.description());
		System.out.println("�踶 " + eggBlackSugarSoya.cost() + " Ԫ");
	}
}
