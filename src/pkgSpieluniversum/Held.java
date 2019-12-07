package pkgSpieluniversum;

public class Held extends Figur {

	private Raum raum;

	public Held(String name, int gesundheit, int schaden, boolean istAmLeben,
			Raum raum) {
		super(name, gesundheit, schaden, istAmLeben);
	}

	public Raum getRaum() {
		return raum;
	}

	public void setRaum(Raum raum) {
		this.raum = raum;
	}

}
