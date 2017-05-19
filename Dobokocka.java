import java.util.Random;

public class Dobokocka {

	/**
	 * Objekt valtozok
	 */
	
	private int dobas1;
	private int dobas2;
	private int dobasOsszeg;
	
	
	
	/**
	 * Getterek es Setterek
	 */
	
	public int getDobas1() {
		return dobas1;
	}
	public void setDobas1(int dobas1) {
		this.dobas1 = dobas1;
	}
	
	public int getDobas2() {
		return dobas2;
	}
	public void setDobas2(int dobas2) {
		this.dobas2 = dobas2;
	}
	
	public int getDobasOsszeg() {
		return dobasOsszeg;
	}
	public void setDobasOsszeg(int elsoDobas, int masodikDobas) {
		this.dobasOsszeg = (elsoDobas + masodikDobas);
	}
	
	
	
	/**
	 * Default konstruktor
	 * az ertekeket minden dobasnal a dob metodussal random generatoraljuk
	 */
	
	Dobokocka() {}
	
	
	
	/**
	 * Metodusok: maga a dobas
	 */
	
	public int dob() {
		Random random = new Random();
		int elsoDobas = (random.nextInt(6) + 1);
		int masodikDobas = (random.nextInt(6) + 1);
		
		setDobas1(elsoDobas);
		setDobas2(masodikDobas);
		
		setDobasOsszeg(getDobas1(), getDobas2());
		
		System.out.println("A ket dobokocka: " + elsoDobas + " es " + masodikDobas +
				" azaz a dobott ertek: " + this.getDobasOsszeg() + "!");
		
		return getDobasOsszeg();
	}
	
	
}
