package pkgIntelligenz;

import pkgGUI.*;
import pkgSpieluniversum.*;

public class Spielsteuerung {
	private Welt welt;
	private boolean hilfe = true;
	private boolean kampf = false;

	public Spielsteuerung(Welt welt) {
		this.welt = welt;
		this.heldInNeuenRaumBewegen(welt.getHeld().getRaum());
		this.userAktionAbfragen();
	}

	public void userAktionAbfragen() {
		String eingabe = InOut
				.stringEingeben(hilfe ? Textbaustein.USER_AKTION_ABFRAGEN : "");
		this.aktionAusfuehren(eingabe);

	}

	public void aktionAusfuehren(String usereingabe) {
		Raum aktuellerRaum = this.welt.getHeld().getRaum();
		Held held = this.welt.getHeld();
		Parser parser = new Parser(usereingabe);
		if (!kampf) {
			if (parser.getAnzahlWoerter() == 1) {
				// Default commands

				switch (parser.getWort1()) {
				case "n":
					if (aktuellerRaum.getN() != null) {
						this.heldInNeuenRaumBewegen(aktuellerRaum.getN());
					} else {
						InOut.textAusgeben(Textbaustein.RICHTUNG_NICHT_MOEGLICH);
					}
					break;
				case "s":
					if (aktuellerRaum.getS() != null) {
						this.heldInNeuenRaumBewegen(aktuellerRaum.getS());
					} else {
						InOut.textAusgeben(Textbaustein.RICHTUNG_NICHT_MOEGLICH);
					}
					break;
				case "o":
					if (aktuellerRaum.getO() != null) {
						this.heldInNeuenRaumBewegen(aktuellerRaum.getO());
					} else {
						InOut.textAusgeben(Textbaustein.RICHTUNG_NICHT_MOEGLICH);
					}
					break;
				case "w":
					if (aktuellerRaum.getW() != null) {
						this.heldInNeuenRaumBewegen(aktuellerRaum.getW());
					} else {
						InOut.textAusgeben(Textbaustein.RICHTUNG_NICHT_MOEGLICH);
					}
					break;
				case "h":
					InOut.textAusgeben(Textbaustein.HILFETEXT_DEFAULT);
					break;
				case "inv":
					InOut.textAusgeben(Textbaustein.INVENTAR_UEBERSCHRIFT);
					for (Item i : held.getInventar()) {
						InOut.textAusgebenOhneUmbruch(i.getName() + ",");
					}
					InOut.textAusgeben("\n");
					break;
				case "disable":
					InOut.textAusgeben(Textbaustein.DISABLE_HELP);
					hilfe = false;
					break;
				default:
					InOut.textAusgeben(Textbaustein.AKTION_NICHT_MOEGLICH);
					break;
				}
			} else if (parser.getAnzahlWoerter() == 2) {
				switch (parser.getWort1()) {
				case "kämpfen":
					this.kampf = Befehle.fight.kaempfen(parser.getWort2(), held);
					break;
				case "nehmen":
					Befehle.nehmen(parser.getWort2(), held);
					break;
				case "list":
					Befehle.list(parser.getWort2(), held);
					break;
				default:
					InOut.textAusgeben(Textbaustein.AKTION_NICHT_MOEGLICH);
					break;
				}
			} else {
				System.out.println(Textbaustein.AKTION_NICHT_MOEGLICH_MEHR_ALS_2_WOERTER);
			}
		} else {
			// fight commands
			switch (parser.getWort1()) {
			case "h":
				InOut.textAusgeben(Textbaustein.HILFETEXT_KAMPF);
				break;
			case "angriff":
				Befehle.fight.angriff(held);
				break;
			default:
				InOut.textAusgeben(Textbaustein.AKTION_NICHT_MOEGLICH);
			}
			Befehle.fight.kampfStatus(held);
		}
		this.userAktionAbfragen();
	}

	public void heldInNeuenRaumBewegen(Raum neuerRaum) {
		if (!neuerRaum.getKey()) {
			this.welt.getHeld().setRaum(neuerRaum);
			InOut.textAusgeben("Du hast " + neuerRaum.getName() + " betreten");
			InOut.textAusgeben(neuerRaum.getBeschreibung());
			if (neuerRaum.getInventar().size() != 0) {
				InOut.textAusgeben("Im raum liegen: ");
				for (Item i : neuerRaum.getInventar()) {
					InOut.textAusgebenOhneUmbruch(i.getName() + ", ");
				}
			}
		} else {
			InOut.textAusgeben(Textbaustein.KEIN_KEY);
		}
		// InOut.textAusgeben(ausgabeInfoNPC);

	}

}
