import java.util.Random;

public class FixedPalya4vsBot implements Palya {

	/**
	 * Objekt valtozok es objektek letrehozasa
	 */
	
	private String epitesiVonalak[][] = new String[9][9];
	private String nyersanyagMezok[][] = new String[4][4];
	private String fixedNyersanyagMezok[][] = { {"H02", "R10", "H06", "M12"}, {"M08", "D03", "R09", "E05"},
			{"M04", "R09", "D10", "H06"}, {"D05", "E08", "E04", "M11"} };
	
	Random random = new Random();
	
	KezdetiParams kezdetiParams = new KezdetiParams(1);
	KezdoLepesek4vsBot kezdoLepesek4vsBot = new KezdoLepesek4vsBot();
	Dobokocka doboKocka = new Dobokocka();
	
	

	/**
	 * Default konstruktor
	 */
	
	FixedPalya4vsBot() {}
	
	

	/**
	 * Metodusok:
	 */
	
	@Override
	public void aKomplettPalyaLeGeneralasa() {
		for (int i = 0; i < epitesiVonalak.length; ++i) {
			for( int j = 0; j < epitesiVonalak.length; ++j) {
				epitesiVonalak[i][j] = "000";
			}
			System.out.println();
		}
	
		for(int i = 0; i < fixedNyersanyagMezok.length; ++i) {
			for(int j = 0; j < fixedNyersanyagMezok.length; ++j) {
				nyersanyagMezok[i][j] = fixedNyersanyagMezok[i][j];
			}
		}
	}
	
	@Override
	public void kirajzolas() {
		int tmp, tmp2;
		
		for (int i = 0; i < epitesiVonalak.length; ++i) {
			if( i%2 == 0) {
				for(int j = 0; j < epitesiVonalak.length; ++j) {
					System.out.print(epitesiVonalak[i][j] + " ");
				}
				System.out.println();
			} else {
				for(int j = 0; j < epitesiVonalak.length; ++j) {
					if( j%2 == 0) {
						System.out.print(epitesiVonalak[i][j] + " ");
					} else {
						tmp = ((i-1)/2);
						tmp2 = ((j-1)/2);
						System.out.print(nyersanyagMezok[tmp][tmp2] + " ");
					}
				}
				System.out.println();
			}
		}
		System.out.println();
		
	}
	
	@Override
	public void kezdoLepesekBeallitasaTelepules(String nev, String nevId) {
		String lepes, lepesTipus;
		int lepes1, lepes2;
		lepesTipus = "telepules";
		boolean bemenetOk = true;
		boolean lepesOk;
		boolean isKezdoLepesTelepules = true;
		
		while(bemenetOk) {
			lepes = kezdoLepesek4vsBot.kezdoLepesTelepules(nev);
			lepes1 = Character.getNumericValue(lepes.charAt(0));
			lepes2 = Character.getNumericValue(lepes.charAt(1));
			
			lepesOk = lepes(lepes1, lepes2, lepesTipus, nevId, isKezdoLepesTelepules);
			
			if(lepesOk == true) {
				bemenetOk = false;
			}
			
		}
	}
	
	@Override
	public void kezdoLepesekBeallitasaUt(String nev, String nevId) {
		String lepes, lepesTipus;
		int lepes1, lepes2;
		lepesTipus = "ut";
		boolean bemenetOk = true;
		boolean lepesOk;
		boolean isKezdoLepesTelepules = false;
		
		while(bemenetOk) {
			lepes = kezdoLepesek4vsBot.kezdoLepesUt(nev);
			lepes1 = Character.getNumericValue(lepes.charAt(0));
			lepes2 = Character.getNumericValue(lepes.charAt(1));
			
			lepesOk = lepes(lepes1, lepes2, lepesTipus, nevId, isKezdoLepesTelepules);
			
			if(lepesOk == true) {
				bemenetOk = false;
			}
		}
	}
	
	public void lepesekBeallitasaTelepules(String nev, String nevId) {
		String lepes, lepesTipus;
		int lepes1, lepes2;
		lepesTipus = "telepules";
		boolean bemenetOk = true;
		boolean lepesOk;
		boolean isKezdoLepesTelepules = false;
		
		while(bemenetOk) {
			lepes = kezdoLepesek4vsBot.kezdoLepesUt(nev);
			lepes1 = Character.getNumericValue(lepes.charAt(0));
			lepes2 = Character.getNumericValue(lepes.charAt(1));
			
			lepesOk = lepes(lepes1, lepes2, lepesTipus, nevId, isKezdoLepesTelepules);
			
			if(lepesOk == true) {
				bemenetOk = false;
			}
		}
	}
	
	@Override
	public void lepesekBeallitasaUt(String nev, String nevId) {
		String lepes, lepesTipus;
		int lepes1, lepes2;
		lepesTipus = "ut";
		boolean bemenetOk = true;
		boolean lepesOk;
		boolean isKezdoLepesTelepules = false;
		
		while(bemenetOk) {
			lepes = kezdoLepesek4vsBot.kezdoLepesUt(nev);
			lepes1 = Character.getNumericValue(lepes.charAt(0));
			lepes2 = Character.getNumericValue(lepes.charAt(1));
			
			lepesOk = lepes(lepes1, lepes2, lepesTipus, nevId, isKezdoLepesTelepules);
			
			if(lepesOk == true) {
				bemenetOk = false;
			}
		}
	}
	
	@Override
	public boolean lepesekBeallitasaVaros(String nev, String nevId) {
		String talatNevId, talatTeruletTipus;
		int oszlop, sor, segedOszlop, segedSor;

		System.out.println(nev + ":\nEloszor kerem a telepules oszlopat(1-5):");
		oszlop = (random.nextInt(5)+1);
		
		System.out.println(nev + ", most pedig a telepules sorat(1-5):");
		sor = (random.nextInt(5)+1);
		
		segedOszlop = ((oszlop*2)-2);
		segedSor = ((sor*2)-2);
		
		talatNevId = nevIdKinyeroEpitesiTeruletbol(segedOszlop, segedSor);
		talatTeruletTipus = teruletTipusKinyero(segedOszlop, segedSor);
		
		if ( (talatNevId.equals(nevId)) && (talatTeruletTipus.equals("T") ) ) {
			System.out.println("Telepules varossa fejlesztve!\n");
			epitesiVonalak[segedSor][segedOszlop] = (nevId + "V");
			return true;
		} else {
			System.out.println("Ezen a teruleten vagy nincs varos, " +
					"vagy ha van, nem a Tied!\n");
		}
		
		return false;
	}
	
	@Override
	public boolean lepes(int oszlop, int sor, String tipus, String nevId, boolean isKezdoLepesTelepules) {
		boolean isSzomszedosMasikSajatEpitmennyel;
		
		/**
		 * telepules eseten:
		 */
		
		if(tipus.equals("telepules")) {
			int segedOszlop = ((oszlop*2)-2);
			int segedSor = ((sor*2)-2);
			
			boolean isSzomszedosMasikTelepulessel = isSzomszedosEMasikTelepulessel(segedOszlop, segedSor);
			if( isSzomszedosMasikTelepulessel == true) {
				System.out.println("A telepules szomszedos volna masik " +
						"telepules/varossal! Valassz masikat!");
				return false;
			}
			
			if( epitesiVonalak[segedSor][segedOszlop].equals("000")) {
				isSzomszedosMasikSajatEpitmennyel = isSzomszedosMasikSajatEpitmennyel(segedOszlop, segedSor, tipus, isKezdoLepesTelepules, nevId);
				if( isSzomszedosMasikSajatEpitmennyel == false) {
					System.out.println("A telepules nem szomszedos masik " + 
							"sajat epitmennyel (ut/telepules/varos)! Valassz masikat!");
					return false;
				}
				
				epitesiVonalak[segedSor][segedOszlop] = (nevId + "T");
				kirajzolas();
				return true;
			} else {
				System.out.println("A mezocsucs mar foglalt! Valassz masikat!");
				return false;
			}
		}

		
		
		/**
		 * Ut eseten:
		 */
		
		else if(tipus.equals("ut")) {
			int segedOszlop = (oszlop - 1);
			int segedSor = (sor - 1);
			
			if ( oszlop%2 == 1) {
				if ( sor%2 == 0) {
					if( epitesiVonalak[segedSor][segedOszlop].equals("000")) {
						
						isSzomszedosMasikSajatEpitmennyel = isSzomszedosMasikSajatEpitmennyel(segedOszlop, segedSor, tipus, isKezdoLepesTelepules, nevId);
						if( isSzomszedosMasikSajatEpitmennyel == false) {
							System.out.println("A telepules nem szomszedos masik " + 
									"sajat epitmennyel (ut/telepules/varos)! Valassz masikat!");
							return false;
						}
						
						epitesiVonalak[segedSor][segedOszlop] = (nevId + "U");
						kirajzolas();
						return true;
					} else {
						System.out.println("Az ut(el) mar foglalt! Valassz masikat!");
						return false;
					}
				} else {
					System.out.println("Ez mezocsucs! Ide nem epithetsz utat! Valassz masikat!");
					return false;
				}
			} else {
				if( sor%2 == 1) {
					if( epitesiVonalak[segedSor][segedOszlop].equals("000")) {
						
						isSzomszedosMasikSajatEpitmennyel = isSzomszedosMasikSajatEpitmennyel(segedOszlop, segedSor, tipus, isKezdoLepesTelepules, nevId);
						if( isSzomszedosMasikSajatEpitmennyel == false) {
							System.out.println("A telepules nem szomszedos masik " + 
									"sajat epitmennyel (ut/telepules/varos)! Valassz masikat!");
							return false;
						}
						
						epitesiVonalak[segedSor][segedOszlop] = (nevId + "U");
						kirajzolas();
						return true;
					} else {
						System.out.println("Az ut(el) mar foglalt! Valassz masikat!");
						return false;
					}
				} else {
					System.out.println("Ez mezocsucs! Ide nem epithetsz utat! Valassz masikat!");
					return false;
				}
			}
		}
		
		
		/**
		 * valahol nem vart hiba keletkezett,
		 * normal es nem normalis esetben se kell erre fusson
		 */
		System.out.println("unexcepted problema");
		return false;
	}
	
	@Override
	public boolean isSzomszedosEMasikTelepulessel(int oszlop, int sor) {
		/**
		 * Eloszor a 4 sarok vizsgalasa
		 */
		if ( (oszlop == 0) && (sor == 0) ) {
			if ( teruletTipusKinyero((oszlop+2),sor).equals("T")
					|| teruletTipusKinyero((oszlop+2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor+2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
		} else if( (oszlop == 0) && (sor == 8) ) {
			if ( teruletTipusKinyero((oszlop+2),sor).equals("T")
					|| teruletTipusKinyero((oszlop+2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor-2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor-2)).equals("V")) {
				return true;
			}
		} else if( (oszlop == 8) && (sor == 0) ) {
			if ( teruletTipusKinyero((oszlop-2),sor).equals("T")
					|| teruletTipusKinyero((oszlop-2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor+2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
		} else if( (oszlop == 8) && (sor == 8) ) {
			if ( teruletTipusKinyero((oszlop-2),sor).equals("T")
					|| teruletTipusKinyero((oszlop-2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor-2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor-2)).equals("V")) {
				return true;
			}
		}
		
		
		
		/**
		 * Most a szelso sorok/oszlopok vizsgalasa
		 */

		if ( (oszlop > 1) && (oszlop < 7) && (sor == 0) ) {
			if ( teruletTipusKinyero((oszlop-2),sor).equals("T")
					|| teruletTipusKinyero((oszlop-2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero((oszlop+2),sor).equals("T")
					|| teruletTipusKinyero((oszlop+2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor+2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
		} else if ( (oszlop > 1) && (oszlop < 7) && (sor == 8) ) {
			if ( teruletTipusKinyero((oszlop-2),sor).equals("T")
					|| teruletTipusKinyero((oszlop-2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero((oszlop+2),sor).equals("T")
					|| teruletTipusKinyero((oszlop+2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor-2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor-2)).equals("V")) {
				return true;
			}
		} else if ( (sor > 1) && (sor < 7) && (oszlop == 0) ) {
			if ( teruletTipusKinyero(oszlop,(sor+2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor-2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero((oszlop+2),sor).equals("T")
					|| teruletTipusKinyero((oszlop+2),sor).equals("V")) {
				return true;
			}
		} else if ( (sor > 1) && (sor < 7) && (oszlop == 8) ) {
			if ( teruletTipusKinyero(oszlop,(sor+2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor-2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero((oszlop-2),sor).equals("T")
					|| teruletTipusKinyero((oszlop-2),sor).equals("V")) {
				return true;
			}
		}
		
		/**
		 * belso elemek vizsgalata
		 */
		
		if( (oszlop > 1) && (oszlop < 8) && (sor > 1) && (sor < 8) ) {
			if ( teruletTipusKinyero(oszlop,(sor+2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero(oszlop,(sor-2)).equals("T")
					|| teruletTipusKinyero(oszlop,(sor+2)).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero((oszlop+2),sor).equals("T")
					|| teruletTipusKinyero((oszlop+2),sor).equals("V")) {
				return true;
			}
			if ( teruletTipusKinyero((oszlop-2),sor).equals("T")
					|| teruletTipusKinyero((oszlop-2),sor).equals("V")) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String nevIdKinyeroEpitesiTeruletbol(int oszlop, int sor) {
		return ( String.valueOf(epitesiVonalak[sor][oszlop].charAt(0)) +
				String.valueOf(epitesiVonalak[sor][oszlop].charAt(1)) );
	}
	
	@Override
	public String teruletTipusKinyero(int oszlop, int sor) {
		return String.valueOf(epitesiVonalak[sor][oszlop].charAt(2));
	}
	
	@Override
	public boolean isSzomszedosMasikSajatEpitmennyel(int oszlop, int sor, String tipus, boolean isKezdoLepesTelepules, String nevId) {
		if(tipus.equals("telepules")) {
			if( isKezdoLepesTelepules == true) {
				return true;
			}
			
			/**
			 * Eloszor a 4 sarok vizsgalasa
			 */
			//bal-felso
			if( (oszlop == 0) && (sor == 0) ) {
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop+1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+1)).equals(nevId) ) {
					return true;
				}
			}
			
			//bal-also
			if( (oszlop == 0) && (sor == 8 ) ) {
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop+1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-1)).equals(nevId) ) {
					return true;
				}
			}
			
			//jobb-felso
			if( (oszlop == 8) && (sor == 0) ) {
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop-1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+1)).equals(nevId) ) {
					return true;
				}
			}
				
			//jobb-also
			if( (oszlop == 8) && (sor == 8 ) ) {
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop-1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-1)).equals(nevId) ) {
					return true;
				}
			}
		
			/**
			 * most a 4 oldal vizsgalasa
			 */
			//felso
			if( (oszlop > 0) && (oszlop < 8) && (sor == 0) ) {
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop-1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop+1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+1)).equals(nevId) ) {
					return true;
				}
			}
			
			//also
			if( (oszlop > 0) && (oszlop < 8) && (sor == 8) ) {
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop-1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop+1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-1)).equals(nevId) ) {
					return true;
				}
			}
			
			//bal
			if( (oszlop == 0) && (sor > 0) && (sor < 8) ) {
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+1)).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-1)).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop+1), sor).equals(nevId) ) {
					return true;
				}
			}
			
			//jobb
			if( (oszlop == 8) && (sor > 0) && (sor < 8) ) {
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+1)).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-1)).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop-1), sor).equals(nevId) ) {
					return true;
				}
			}
			
			/**
			 * s vegul a belso elemek vizsgalata
			 */
			if( (oszlop < 8) && (oszlop > 0) && (sor < 8) && ( sor > 0) ) {
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+1)).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-1)).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop-1), sor).equals(nevId) ) {
					return true;
				}
				if ( nevIdKinyeroEpitesiTeruletbol((oszlop+1), sor).equals(nevId) ) {
					return true;
				}
			}
			return false;
		} else if(tipus.equals("ut")) {
			
			/**
			 * szomszedos-e varossal
			 */
			if( oszlop%2 == 0 ) {
				if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-1)).equals(nevId) ) {
					return true;
				}
			} else {
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), sor).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), sor).equals(nevId) ) {
					return true;
				}
			}
			
			
			
			/**
			 * szomszedos-e utakkal
			 */
			
			/**
			 * eloszor is a "sarkok"
			 */
			//bal-felul
			if ( (oszlop == 1) && (sor == 0) ) {
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+2), sor).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor+1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor+1)).equals(nevId) ) {
					return true;
				}
			}
			//bal-alul
			if ( (oszlop == 0) && (sor == 7) ) {
				if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-2)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor+1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor-1)).equals(nevId) ) {
					return true;
				}
			}
			//jobb-felul
			if ( (oszlop == 7) && (sor == 0) ) {
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-2), sor).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor+1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor+1)).equals(nevId) ) {
					return true;
				}
			}	
			//jobb-alul
			if ( (oszlop == 8) && (sor == 7) ) {
				if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-2)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor+1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor+1)).equals(nevId) ) {
					return true;
				}
			}	
			
			
			
			/**
			 * szelek:
			 */
			//felso
			if ( (oszlop > 1) && (oszlop < 7) && (sor == 0) ) {
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-2), sor).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+2), sor).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor+1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor+1)).equals(nevId) ) {
					return true;
				}
			}
			//also
			if ( (oszlop > 1) && (oszlop < 7) && (sor == 8) ) {
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-2), sor).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+2), sor).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor-1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor-1)).equals(nevId) ) {
					return true;
				}
			}
			//balszel
			if ( (oszlop == 0) && (sor > 1) && (sor < 7) ) {
				if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+2)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-2)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor+1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor-1)).equals(nevId) ) {
					return true;
				}
			}
			//jobbszel
			if ( (oszlop == 8) && (sor > 1) && (sor < 7) ) {
				if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+2)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-2)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor+1)).equals(nevId) ) {
					return true;
				}
				if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor-1)).equals(nevId) ) {
					return true;
				}
			}
			
			
			/**
			 * kozepe:
			 */
			
			if ( (oszlop > 0) && (oszlop < 8) && (sor > 0) && (sor < 8) ) {
				if( oszlop%2 == 0 ) {
					if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor+2)).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol(oszlop, (sor-2)).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor+1)).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor-1)).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor+1)).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor-1)).equals(nevId) ) {
						return true;
					}
				} else {
					if( nevIdKinyeroEpitesiTeruletbol((oszlop-2), sor).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop+2), sor).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor+1)).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop-1), (sor-1)).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor+1)).equals(nevId) ) {
						return true;
					}
					if( nevIdKinyeroEpitesiTeruletbol((oszlop+1), (sor-1)).equals(nevId) ) {
						return true;
					}
				}
			}

			return false;
		}
		return false;
	}
	
	@Override
	public String dobas() {
		//kockadobas dobott ertekenek kimentese
		int dobasErteke = doboKocka.dob();
		
		if ( dobasErteke == 7 ) {
			return "7";
		}
		
		String nyersanyagotKap = "";
				
		//jatekosok keresese akik majd pontot kapnak
		for(int i = 0; i < fixedNyersanyagMezok.length; ++i) {
			for(int j = 0; j < fixedNyersanyagMezok.length; ++j) {
				if ( dobasErteke == mezoSzamKinyero(i, j)) {
					nyersanyagotKap += pontSzamKereso(j, i);
				}
			}
		}
		
		//lezaras, hogy majd ezt keressuk
		nyersanyagotKap += "X";
		
		return nyersanyagotKap;
	}
	
	@Override
	public int mezoSzamKinyero(int oszlop, int sor) {
		return Integer.parseInt( String.valueOf(fixedNyersanyagMezok[sor][oszlop].charAt(1)) +
				String.valueOf(fixedNyersanyagMezok[sor][oszlop].charAt(2)) );
	}
	
	@Override
	public String mezoTipusKinyero(int oszlop, int sor) {
		return String.valueOf(fixedNyersanyagMezok[sor][oszlop].charAt(0));
	}
	
	public String pontSzamKereso(int oszlop, int sor) {
		//minden mezo korul 4 telepules/varos lehet, ezt a kovetkezo
		//matematikai atalakitasokkal ki is nyerjuk
		int segedOszlop, segedSor;
		String segedString;
		String segedStringNyersanyagTipus = mezoTipusKinyero(oszlop, sor);
		String eredmeny = "";
		
		//bal-felul
		segedOszlop = (oszlop * 2);
		segedSor = (sor * 2);
		segedString = teruletTipusKinyero(segedOszlop, segedSor);
		if ( segedString.equals("T") || segedString.equals("V") ) {
			eredmeny += nevIdKinyeroEpitesiTeruletbol(segedOszlop, segedSor);
			eredmeny += segedString;
			eredmeny += segedStringNyersanyagTipus;
		}
		
		//bal-alul
		segedOszlop = (oszlop * 2);
		segedSor = (sor * 2 + 2);
		segedString = teruletTipusKinyero(segedOszlop, segedSor);
		if ( segedString.equals("T") || segedString.equals("V") ) {
			eredmeny += nevIdKinyeroEpitesiTeruletbol(segedOszlop, segedSor);
			eredmeny += segedString;
			eredmeny += segedStringNyersanyagTipus;
		}
		
		//jobb-felul
		segedOszlop = (oszlop * 2 + 2);
		segedSor = (sor * 2);
		segedString = teruletTipusKinyero(segedOszlop, segedSor);
		if ( segedString.equals("T") || segedString.equals("V") ) {
			eredmeny += nevIdKinyeroEpitesiTeruletbol(segedOszlop, segedSor);
			eredmeny += segedString;
			eredmeny += segedStringNyersanyagTipus;
		}
		
		//jobb-alul
		segedOszlop = (oszlop * 2 + 2);
		segedSor = (sor * 2 + 2);
		segedString = teruletTipusKinyero(segedOszlop, segedSor);
		if ( segedString.equals("T") || segedString.equals("V") ) {
			eredmeny += nevIdKinyeroEpitesiTeruletbol(segedOszlop, segedSor);
			eredmeny += segedString;
			eredmeny += segedStringNyersanyagTipus;
		}
		
		return eredmeny;
	}
	
	@Override
	public void jatekStart() {
		kezdetiParams.setupInPalyaBotVsBot();
		aKomplettPalyaLeGeneralasa();
		kirajzolas();
		kezdoLepesek4vsBot.szabalyzat();
	}
	
	@Override
	public void jatekMenet() {
		jatekStart();
		
		

		/**
		 * botok letrehozasa es jatek inditasa
		 */
		
		BotJatekos botJatekos1 = new BotJatekos("BOT1", "B1");
		BotJatekos botJatekos2 = new BotJatekos("BOT2", "B2");

	
		/**
		 * kezdolepesek meglepese
		 */
		kezdoLepesekBeallitasaTelepules(botJatekos1.getNev(), botJatekos1.getId());
		kezdoLepesekBeallitasaUt(botJatekos1.getNev(), botJatekos1.getId());
		kezdoLepesekBeallitasaTelepules(botJatekos2.getNev(), botJatekos2.getId());
		kezdoLepesekBeallitasaUt(botJatekos2.getNev(), botJatekos2.getId());
		
		kezdoLepesek4vsBot.szabalyLepesVisszaIranyban();
		
		kezdoLepesekBeallitasaTelepules(botJatekos2.getNev(), botJatekos2.getId());
		kezdoLepesekBeallitasaUt(botJatekos2.getNev(), botJatekos2.getId());
		kezdoLepesekBeallitasaTelepules(botJatekos1.getNev(), botJatekos1.getId());
		kezdoLepesekBeallitasaUt(botJatekos1.getNev(), botJatekos1.getId());
		
		kezdoLepesek4vsBot.kezdoLepesekEND();
		

			
		/**
		 * maga a jatek!
		 * a jatekot vezenylo bool valtozok:
		 */
		
		//ha ez atmegy " false "-ba, vege a jateknak
		boolean notEND = true;
		
		//egy teljes korert felel: 1 dobas es a jatekosok korei
		boolean turnNotEND = true;
		
		//adott jatekos koreert felel, " false " ertek utan, a kovetkezo jatekos kovetkezik
		boolean jatekosTurnNotEND = true;
		
		
		while(notEND) {
			//reset
			turnNotEND = true;
			jatekosTurnNotEND = true;
			
			/**
			 * Eloszor is a kor eleji dobas:
			 */

			String nyersanyagotKapTeljes = dobas();
			String nyersanyagotKap ="";
			
			if( nyersanyagotKapTeljes.equals("7")) {
				System.out.println("7! Senki se kap semmit!");
			} else if( nyersanyagotKapTeljes.equals("X")) {
				System.out.println("Nem volt senkinek se telepules vagy " +
						"varos az adott mezon! Senki sem kap nyersanyagot!");
			} else {
				for(int i = 0; i < (nyersanyagotKapTeljes.length()-1); ++i) {
					
					if( i%4 == 3) {
						nyersanyagotKap += ( (String.valueOf(nyersanyagotKapTeljes.charAt(i-3))) +
								(String.valueOf(nyersanyagotKapTeljes.charAt(i-2))) );
						int nyersanyagSzamMerteke;
						String nyersanyagTipus;
						String nyersanyagTipusKiirashoz;
						
						/**
						 * botJatekos1 a szerencses
						 */
						if( nyersanyagotKap.equals(botJatekos1.getId()) ) {
							if ( String.valueOf(nyersanyagotKapTeljes.charAt(i-1)).equals("T") ) {
								nyersanyagSzamMerteke = 1;
							} else {
								nyersanyagSzamMerteke = 2;
							}
							
							nyersanyagTipus = String.valueOf(nyersanyagotKapTeljes.charAt(i));
							
							if ( nyersanyagTipus.equals("D") ) {
								botJatekos1.setAgyag(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "agyag";
							} else if ( nyersanyagTipus.equals("M") ) {
								botJatekos1.setBuza(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "buza";
							} else if ( nyersanyagTipus.equals("H") ) {
								botJatekos1.setErc(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "erc";
							} else if ( nyersanyagTipus.equals("R") ) {
								botJatekos1.setBarany(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "barany";
							} else {
								botJatekos1.setFa(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "fa";
							}
							
							System.out.println(botJatekos1.getNev() + ": " +
									nyersanyagSzamMerteke + " db " +
									nyersanyagTipusKiirashoz + " nyersanyagot kap!");
						}
						
						/**
						 * botJatekos2 a szerencses
						 */
						
						else if( nyersanyagotKap.equals(botJatekos2.getId()) ) {
							if ( String.valueOf(nyersanyagotKapTeljes.charAt(i-1)).equals("T") ) {
								nyersanyagSzamMerteke = 1;
							} else {
								nyersanyagSzamMerteke = 2;
							}
							
							nyersanyagTipus = String.valueOf(nyersanyagotKapTeljes.charAt(i));
							
							if ( nyersanyagTipus.equals("D") ) {
								botJatekos2.setAgyag(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "agyag";
							} else if ( nyersanyagTipus.equals("M") ) {
								botJatekos2.setBuza(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "buza";
							} else if ( nyersanyagTipus.equals("H") ) {
								botJatekos2.setErc(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "erc";
							} else if ( nyersanyagTipus.equals("R") ) {
								botJatekos2.setBarany(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "barany";
							} else {
								botJatekos2.setFa(nyersanyagSzamMerteke);
								nyersanyagTipusKiirashoz = "fa";
							}
							
							System.out.println(botJatekos2.getNev() + ": " +
									nyersanyagSzamMerteke + " db " +
									nyersanyagTipusKiirashoz + " nyersanyagot kap!");
						}
						
						/**
						 * reset
						 */
						nyersanyagotKap = "";
					}
					
				}
			}
			
			
			
			/**
			 * most jonnek a lepesek jatekosonkent:
			 */

			while(turnNotEND) {
				int bemenet;
				
				/**
				 * elso bot jatekos:
				 */

				System.out.println("\n" + botJatekos1.getNev() + " kore kovetkezik!\n");
				while(jatekosTurnNotEND) {
					System.out.println("A korben az alabbi dolgokat lehet csinalni: " +
							"(az opcio kivalasztasahoz az elotte allo szamot kell beutni!)\n" +
							"0: terkep mutatasa\n" +
							"1: ut epitese\n" +
							"2: telepules epitese\n" +
							"3: telepules varossa fejlesztese\n" +
							"4: csere a bankkal (4:1 aranyban)\n" +
							"5: nyersanyagkeszlet kilistazasa\n" +
							"6: epitesekhez szukseges nyersanyagmennyisegek kilistazasa\n" +
							"7: kor tovabbadasa");
					
					/**
					 * Opcio valasztasa
					 */
					bemenet = (random.nextInt(8));
					if ( bemenet == 0 ) {
						kirajzolas();
					}
					
					else if ( bemenet == 1 ) {
						if ( (botJatekos1.getAgyag() < 1 ) || (botJatekos1.getFa() < 1) ) {
							System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
						} else {
							lepesekBeallitasaUt(botJatekos1.getNev(), botJatekos1.getId());
							botJatekos1.setFa(-1);
							botJatekos1.setAgyag(-1);
						}
					}
					
					else if ( bemenet == 2 ) {
						if ( (botJatekos1.getFa() < 1) || (botJatekos1.getAgyag() < 1) ||
								(botJatekos1.getBarany() < 1) || (botJatekos1.getBuza() < 1) ) {
							System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
						} else {
							lepesekBeallitasaTelepules(botJatekos1.getNev(), botJatekos1.getId());
							botJatekos1.setFa(-1);
							botJatekos1.setAgyag(-1);
							botJatekos1.setBarany(-1);
							botJatekos1.setBuza(-1);
							botJatekos1.setPontszam(1);
							
							if( botJatekos1.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
								System.out.println(botJatekos1.getNev() + " a gyoztes!!");

								jatekosTurnNotEND = false;
								turnNotEND = false;
								notEND = false;
							}
						}
					}
					
					else if ( bemenet == 3 ) {
						if ( (botJatekos1.getErc() < 1) || (botJatekos1.getBuza() < 2) ) {
							System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
						} else {
							if (lepesekBeallitasaVaros(botJatekos1.getNev(), botJatekos1.getId()) == true) {
								botJatekos1.setErc(-3);
								botJatekos1.setBuza(-2);
								botJatekos1.setPontszam(1);
								
								if( botJatekos1.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(botJatekos1.getNev() + " a gyoztes!!");
									
									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
					}
					
					else if ( bemenet == 4 ) {
						/**
						 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
						 */
						
						if ( (botJatekos1.getFa() < 4) || (botJatekos1.getAgyag() < 4) ||
								(botJatekos1.getBarany() < 4) || (botJatekos1.getBuza() < 4) ||
								(botJatekos1.getErc() < 4) ) {
							System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
								"Kerem valassza a vissza opciot!");
						}
						
						/**
						 * "mit" opcio valasztasa
						 */
						boolean isCsereltE = false;
						System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
								"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
						bemenet = (random.nextInt(6)+1);
						
						if ( bemenet == 1 ) {
							if ( botJatekos1.getAgyag() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
							} else {
								botJatekos1.setAgyag(-4);
								isCsereltE = true;
							}
						} else if ( bemenet == 2 ) {
							if ( botJatekos1.getBuza() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
							} else {
								botJatekos1.setBuza(-4);
								isCsereltE = true;
							}
						} else if ( bemenet == 3 ) {
							if ( botJatekos1.getErc() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
							} else {
								botJatekos1.setErc(-4);
								isCsereltE = true;
							}
						} else if ( bemenet == 4 ) {
							if ( botJatekos1.getBarany() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
							} else {
								botJatekos1.setBarany(-4);
								isCsereltE = true;
							}
						} else if ( bemenet == 5 ) {
							if ( botJatekos1.getFa() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
							} else {
								botJatekos1.setFa(-4);
								isCsereltE = true;
							}
						} else {
							isCsereltE = false;
						}
						
						
						
						/**
						 * "mire" opcio valasztasa
						 */
						
						if ( isCsereltE == true ) {
							System.out.println("Milyen nyersanyagra szeretned cserelni?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa");
							bemenet = (random.nextInt(5)+1);
							
							if ( bemenet == 1 ) {
								botJatekos1.setAgyag(1);
								System.out.println("Csere megtortent!\n");
							} else if ( bemenet == 2 ) {
								botJatekos1.setBuza(1);
								System.out.println("Csere megtortent!\n");
							} else if ( bemenet == 3 ) {
								botJatekos1.setErc(1);
								System.out.println("Csere megtortent!\n");
							} else if ( bemenet == 4 ) {
								botJatekos1.setBarany(1);
								System.out.println("Csere megtortent!\n");
							} else {
								botJatekos1.setFa(1);
								System.out.println("Csere megtortent!\n");
							}
						}
					}
					
					else if ( bemenet == 5 ) {
						System.out.println("agyag: " + botJatekos1.getAgyag() + "\n" +
								"buza: " + botJatekos1.getBuza() + "\n" +
								"erc: " + botJatekos1.getErc() + "\n" +
								"barany: " + botJatekos1.getBarany() + "\n" +
								"fa: " + botJatekos1.getFa() + "\n" +
								"pontszam: " + botJatekos1.getPontszam() );
					}
					
					else if ( bemenet == 6 ) {
						System.out.println("ut: 1 fa, 1 agyag\n" +
								"telepules: 1 fa, 1 agyag, 1 barany, 1 buza\n" +
								"varos: 3 erc, 2 buza\n");
					}
					
					else {
						jatekosTurnNotEND = false;
					}
				}
				
				/**
				 * valtozok resetelese:
				 */
				
				bemenet = 0;
				jatekosTurnNotEND = true;
				

				
				/**
				 * masodik bot jatekos kore
				 */
				
				System.out.println("\n" + botJatekos2.getNev() + " kore kovetkezik!\n");
				while(jatekosTurnNotEND) {
					System.out.println("A korben az alabbi dolgokat lehet csinalni: " +
							"(az opcio kivalasztasahoz az elotte allo szamot kell beutni!)\n" +
							"0: terkep mutatasa\n" +
							"1: ut epitese\n" +
							"2: telepules epitese\n" +
							"3: telepules varossa fejlesztese\n" +
							"4: csere a bankkal (4:1 aranyban)\n" +
							"5: nyersanyagkeszlet kilistazasa\n" +
							"6: epitesekhez szukseges nyersanyagmennyisegek kilistazasa\n" +
							"7: kor tovabbadasa");
					
					/**
					 * Opcio valasztasa
					 */
					bemenet = (random.nextInt(8));
					
					if ( bemenet == 0 ) {
						kirajzolas();
					}
					
					else if ( bemenet == 1 ) {
						if ( (botJatekos2.getAgyag() < 1 ) || (botJatekos2.getFa() < 1) ) {
							System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
						} else {
							lepesekBeallitasaUt(botJatekos2.getNev(), botJatekos2.getId());
							botJatekos2.setFa(-1);
							botJatekos2.setAgyag(-1);
						}
					}
					
					else if ( bemenet == 2 ) {
						if ( (botJatekos2.getFa() < 1) || (botJatekos2.getAgyag() < 1) ||
								(botJatekos2.getBarany() < 1) || (botJatekos2.getBuza() < 1) ) {
							System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
						} else {
							lepesekBeallitasaTelepules(botJatekos2.getNev(), botJatekos2.getId());
							botJatekos2.setFa(-1);
							botJatekos2.setAgyag(-1);
							botJatekos2.setBarany(-1);
							botJatekos2.setBuza(-1);
							botJatekos2.setPontszam(1);
							
							if( botJatekos2.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
								System.out.println(botJatekos2.getNev() + " a gyoztes!!");

								jatekosTurnNotEND = false;
								turnNotEND = false;
								notEND = false;
							}
						}
					}
					
					else if ( bemenet == 3 ) {
						if ( (botJatekos2.getErc() < 1) || (botJatekos2.getBuza() < 2) ) {
							System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
						} else {
							if (lepesekBeallitasaVaros(botJatekos2.getNev(), botJatekos2.getId()) == true) {
								botJatekos2.setErc(-3);
								botJatekos2.setBuza(-2);
								botJatekos2.setPontszam(1);
								
								if( botJatekos2.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(botJatekos2.getNev() + " a gyoztes!!");
									
									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
					}
					
					else if ( bemenet == 4 ) {
						/**
						 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
						 */
						
						if ( (botJatekos2.getFa() < 4) || (botJatekos2.getAgyag() < 4) ||
								(botJatekos2.getBarany() < 4) || (botJatekos2.getBuza() < 4) ||
								(botJatekos2.getErc() < 4) ) {
							System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
								"Kerem valassza a vissza opciot!");
						}
						
						/**
						 * "mit" opcio valasztasa
						 */
						boolean isCsereltE = false;
						System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
								"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
						bemenet = (random.nextInt(6)+1);
						
						
						if ( bemenet == 1 ) {
							if ( botJatekos2.getAgyag() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
							} else {
								botJatekos2.setAgyag(-4);
								isCsereltE = true;
							}
						} else if ( bemenet == 2 ) {
							if ( botJatekos2.getBuza() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
							} else {
								botJatekos2.setBuza(-4);
								isCsereltE = true;
							}
						} else if ( bemenet == 3 ) {
							if ( botJatekos2.getErc() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
							} else {
								botJatekos2.setErc(-4);
								isCsereltE = true;
							}
						} else if ( bemenet == 4 ) {
							if ( botJatekos2.getBarany() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
							} else {
								botJatekos2.setBarany(-4);
								isCsereltE = true;
							}
						} else if ( bemenet == 5 ) {
							if ( botJatekos2.getFa() < 4 ) {
								System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
							} else {
								botJatekos2.setFa(-4);
								isCsereltE = true;
							}
						} else {
							isCsereltE = false;
						}
						
						
						
						/**
						 * "mire" opcio valasztasa
						 */
						
						if ( isCsereltE == true ) {
							System.out.println("Milyen nyersanyagra szeretned cserelni?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa");
							bemenet = (random.nextInt(5)+1);
							
							if ( bemenet == 1 ) {
								botJatekos2.setAgyag(1);
								System.out.println("Csere megtortent!\n");
							} else if ( bemenet == 2 ) {
								botJatekos2.setBuza(1);
								System.out.println("Csere megtortent!\n");
							} else if ( bemenet == 3 ) {
								botJatekos2.setErc(1);
								System.out.println("Csere megtortent!\n");
							} else if ( bemenet == 4 ) {
								botJatekos2.setBarany(1);
								System.out.println("Csere megtortent!\n");
							} else {
								botJatekos2.setFa(1);
								System.out.println("Csere megtortent!\n");
							}
						}
					}
					
					else if ( bemenet == 5 ) {
						System.out.println("agyag: " + botJatekos2.getAgyag() + "\n" +
								"buza: " + botJatekos2.getBuza() + "\n" +
								"erc: " + botJatekos2.getErc() + "\n" +
								"barany: " + botJatekos2.getBarany() + "\n" +
								"fa: " + botJatekos2.getFa() + "\n" +
								"pontszam: " + botJatekos2.getPontszam() );
					}
					
					else if ( bemenet == 6 ) {
						System.out.println("ut: 1 fa, 1 agyag\n" +
								"telepules: 1 fa, 1 agyag, 1 barany, 1 buza\n" +
								"varos: 3 erc, 2 buza\n");
					}
					
					else {
						jatekosTurnNotEND = false;
						turnNotEND = false;
					}
				}
				
				
				/**
				 * valtozok resetelese nem kell, fent a ciklus kezdetenel resete;
				 * csak a "bemenet" stringet
				 */
				bemenet = 0;
			}
		}		
	

	}
}
