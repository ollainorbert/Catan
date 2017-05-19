import java.util.Scanner;

public class KezdoLepesek {

	/**
	 * szukseges valtozok deklaralasa
	 */
	
	private Scanner be;
	
	
	
	/**
	 * default konstruktor
	 */
	
	KezdoLepesek () {}
	
	
	
	/**
	 * szabalyzat ismertetese a kezdo lepesekhez
	 */
	
	public void szabalyzatAlap() {
		System.out.println("Minden jatekosnak fel kell tennie 2 telepulest es hozzajuk 1-1 utat!\n" +
				"A sorrend a kovetkezo lesz: Jatekos 1 -> Jatekos 2 -> ... feltesz 1 telepulest " +
				"es egy utat, majd a kovetkezo korben hatulrol haladunk visszafele, az " +
				"eselyek kiegyenletese vegett!");
	}
	
	public void szabalyosLepesFogalma() {
		System.out.println("A telepuleseket a mezo csucsokra lehet tenni, az utakat pedig a mezo elekre!\n" +
				"A megadasi formatum a kovetkezo: X. oszlop Y. sor!\n" + "X\nY\n" +
				"\nEloszor a telepulest kell megadni, majd az utat!\n");
	}
	
	public void szabalyzat() {
		szabalyzatAlap();
		szabalyosLepesFogalma();
	}
	
	public void szabalyLepesVisszaIranyban() {
		System.out.println("Most pedig visszafele sorrendben kovetkeznek a kezdo lepesek!");
	}
	
	public void kezdoLepesekEND() {
		System.out.println("Kezdolepesek meglepve! Kezdodjek a jatek!");
	}
	
	
	
	/**
	 * metodusok: kezdo lepesek meglepese
	 */
	
	public String kezdoLepesTelepules(String nev) {
		be = new Scanner(System.in);
		String XY;
		String bemenet;
		String bemenet2;
		
		System.out.println(nev + " kezdo lepese:\nEloszor kerem a telepules oszlopat(1-5):");
		bemenet = be.nextLine();
		while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
				&& !bemenet.equals("4") && !bemenet.equals("5")) {
			System.out.println("5 oszlop van, ahova telepules helyezheto! A mezo csucsai!");
			bemenet = be.nextLine();
		}
		
		System.out.println(nev + ", most pedig a telepules sorat(1-5):");
		bemenet2 = be.nextLine();
		while(!bemenet2.equals("1") && !bemenet2.equals("2") && !bemenet2.equals("3")
				&& !bemenet2.equals("4") && !bemenet2.equals("5")) {
			System.out.println("5 sor van, ahova telepules helyezheto! A mezo csucsai!");
			bemenet2 = be.nextLine();
		}
		
		XY = (bemenet + bemenet2);
		
		return XY;
	}
	
	public String kezdoLepesUt(String nev) {
		be = new Scanner(System.in);
		String XY;
		String bemenet;
		String bemenet2;
		
		System.out.println(nev + " kezdo lepese:\nEloszor kerem az ut oszlopat(1-9):");
		bemenet = be.nextLine();
		while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3") && !bemenet.equals("4")
				&& !bemenet.equals("5") && !bemenet.equals("6") && !bemenet.equals("7")
				&& !bemenet.equals("8") && !bemenet.equals("9")) {
			System.out.println("9 oszlop van, ahova az ut helyezheto! A mezo elei!");
			bemenet = be.nextLine();
		}
		
		System.out.println(nev + ", most pedig az ut sorat(1-9):");
		bemenet2 = be.nextLine();
		while(!bemenet2.equals("1") && !bemenet2.equals("2") && !bemenet2.equals("3") && !bemenet2.equals("4")
				&& !bemenet2.equals("5") && !bemenet2.equals("6") && !bemenet2.equals("7")
				&& !bemenet2.equals("8") && !bemenet2.equals("9")) {
			System.out.println("9 sor van, ahova az ut helyezheto! A mezo elei!");
			bemenet2 = be.nextLine();
		}
		
		XY = (bemenet + bemenet2);
		
		return XY;
	}
}
