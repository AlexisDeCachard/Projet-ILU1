package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ( "Astérix" , 8);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Romain minus = new Romain ("Minus" , 45);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.parler("Je vais préparer une petite potion.");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste  !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU...UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}
}
