
public interface Palya {

	/**
	 * palya mezok generalasa
	 */
	
	public void aKomplettPalyaLeGeneralasa();
	
	
	
	/**
	 * aktualis allas kirajzolasa
	 */
	
	public void kirajzolas();
	
	
	
	/**
	 * szabaly szerint kezdo- es tovabbi lepesek meglepese
	 */
	
	public void kezdoLepesekBeallitasaTelepules(String nev, String nevId);
	public void kezdoLepesekBeallitasaUt(String nev, String nevId);
	public void lepesekBeallitasaTelepules(String nev, String nevId);
	public void lepesekBeallitasaUt(String nev, String nevId);
	public boolean lepesekBeallitasaVaros(String nev, String nevId);
	
	
	
	/**
	 * lepes lepese, es ellenorzo metodusai
	 */
	
	public boolean lepes(int oszlop, int sor, String tipus, String nevId, boolean isKezdoLepesTelepules);
	public boolean isSzomszedosEMasikTelepulessel(int oszlop, int sor);
	public String teruletTipusKinyero(int oszlop, int sor);
	public String nevIdKinyeroEpitesiTeruletbol(int oszlop, int sor);
	public boolean isSzomszedosMasikSajatEpitmennyel(int oszlop, int sor, String tipus, boolean isKezdoLepesTelepules, String nevId);
	
	
	
	/**
	 * adott kor eleji dobas dobasa
	 */
	
	public String dobas();
	public int mezoSzamKinyero(int oszlop, int sor);
	public String mezoTipusKinyero(int oszlop, int sor);

	
	
	/**
	 * a jatek elkezdesehez kapcsolodo metodusok
	 */
	
	public void jatekStart();
	
	
	
	/**
	 * a komplett jatekmenet vezenylese
	 */
	
	public void jatekMenet();
}
