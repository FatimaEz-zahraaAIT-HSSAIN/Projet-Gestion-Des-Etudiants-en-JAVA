public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private int age;

    
    public Etudiant() {
    }

    
    public Etudiant(int id, String nom, String prenom, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    
    public void display() {
    	int id = getId() - 1;
    	 System.out.println("Student ID: " + id);
         System.out.println("Nom: " + getNom());
         System.out.println("Prénom: " + getPrenom());
         System.out.println("Âge: " + getAge());
         System.out.println("---------------------------");
    }
}
