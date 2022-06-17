package engine;
import java.util.*;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import model.abilities.*;
import model.effects.*;
import model.world.*;
public class Game {
	private Player firstPlayer;       	private boolean firstLeaderAbilityUsed;  
	private Player secondPlayer;		private boolean secondLeaderAbilityUsed;	
	private Object [][] board;          private PriorityQueue turnOrder;	
	private static ArrayList<Champion> availableChampions;
	private static ArrayList<Ability> availableAbilities;
	private final static int BOARDWIDTH = 5;		private final static int BOARDHEIGHT =5;

	public Game(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		
		availableChampions	=	new ArrayList<Champion>();
		availableAbilities	=	new ArrayList<Ability>();
		this.turnOrder		=	new PriorityQueue(6);
		
		board  = new Object[5][5];	placeChampions();
		firstLeaderAbilityUsed	= false;	// 
		secondLeaderAbilityUsed	= false;
		placeCovers();
	}
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public boolean isFirstLeaderAbilityUsed() {
		return firstLeaderAbilityUsed;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public boolean isSecondLeaderAbilityUsed() {
		return secondLeaderAbilityUsed;
	}

	public Object[][] getBoard() {
		return board;
	}

	public PriorityQueue getTurnOrder() {
		return turnOrder;
	}

	public static ArrayList<Champion> getAvailableChampions() {
		return availableChampions;
	}

	public static ArrayList<Ability> getAvailableAbilities() {
		return availableAbilities;
	}

	public static int getBoardwidth() {
		return BOARDWIDTH;
	}

	public static int getBoardheight() {
		return BOARDHEIGHT;
	}
		
	private void placeChampions() {
		if(firstPlayer.getTeam().size()==0 ||secondPlayer.getTeam().size()==0)
			return;
		ArrayList<Champion> ChampList = firstPlayer.getTeam();
		for(int j = 1; j<=ChampList.size();j++) {  				 //loops on the middle (3positions/teamSize)
			board[0][j] = firstPlayer.getTeam().get(j-1); 					//place Players' 3 champs
			ChampList.get(j-1).setLocation(new Point(0,j));
			}                                                 	
		ArrayList<Champion> p2ChampList = secondPlayer.getTeam();
		for(int j = 1; j<=p2ChampList.size();j++) {				//loops on the middle 3 positions
			board[this.BOARDHEIGHT-1][j] = secondPlayer.getTeam().get(j-1);//place Players' 3 champs
			p2ChampList.get(j-1).setLocation(new Point(this.BOARDHEIGHT-1,j));
		}
	}			
	
	
	
	private void placeCovers() {
		int noOfCover=0;
		while(noOfCover<5) {
			int n1 = (int) ((Math.random() * BOARDHEIGHT ));   	 //	generate position of 
			int n2 = (int) ((Math.random() * BOARDWIDTH ));    	//      the cover
			if(!((n1==0)||(n1==BOARDHEIGHT-1))) {
				if(board[n1][n2] == null) {              	 //check if position is available
					board[n1][n2] = new Cover(n1,n2);       //calling Cover's constructor to place the cover 
					noOfCover++;
					}
				}
			}
	}
	public static void loadAbilities(String filePath) throws Exception {
		BufferedReader br= new BufferedReader(new FileReader(filePath));
		while(br.ready()) {
			String[] ab= br.readLine().split(",");		 //Save the ability line into a cell of the array
			if(ab[0].equals("CC")){
				Effect f = null;
				switch(ab[7]) {
				case "Dodge":f = new Dodge(Integer.parseInt(ab[8]));break;
				case "SpeedUp":f = new SpeedUp(Integer.parseInt(ab[8]));break;
				case "Silence":f = new Silence(Integer.parseInt(ab[8]));break;
				case "PowerUp":f = new PowerUp(Integer.parseInt(ab[8]));break;
				case "Disarm":f = new Disarm(Integer.parseInt(ab[8]));break;
				case "Root":f = new Root(Integer.parseInt(ab[8]));break;
				case "Embrace":f = new Embrace(Integer.parseInt(ab[8]));break;
				case "Shock":f = new Shock(Integer.parseInt(ab[8]));break;
				case "Stun":f = new Stun(Integer.parseInt(ab[8]));break;
				case "Shield":f = new Shield(Integer.parseInt(ab[8]));break;
				}
				//Create new ability aa with the given parameters then add to the List
				Ability aa = new CrowdControlAbility(ab[1],Integer.parseInt(ab[2]),Integer.parseInt(ab[4]),
						Integer.parseInt(ab[3]), AreaOfEffect.valueOf(ab[5]), Integer.parseInt(ab[6]), f);				
				availableAbilities.add(aa);
			}
			if(ab[0].equals("DMG")) {
				Ability aa = new DamagingAbility(ab[1],Integer.parseInt(ab[2]),Integer.parseInt(ab[4]),
						Integer.parseInt(ab[3]), AreaOfEffect.valueOf(ab[5]), Integer.parseInt(ab[6]), Integer.parseInt(ab[7]));
				
				availableAbilities.add(aa);
			}
			if(ab[0].equals("HEL")) {
				Ability aa = new HealingAbility(ab[1],Integer.parseInt(ab[2]),Integer.parseInt(ab[4]),
						Integer.parseInt(ab[3]), AreaOfEffect.valueOf(ab[5]), Integer.parseInt(ab[6]), Integer.parseInt(ab[7]));
					availableAbilities.add(aa);
			}
		}
		br.close();

	}
	public static void loadChampions(String filePath) throws Exception {
		BufferedReader br= new BufferedReader(new FileReader(filePath));
		while(br.ready()) {
			String[] ch= br.readLine().split(",");		 //Save the champ line into a cell of the array
			if(ch[0].equals("H")) {
				Champion h = new Hero(ch[1], Integer.parseInt(ch[2]), Integer.parseInt(ch[3]),
						Integer.parseInt(ch[4]), Integer.parseInt(ch[5]), Integer.parseInt(ch[6]),Integer.parseInt(ch[7]));
				for(int i = 0;i<availableAbilities.size();i++) {
					if((ch[8].equals(availableAbilities.get(i).getName()))
					||(ch[9].equals(availableAbilities.get(i).getName()))||(ch[10].equals(availableAbilities.get(i).getName())))
						h.getAbilities().add(availableAbilities.get(i));
				}
				availableChampions.add(h);
			}
			if(ch[0].equals("A")) {
				Champion a = new AntiHero(ch[1], Integer.parseInt(ch[2]), Integer.parseInt(ch[3]),
						Integer.parseInt(ch[4]), Integer.parseInt(ch[5]), Integer.parseInt(ch[6]), Integer.parseInt(ch[7]));
				for(int i = 0;i<availableAbilities.size();i++) {
					if((ch[8].equals(availableAbilities.get(i).getName()))
					||(ch[9].equals(availableAbilities.get(i).getName()))||(ch[10].equals(availableAbilities.get(i).getName())))
						a.getAbilities().add(availableAbilities.get(i));
				}
				availableChampions.add(a);				
			}
			if(ch[0].equals("V")) {
				Champion v = new Villain(ch[1], Integer.parseInt(ch[2]), Integer.parseInt(ch[3]),
						Integer.parseInt(ch[4]), Integer.parseInt(ch[5]), Integer.parseInt(ch[6]), Integer.parseInt(ch[7]));
				for(int i = 0;i<availableAbilities.size();i++) {
					if((ch[8].equals(availableAbilities.get(i).getName()))
					||(ch[9].equals(availableAbilities.get(i).getName()))||(ch[10].equals(availableAbilities.get(i).getName())))
						v.getAbilities().add(availableAbilities.get(i));
				}
				availableChampions.add(v);
			}			
		}
		br.close();
	}	
}
