package pkgSpieluniversum;

import java.util.ArrayList;

public abstract class Figur {
	protected String name;
	protected int gesundheit;
	protected int schaden;
	protected int shield;
	protected int critchance;
	protected int critDamage;
	protected int level;
	protected boolean istAmLeben;
	protected ArrayList<Item> inventar = new ArrayList<Item>();
	protected Item Waffe;

	public Figur(String name, int gesundheit, int schaden, boolean istAmLeben) {
		this.name = name;
		this.gesundheit = gesundheit;
		this.schaden = schaden;
		this.istAmLeben = istAmLeben;
	}
	public int getGesamtSchaden() {
		return this.schaden +((this.Waffe == null)?0:this.Waffe.getSchaden());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGesundheit() {
		return gesundheit;
	}

	public void setGesundheit(int gesundheit) {
		this.gesundheit = gesundheit;
	}

	public int getSchaden() {
		return schaden;
	}

	public void setSchaden(int schaden) {
		this.schaden = schaden;
	}

	public boolean isIstAmLeben() {
		return istAmLeben;
	}

	public void setIstAmLeben(boolean istAmLeben) {
		this.istAmLeben = istAmLeben;
	}

	public void addItem(Item item) {
		this.inventar.add(item);
	}

	public ArrayList<Item> getInventar() {
		return inventar;
	}

	public void setInventar(ArrayList<Item> inventar) {
		this.inventar = inventar;
	}
	
	
}
