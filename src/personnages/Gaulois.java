package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ( "Astérix" , 8 );
		Romain minus = new Romain ("Minus" , 6);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("blabla");
		asterix.frapper(minus);
	}
}
