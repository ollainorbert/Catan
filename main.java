public class main {

	public static void main(String[] args) {
		
		/**
		 * kezdeti parameterek megadasa a palya tipusanak kivalasztasahoz,
		 * illetve a kezdo lepesek osztaly peldanyasitasa
		 */
		
		KezdetiParams kezdetiParams = new KezdetiParams();
		kezdetiParams.setupInMain1();
		
		if ( kezdetiParams.getBotVsBot() == 2) {
			FixedPalya4vsBot fixedPalyaBotVsBot = new FixedPalya4vsBot();
			fixedPalyaBotVsBot.jatekMenet();
		} else {
			kezdetiParams.setupInMain2();
			
			/**
			 * palya beallitasa, es iranyitas atadasa
			 */
			
			if ( kezdetiParams.getFixVagyRandomPalya() == 1) {
				FixedPalya fixedPalya = new FixedPalya();
				fixedPalya.jatekMenet();
			} else {
				RandomGeneraltPalya randomGeneraltPalya = new RandomGeneraltPalya();
				randomGeneraltPalya.jatekMenet();
			}
		}
		
		
		
		
		
		
	}
	
	
}
