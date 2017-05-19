
import java.util.Scanner;

public class FixedPalya implements Palya {

	/**
	 * Objekt valtozok es objektek letrehozasa
	 */
	
	private String epitesiVonalak[][] = new String[9][9];
	private String nyersanyagMezok[][] = new String[4][4];
	private String fixedNyersanyagMezok[][] = { {"H02", "R10", "H06", "M12"}, {"M08", "D03", "R09", "E05"},
			{"M04", "R09", "D10", "H06"}, {"D05", "E08", "E04", "M11"} };
	
	private Scanner be;
	
	KezdetiParams kezdetiParams = new KezdetiParams(1);
	KezdoLepesek kezdoLepesek = new KezdoLepesek();
	Dobokocka doboKocka = new Dobokocka();
	
	

	/**
	 * Default konstruktor
	 */
	
	FixedPalya() {}
	
	

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
			lepes = kezdoLepesek.kezdoLepesTelepules(nev);
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
			lepes = kezdoLepesek.kezdoLepesUt(nev);
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
			lepes = kezdoLepesek.kezdoLepesUt(nev);
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
			lepes = kezdoLepesek.kezdoLepesUt(nev);
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
		be = new Scanner(System.in);
		String bemenet, bemenet2, talatNevId, talatTeruletTipus;
		int oszlop, sor, segedOszlop, segedSor;

		System.out.println(nev + ":\nEloszor kerem a telepules oszlopat(1-5):");
		bemenet = be.nextLine();
		while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
				&& !bemenet.equals("4") && !bemenet.equals("5")) {
			System.out.println("5 oszlop van, ahol telepules talalhato! A mezo csucsai!");
			bemenet = be.nextLine();
		}
		oszlop = Integer.parseInt(bemenet);
		
		System.out.println(nev + ", most pedig a telepules sorat(1-5):");
		bemenet2 = be.nextLine();
		while(!bemenet2.equals("1") && !bemenet2.equals("2") && !bemenet2.equals("3")
				&& !bemenet2.equals("4") && !bemenet2.equals("5")) {
			System.out.println("5 sor van, ahol telepules talalhato! A mezo csucsai!");
			bemenet2 = be.nextLine();
		}
		sor = Integer.parseInt(bemenet2);
		
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
		kezdetiParams.setupInPalya();
		aKomplettPalyaLeGeneralasa();
		kirajzolas();
		kezdoLepesek.szabalyzat();
	}
	
	@Override
	public void jatekMenet() {
		jatekStart();
		
		

		/**
		 * jatekosok letrehozasa es jatek inditasa
		 */
		
		//egy ember jatekos mindig lesz
		EmberJatekos emberJatekos1 = new EmberJatekos();
		emberJatekos1.setId("P1");
	
		//kezdo lepesek meglepese az elso jatekossal, ez is minden esetben meg fog tortenni
		kezdoLepesekBeallitasaTelepules(emberJatekos1.getNev(), emberJatekos1.getId());
		kezdoLepesekBeallitasaUt(emberJatekos1.getNev(), emberJatekos1.getId());
		
		
		
		/**
		 * Jatekosok vs Jatekosok: 3 fo
		 */
		
		if ( kezdetiParams.getLetszam() == 3) {
			/**
			 * jatekosok letrehozasa es kezdo lepesek meglepese veluk
			 */
			
			EmberJatekos emberJatekos2 = new EmberJatekos();
			emberJatekos2.setId("P2");
			kezdoLepesekBeallitasaTelepules(emberJatekos2.getNev(), emberJatekos2.getId());
			kezdoLepesekBeallitasaUt(emberJatekos2.getNev(), emberJatekos2.getId());
			
			EmberJatekos emberJatekos3 = new EmberJatekos();
			emberJatekos3.setId("P3");
			kezdoLepesekBeallitasaTelepules(emberJatekos3.getNev(), emberJatekos3.getId());
			kezdoLepesekBeallitasaUt(emberJatekos3.getNev(), emberJatekos3.getId());
			
			kezdoLepesek.szabalyLepesVisszaIranyban();
			
			kezdoLepesekBeallitasaTelepules(emberJatekos3.getNev(), emberJatekos3.getId());
			kezdoLepesekBeallitasaUt(emberJatekos3.getNev(), emberJatekos3.getId());
			kezdoLepesekBeallitasaTelepules(emberJatekos2.getNev(), emberJatekos2.getId());
			kezdoLepesekBeallitasaUt(emberJatekos2.getNev(), emberJatekos2.getId());
			kezdoLepesekBeallitasaTelepules(emberJatekos1.getNev(), emberJatekos1.getId());
			kezdoLepesekBeallitasaUt(emberJatekos1.getNev(), emberJatekos1.getId());
			
			kezdoLepesek.kezdoLepesekEND();

			
			
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
							 * emberJatekos1 a szerencses
							 */
							if( nyersanyagotKap.equals(emberJatekos1.getId()) ) {
								if ( String.valueOf(nyersanyagotKapTeljes.charAt(i-1)).equals("T") ) {
									nyersanyagSzamMerteke = 1;
								} else {
									nyersanyagSzamMerteke = 2;
								}
								
								nyersanyagTipus = String.valueOf(nyersanyagotKapTeljes.charAt(i));
								
								if ( nyersanyagTipus.equals("D") ) {
									emberJatekos1.setAgyag(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "agyag";
								} else if ( nyersanyagTipus.equals("M") ) {
									emberJatekos1.setBuza(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "buza";
								} else if ( nyersanyagTipus.equals("H") ) {
									emberJatekos1.setErc(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "erc";
								} else if ( nyersanyagTipus.equals("R") ) {
									emberJatekos1.setBarany(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "barany";
								} else {
									emberJatekos1.setFa(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "fa";
								}
								
								System.out.println(emberJatekos1.getNev() + ": " +
										nyersanyagSzamMerteke + " db " +
										nyersanyagTipusKiirashoz + " nyersanyagot kap!");
							}
							
							/**
							 * emberJatekos2 a szerencses
							 */
							
							else if( nyersanyagotKap.equals(emberJatekos2.getId()) ) {
								if ( String.valueOf(nyersanyagotKapTeljes.charAt(i-1)).equals("T") ) {
									nyersanyagSzamMerteke = 1;
								} else {
									nyersanyagSzamMerteke = 2;
								}
								
								nyersanyagTipus = String.valueOf(nyersanyagotKapTeljes.charAt(i));
								
								if ( nyersanyagTipus.equals("D") ) {
									emberJatekos2.setAgyag(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "agyag";
								} else if ( nyersanyagTipus.equals("M") ) {
									emberJatekos2.setBuza(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "buza";
								} else if ( nyersanyagTipus.equals("H") ) {
									emberJatekos2.setErc(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "erc";
								} else if ( nyersanyagTipus.equals("R") ) {
									emberJatekos2.setBarany(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "barany";
								} else {
									emberJatekos2.setFa(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "fa";
								}
								
								System.out.println(emberJatekos2.getNev() + ": " +
										nyersanyagSzamMerteke + " db " +
										nyersanyagTipusKiirashoz + " nyersanyagot kap!");
							}
							
							/**
							 * emberJatekos3 a szerencses
							 */
							
							else if( nyersanyagotKap.equals(emberJatekos3.getId()) ) {
								if ( String.valueOf(nyersanyagotKapTeljes.charAt(i-1)).equals("T") ) {
									nyersanyagSzamMerteke = 1;
								} else {
									nyersanyagSzamMerteke = 2;
								}
								
								nyersanyagTipus = String.valueOf(nyersanyagotKapTeljes.charAt(i));
								
								if ( nyersanyagTipus.equals("D") ) {
									emberJatekos3.setAgyag(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "agyag";
								} else if ( nyersanyagTipus.equals("M") ) {
									emberJatekos3.setBuza(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "buza";
								} else if ( nyersanyagTipus.equals("H") ) {
									emberJatekos3.setErc(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "erc";
								} else if ( nyersanyagTipus.equals("R") ) {
									emberJatekos3.setBarany(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "barany";
								} else {
									emberJatekos3.setFa(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "fa";
								}
								
								System.out.println(emberJatekos3.getNev() + ": " +
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
					be = new Scanner(System.in);
					String bemenet;
					
					/**
					 * elso jatekos:
					 */

					System.out.println("\n" + emberJatekos1.getNev() + " kore kovetkezik!\n");
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
						bemenet = be.nextLine();
						while(!bemenet.equals("0") && !bemenet.equals("1") && !bemenet.equals("2")
								&& !bemenet.equals("3") && !bemenet.equals("4") && !bemenet.equals("5")
								&& !bemenet.equals("6") && !bemenet.equals("7")) {
							System.out.println("Az opciok kivalasztasanak menupontjai 0-7-ig vannak!");
							bemenet = be.nextLine();
						}
						if ( bemenet.equals("0") ) {
							kirajzolas();
						}
						
						else if ( bemenet.equals("1") ) {
							if ( (emberJatekos1.getAgyag() < 1 ) || (emberJatekos1.getFa() < 1) ) {
								System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
							} else {
								lepesekBeallitasaUt(emberJatekos1.getNev(), emberJatekos1.getId());
								emberJatekos1.setFa(-1);
								emberJatekos1.setAgyag(-1);
							}
						}
						
						else if ( bemenet.equals("2") ) {
							if ( (emberJatekos1.getFa() < 1) || (emberJatekos1.getAgyag() < 1) ||
									(emberJatekos1.getBarany() < 1) || (emberJatekos1.getBuza() < 1) ) {
								System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
							} else {
								lepesekBeallitasaTelepules(emberJatekos1.getNev(), emberJatekos1.getId());
								emberJatekos1.setFa(-1);
								emberJatekos1.setAgyag(-1);
								emberJatekos1.setBarany(-1);
								emberJatekos1.setBuza(-1);
								emberJatekos1.setPontszam(1);
								
								if( emberJatekos1.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(emberJatekos1.getNev() + " a gyoztes!!");

									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
						
						else if ( bemenet.equals("3") ) {
							if ( (emberJatekos1.getErc() < 1) || (emberJatekos1.getBuza() < 2) ) {
								System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
							} else {
								if (lepesekBeallitasaVaros(emberJatekos1.getNev(), emberJatekos1.getId()) == true) {
									emberJatekos1.setErc(-3);
									emberJatekos1.setBuza(-2);
									emberJatekos1.setPontszam(1);
									
									if( emberJatekos1.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
										System.out.println(emberJatekos1.getNev() + " a gyoztes!!");
										
										jatekosTurnNotEND = false;
										turnNotEND = false;
										notEND = false;
									}
								}
							}
						}
						
						else if ( bemenet.equals("4") ) {
							/**
							 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
							 */
							
							if ( (emberJatekos1.getFa() < 4) || (emberJatekos1.getAgyag() < 4) ||
									(emberJatekos1.getBarany() < 4) || (emberJatekos1.getBuza() < 4) ||
									(emberJatekos1.getErc() < 4) ) {
								System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
									"Kerem valassza a vissza opciot!");
							}
							
							/**
							 * "mit" opcio valasztasa
							 */
							boolean isCsereltE = false;
							System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
							bemenet = be.nextLine();
							while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
									&& !bemenet.equals("4") && !bemenet.equals("5") && !bemenet.equals("6")) {
								System.out.println("Az opciok kivalasztasanak menupontjai 1-6-ig vannak!");
								bemenet = be.nextLine();
							}
							
							if ( bemenet.equals("1") ) {
								if ( emberJatekos1.getAgyag() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos1.setAgyag(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("2") ) {
								if ( emberJatekos1.getBuza() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
								} else {
									emberJatekos1.setBuza(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("3") ) {
								if ( emberJatekos1.getErc() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos1.setErc(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("4") ) {
								if ( emberJatekos1.getBarany() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos1.setBarany(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("5") ) {
								if ( emberJatekos1.getFa() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos1.setFa(-4);
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
								bemenet = be.nextLine();
								while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
										&& !bemenet.equals("4") && !bemenet.equals("5")) {
									System.out.println("Az opciok kivalasztasanak menupontjai 1-5-ig vannak!");
									bemenet = be.nextLine();
								}
								
								if ( bemenet.equals("1") ) {
									emberJatekos1.setAgyag(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("2") ) {
									emberJatekos1.setBuza(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("3") ) {
									emberJatekos1.setErc(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("4") ) {
									emberJatekos1.setBarany(1);
									System.out.println("Csere megtortent!\n");
								} else {
									emberJatekos1.setFa(1);
									System.out.println("Csere megtortent!\n");
								}
							}
						}
						
						else if ( bemenet.equals("5") ) {
							System.out.println("agyag: " + emberJatekos1.getAgyag() + "\n" +
									"buza: " + emberJatekos1.getBuza() + "\n" +
									"erc: " + emberJatekos1.getErc() + "\n" +
									"barany: " + emberJatekos1.getBarany() + "\n" +
									"fa: " + emberJatekos1.getFa() + "\n" +
									"pontszam: " + emberJatekos1.getPontszam() );
						}
						
						else if ( bemenet.equals("6") ) {
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
					
					bemenet = "";
					jatekosTurnNotEND = true;
					

					
					/**
					 * masodik jatekos kore
					 */
					
					System.out.println("\n" + emberJatekos2.getNev() + " kore kovetkezik!\n");
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
						bemenet = be.nextLine();
						while(!bemenet.equals("0") && !bemenet.equals("1") && !bemenet.equals("2")
								&& !bemenet.equals("3") && !bemenet.equals("4") && !bemenet.equals("5")
								&& !bemenet.equals("6") && !bemenet.equals("7")) {
							System.out.println("Az opciok kivalasztasanak menupontjai 0-7-ig vannak!");
							bemenet = be.nextLine();
						}
						if ( bemenet.equals("0") ) {
							kirajzolas();
						}
						
						else if ( bemenet.equals("1") ) {
							if ( (emberJatekos2.getAgyag() < 1 ) || (emberJatekos2.getFa() < 1) ) {
								System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
							} else {
								lepesekBeallitasaUt(emberJatekos2.getNev(), emberJatekos2.getId());
								emberJatekos2.setFa(-1);
								emberJatekos2.setAgyag(-1);
							}
						}
						
						else if ( bemenet.equals("2") ) {
							if ( (emberJatekos2.getFa() < 1) || (emberJatekos2.getAgyag() < 1) ||
									(emberJatekos2.getBarany() < 1) || (emberJatekos2.getBuza() < 1) ) {
								System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
							} else {
								lepesekBeallitasaTelepules(emberJatekos2.getNev(), emberJatekos2.getId());
								emberJatekos2.setFa(-1);
								emberJatekos2.setAgyag(-1);
								emberJatekos2.setBarany(-1);
								emberJatekos2.setBuza(-1);
								emberJatekos2.setPontszam(1);
								
								if( emberJatekos2.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(emberJatekos2.getNev() + " a gyoztes!!");

									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
						
						else if ( bemenet.equals("3") ) {
							if ( (emberJatekos2.getErc() < 1) || (emberJatekos2.getBuza() < 2) ) {
								System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
							} else {
								if (lepesekBeallitasaVaros(emberJatekos2.getNev(), emberJatekos2.getId()) == true) {
									emberJatekos2.setErc(-3);
									emberJatekos2.setBuza(-2);
									emberJatekos2.setPontszam(1);
									
									if( emberJatekos2.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
										System.out.println(emberJatekos2.getNev() + " a gyoztes!!");
										
										jatekosTurnNotEND = false;
										turnNotEND = false;
										notEND = false;
									}
								}
							}
						}
						
						else if ( bemenet.equals("4") ) {
							/**
							 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
							 */
							
							if ( (emberJatekos2.getFa() < 4) || (emberJatekos2.getAgyag() < 4) ||
									(emberJatekos2.getBarany() < 4) || (emberJatekos2.getBuza() < 4) ||
									(emberJatekos2.getErc() < 4) ) {
								System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
									"Kerem valassza a vissza opciot!");
							}
							
							/**
							 * "mit" opcio valasztasa
							 */
							boolean isCsereltE = false;
							System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
							bemenet = be.nextLine();
							while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
									&& !bemenet.equals("4") && !bemenet.equals("5") && !bemenet.equals("6")) {
								System.out.println("Az opciok kivalasztasanak menupontjai 1-6-ig vannak!");
								bemenet = be.nextLine();
							}
							
							if ( bemenet.equals("1") ) {
								if ( emberJatekos2.getAgyag() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos2.setAgyag(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("2") ) {
								if ( emberJatekos2.getBuza() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
								} else {
									emberJatekos2.setBuza(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("3") ) {
								if ( emberJatekos2.getErc() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos2.setErc(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("4") ) {
								if ( emberJatekos2.getBarany() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos2.setBarany(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("5") ) {
								if ( emberJatekos2.getFa() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos2.setFa(-4);
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
								bemenet = be.nextLine();
								while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
										&& !bemenet.equals("4") && !bemenet.equals("5")) {
									System.out.println("Az opciok kivalasztasanak menupontjai 1-5-ig vannak!");
									bemenet = be.nextLine();
								}
								
								if ( bemenet.equals("1") ) {
									emberJatekos2.setAgyag(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("2") ) {
									emberJatekos2.setBuza(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("3") ) {
									emberJatekos2.setErc(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("4") ) {
									emberJatekos2.setBarany(1);
									System.out.println("Csere megtortent!\n");
								} else {
									emberJatekos2.setFa(1);
									System.out.println("Csere megtortent!\n");
								}
							}
						}
						
						else if ( bemenet.equals("5") ) {
							System.out.println("agyag: " + emberJatekos2.getAgyag() + "\n" +
									"buza: " + emberJatekos2.getBuza() + "\n" +
									"erc: " + emberJatekos2.getErc() + "\n" +
									"barany: " + emberJatekos2.getBarany() + "\n" +
									"fa: " + emberJatekos2.getFa() + "\n" +
									"pontszam: " + emberJatekos2.getPontszam() );
						}
						
						else if ( bemenet.equals("6") ) {
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
					
					bemenet = "";
					jatekosTurnNotEND = true;
					
					
					
					/**
					 * harmadik jatekos kore:
					 */
					
					System.out.println("\n" + emberJatekos3.getNev() + " kore kovetkezik!\n");
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
						bemenet = be.nextLine();
						while(!bemenet.equals("0") && !bemenet.equals("1") && !bemenet.equals("2")
								&& !bemenet.equals("3") && !bemenet.equals("4") && !bemenet.equals("5")
								&& !bemenet.equals("6") && !bemenet.equals("7")) {
							System.out.println("Az opciok kivalasztasanak menupontjai 0-7-ig vannak!");
							bemenet = be.nextLine();
						}
						if ( bemenet.equals("0") ) {
							kirajzolas();
						}
						
						else if ( bemenet.equals("1") ) {
							if ( (emberJatekos3.getAgyag() < 1 ) || (emberJatekos3.getFa() < 1) ) {
								System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
							} else {
								lepesekBeallitasaUt(emberJatekos3.getNev(), emberJatekos3.getId());
								emberJatekos3.setFa(-1);
								emberJatekos3.setAgyag(-1);
							}
						}
						
						else if ( bemenet.equals("2") ) {
							if ( (emberJatekos3.getFa() < 1) || (emberJatekos3.getAgyag() < 1) ||
									(emberJatekos3.getBarany() < 1) || (emberJatekos3.getBuza() < 1) ) {
								System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
							} else {
								lepesekBeallitasaTelepules(emberJatekos3.getNev(), emberJatekos3.getId());
								emberJatekos3.setFa(-1);
								emberJatekos3.setAgyag(-1);
								emberJatekos3.setBarany(-1);
								emberJatekos3.setBuza(-1);
								emberJatekos3.setPontszam(1);
								
								if( emberJatekos3.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(emberJatekos3.getNev() + " a gyoztes!!");

									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
						
						else if ( bemenet.equals("3") ) {
							if ( (emberJatekos3.getErc() < 1) || (emberJatekos3.getBuza() < 2) ) {
								System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
							} else {
								if (lepesekBeallitasaVaros(emberJatekos3.getNev(), emberJatekos3.getId()) == true) {
									emberJatekos3.setErc(-3);
									emberJatekos3.setBuza(-2);
									emberJatekos3.setPontszam(1);
									
									if( emberJatekos3.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
										System.out.println(emberJatekos3.getNev() + " a gyoztes!!");
										
										jatekosTurnNotEND = false;
										turnNotEND = false;
										notEND = false;
									}
								}
							}
						}
						
						else if ( bemenet.equals("4") ) {
							/**
							 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
							 */
							
							if ( (emberJatekos3.getFa() < 4) || (emberJatekos3.getAgyag() < 4) ||
									(emberJatekos3.getBarany() < 4) || (emberJatekos3.getBuza() < 4) ||
									(emberJatekos3.getErc() < 4) ) {
								System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
									"Kerem valassza a vissza opciot!");
							}
							
							/**
							 * "mit" opcio valasztasa
							 */
							boolean isCsereltE = false;
							System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
							bemenet = be.nextLine();
							while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
									&& !bemenet.equals("4") && !bemenet.equals("5") && !bemenet.equals("6")) {
								System.out.println("Az opciok kivalasztasanak menupontjai 1-6-ig vannak!");
								bemenet = be.nextLine();
							}
							
							if ( bemenet.equals("1") ) {
								if ( emberJatekos3.getAgyag() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos3.setAgyag(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("2") ) {
								if ( emberJatekos3.getBuza() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
								} else {
									emberJatekos3.setBuza(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("3") ) {
								if ( emberJatekos3.getErc() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos3.setErc(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("4") ) {
								if ( emberJatekos3.getBarany() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos3.setBarany(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("5") ) {
								if ( emberJatekos3.getFa() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos3.setFa(-4);
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
								bemenet = be.nextLine();
								while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
										&& !bemenet.equals("4") && !bemenet.equals("5")) {
									System.out.println("Az opciok kivalasztasanak menupontjai 1-5-ig vannak!");
									bemenet = be.nextLine();
								}
								
								if ( bemenet.equals("1") ) {
									emberJatekos3.setAgyag(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("2") ) {
									emberJatekos3.setBuza(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("3") ) {
									emberJatekos3.setErc(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("4") ) {
									emberJatekos3.setBarany(1);
									System.out.println("Csere megtortent!\n");
								} else {
									emberJatekos3.setFa(1);
									System.out.println("Csere megtortent!\n");
								}
							}
						}
						
						else if ( bemenet.equals("5") ) {
							System.out.println("agyag: " + emberJatekos3.getAgyag() + "\n" +
									"buza: " + emberJatekos3.getBuza() + "\n" +
									"erc: " + emberJatekos3.getErc() + "\n" +
									"barany: " + emberJatekos3.getBarany() + "\n" +
									"fa: " + emberJatekos3.getFa() + "\n" +
									"pontszam: " + emberJatekos3.getPontszam() );
						}
						
						else if ( bemenet.equals("6") ) {
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
					bemenet = "";
				}
			}		
		}
		
		
		
		/**
		 * Jatekosok vs Jatekosok: 4 fo
		 */
		
		else {
			/**
			 * jatekosok letrehozasa es kezdo lepesek meglepese veluk
			 */
			
			EmberJatekos emberJatekos2 = new EmberJatekos();
			emberJatekos2.setId("P2");
			kezdoLepesekBeallitasaTelepules(emberJatekos2.getNev(), emberJatekos2.getId());
			kezdoLepesekBeallitasaUt(emberJatekos2.getNev(), emberJatekos2.getId());
			
			EmberJatekos emberJatekos3 = new EmberJatekos();
			emberJatekos3.setId("P3");
			kezdoLepesekBeallitasaTelepules(emberJatekos3.getNev(), emberJatekos3.getId());
			kezdoLepesekBeallitasaUt(emberJatekos3.getNev(), emberJatekos3.getId());
			
			EmberJatekos emberJatekos4 = new EmberJatekos();
			emberJatekos4.setId("P4");
			kezdoLepesekBeallitasaTelepules(emberJatekos4.getNev(), emberJatekos4.getId());
			kezdoLepesekBeallitasaUt(emberJatekos4.getNev(), emberJatekos4.getId());
			
			kezdoLepesek.szabalyLepesVisszaIranyban();
			
			kezdoLepesekBeallitasaTelepules(emberJatekos4.getNev(), emberJatekos4.getId());
			kezdoLepesekBeallitasaUt(emberJatekos4.getNev(), emberJatekos4.getId());
			kezdoLepesekBeallitasaTelepules(emberJatekos3.getNev(), emberJatekos3.getId());
			kezdoLepesekBeallitasaUt(emberJatekos3.getNev(), emberJatekos3.getId());
			kezdoLepesekBeallitasaTelepules(emberJatekos2.getNev(), emberJatekos2.getId());
			kezdoLepesekBeallitasaUt(emberJatekos2.getNev(), emberJatekos2.getId());
			kezdoLepesekBeallitasaTelepules(emberJatekos1.getNev(), emberJatekos1.getId());
			kezdoLepesekBeallitasaUt(emberJatekos1.getNev(), emberJatekos1.getId());
			
			kezdoLepesek.kezdoLepesekEND();
			
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
							 * emberJatekos1 a szerencses
							 */
							if( nyersanyagotKap.equals(emberJatekos1.getId()) ) {
								if ( String.valueOf(nyersanyagotKapTeljes.charAt(i-1)).equals("T") ) {
									nyersanyagSzamMerteke = 1;
								} else {
									nyersanyagSzamMerteke = 2;
								}
								
								nyersanyagTipus = String.valueOf(nyersanyagotKapTeljes.charAt(i));
								
								if ( nyersanyagTipus.equals("D") ) {
									emberJatekos1.setAgyag(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "agyag";
								} else if ( nyersanyagTipus.equals("M") ) {
									emberJatekos1.setBuza(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "buza";
								} else if ( nyersanyagTipus.equals("H") ) {
									emberJatekos1.setErc(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "erc";
								} else if ( nyersanyagTipus.equals("R") ) {
									emberJatekos1.setBarany(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "barany";
								} else {
									emberJatekos1.setFa(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "fa";
								}
								
								System.out.println(emberJatekos1.getNev() + ": " +
										nyersanyagSzamMerteke + " db " +
										nyersanyagTipusKiirashoz + " nyersanyagot kap!");
							}
							
							/**
							 * emberJatekos2 a szerencses
							 */
							
							else if( nyersanyagotKap.equals(emberJatekos2.getId()) ) {
								if ( String.valueOf(nyersanyagotKapTeljes.charAt(i-1)).equals("T") ) {
									nyersanyagSzamMerteke = 1;
								} else {
									nyersanyagSzamMerteke = 2;
								}
								
								nyersanyagTipus = String.valueOf(nyersanyagotKapTeljes.charAt(i));
								
								if ( nyersanyagTipus.equals("D") ) {
									emberJatekos2.setAgyag(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "agyag";
								} else if ( nyersanyagTipus.equals("M") ) {
									emberJatekos2.setBuza(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "buza";
								} else if ( nyersanyagTipus.equals("H") ) {
									emberJatekos2.setErc(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "erc";
								} else if ( nyersanyagTipus.equals("R") ) {
									emberJatekos2.setBarany(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "barany";
								} else {
									emberJatekos2.setFa(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "fa";
								}
								
								System.out.println(emberJatekos2.getNev() + ": " +
										nyersanyagSzamMerteke + " db " +
										nyersanyagTipusKiirashoz + " nyersanyagot kap!");
							}
							
							/**
							 * emberJatekos3 a szerencses
							 */
							
							else if( nyersanyagotKap.equals(emberJatekos3.getId()) ) {
								if ( String.valueOf(nyersanyagotKapTeljes.charAt(i-1)).equals("T") ) {
									nyersanyagSzamMerteke = 1;
								} else {
									nyersanyagSzamMerteke = 2;
								}
								
								nyersanyagTipus = String.valueOf(nyersanyagotKapTeljes.charAt(i));
								
								if ( nyersanyagTipus.equals("D") ) {
									emberJatekos3.setAgyag(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "agyag";
								} else if ( nyersanyagTipus.equals("M") ) {
									emberJatekos3.setBuza(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "buza";
								} else if ( nyersanyagTipus.equals("H") ) {
									emberJatekos3.setErc(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "erc";
								} else if ( nyersanyagTipus.equals("R") ) {
									emberJatekos3.setBarany(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "barany";
								} else {
									emberJatekos3.setFa(nyersanyagSzamMerteke);
									nyersanyagTipusKiirashoz = "fa";
								}
								
								System.out.println(emberJatekos3.getNev() + ": " +
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
					be = new Scanner(System.in);
					String bemenet;
					
					/**
					 * elso jatekos:
					 */

					System.out.println("\n" + emberJatekos1.getNev() + " kore kovetkezik!\n");
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
						bemenet = be.nextLine();
						while(!bemenet.equals("0") && !bemenet.equals("1") && !bemenet.equals("2")
								&& !bemenet.equals("3") && !bemenet.equals("4") && !bemenet.equals("5")
								&& !bemenet.equals("6") && !bemenet.equals("7")) {
							System.out.println("Az opciok kivalasztasanak menupontjai 0-7-ig vannak!");
							bemenet = be.nextLine();
						}
						if ( bemenet.equals("0") ) {
							kirajzolas();
						}
						
						else if ( bemenet.equals("1") ) {
							if ( (emberJatekos1.getAgyag() < 1 ) || (emberJatekos1.getFa() < 1) ) {
								System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
							} else {
								lepesekBeallitasaUt(emberJatekos1.getNev(), emberJatekos1.getId());
								emberJatekos1.setFa(-1);
								emberJatekos1.setAgyag(-1);
							}
						}
						
						else if ( bemenet.equals("2") ) {
							if ( (emberJatekos1.getFa() < 1) || (emberJatekos1.getAgyag() < 1) ||
									(emberJatekos1.getBarany() < 1) || (emberJatekos1.getBuza() < 1) ) {
								System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
							} else {
								lepesekBeallitasaTelepules(emberJatekos1.getNev(), emberJatekos1.getId());
								emberJatekos1.setFa(-1);
								emberJatekos1.setAgyag(-1);
								emberJatekos1.setBarany(-1);
								emberJatekos1.setBuza(-1);
								emberJatekos1.setPontszam(1);
								
								if( emberJatekos1.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(emberJatekos1.getNev() + " a gyoztes!!");

									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
						
						else if ( bemenet.equals("3") ) {
							if ( (emberJatekos1.getErc() < 1) || (emberJatekos1.getBuza() < 2) ) {
								System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
							} else {
								if (lepesekBeallitasaVaros(emberJatekos1.getNev(), emberJatekos1.getId()) == true) {
									emberJatekos1.setErc(-3);
									emberJatekos1.setBuza(-2);
									emberJatekos1.setPontszam(1);
									
									if( emberJatekos1.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
										System.out.println(emberJatekos1.getNev() + " a gyoztes!!");
										
										jatekosTurnNotEND = false;
										turnNotEND = false;
										notEND = false;
									}
								}
							}
						}
						
						else if ( bemenet.equals("4") ) {
							/**
							 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
							 */
							
							if ( (emberJatekos1.getFa() < 4) || (emberJatekos1.getAgyag() < 4) ||
									(emberJatekos1.getBarany() < 4) || (emberJatekos1.getBuza() < 4) ||
									(emberJatekos1.getErc() < 4) ) {
								System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
									"Kerem valassza a vissza opciot!");
							}
							
							/**
							 * "mit" opcio valasztasa
							 */
							boolean isCsereltE = false;
							System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
							bemenet = be.nextLine();
							while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
									&& !bemenet.equals("4") && !bemenet.equals("5") && !bemenet.equals("6")) {
								System.out.println("Az opciok kivalasztasanak menupontjai 1-6-ig vannak!");
								bemenet = be.nextLine();
							}
							
							if ( bemenet.equals("1") ) {
								if ( emberJatekos1.getAgyag() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos1.setAgyag(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("2") ) {
								if ( emberJatekos1.getBuza() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
								} else {
									emberJatekos1.setBuza(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("3") ) {
								if ( emberJatekos1.getErc() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos1.setErc(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("4") ) {
								if ( emberJatekos1.getBarany() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos1.setBarany(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("5") ) {
								if ( emberJatekos1.getFa() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos1.setFa(-4);
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
								bemenet = be.nextLine();
								while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
										&& !bemenet.equals("4") && !bemenet.equals("5")) {
									System.out.println("Az opciok kivalasztasanak menupontjai 1-5-ig vannak!");
									bemenet = be.nextLine();
								}
								
								if ( bemenet.equals("1") ) {
									emberJatekos1.setAgyag(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("2") ) {
									emberJatekos1.setBuza(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("3") ) {
									emberJatekos1.setErc(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("4") ) {
									emberJatekos1.setBarany(1);
									System.out.println("Csere megtortent!\n");
								} else {
									emberJatekos1.setFa(1);
									System.out.println("Csere megtortent!\n");
								}
							}
						}
						
						else if ( bemenet.equals("5") ) {
							System.out.println("agyag: " + emberJatekos1.getAgyag() + "\n" +
									"buza: " + emberJatekos1.getBuza() + "\n" +
									"erc: " + emberJatekos1.getErc() + "\n" +
									"barany: " + emberJatekos1.getBarany() + "\n" +
									"fa: " + emberJatekos1.getFa() + "\n" +
									"pontszam: " + emberJatekos1.getPontszam() );
						}
						
						else if ( bemenet.equals("6") ) {
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
					
					bemenet = "";
					jatekosTurnNotEND = true;
					

					
					/**
					 * masodik jatekos kore
					 */
					
					System.out.println("\n" + emberJatekos2.getNev() + " kore kovetkezik!\n");
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
						bemenet = be.nextLine();
						while(!bemenet.equals("0") && !bemenet.equals("1") && !bemenet.equals("2")
								&& !bemenet.equals("3") && !bemenet.equals("4") && !bemenet.equals("5")
								&& !bemenet.equals("6") && !bemenet.equals("7")) {
							System.out.println("Az opciok kivalasztasanak menupontjai 0-7-ig vannak!");
							bemenet = be.nextLine();
						}
						if ( bemenet.equals("0") ) {
							kirajzolas();
						}
						
						else if ( bemenet.equals("1") ) {
							if ( (emberJatekos2.getAgyag() < 1 ) || (emberJatekos2.getFa() < 1) ) {
								System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
							} else {
								lepesekBeallitasaUt(emberJatekos2.getNev(), emberJatekos2.getId());
								emberJatekos2.setFa(-1);
								emberJatekos2.setAgyag(-1);
							}
						}
						
						else if ( bemenet.equals("2") ) {
							if ( (emberJatekos2.getFa() < 1) || (emberJatekos2.getAgyag() < 1) ||
									(emberJatekos2.getBarany() < 1) || (emberJatekos2.getBuza() < 1) ) {
								System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
							} else {
								lepesekBeallitasaTelepules(emberJatekos2.getNev(), emberJatekos2.getId());
								emberJatekos2.setFa(-1);
								emberJatekos2.setAgyag(-1);
								emberJatekos2.setBarany(-1);
								emberJatekos2.setBuza(-1);
								emberJatekos2.setPontszam(1);
								
								if( emberJatekos2.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(emberJatekos2.getNev() + " a gyoztes!!");

									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
						
						else if ( bemenet.equals("3") ) {
							if ( (emberJatekos2.getErc() < 1) || (emberJatekos2.getBuza() < 2) ) {
								System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
							} else {
								if (lepesekBeallitasaVaros(emberJatekos2.getNev(), emberJatekos2.getId()) == true) {
									emberJatekos2.setErc(-3);
									emberJatekos2.setBuza(-2);
									emberJatekos2.setPontszam(1);
									
									if( emberJatekos2.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
										System.out.println(emberJatekos2.getNev() + " a gyoztes!!");
										
										jatekosTurnNotEND = false;
										turnNotEND = false;
										notEND = false;
									}
								}
							}
						}
						
						else if ( bemenet.equals("4") ) {
							/**
							 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
							 */
							
							if ( (emberJatekos2.getFa() < 4) || (emberJatekos2.getAgyag() < 4) ||
									(emberJatekos2.getBarany() < 4) || (emberJatekos2.getBuza() < 4) ||
									(emberJatekos2.getErc() < 4) ) {
								System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
									"Kerem valassza a vissza opciot!");
							}
							
							/**
							 * "mit" opcio valasztasa
							 */
							boolean isCsereltE = false;
							System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
							bemenet = be.nextLine();
							while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
									&& !bemenet.equals("4") && !bemenet.equals("5") && !bemenet.equals("6")) {
								System.out.println("Az opciok kivalasztasanak menupontjai 1-6-ig vannak!");
								bemenet = be.nextLine();
							}
							
							if ( bemenet.equals("1") ) {
								if ( emberJatekos2.getAgyag() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos2.setAgyag(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("2") ) {
								if ( emberJatekos2.getBuza() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
								} else {
									emberJatekos2.setBuza(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("3") ) {
								if ( emberJatekos2.getErc() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos2.setErc(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("4") ) {
								if ( emberJatekos2.getBarany() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos2.setBarany(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("5") ) {
								if ( emberJatekos2.getFa() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos2.setFa(-4);
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
								bemenet = be.nextLine();
								while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
										&& !bemenet.equals("4") && !bemenet.equals("5")) {
									System.out.println("Az opciok kivalasztasanak menupontjai 1-5-ig vannak!");
									bemenet = be.nextLine();
								}
								
								if ( bemenet.equals("1") ) {
									emberJatekos2.setAgyag(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("2") ) {
									emberJatekos2.setBuza(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("3") ) {
									emberJatekos2.setErc(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("4") ) {
									emberJatekos2.setBarany(1);
									System.out.println("Csere megtortent!\n");
								} else {
									emberJatekos2.setFa(1);
									System.out.println("Csere megtortent!\n");
								}
							}
						}
						
						else if ( bemenet.equals("5") ) {
							System.out.println("agyag: " + emberJatekos2.getAgyag() + "\n" +
									"buza: " + emberJatekos2.getBuza() + "\n" +
									"erc: " + emberJatekos2.getErc() + "\n" +
									"barany: " + emberJatekos2.getBarany() + "\n" +
									"fa: " + emberJatekos2.getFa() + "\n" +
									"pontszam: " + emberJatekos2.getPontszam() );
						}
						
						else if ( bemenet.equals("6") ) {
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
					
					bemenet = "";
					jatekosTurnNotEND = true;
					
					
					
					/**
					 * harmadik jatekos kore:
					 */
					
					System.out.println("\n" + emberJatekos3.getNev() + " kore kovetkezik!\n");
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
						bemenet = be.nextLine();
						while(!bemenet.equals("0") && !bemenet.equals("1") && !bemenet.equals("2")
								&& !bemenet.equals("3") && !bemenet.equals("4") && !bemenet.equals("5")
								&& !bemenet.equals("6") && !bemenet.equals("7")) {
							System.out.println("Az opciok kivalasztasanak menupontjai 0-7-ig vannak!");
							bemenet = be.nextLine();
						}
						if ( bemenet.equals("0") ) {
							kirajzolas();
						}
						
						else if ( bemenet.equals("1") ) {
							if ( (emberJatekos3.getAgyag() < 1 ) || (emberJatekos3.getFa() < 1) ) {
								System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
							} else {
								lepesekBeallitasaUt(emberJatekos3.getNev(), emberJatekos3.getId());
								emberJatekos3.setFa(-1);
								emberJatekos3.setAgyag(-1);
							}
						}
						
						else if ( bemenet.equals("2") ) {
							if ( (emberJatekos3.getFa() < 1) || (emberJatekos3.getAgyag() < 1) ||
									(emberJatekos3.getBarany() < 1) || (emberJatekos3.getBuza() < 1) ) {
								System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
							} else {
								lepesekBeallitasaTelepules(emberJatekos3.getNev(), emberJatekos3.getId());
								emberJatekos3.setFa(-1);
								emberJatekos3.setAgyag(-1);
								emberJatekos3.setBarany(-1);
								emberJatekos3.setBuza(-1);
								emberJatekos3.setPontszam(1);
								
								if( emberJatekos3.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(emberJatekos3.getNev() + " a gyoztes!!");

									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
						
						else if ( bemenet.equals("3") ) {
							if ( (emberJatekos3.getErc() < 1) || (emberJatekos3.getBuza() < 2) ) {
								System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
							} else {
								if (lepesekBeallitasaVaros(emberJatekos3.getNev(), emberJatekos3.getId()) == true) {
									emberJatekos3.setErc(-3);
									emberJatekos3.setBuza(-2);
									emberJatekos3.setPontszam(1);
									
									if( emberJatekos3.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
										System.out.println(emberJatekos3.getNev() + " a gyoztes!!");
										
										jatekosTurnNotEND = false;
										turnNotEND = false;
										notEND = false;
									}
								}
							}
						}
						
						else if ( bemenet.equals("4") ) {
							/**
							 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
							 */
							
							if ( (emberJatekos3.getFa() < 4) || (emberJatekos3.getAgyag() < 4) ||
									(emberJatekos3.getBarany() < 4) || (emberJatekos3.getBuza() < 4) ||
									(emberJatekos3.getErc() < 4) ) {
								System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
									"Kerem valassza a vissza opciot!");
							}
							
							/**
							 * "mit" opcio valasztasa
							 */
							boolean isCsereltE = false;
							System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
							bemenet = be.nextLine();
							while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
									&& !bemenet.equals("4") && !bemenet.equals("5") && !bemenet.equals("6")) {
								System.out.println("Az opciok kivalasztasanak menupontjai 1-6-ig vannak!");
								bemenet = be.nextLine();
							}
							
							if ( bemenet.equals("1") ) {
								if ( emberJatekos3.getAgyag() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos3.setAgyag(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("2") ) {
								if ( emberJatekos3.getBuza() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
								} else {
									emberJatekos3.setBuza(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("3") ) {
								if ( emberJatekos3.getErc() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos3.setErc(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("4") ) {
								if ( emberJatekos3.getBarany() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos3.setBarany(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("5") ) {
								if ( emberJatekos3.getFa() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos3.setFa(-4);
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
								bemenet = be.nextLine();
								while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
										&& !bemenet.equals("4") && !bemenet.equals("5")) {
									System.out.println("Az opciok kivalasztasanak menupontjai 1-5-ig vannak!");
									bemenet = be.nextLine();
								}
								
								if ( bemenet.equals("1") ) {
									emberJatekos3.setAgyag(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("2") ) {
									emberJatekos3.setBuza(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("3") ) {
									emberJatekos3.setErc(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("4") ) {
									emberJatekos3.setBarany(1);
									System.out.println("Csere megtortent!\n");
								} else {
									emberJatekos3.setFa(1);
									System.out.println("Csere megtortent!\n");
								}
							}
						}
						
						else if ( bemenet.equals("5") ) {
							System.out.println("agyag: " + emberJatekos3.getAgyag() + "\n" +
									"buza: " + emberJatekos3.getBuza() + "\n" +
									"erc: " + emberJatekos3.getErc() + "\n" +
									"barany: " + emberJatekos3.getBarany() + "\n" +
									"fa: " + emberJatekos3.getFa() + "\n" +
									"pontszam: " + emberJatekos3.getPontszam() );
						}
						
						else if ( bemenet.equals("6") ) {
							System.out.println("ut: 1 fa, 1 agyag\n" +
									"telepules: 1 fa, 1 agyag, 1 barany, 1 buza\n" +
									"varos: 3 erc, 2 buza\n");
						}
						
						else {
							jatekosTurnNotEND = false;
						}
					}
					
					
					
					/**
					 * negyedik jatekos kore:
					 */
					
					System.out.println("\n" + emberJatekos4.getNev() + " kore kovetkezik!\n");
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
						bemenet = be.nextLine();
						while(!bemenet.equals("0") && !bemenet.equals("1") && !bemenet.equals("2")
								&& !bemenet.equals("3") && !bemenet.equals("4") && !bemenet.equals("5")
								&& !bemenet.equals("6") && !bemenet.equals("7")) {
							System.out.println("Az opciok kivalasztasanak menupontjai 0-7-ig vannak!");
							bemenet = be.nextLine();
						}
						if ( bemenet.equals("0") ) {
							kirajzolas();
						}
						
						else if ( bemenet.equals("1") ) {
							if ( (emberJatekos4.getAgyag() < 1 ) || (emberJatekos4.getFa() < 1) ) {
								System.out.println("Nincs eleg nyersanyag az ut epitesehez!\n");
							} else {
								lepesekBeallitasaUt(emberJatekos4.getNev(), emberJatekos4.getId());
								emberJatekos4.setFa(-1);
								emberJatekos4.setAgyag(-1);
							}
						}
						
						else if ( bemenet.equals("2") ) {
							if ( (emberJatekos4.getFa() < 1) || (emberJatekos4.getAgyag() < 1) ||
									(emberJatekos4.getBarany() < 1) || (emberJatekos4.getBuza() < 1) ) {
								System.out.println("Nincs eleg nyersanyag telepules epitesehez!\n");
							} else {
								lepesekBeallitasaTelepules(emberJatekos4.getNev(), emberJatekos4.getId());
								emberJatekos4.setFa(-1);
								emberJatekos4.setAgyag(-1);
								emberJatekos4.setBarany(-1);
								emberJatekos4.setBuza(-1);
								emberJatekos4.setPontszam(1);
								
								if( emberJatekos4.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
									System.out.println(emberJatekos4.getNev() + " a gyoztes!!");

									jatekosTurnNotEND = false;
									turnNotEND = false;
									notEND = false;
								}
							}
						}
						
						else if ( bemenet.equals("3") ) {
							if ( (emberJatekos4.getErc() < 1) || (emberJatekos4.getBuza() < 2) ) {
								System.out.println("Nincs eleg nyersanyag varos epitesehez!\n");
							} else {
								if (lepesekBeallitasaVaros(emberJatekos4.getNev(), emberJatekos4.getId()) == true) {
									emberJatekos4.setErc(-3);
									emberJatekos4.setBuza(-2);
									emberJatekos4.setPontszam(1);
									
									if( emberJatekos4.getPontszam() == kezdetiParams.getGyozelemhezSzuksegesPont() ) {
										System.out.println(emberJatekos4.getNev() + " a gyoztes!!");
										
										jatekosTurnNotEND = false;
										turnNotEND = false;
										notEND = false;
									}
								}
							}
						}
						
						else if ( bemenet.equals("4") ) {
							/**
							 * ellenorzes, hogy egyaltalan van-e barmibol is 4 db
							 */
							
							if ( (emberJatekos4.getFa() < 4) || (emberJatekos4.getAgyag() < 4) ||
									(emberJatekos4.getBarany() < 4) || (emberJatekos4.getBuza() < 4) ||
									(emberJatekos4.getErc() < 4) ) {
								System.out.println("Nincs eleg nyersanyag semmilyen cserehez!\n" +
									"Kerem valassza a vissza opciot!");
							}
							
							/**
							 * "mit" opcio valasztasa
							 */
							boolean isCsereltE = false;
							System.out.println("Milyen nyersanyagot szeretnel cserelni a bankkal?\n" +
									"1: agyag\n2: buza\n3: erc\n4: barany\n5: fa\n6: vissza\n");
							bemenet = be.nextLine();
							while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
									&& !bemenet.equals("4") && !bemenet.equals("5") && !bemenet.equals("6")) {
								System.out.println("Az opciok kivalasztasanak menupontjai 1-6-ig vannak!");
								bemenet = be.nextLine();
							}
							
							if ( bemenet.equals("1") ) {
								if ( emberJatekos4.getAgyag() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos4.setAgyag(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("2") ) {
								if ( emberJatekos4.getBuza() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");	
								} else {
									emberJatekos4.setBuza(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("3") ) {
								if ( emberJatekos4.getErc() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos4.setErc(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("4") ) {
								if ( emberJatekos4.getBarany() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos4.setBarany(-4);
									isCsereltE = true;
								}
							} else if ( bemenet.equals("5") ) {
								if ( emberJatekos4.getFa() < 4 ) {
									System.out.println("Nincs mininmum 4 egyseg a cserehez!\n");
								} else {
									emberJatekos4.setFa(-4);
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
								bemenet = be.nextLine();
								while(!bemenet.equals("1") && !bemenet.equals("2") && !bemenet.equals("3")
										&& !bemenet.equals("4") && !bemenet.equals("5")) {
									System.out.println("Az opciok kivalasztasanak menupontjai 1-5-ig vannak!");
									bemenet = be.nextLine();
								}
								
								if ( bemenet.equals("1") ) {
									emberJatekos4.setAgyag(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("2") ) {
									emberJatekos4.setBuza(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("3") ) {
									emberJatekos4.setErc(1);
									System.out.println("Csere megtortent!\n");
								} else if ( bemenet.equals("4") ) {
									emberJatekos4.setBarany(1);
									System.out.println("Csere megtortent!\n");
								} else {
									emberJatekos4.setFa(1);
									System.out.println("Csere megtortent!\n");
								}
							}
						}
						
						else if ( bemenet.equals("5") ) {
							System.out.println("agyag: " + emberJatekos4.getAgyag() + "\n" +
									"buza: " + emberJatekos4.getBuza() + "\n" +
									"erc: " + emberJatekos4.getErc() + "\n" +
									"barany: " + emberJatekos4.getBarany() + "\n" +
									"fa: " + emberJatekos4.getFa() + "\n" +
									"pontszam: " + emberJatekos4.getPontszam() );
						}
						
						else if ( bemenet.equals("6") ) {
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
					bemenet = "";
				}
			}	

			
		}
	}
}
