import java.util.InputMismatchException;
import java.util.Scanner;

public class KezdetiParams {

	/**
	 * Objekt es egyeb valtozok
	 */
	
	private int letszam;
	private int gyozelemhezSzuksegesPont;
	private int fixVagyRandomPalya;
	private int botVsBot;
	private Scanner be;
	
	
	
	/**
	 * Getterek es Setterek
	 */
	
	public int getLetszam() {
		return letszam;
	}
	public void setLetszam(int letszam) {
		this.letszam = letszam;
	}
	
	
	public int getGyozelemhezSzuksegesPont() {
		return gyozelemhezSzuksegesPont;
	}
	public void setGyozelemhezSzuksegesPont(int gyozelemhezSzuksegesPont) {
		this.gyozelemhezSzuksegesPont = gyozelemhezSzuksegesPont;
	}
	
	
	public int getFixVagyRandomPalya() {
		return fixVagyRandomPalya;
	}
	public void setFixVagyRandomPalya(int fixVagyRandomPalya) {
		this.fixVagyRandomPalya = fixVagyRandomPalya;
	}
	
	
	public int getBotVsBot() {
		return botVsBot;
	}
	public void setBotVsBot(int pvpVagyBotokEllen) {
		this.botVsBot = pvpVagyBotokEllen;
	}
	
	
	
	/**
	 * Default konstruktor
	 * az ertekeket majd futas kozben allitjuk be
	 */
	
	KezdetiParams() {}
	
	
	
	/**
	 * parameteres konstruktor, a palyakon valo peldanyositashoz
	 */
	
	KezdetiParams(int fixVagyRandomPalya) {
		setFixVagyRandomPalya(fixVagyRandomPalya);
	}
	
	
	
	/**
	 * Metodusok: leirasok es kezdeti paramterek beallitasa
	 */
	
	public void startRules() {
		System.out.println("A jatekban telepulesek es varosok epitesevel lehet pontot szerezni." +
				"A jatekosok egymas utan kovetkeznek, egeszen addig, amig valamelyik jatekos" +
				"el nem eri az elore meghatarozott pontszamot.\n" +
				"A telepules 1 pontot, a varos pedig 2 pontot er!\n" +
				"Nehany jeloles:\nP1 - player 1, P2..., B1 - Bot1\n" +
				"U - ut; T - telepules; V - varos\n" );
	}
	
	public void fixVagyRandomPalyaLeiras() {
		System.out.println("Kerem valassza ki, hogy fix felepitesu palyat szeretne " +
				"valasztani: 1 (a fix palya ami a tutorialban talalhato)\n" +
				"vagy veletlenszeruen generaltat: 2!");
		
	}
	public void fixVagyRandomPalyaBe() {
		be = new Scanner(System.in);
		String bemenet;
		bemenet = be.nextLine();
		
		while(!bemenet.equals("1") && !bemenet.equals("2")) {
			System.out.println("A fentebb lathato fix palyahoz: 1-est kell beirni, " +
					"A random generalthoz: 2-es, majd enter!");
			bemenet = be.nextLine();
		}
		
		if (bemenet.equals("1")) {
			setFixVagyRandomPalya(1);
		} else {
			setFixVagyRandomPalya(2);
		}
	}
	
	public void letszamLeiras() {
		System.out.println("Kerem valassza ki, hogy a jatekot 3 vagy 4 fo jatsza:\n" +
				"3 jatekoshoz kerem irjon be 3-at, majd usson entert,\n" +
				"4 jatekoshoz kerem irjon be 4-et, amjd usson entert!");
	}
	public void letszamBe() {
		be = new Scanner(System.in);
		String bemenet;
		bemenet = be.nextLine();
		
		while(!bemenet.equals("3") && !bemenet.equals("4")) {
			System.out.println("3 jatekoshoz: 3-ast kell beirni, 4 jatekoshoz 4-et, s enter!");
			bemenet = be.nextLine();
		}
		
		if (bemenet.equals("3")) {
			setLetszam(3);
		} else {
			setLetszam(4);
		}
		
	}
	
	public void gyozelemhezSzuksegesPontLeiras() {
		System.out.println("Kerem adja meg, hogy mennyi legyen a gyozelemhez " +
				"szukseges pontszam! Minimum 3-nek lennie kell!");
	}
	public void gyozelemhezSzuksegesPontBe() {
		be = new Scanner(System.in);
		int bemenet;
		boolean bemenetOk = true;
		
		while(bemenetOk) {
			try {
				bemenet = be.nextInt();
				
				if(bemenet < 3) {
					System.out.println("Minimum 3!");
				}
				
				if(bemenet > 2) {
					setGyozelemhezSzuksegesPont(bemenet);
					bemenetOk = false;
				}
				
			} catch (InputMismatchException ex) {
				System.err.println("Nem szamot adtal meg!");
				be.next();
				continue;
			}
			
		}
		
	}
	
	public void BotvsBotLeiras() {
		System.out.println("Lehetoseg van Bot vs Bot jatszmat nezni.\n" +
				"Ez a tutorialban feltuntetett palyan fog zajlani.\n" +
				"Rendes modehoz (Jatekosok versus Jatekosok): 1!\n" +
				"BotvsBot modehoz: 2!");
	}
	public void BotvsBotBe() {
		be = new Scanner(System.in);
		String bemenet;
		bemenet = be.nextLine();
		
		while(!bemenet.equals("1") && !bemenet.equals("2")) {
			System.out.println("Jatekos versus Jatekoshoz: 1-est kell beirni, " +
					"Jatekos vs Bothoz: 2-es, majd enter!");
			bemenet = be.nextLine();
		}
		
		if (bemenet.equals("1")) {
			setBotVsBot(1);
		} else {
			setBotVsBot(2);
		}
	}
	
	
	
	/**
	 * Objekt ertekeinek beallitasa
	 */
	
	public void setupInMain1() {
		startRules();
		BotvsBotLeiras();
		BotvsBotBe();
	}
	
	public void setupInMain2() {
		fixVagyRandomPalyaLeiras();
		fixVagyRandomPalyaBe();
	}
	
	public void setupInPalya() {
		letszamLeiras();
		letszamBe();
		gyozelemhezSzuksegesPontLeiras();
		gyozelemhezSzuksegesPontBe();
	}
	
	public void setupInPalyaBotVsBot() {
		gyozelemhezSzuksegesPontLeiras();
		gyozelemhezSzuksegesPontBe();
	}

}
