package pkgStartAndConfig;

import pkgGUI.InOut;
import pkgIntelligenz.Spielsteuerung;
import pkgSpieluniversum.Held;
import pkgSpieluniversum.Welt;

public class Startklasse {

	public static void main(String[] args) {
		Welt welt = new Welt(new Held("Erking", 10, 3, true, null));
		InOut.trennerAusgeben("#");
		Spielsteuerung ss = new Spielsteuerung(welt);
	}

}
