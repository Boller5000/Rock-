package pkgSpieluniversum;

public class NPC extends Figur {
	private boolean isAlive = true;
	public NPC(String name, int gesundheit, int schaden) {
		super(name, gesundheit, schaden,true);
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
