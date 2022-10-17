package personnages;

public class Gaulois {

	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees=0;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}

	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom = " + nom + ", force = " + force + ", effetPotion = " + effetPotion + "]";
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees1 = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees1 != null && i < trophees1.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = trophees1[i];
		}
	}


	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler(" Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ( "Astérix" , 8 );
		Romain minus = new Romain ("Minus" , 6);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("blabla");
		asterix.boirePotion(6);
		asterix.frapper(minus);
	}
}
