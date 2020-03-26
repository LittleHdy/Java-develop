
/**
 * װ���߻���
 * @author Administrator
 *
 */
public abstract class Decorator implements Drink {

	Drink drink;
	
	public Decorator(Drink drink){
		this.drink=drink;
	}
	
	@Override
	public String description() {
		return drink.description();
	}

	@Override
	public float cost() {
		return drink.cost();
	}

}
