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
				ajouterEquipement(equipement, 1);
				break;
			}
		default:
			ajouterEquipement(equipement,0);
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement,int indice) {
		equipements[indice] = equipement;
		nbEquipement += 1;
		System.out.println(" Le soldat "+ getNom() + " s'équipe avec un " + equipement.toString() + " !");
	}
    
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;{assert force>0 : "Force Négative";}
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
//	public void recevoirCoup(int forceCoup) {
//		int force1=force;{assert force > 0 : "Force Négative";}
//		force -=forceCoup;
//		{assert force1 > force : "Pas de Dégâts";}
//		if (force>0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom+ " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public static void main(String[] args) {
		Romain minus = new Romain ("Minus" , 1);
		Equipement equip1 = Equipement.CASQUE;
		Equipement equip2 = Equipement.BOUCLIER;
		System.out.println(minus);
		minus.prendreParole();
		minus.parler("blabla");
		minus.recevoirCoup(1);
		for (Equipement equip : Equipement.values() ) {
			System.out.println("- "+equip);
		}
		minus.sEquiper(equip1);
		minus.sEquiper(equip1);
		minus.sEquiper(equip2);
		minus.sEquiper(equip1);
	}
}
