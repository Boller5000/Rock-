package pkgSpieluniversum;

import java.util.ArrayList;

public class Welt {
	private ArrayList<Raum> raumListe = new ArrayList<Raum>();
	private Held held;

	public Welt(Held held) {
		this.held = held;
		Item umbrella = new Item("Regenschirm", false, 10);//strand
		Item banane = new Item("Banane", true);
		Item key = new Item("Schlüssel", true);
		Item wood = new Item("Holz", true);
		Item planks = new Item("Bretter", true);
		Item sail = new Item("Segel", true);
		Item excalibur = new Item("Excalibur", false, 100);// für besiegen von mephisto
		Item stone = new Item("Stein", true);
		Item bucket = new Item("Eimer",true);
		Item obsidian = new Item("Obsidian", true);
		Item devilSword = new Item("Teufelsschwert", false, 80);//mit obsidian
		Item treebranch = new Item("Ast", false, 2);
		Item falchion = new Item("Falchion", false, 60);
		Item astra = new Item("Astra", false, 85);
		Item ironSword = new Item("Eisenschwert", false, 30);//wald
		Item steelSword = new Item("Stahlschwert", false, 40);//craften
		Item durandal = new Item("Durandal", false, 70);
		Item broom = new Item("Besen", false, 5);
		Item masterLance = new Item("Meisterlanze", false, 50);
		Item braveLance = new Item("Kriegerlanze", false, 60);//craften
		Item hunterKnife = new Item("Jagdmesser", false, 35);
		Item sacrificialknife = new Item("Opferungsmesser", false, 20);
		Item mapNcompass = new Item("Karte & Kompass", true);//im Boss Raum
		Item shovel = new Item("Schaufel", false);
		
		
		NPC pirat = new NPC("Black Beard", 9,10);// sagt einem das man bretter und segel fürs Bot und die karte um von der insel zu kommen braucht
		NPC merchant = new NPC("Händler", 9,10);
		NPC blacksmith = new NPC("Schmied", 10,2);
		NPC riverDeity = new NPC("Fluss Göttin", 9,10);//Item in den Fluss werfen um es zu verbessern
		NPC monkeyman = new NPC("Monkey Man", 9,10);
		NPC monkey = new NPC("Affe", 9,10);
		NPC wmonster1 = new NPC("Goblin", 9,10); // schwache
		NPC wmonster2 = new NPC("Orc", 9,10);
		NPC wmonster3 = new NPC("Cyclops", 9,10);
		NPC smonster1 = new NPC("Hobgoblin", 9,10); // starke 
		NPC smonster2 = new NPC("Cerberus", 9,10);
		NPC smonster3 = new NPC("Vampire", 9,10);
		NPC tmonster = new NPC("Fafnir", 9,10); // automatischer Kampf bei betreten des Boss Raums
		NPC endboss = new NPC("Mephisto", 9,10); // Lässt einen die Wahl ob man kämpfen will (hatt Dialog)
		NPC vmonster = new NPC("Salamander", 9,10);//beim Vulkan
		NPC wmonster = new NPC("Slime", 9,10);// im Wald
		
	
		// raumerstellung
		Raum dorf = new Raum("Dorf", "Das dorf ist das Zentrum");
		Raum strand = new Raum("Strand", "Der Strand ist warm und die wellen plätschern,\n überall liegen Steine...");
		Raum wald = new Raum("Wald", "Ein dichter Wald umgibt dich, ob man die bäume fällen kann?");
		Raum lehmgrube = new Raum("lehmgrube", "Due stehst bis zu den knien in der scheiße...oder ist das lehm?");
		Raum fluss = new Raum("Fluss", "Frisches trinckwasser, nicht abgekocht");
		Raum wiese = new Raum("Wiese", "Eine wunderschöne Wiese umgibt dich, was man hier wohl alles machen kann?");
		Raum monkeyhill = new Raum("Monkey Hill", "Die Affen gaffe, aber irgendwie fühlst du dich unter deinesgleichen...");
		Raum vulkan = new Raum("Vulkan", "Heiß!!");
		Raum opferAltar = new Raum("Opfer Altar", "You died, or did you?");
		Raum cave = new Raum("Cave", "Es ist dunkel und am liebsten würdest du zurück gehen...");
		Raum altar = new Raum("Altar", "Abrakkadabra dieser Raum Strotzt nur so vor Magie");
		Raum dungeon = new Raum("Dungeon", "Uaa grußelig");
		Raum bossRaum = new Raum("BossRaum", "hehehe XD, it's over for you");
		
		strand.addNpcs(pirat);
		dorf.addNpcs(merchant);
		dorf.addNpcs(blacksmith);
		fluss.addNpcs(riverDeity);
		monkeyhill.addNpcs(monkeyman);
		strand.addItem(umbrella);
		lehmgrube.addItem(shovel);
		wald.addItem(ironSword);
		
		raumListe.add(dorf);
		raumListe.add(strand);
		raumListe.add(lehmgrube);
		raumListe.add(fluss);
		raumListe.add(wiese);
		raumListe.add(monkeyhill);
		raumListe.add(vulkan);
		raumListe.add(opferAltar);
		raumListe.add(cave);
		raumListe.add(altar);
		raumListe.add(dungeon);
		raumListe.add(bossRaum);

		// Raum orientierung
		dorf.setS(strand);
		dorf.setO(wald);
		dorf.setN(fluss);
		dorf.setW(lehmgrube);

		strand.setN(dorf);

		wald.setW(dorf);
		wald.setO(cave);

		lehmgrube.setO(dorf);

		fluss.setS(dorf);
		fluss.setN(vulkan);
		fluss.setW(wiese);

		wiese.setO(fluss);
		wiese.setN(monkeyhill);

		monkeyhill.setS(wiese);
		monkeyhill.setO(vulkan);

		vulkan.setW(monkeyhill);
		vulkan.setS(fluss);
		vulkan.setO(opferAltar);

		opferAltar.setW(vulkan);

		cave.setW(wald);
		cave.setN(dungeon);
		cave.setS(altar);
		cave.setKey(true);

		altar.setN(cave);
		altar.setKey(true);

		dungeon.setS(cave);
		dungeon.setN(bossRaum);
		// held init
		this.held.setRaum(dorf);
		//this.held.addItem(excalibur);
		System.out.println("Startraum: dorf");
	}

	public Held getHeld() {
		return held;
	}

	public void setHeld(Held held) {
		this.held = held;
	}

	public ArrayList<Raum> getRaumListe() {
		return raumListe;
	}

}
