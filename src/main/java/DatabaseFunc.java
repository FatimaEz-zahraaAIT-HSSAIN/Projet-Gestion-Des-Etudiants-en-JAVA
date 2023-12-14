import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseFunc {
	
	public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/tp_jdbc";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    
    public static Etudiant[] getEtudiants() {
    	List<Etudiant> List = new ArrayList<>();
    	
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            String selectQuery = "SELECT * FROM etudiants";
            ResultSet rs = stmt.executeQuery(selectQuery);

            
            while (rs.next()) {
            	
            	int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                int age = rs.getInt("age");

                
                Etudiant etudiant = new Etudiant(id, nom, prenom, age);
                List.add(etudiant);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return List.toArray(new Etudiant[0]);
    }
    
    
    public static void displayEtudiants() {
    	Etudiant[] List = getEtudiants();
    	
    	for (Etudiant etudiant : List) {
    		etudiant.display();
    	}
    }
    
    
  
    
	public static void insererEtudiant(){
        try (Connection conn = getConnection();){
        	
        	@SuppressWarnings("resource")
        	Scanner scanner = new Scanner(System.in);
        	System.out.println("--------------------------------------------------------------------");
        	System.out.println("Inserer les informations");
        	System.out.println("--------------------------------------------------------------------");
        	System.out.print("Enter le nom d'etudiant: ");
            String n = scanner.nextLine();
        	
            System.out.print("Enter le prenom d'etudiant: ");
            String pn = scanner.nextLine();
            
            System.out.print("Enter l'age d'etudiant: ");
            int age = scanner.nextInt();
            
            String query = "INSERT INTO etudiants (nom, prenom, age) VALUES (?, ?, ?)";
            
            
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, n);
            pre.setString(2, pn);
            pre.setInt(3, age);
            
            pre.executeUpdate();
            
            System.out.println("Nouvel étudiant inséré avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void modifierEtudiant() {
    	try(Connection conn = getConnection();){
    		String query = "UPDATE etudiants SET nom = ?, prenom = ?, age = ? WHERE id = ?";
    		
    		@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
    		System.out.println("--------------------------------------------------------------------");
    		System.out.println("Modifier information");
    		System.out.println("--------------------------------------------------------------------");
    		System.out.print("Enter l'id d'etudiant: ");
            int id = scanner.nextInt();
            
        	System.out.print("Enter le nom d'etudiant: ");
            String n = scanner.nextLine();
        	
            System.out.print("Enter le prenom d'etudiant: ");
            String pn = scanner.nextLine();
            
            System.out.print("Enter l'age d'etudiant: ");
            int age = scanner.nextInt();
            
            
            
    		PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, n);
            pre.setString(2, pn);
            pre.setInt(3, age);
            pre.setInt(4, id);
            
            int rows = pre.executeUpdate();
            
            if (rows > 0) {
            	System.out.println();
            	System.out.println();
                System.out.println("Informations de l'étudiant mises à jour avec succès !");
                System.out.println("--------------------------------------------------------------------");
            } else {
            	System.out.println();
            	System.out.println();
                System.out.println("Aucun étudiant trouvé avec cet ID. Aucune mise à jour effectuée.");
                System.out.println("--------------------------------------------------------------------");
            }
    	}catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
   
	public static void supprimerEtudiant() {
        try (Connection conn = getConnection();){
            String query = "DELETE FROM etudiants WHERE id = ?";
            
            
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
    		System.out.println("--------------------------------------------------------------------");
    		System.out.println("Supprimer etudiant");
    		System.out.println("--------------------------------------------------------------------");
    		System.out.print("Enter l'id d'etudiant: ");
            int id = scanner.nextInt();
            
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, id);
            
            
            int rows = pre.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Étudiant supprimé avec succès !");
            } else {
                System.out.println("Aucun étudiant trouvé avec cet ID. Aucune suppression effectuée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void menu() {
		System.out.println("-------------------------------Menu---------------------------------");
		System.out.println("1. Afficher les etudiants");
		System.out.println("2. Ajouter etudiant");
		System.out.println("3. Supprimer etudiant");
		System.out.println("4. Modifier etudiant");
		System.out.println("5. Sortir");
		System.out.println("--------------------------------------------------------------------");
	}
	

}
