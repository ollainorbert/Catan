import java.util.Random;

public class KezdoLepesek4vsBot {

	/**
	 * szukseges valtozok deklaralasa
	 */
	
	Random random = new Random();
	
	
	
	/**
	 * default konstruktor
	 */
	
	KezdoLepesek4vsBot() {}
	
	
	
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
		String XY;
		int bemenet, bemenet2;
		
		System.out.println(nev + " kezdo lepese:\nEloszor kerem a telepules oszlopat(1-5):");
		bemenet = (random.nextInt(5)+1);
		
		System.out.println(nev + ", most pedig a telepules sorat(1-5):");
		bemenet2 = (random.nextInt(5)+1);
		
		XY = (String.valueOf(bemenet) + String.valueOf(bemenet2));
		
		return XY;
	}
	
	public String kezdoLepesUt(String nev) {
		String XY;
		int bemenet, bemenet2;
		
		System.out.println(nev + " kezdo lepese:\nEloszor kerem az ut oszlopat(1-9):");
		bemenet = (random.nextInt(9)+1);
		
		System.out.println(nev + ", most pedig az ut sorat(1-9):");
		bemenet2 = (random.nextInt(9)+1);
		
		XY = (String.valueOf(bemenet) + String.valueOf(bemenet2));
		
		return XY;
	}
}