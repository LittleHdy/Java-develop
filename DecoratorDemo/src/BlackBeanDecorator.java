/**
 * �ڶ�������װ���߶���
 * 
 * @author Administrator
 * 
 */
public class BlackBeanDecorator extends Decorator {

	public BlackBeanDecorator(Drink drink) {
		super(drink);
	}

	@Override
	public String description() {
		return super.description() + "+�ڶ�";
	}

	@Override
	public float cost() {
		return super.cost() + 1.5f;
	}
}
