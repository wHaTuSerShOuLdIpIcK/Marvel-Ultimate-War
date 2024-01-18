import java.io.IOException;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	private Game game;
	
	private PlayerNamePanel playerNamePanel;
	private String player1name;
	private String player2name;
	private GamePanel gamePanel;
	
	private ChampionSelectionPanel championSelectionPanel;
	
	
	public MainFrame(){
		playeNamePanel= new PlayerNamePanel(this);
		this.getContentPane().add(PlayerNamePanel);
		this.setTitle("Marvel");
		this.setSize(400,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void switchToNextPanel(String n1, String n2){
		player1name=n1;
		player2name=n2;
		try{
			Game.LoadAbilities("Abilities.csv");
			Game.LoadChampions("Champions.csv");
		
		this.setSize(400,400);
		this.remove(playerNamePanel);
		
		championSelectionPanel = new championSelectionPanel(this);
		
		this.getContentPane().add(championSelectionPanel);
		
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public String[]getListOfChampions(){
		ArrayList<Champion> list = Game.getAvailableChampions();
		
		String[] r= new String[list.size()+1];
		r[0]="Select Champion";
		for (int i=0;i<list.size();i++){
			r[i+1]= list.get(i).getName();
		}
		return r;
	}
	public String getChampionInfo(int champIndex){
		ArrayList<Champion> list = Game.getAvailableChampions();
		Champion c = list.get(champIndex);
		
		String r= "name: "+ c.getName()+ "\n"+"Attack: "+c.getAttackDamage()+"\n"+"Range: "+c.getAttackRange()+"\n"+"Health: "+c.getCurrentHP()+"\n"+"Mana: "c.getMana+"Abilities: "+"\n";
		
		
		for (int i=0;i<c.getAbilities().size();i++){
			r= r+(i+1)+")"+c.getAbilities().get(i).getName()+"\n";
		}
		return r;
	}
	public static void main (String [] args){
		MainFrame f = new MainFrame();
	}
	

}
