package pkgGUI;

import java.util.Scanner;

public class InOut {

	/**
	 * einfache Eingabe, die auch auf eingabe prüft
	 * @param booleann eingabeIstLeer
	 */
	public static String stringEingeben(String anweisung) {
		anweisungAnUserAusgeben(anweisung);
		String input = createScanner().nextLine();
		if (eingabeIstLeer(input)) {
			anweisungAnUserAusgeben(Textbaustein.KEINE_EINGABE);
			stringEingeben(anweisung);
		}
		return input;
	}

	/**
	 * zahlen(int) eingabe
	 * @param anweisung
	 * @return
	 */
	public static int intEingeben(String anweisung) {
		String input = stringEingeben(anweisung);
		int inputInt = 0;
		try {
			inputInt = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			anweisungAnUserAusgeben(Textbaustein.BITTE_ZAHL_EINGEBEN);
		} catch (Exception e) {
			anweisungAnUserAusgeben(Textbaustein.ALLGEMEINE_FEHLERMELDUNG);
		}

		return inputInt;
	}

	private static Scanner createScanner() {
		return new Scanner(System.in);
	}

	/**
	 * einfache ausgabe
	 * @param anweisung
	 */
	public static void anweisungAnUserAusgeben(String anweisung) {
		System.out.println(anweisung);
	}
	public static void textAusgeben(String text) {
		// für Raumbeschreibungen usw.
		// kann später differenziert werden, wenn bspw. unterschiedliche
		// Texte in unterschiedlichen Formaten auf unterschiedlichen
		// GUI-Bereichen ausgegeben werden.
		System.out.println(text);
		
	}
	/**
	 * textausgabe ohne Umbruch (no nl)
	 * @param text
	 */
	public static void textAusgebenOhneUmbruch(String text) {
		System.out.print(text);
	}
	/**
	 * zeilen filler mich for schleife
	 * @param anzahl
	 * @param zeichen
	 */
	public static void trennerAusgeben(int anzahl, String zeichen) {
		for(int i = 1;i <= anzahl;i++) {
		System.out.print(zeichen);
		}
		System.out.println("\n");
	}
	public static void trennerAusgeben(int anzahl) {
		for(int i = 1;i <= anzahl;i++) {
		System.out.print("+");
		}
		System.out.println("\n");
	}
	public static void trennerAusgeben() {
		for(int i = 1;i <= 20;i++) {
		System.out.print("+");
		}
		System.out.println("\n");
	}
	public static void trennerAusgeben(String zeichen) {
		for(int i = 1;i <= 20;i++) {
		System.out.print(zeichen);
		}
		System.out.println("\n");
	}
	private static boolean eingabeIstLeer(String eingabe) {
		if ("".equals(eingabe)) {
			return true;
		} else {
			return false;
		}
	}

}
