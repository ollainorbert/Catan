
public class BotJatekos extends Jatekos {

	/**
	 * Objekt es egyeb valtozok
	 */
		
	private String nev;
	private String id;
	private int fa = 0;
	private int erc = 0;
	private int barany = 0;
	private int agyag = 0;
	private int buza = 0;
	private int pontszam = 2;
	
	
	
	/**
	 * Getterek es Setterek
	 */
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getFa() {
		return fa;
	}
	public void setFa(int fa) {
		this.fa += fa;
	}

	public int getErc() {
		return erc;
	}
	public void setErc(int erc) {
		this.erc += erc;
	}

	public int getBarany() {
		return barany;
	}
	public void setBarany(int barany) {
		this.barany += barany;
	}

	public int getAgyag() {
		return agyag;
	}
	public void setAgyag(int agyag) {
		this.agyag += agyag;
	}

	public int getBuza() {
		return buza;
	}
	public void setBuza(int buza) {
		this.buza += buza;
	}

	public int getPontszam() {
		return pontszam;
	}
	public void setPontszam(int pontszam) {
		this.pontszam += pontszam;
	}
	
	
	
	/**
	 * Default Konstruktor, nev beallitas meghivasaval
	 */
	
	BotJatekos(String nev, String id) {
		setNev(nev);
		setId(id);
	}
	

}