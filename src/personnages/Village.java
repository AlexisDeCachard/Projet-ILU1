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
	
	public Chef getChef() {
		return chef;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois<=villageois.length) {
			villageois[nbVillageois]=gaulois;
			nbVillageois++;
		}else {
			System.out.println("Le village est plein !");
		}
	}
	
	public Gaulois trouverHabitant (int num?roVillageois) {
		return villageois[num?roVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent  les l?gendaires gaulois :");
		for(int i =0; i <nbVillageois; i++) {
			System.out.println(" -" + trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irr?ductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30); Exception out of bound
		//L'exception ci-dessus a lieu car il y a trente emplacements dans la liste repr?sentant le village, allant de 0 ? 29. Donc 30 est au-del?.
        Chef Abraracourcix = new Chef("Abraracourcix",6, village);
        village.setChef(Abraracourcix);
        Gaulois asterix = new Gaulois("Ast?rix",8);
        village.ajouterHabitant(asterix);
        //Gaulois gaulois=village.trouverHabitant(1);
        //System.out.println(gaulois); r?sultat obtenu : null
        //On obtient ce r?sultat car Ast?rix est dans le village, à la premi?re position dans la liste, soit la position 0.
        //Il n'y a donc pas de gaulois ? la position 1, mais ?tant donn? que cette position a ?t? initialis?e, on obtient donc null et pas out of bound.
        Gaulois obelix = new Gaulois("Ob?lix",25);
        village.ajouterHabitant(obelix);
        village.afficherVillageois();
	}
	
}
