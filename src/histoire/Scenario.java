package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ( "Ast�rix" , 8);
		Gaulois obelix = new Gaulois("Ob�lix", 20);
		Romain minus = new Romain ("Minus" , 6);
		Romain milexus = new Romain("Milexus",8);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.parler("Je vais pr�parer une petite potion.");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par B�l�nos, ce n'est pas juste  !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU...UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}
}
