package personnages;

public class Romain {
	private String nom;
	private int force;

	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
		@Override
	public String toString() {
		return "Romain [nom = " + nom + ", force = " + force + "]";
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + " << " + texte + " >>");
	}
	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		{assert force > 0 : "Force Négative";}
		int force1=force;
		force -=forceCoup;
		if (force>0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		{assert force1 > force : "Pas de Dégâts";}
	}
	public static void main(String[] args) {
		Romain minus = new Romain ("Minus" , 6);
		System.out.println(minus);
		minus.prendreParole();
		minus.parler("blabla");
		minus.recevoirCoup(6);
}
