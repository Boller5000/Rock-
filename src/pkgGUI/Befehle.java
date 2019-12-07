package pkgGUI;

import pkgSpieluniversum.Figur;
import pkgSpieluniversum.Held;
import pkgSpieluniversum.Item;
import pkgSpieluniversum.NPC;

public class Befehle {

	public static void nehmen(String item, Held held) {
		Item localItem = null;
		for (Item i : held.getRaum().getInventar()) {
			if (i.getName().toLowerCase().equals(item.toLowerCase())) {
				localItem = i;
			}
		}
		if (localItem != null) {
			held.addItem(localItem);
			held.getRaum().removeItem(localItem);
			InOut.textAusgeben(Textbaustein.GEGENSTAND_GENOMMEN
					+ localItem.getName());
		} else {
			InOut.textAusgeben(Textbaustein.GEGENSTAND_NICHT_IM_RAUM);
		}

	}

	public static void list(String object, Held held) {
		switch (object) {
		case "npcs":
			System.out.println("Liste aller NPC's im raum:");
			for(Figur f : held.getRaum().getNpcs()) {
				System.out.println(f.getName() + ",");
			}
			break;
		case "item":
			System.out.println("Liste aller Item's im raum:");
			for(Item i : held.getRaum().getInventar()) {
				System.out.println(i.getName() + ",");
			}
			break;
		default:

		}

	}

	public static class fight {
		public static NPC gegner;

		public static void kampfStatus(Held held) {
			System.out.println(gegner.getName() + "(" + gegner.getGesundheit() + "):" + held.getName() + "(" + held.getGesundheit() + ")");
		}
		
		public static boolean kaempfen(String npc, Held held) {
			for (NPC n : held.getRaum().getNpcs()) {
				if (n == null) {
					InOut.textAusgeben(Textbaustein.NPC_NICHT_IM_RAUM);
				} else {
					NPC npcImRaum = n;
					if (npcImRaum.getName().toLowerCase()
							.equals(npc.toLowerCase())) {
						if (!npcImRaum.isIstAmLeben()) {
							InOut.textAusgeben(Textbaustein.NPC_IST_TOT);
						} else {
							// NPC bekämpfen
							InOut.textAusgeben(Textbaustein.KAMPF_START);
							fight.gegner = n;
							return true;
						}
					}
				}
			}
			return false;
		}

		public static void angriff(Held held) {
			gegner.setGesundheit(gegner.getGesundheit()
					- held.getGesamtSchaden());
			held.setGesundheit(held.getGesundheit()
					- gegner.getGesamtSchaden());
			InOut.textAusgeben("Du schlägst zu und verursachst "
					+ held.getGesamtSchaden() + " Schaden");
			// held.getGesundheit()

		}

		public static void blocken(Held held) {

		}

		public static void fliehen(Held held) {

		}
	}

}
