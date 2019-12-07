package pkgFenster;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing;
	String weapon, position;
	boolean hatDoenerspiess = false;
	boolean goblinTot = false;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();


	public static void main(String[] args) {

		new Game();
	}
	
	public Game(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Neulich in Bad Krozingen");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		window.setVisible(true);
	}
	
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("Bla");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("Leben:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Waffe:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

		playerSetup();

	}
	public void playerSetup(){
		playerHP = 15;
		monsterHP = 20;
		weapon = "Dosenöffner";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		townGate();
	}
	public void townGate(){
		position = "townGate";
		mainTextArea.setText("Du stehst vor den Stadttoren Bad Krozingens. \nEine Wache steht vor dir. \n\nWas tust du?");		
		choice1.setText("Mit Wache sprechen");
		choice2.setText("Wache angreifen");
		choice3.setText("Gehe nach Norden");
		choice4.setText("");
	}
	public void talkGuard(){
		position = "talkGuard";
		mainTextArea.setText("Wache: Hallo Fremder. \nDein Gesicht habe ich noch nie gesehen. \nEs tut mir leid aber du kommst hier net rein.\nAber da draußen treibt ein Monster sein Unwesen.\nWenn du es besiegst und mir einen Beweis lieferst,\nwürdest du der Stadt ein großen Gefallen erweisen.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void attackGuard(){
		
		switch(playerHP){
		case 0:
			lose();
			break;
			
		default:
			position = "attackGuard";
			mainTextArea.setText("Wache: Hey sei nicht leichtsinnig!\n\nDie Wache schlägt überzeugend auf dich ein.\n(Du erhältst 3 Schadenspunkte)");
			playerHP = playerHP -3;
			hpLabelNumber.setText(""+playerHP);
			choice1.setText("weiter");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");	
		}

	}
	public void crossRoad(){
		position = "crossRoad";
		mainTextArea.setText("Du kommst an eine Kreuzung.\nRichtung Süden gelangst du wieder zum Stadttor.");
		choice1.setText("Gehe nach Norden");
		choice2.setText("Gehe nach Westen");
		choice3.setText("Gehe nach Süden");
		choice4.setText("Gehe nach Osten");
	}
	public void north(){
		position = "north";
		if(playerHP<15) {
			playerHP = 15;
			mainTextArea.setText("Du kommst an einen Fluss. \nDu trinkst etwas Wasser und ruhst dich aus. \n\n(Du fühlst dich komplett regeneriert!)");
		}
		else {
			mainTextArea.setText("Du kommst an einen Fluss. \nDu trinkst etwas Wasser und ruhst dich aus.");
		}
		
		
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Gehe nach Süden");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void east(){
		position = "east";
		if(!hatDoenerspiess) {
			mainTextArea.setText("Du stolperst auf eine Lichtung und findest \neinen mächtigen Dönerspieß!\n\n(Die Waffe erhöht deine Angriffskraft)");
			weapon = "Dönerspieß";
			weaponLabelName.setText(weapon);
			this.hatDoenerspiess=true;
		}
		else {
			mainTextArea.setText("Du stolperst auf eine Lichtung,- schön hier!");
		}

		choice1.setText("Gehe nach Westen");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void west(){
		position = "west";
		if(!this.goblinTot) {
			mainTextArea.setText("Du kommst zu einer düsteren Höhle.\nAus der Höhle rennt ein Goblin auf dich zu!");
			choice1.setText("Kämpfe gegen Goblin");
			choice2.setText("Nichts wie weg!");
			choice3.setText("");
			choice4.setText("");	
		}
		else {
			mainTextArea.setText("Du kommst zu einer verlassenen Höhle.");
			choice1.setText("Gehe nach Osten");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
	}
	public void fight(){
		position = "fight";
		mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWas willst du tun?");
		choice1.setText("Kämpfe gegen Goblin");
		choice2.setText("Nichts wie weg!");
		choice3.setText("");
		choice4.setText("");
	}
	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.equals("Dosenöffner")){
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Dönerspieß")){
			playerDamage = new java.util.Random().nextInt(12); 
		}
		
		mainTextArea.setText("Du attackierst das Monster und schadest ihn um: \n" + playerDamage + " Lebenspunkte");
		
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText("weiter");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void monsterAttack(){
		position = "monsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(5); 
		
		mainTextArea.setText("Der Gobling fügt dir  " + monsterDamage + " Schaden zu!");
		
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText("weiter");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void win(){
		position = "win";
		
		mainTextArea.setText("Du hast den Goblin besiegt!\nAn seiner blutigen Hand glitzert ein prächtiger Ring!\n\n(Du erhältst einen Ring)");
		
		silverRing = 1;
		this.goblinTot = true;
		
		choice1.setText("Gehe nach Osten");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("Du bist leider gestorben,- sehr ärgerlich!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void ending(){
		position = "ending";
		
		mainTextArea.setText("Wache: Oh, du hast den grausamen Goblin besiegt!?\nSehr heldenhaft!\nWillkommen in Bad Krozingen!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}



	
	
	
		
	
	
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "townGate":
				switch(yourChoice){
				case "c1": 
					if(silverRing==1){
						ending();
					}
					else{
						talkGuard();
					}
					break;
				case "c2": attackGuard();break;
				case "c3": crossRoad();break;
				}
				break;
			case "talkGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice){
				case "c1": north(); break;
				case "c2": west();break;
				case "c3": townGate(); break;
				case "c4": east();break;
				}
				break;
			case "north":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				if(!goblinTot) {
					switch(yourChoice){
					case "c1": fight(); break;
					case "c2": crossRoad(); break;
					}
				}
				else {
					switch(yourChoice){
					case "c1": crossRoad(); break;

					}
				}
				
				break;
			case "fight":
				switch(yourChoice){
				case "c1": playerAttack();break;
				case "c2": crossRoad(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP<1){
						win();
					}
					else{
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1": crossRoad();
				}
				break;
				
			}
			
			
		}
	}



}
