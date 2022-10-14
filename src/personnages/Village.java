package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois<=villageois.length) {
			villageois[nbVillageois]=gaulois;
			nbVillageois++;
		}else {
			System.out.println("Le village est plein !");
		}
		
	}
	public void trouverHabitant(int numéro) {
		
	}
}
