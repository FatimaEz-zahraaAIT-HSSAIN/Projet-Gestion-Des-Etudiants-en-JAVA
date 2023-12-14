import java.util.Scanner;

public class Main {
	public static void menuFunc(int choix) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int i ;
		switch (choix) {
        case 1:
            DatabaseFunc.displayEtudiants();
            System.out.print("Votre choix: ");
            i = s.nextInt();
            
            menuFunc(i);
            
            break;
        case 2:
        	DatabaseFunc.insererEtudiant();
        	System.out.print("Votre choix: ");
            i = s.nextInt();
            
            menuFunc(i);
            break;
        case 3:
        	DatabaseFunc.supprimerEtudiant();
        	System.out.print("Votre choix: ");
            i = s.nextInt();
            
            menuFunc(i);
            break;
        case 4:
        	DatabaseFunc.modifierEtudiant();
        	System.out.print("Votre choix: ");
            i = s.nextInt();
            
            menuFunc(i);
            break;
        case 5:
        	break;
        
        default:
            DatabaseFunc.menu();
            System.out.print("Votre choix: ");
            i = s.nextInt();
            
            menuFunc(i);
            
            break;
    }
	}
	

	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		
		DatabaseFunc.menu();
		
		
		int choix ;
		System.out.print("Votre choix: ");
		
			
			choix = scanner.nextInt();
			
			Main.menuFunc(choix);
		
		
	}

}
