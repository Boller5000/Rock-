package pkgSpieluniversum;

import java.util.ArrayList;

public class Raum {
	private String name;
	private String beschreibung;
	private Raum n, o, s, w;
	private ArrayList<NPC> npcs = new ArrayList<NPC>();
	private ArrayList<Item> inventar = new ArrayList<Item>();
	private boolean key = false;

	public Raum(String name, String beschreibung) {
		this.name = name;
		this.beschreibung = beschreibung;
		this.s = null;
		this.o = null;
		this.n = null;
		this.w = null;
		System.out.println("Raum - " + name + " erstellt");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Raum getN() {
		return n;
	}

	public void setN(Raum n) {
		this.n = n;
	}

	public Raum getO() {
		return o;
	}

	public void setO(Raum o) {
		this.o = o;
	}

	public Raum getS() {
		return s;
	}

	public void setS(Raum s) {
		this.s = s;
	}

	public Raum getW() {
		return w;
	}

	public void setW(Raum w) {
		this.w = w;
	}

	public ArrayList<NPC> getNpcs() {
		return npcs;
	}

	public void addNpcs(NPC npc) {
		this.npcs.add(npc);
	}

	public void addItem(Item item) {
		this.inventar.add(item);
	}
	public void removeItem(Item item) {
		this.inventar.remove(item);
	}

	public ArrayList<Item> getInventar() {
		return inventar;
	}

	public boolean getKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}
	

}
