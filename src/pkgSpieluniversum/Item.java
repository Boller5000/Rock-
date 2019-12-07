package pkgSpieluniversum;

public class Item {
	private String name;
	private boolean verbrauchbar;
	private int schaden;

	public Item(String name, boolean verbrauchbar) {
		super();
		this.name = name;
		this.verbrauchbar = verbrauchbar;
	}
	public Item(String name, boolean verbrauchbar,int schaden) {
		super();
		this.name = name;
		this.verbrauchbar = verbrauchbar;
		this.schaden = schaden;
	}

	
	public int getSchaden() {
		return schaden;
	}
	public void setSchaden(int schaden) {
		this.schaden = schaden;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVerbrauchbar() {
		return verbrauchbar;
	}

	public void setVerbrauchbar(boolean verbrauchbar) {
		this.verbrauchbar = verbrauchbar;
	}

	
	
}
