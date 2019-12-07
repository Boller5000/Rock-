package pkgIntelligenz;

public class Parser {

	private int anzahlWoerter;
	private String wort1, wort2, usereingabe;
	private String[] woerter;

	public Parser(String usereingabe) {
		super();
		this.usereingabe = usereingabe;
		this.wort1 = "";
		this.wort2 = "";
		this.anzahlWoerter = this.anzahlWoerterHerausfinden();

	}

	public int anzahlWoerterHerausfinden() {
		int anzahlZeichen = this.usereingabe.length();
		this.usereingabe = this.usereingabe.toLowerCase();
		this.woerter = usereingabe.trim().split("\\s+");
		this.anzahlWoerter = this.woerter.length;
		switch (anzahlWoerter) {
		case 1:
			this.setWort1(this.getWoerter()[0]);
			break;
		case 2:
			this.setWort1(this.getWoerter()[0]);
			this.setWort2(this.getWoerter()[1]);
			break;

		default:
			anzahlWoerter = 99;
			break;
		}
		return anzahlWoerter;
	}

	public int getAnzahlWoerter() {
		return anzahlWoerter;
	}

	public void setAnzahlWoerter(int anzahlWoerter) {
		this.anzahlWoerter = anzahlWoerter;
	}

	public String getWort1() {
		return wort1;
	}

	public void setWort1(String wort1) {
		this.wort1 = wort1;
	}

	public String getWort2() {
		return wort2;
	}

	public void setWort2(String wort2) {
		this.wort2 = wort2;
	}

	public String getUsereingabe() {
		return usereingabe;
	}

	public void setUsereingabe(String usereingabe) {
		this.usereingabe = usereingabe;
	}

	public String[] getWoerter() {
		return woerter;
	}

	public void setWoerter(String[] woerter) {
		this.woerter = woerter;
	}

}
