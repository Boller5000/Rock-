package pkgGUI;

public final class Textbaustein {


	public static final String KEINE_EINGABE = "Ihre Eingabe ist leer.";
	public static final String BITTE_ZAHL_EINGEBEN = "Bitte Zahl eingeben.";
	public static final String ALLGEMEINE_FEHLERMELDUNG = "Es ist ein Fehler aufgetreten. Bitte nochmals Eingabe versuchen.";
	public static final String USER_AKTION_ABFRAGEN = "\nWas möchtest du tun? (h = Hilfe)";
	public static final String HILFETEXT_DEFAULT = "\n++++++ HILFE +++++++\nn,o,s,w - Raumwechsel\nh - Hilfe\ni - Inventar\nnimm + Gegenstand im Raum - etwas ins Inventar tun (nimm flasche)\nbenutze + Gegenstand im Inventar - einen Gegenstand benutzen (benutze fernrohr)\n++++++ HILFE ENDE +++++++\n";
	public static final String HILFETEXT_KAMPF = "\n++++++ HILFE +++++++ kampf -  zum kämpfen\nfliehen -  um versuchen abzuhauen\n\n++++++ HILFE ENDE +++++++\n";

	public static final String INVENTAR_UEBERSCHRIFT = "+++++++ INVENTAR ++++++++\nDu trägst folgende Gegenstände bei dir:";	
	public static final String INVENTAR_KEINE_GEGENSTAENDE = "Sie tragen leider nichts bei sich.";
	public static final String RICHTUNG_NICHT_MOEGLICH = "In diese Richtung können Sie nicht gehen.";
	public static final String AKTION_NICHT_MOEGLICH = "Ich verstehe nicht, was Sie meinen. h für Hilfe drücken.";
	public static final String AKTION_NICHT_MOEGLICH_MEHR_ALS_2_WOERTER = "Willst du mich beschwallen, bitte höchstens 2 Wörter eingeben.";

	public static final String DISABLE_HELP = "Hilfetext ausgeschaltet,\n schreib disable um ihn wieder einzuschalten";
	public static final String GEGENSTAND_GENOMMEN = "Ihrem Inventar hinzugefügt: ";		
	public static final String GEGENSTAND_NICHT_IM_RAUM = "Das liegt hier nirgends herum.";
	public static final String GEGENSTAND_NICHT_IM_INVENTAR = "Das habe ich nicht im Inventar.";
	public static final String DU_SIEHST_IM_RAUM = "Du siehst:";
	public static final String KEIN_KEY = "Du hast den Schlüssel für diese aktion nich nicht eingesetzt\noder gefunden.";
	public static final String NPC_NICHT_IM_RAUM = "Wer soll das sein?Von dem hab ich noch nie gehört";
	public static final String NPC_IST_TOT = "Huch, von dem ist nur noch staub und Knochen übrig...";
	public static final String KAMPF_START = "Der Kampf hat begonnen, mach dich bereit auf ein kampf um leben und tot";
	
	// privater (!) Konstruktor
	private Textbaustein() {
		// Konstruktor darf nicht von der Caller-Klasse aufgerufen werden
		throw new AssertionError();
	}
}
