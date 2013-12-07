package setgame.modell;

public class maintryes {
	public static void main(String[] args) {
		Pack pack = new Pack();
		for(Card card : pack.getPack()){
			System.out.println(card.getColor()+" , "+card.getFomr()+" , "+card.getPanelFilling()+" , "+card.getNumberOfComponents());
		}
	}
}
