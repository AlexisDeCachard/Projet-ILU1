package personnages;

public class Romain {
	private String nom;
	private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0 ;
    
    public void sEquiper(Equipement equipement) {
    	int nb = nbEquipement;
		switch (nb) {
		case 2: {
			System.out.println(" Le soldat "+ getNom() + " est déjà bien protégé !");
			break;
		}
		case 1:
			if (equipements[0]==equipement) {
				System.out.println(" Le soldat "+ getNom() + " possède déjà un " + equipement.toString() + " !");
				break;
			} else {
				equipements[1] = equipement;
				nbEquipement +=1;
				System.out.println(" Le soldat "+ getNom() + " s'équipe avec un " + equipement.toString() + " !");
				break;
			}
		default:
			equipements[0] = equipement;
			nbEquipement += 1;
			System.out.println(" Le soldat "+ getNom() + " s'équipe avec un " + equipement.toString() + " !");
			break;
		}
	}
    
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
		Equipement equip1 = Equipement.CASQUE;
		Equipement equip2 = Equipement.BOUCLIER;
		System.out.println(minus);
		minus.prendreParole();
		minus.parler("blabla");
		minus.recevoirCoup(6);
		for (Equipement equip : Equipement.values() ) {
			System.out.println("- "+equip);
		}
		minus.sEquiper(equip1);
		minus.sEquiper(equip1);
		minus.sEquiper(equip2);
		minus.sEquiper(equip1);
	}
}
