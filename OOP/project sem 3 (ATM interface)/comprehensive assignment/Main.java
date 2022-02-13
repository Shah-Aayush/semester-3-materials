import java.util.*;

class WrongDate extends Exception{		//class which represents the use-defined exception when user entered invalid date.
	public WrongDate(String s){
		super(s);		//call constructor of parent exception
	}
}
class InvalidWicket extends Exception{		//class which represents the use-defined exception when user entered more than 10 wickets per match.
	public InvalidWicket(String s){
		super(s);		//call constructor of parent excpetion
	}	
}
class Date{		//class which represents the date format
	int day,month,year;
	Date(){		//constructor without argument
		day = 8;		//assigning random value
		month = 12;
		year = 2000;
	}
	Date(int d, int m, int y){		//constructor with arguments
		day = d;	
		month = m;
		year = y;
	}
	
	void setDay(int day){		//set method for day
		this.day = day;
	}
	void setMonth(int month){		//set method for month
		this.month = month;
	}
	void setYear(int year){		//set method for year
		this.year = year;
	}
	void display() {		//method for displaying the date
		System.out.print(this.day + "/" + this.month + "/" + this.year);
	}
	
	public boolean check(int Day, int Month, int Year){		//method to check whether the entered date is correct or not
		//checking year
		int flagYear=0;
		int flagMonth=0;
		int flagDay=0;
		if(Year>2020 || Year <0){
			System.out.println("Entered year is incorrect :(");
		}
		else{
			System.out.println("YEAR : CORRECT");
			flagYear=1;
		}
		//checking month
		if(Month>12 || Month<1){
			System.out.println("Entered month is incorrect :(");
		}
		else{
			System.out.println("MONTH : CORRECT");
			flagMonth=1;
		}
		//checking day
		if(Month!=2){
			if(Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12){
				if(Day>0 && Day<32){
					System.out.println("DAY : CORRECT");
					flagDay=1;
				}
				else
				System.out.println("Entered day is incorrect :(");
			}
			else{
				if(Day>0 && Day<31){
					System.out.println("DAY : CORRECT");
					flagDay=1;
				}
				else
				System.out.println("Entered day is incorrect :(");
			}
		}
		else{
			if(Year%4==0 && Year%100!=0){
				if(Day>0 && Day<30){
					System.out.println("DAY : CORRECT");
					flagDay=1;
				}
				else
				System.out.println("Entered day is incorrect :(");
			}
			else{
				if(Day>0 && Day<29){
					System.out.println("DAY : CORRECT");
					flagDay=1;
				}
				else
				System.out.println("Entered day is incorrect :(");
			}
		}
		if(flagDay==1 && flagMonth==1 && flagYear==1)
		return true;		//returns true if date is valid
		else
		return false;		//returs false if date is invalid
	}
}
class Cricketer{		//class which represent the Cricketer (players of match)
	String playerFirstName;		//player's name
	int totalScore,totalWicket;		//player's total-Score if he/she is batsman OR player's total-Wicket if he/she is bowler(sum of - score/wickets from all matches).
	boolean rollInTeam;		//if player is batsman then rollInTeam will be true otherwise false.
	Cricketer(String playerFirstName, boolean rollInTeam){		//construcotr with argument
		this.playerFirstName = playerFirstName;
		this.rollInTeam = rollInTeam;
		this.totalScore = 0;
		this.totalWicket = 0;
	}
	void setTotalScore(int totalScore){		//setter method for totalScore
		this.totalScore += totalScore;
	}
	void setTotalWicket(int totalWicket) {		//setter method for totalWicket
		this.totalWicket += totalWicket;
	}
	int getTotalScore() {		//getter method for totalScore
		return totalScore;
	}
	int getTotalWicket() {		//getter method for totalWicket
		return totalWicket;
	}
}
class Match{		//class which represents each Match
	Date matchDate = new Date();		//represents match Date
	int totalScore,totalWickets;		//represents (total run scored)/(total wickets taken) in this particular match
	int[] matchInfo = new int[11];		//array for storing player's run/wickets
	Cricketer[] players; 	//array of cricketer object.
	
	Match(Date matchDate, Cricketer[] players){		//constructor with arguments (of Objects)
		this.totalScore = 0;
		this.totalWickets = 0;
		this.matchDate = matchDate;
		this.players = players;
	}
	
	void addPlayerDetails(int index, int scoreOrWicket) {		//method for adding players into the match
		//rollInTeam is batsman ==> rollInTeam = 1 || rollInTeam is bowler ==> rollInTeam = 0
		//in array, rollInTeam is batsman ==> 1 || rollInTeam is bowler ==> 0
		//in array, first index is rollInTeam, second index is score/wickets
		if(players[index].rollInTeam == true) {
			this.players[index].setTotalScore(scoreOrWicket);
			this.totalScore += scoreOrWicket;
		}
		else {
			this.players[index].setTotalWicket(scoreOrWicket);
			this.totalWickets += scoreOrWicket;
		}
			
		this.matchInfo[index] = scoreOrWicket;
		
	}
	
	void displayPlayerDetails() {		//method for displaying the player's details like runs/wickets,roll-In-Team in this match.
		for(int i=0;i<11;i++) {
			System.out.println("\nPlayer no. : " + (i+1));
			System.out.println("Player Name : " + players[i].playerFirstName);
			System.out.println("Roll In Team : " + ((players[i].rollInTeam==false)?"Bowler":"Batsman"));
			System.out.println(((players[i].rollInTeam==false)? ("Wickets taken : ") : ("Score : ")) + matchInfo[i]);
		}
	}
	void displayMatchInfo() {		//method for displaying the match-date, total-score and total-Wickets
		System.out.println("Match date : " + this.matchDate.day + " / " + this.matchDate.month + " / " + this.matchDate.year);
		System.out.println("Total Score : " + this.totalScore);
		System.out.println("Total Wickets : " + this.totalWickets);
	}
}


public class Main {		//Main class 
	Scanner sc = new Scanner(System.in);
	Cricketer[] players = new Cricketer[11];		//Array of Object Cricketer(players)
	ArrayList<Match> matches = new ArrayList<Match>();		//ArrayList for storing the matches : creating an empty array list
	int day,month,year;
	
	Match addMatch() {		//method for adding new match to the ArrayList-matches
		System.out.println("Adding details for match number : " + (matches.size()+1));
		int scoreOrWicket;		//if player is batsman then it will store his/her runs/score and if player is bowler then it will store wickets taken by him/her
		System.out.println("Enter match date : ");
		
		Date d = new Date(day,month,year);
//		Date d;			//->We can also do this.
		while(true){
			try {
				System.out.print("Day : ");
				day = sc.nextInt();
				System.out.print("Month : ");
				month = sc.nextInt();
				System.out.print("Year : ");
				year = sc.nextInt();
				d.setDay(day);
				d.setMonth(month);
				d.setYear(year);
				//d = new Date(day,month,year);		//->And this.
				if(d.check(day,month,year)==false)
				throw new WrongDate("WrongDate exception occurred.\n");		//throw an object of user defined exception WrongDate
				else
				break;
			} catch (WrongDate ex) {
				System.out.println(ex.getMessage());		//prints the message from WrondDate exception
				System.out.println("Enter date again : ");
			}
		}
				
		//Adding player details one by one : 
		Match m = new Match(d,players);
		int sumOfWickets = 0;
		System.out.println("Enter player details : ");
		for(int i=0;i<11;i++) {
			System.out.println("For player " + players[i].playerFirstName);
			if(players[i].rollInTeam == true) {
				System.out.print("Enter score : ");
				scoreOrWicket = sc.nextInt();
			}
			else {
				
				while (true) {
					try {
						System.out.print("Enter wickets : ");
						scoreOrWicket = sc.nextInt();
						if(scoreOrWicket<=10 && scoreOrWicket>=0 && (sumOfWickets+scoreOrWicket<=10))
						break;
						else
						throw new InvalidWicket("Total Wickets in a match should be in range from 0 to 10 :(\n");		//throw an object of userdefined exception
					} catch (InvalidWicket e) {
						System.out.println("Exception occurred : " + e.getMessage());		//prints then message from InvalidWicket object
						System.out.println("Enter wickets again : ");
					}
				}
				sumOfWickets+=scoreOrWicket;
			}
			m.addPlayerDetails(i, scoreOrWicket);
		}
		return m;		//returs the recently created match object.
	}	
	
	void displayMatchInfo() {		//method for displaying the match's info which includes match-date, total runs and total wickets.
		if(matches.size()==0){		//if ArrayList is empty 
			System.out.println("Record is empty :(\n");
			return;
		}
		
		System.out.println("Enter match number : " + "(from 1 to " + matches.size() + ")");
		int index;
		Match m1;
		do {
			//exception handling : Exception class used - ArrayIndexOutOfBoundsException
			try {		//try block
				index = sc.nextInt();
				//when user enters invalid match index(i.e less then zero or greater then total matches) then exception will be occurred.
				if(index<1 || index>matches.size())
				throw new ArrayIndexOutOfBoundsException("Exception occurred : Array index is out of Bounds :(\n");
				m1 = matches.get(index-1);
				break;
			} catch (ArrayIndexOutOfBoundsException e1) {		//catch block
				System.out.print(e1.getMessage());
				System.out.print("Please enter valid match number : ");
				
			}

		}while(true);		//do-while loop till condition fullfilled.
		m1.displayMatchInfo();		//actual method for showing match-information
	}	
	
	void displayMatchPlayerInfo() {		//method for displaying the detail of user-entered players's name according to the number. which also includes his/her scored-runs/wickets-taken in that specific match.
		if(matches.size()==0){		//if ArrayList is empty
			System.out.println("Record is empty :(\n");
			return;
		}
		
		
		System.out.println("Enter match number : " + "(from 1 to " + matches.size() + ")");
		int index;
		Match m1;
		do {
			
			try {
				index = sc.nextInt();
				
				if(index<1 || index>matches.size())
				throw new ArrayIndexOutOfBoundsException("Exception occurred : Array index is out of Bounds :(\n");
				m1 = matches.get(index-1);
				break;
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.print(e1.getMessage());
				System.out.print("Please enter valid match number : ");
				
			}
			
		}while(true);
		m1.displayPlayerDetails();		//actual display method
	}
	
	void displayPlayerInfo() {		//method for displaying the player's information. which includes details like which matches he played till now and its corrospoing date and his/her scored-runs/wickets-taken
		if(matches.size()==0){		//if Arraylist is empty
			System.out.println("Not enough records :(\n");
			return;
		}
		
		System.out.println("Enter player number : (from 1 to 11)");
		int index;
		
		while (true) {
			try {
				index = sc.nextInt();
				//Exception handling : when user enters the player number other then from 1 to 11 - Exception name : ArrayIndexOutOfBoundsException
				if(index<1 || index>11)
				throw new ArrayIndexOutOfBoundsException("Exception occurred : Array index is out of Bounds :(\n");
				Match m1;
				System.out.println("\t" + players[index-1].playerFirstName + "\t" + ((players[index-1].rollInTeam==false)? "Bowler" : "Batsman"));
				for(int i=0;i<matches.size();i++) {
					m1 = matches.get(i);
					System.out.print("\n[" + (i+1) + "] ");
					m1.matchDate.display();
					if(players[index-1].rollInTeam == false) {
						System.out.println(" Wickets : " + m1.matchInfo[index-1]);
					}
					else {
						System.out.println(" Score : " + m1.matchInfo[index-1]);
					}
				}
				break;
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.print(e1.getMessage());
				System.out.print("Please enter valid player number : ");
				
			}
		}
	}
	
	void displayPlayerTopInfo() {		//Method for displaying only top matches of the given player on the basis of his/her performance. this details includes match-date and player's scored-runs/wickets-taken
		if(matches.size()<4){		//if ArrayList has not more then 3 entries then there is no significance of showing the top 3 player information. because when there are atleast 4 matches then only we can show the top 3 matches of that player on the basis of player's performace in each match.
			System.out.println("Not enough records :(\n");
			return;
		}
		System.out.println("Enter player number : (from 1 to 11)");
		int index;
		
		while (true) {
			try {
				index = sc.nextInt();
				
				if(index<1 || index>11)
				throw new ArrayIndexOutOfBoundsException("Exception occurred : Array index is out of Bounds :(\n");
				
				break;
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.print(e1.getMessage());
				System.out.print("Please enter valid player number : ");
				
			}
		}
		
		Match m1;
		
		String[][] top3Matches = new String[matches.size()][2];
		
		//collecting data
		for(int i=0;i<matches.size();i++) {
			m1 = matches.get(i);
			top3Matches[i][0] = m1.matchDate.day + "/" + m1.matchDate.month + "/" + m1.matchDate.year;
			top3Matches[i][1] = "" + m1.matchInfo[index-1]; 
		}
		
		//sorting matches 
		for(int pick = 0;pick<matches.size();pick++) {
			for(int comp = pick+1;comp<matches.size();comp++) {
				if(Integer.parseInt(top3Matches[pick][1])<Integer.parseInt(top3Matches[comp][1])) {
					String temp1 = top3Matches[pick][1];
					top3Matches[pick][1] =top3Matches[comp][1];
					top3Matches[comp][1] = temp1;
					temp1 = top3Matches[pick][0];
					top3Matches[pick][0] =top3Matches[comp][0];
					top3Matches[comp][0] = temp1;
				}
			}
		}
		
		//display top matches of that specific player
		System.out.println("Top matches of " + players[index-1].playerFirstName + " : \nDate         " + ((players[index-1].rollInTeam==true)?" Score ":" Wickets "));
		for(int i=0;i<(3<matches.size()?3:matches.size());i++) {
			System.out.println(top3Matches[i][0] + "     " + top3Matches[i][1]);
		}
	}
	
	void topPlayers() {		//method for displaying the top 3 batsmans and top 3 bowlers from all match's data. batsman are rated on the basis of total score in all matches played and bowlers are rated on the basis of total wickets taken in all matches played.
		if(matches.size()==0){		//if ArrayList is empty
			System.out.println("Not enough records :(\n");
			return;
		}
		
		int[][] topBatsman = new int[11][2];		//2d integer array
		int[][] topBowlers = new int[11][2];		//2d integer array
		int count1=0,count2=0;
		
		//collecting the data of all players and storing it in the about arrays.
		for(int i=0;i<11;i++) {
			if(players[i].rollInTeam == true) {
				topBatsman[count1][0] = i;
				topBatsman[count1][1] = players[i].totalScore;
				count1++;
			}
			else {
				topBowlers[count2][0] = i;
				topBowlers[count2][1] = players[i].totalWicket;
				count2++;
			}
		}
		
		//sorting of batsmen
		for(int pick = 0;pick<count1;pick++) {
			for(int comp = pick+1;comp<count1;comp++) {
				if(topBatsman[pick][1] < topBatsman[comp][1]) {
					int temp = topBatsman[pick][1];
					topBatsman[pick][1] = topBatsman[comp][1];
					topBatsman[comp][1] = temp;
					temp = topBatsman[pick][0];
					topBatsman[pick][0] = topBatsman[comp][0];
					topBatsman[comp][0] = temp;
				}
			}
		}
		
		//display batsmen
		System.out.println("Batsman : \nName    Score");
		for(int i=0;i<3;i++) {
			if(i<count1)
			System.out.println(players[topBatsman[i][0]].playerFirstName + "     " + topBatsman[i][1]);
		}
			
		
		//sorting of bowler
		for(int pick = 0;pick<count2;pick++) {
			for(int comp = pick+1;comp<count2;comp++) {
				if(topBowlers[pick][1] < topBowlers[comp][1]) {
					int temp = topBowlers[pick][1];
					topBowlers[pick][1] = topBowlers[comp][1];
					topBowlers[comp][1] = temp;
					temp = topBowlers[pick][0];
					topBowlers[pick][0] = topBowlers[comp][0];
					topBowlers[comp][0] = temp;
				}
			}
		}
		
		//display bowlers
		System.out.println("Bowlers : \nName    Wickets");
		for(int i=0;i<3;i++) {
			if(i<count2)
			System.out.println(players[topBowlers[i][0]].playerFirstName + "     " + topBowlers[i][1]);
		}
		
	}
	
	public static void main(String[] args) {		//main method
		Main project = new Main();
		String name;
		boolean rollInTeam;
		
		System.out.println("Enter player details : \n");
		//userdefined players :
		for(int i=0;i<11;i++) {
			//user Input
			System.out.println("For player number : " + (i+1));
			System.out.print("Enter player name : ");
			name = project.sc.next();
			System.out.print("Roll in Team : \n[1.]Batsman (press 1)\n[2.]Bowler (press 2)\nEnter choice : ");
			int choice;
			do {
				choice = project.sc.nextInt();
				if(choice!=1 && choice!=2)
					System.out.print("Invalid Input :(\nEnter choice : ");
			}while(choice!=1 && choice!=2);
			rollInTeam = (choice==1)?true:false;	//assignes true if player is batsman otherwise false.
			project.players[i] = new Cricketer(name, rollInTeam);
		}
		 
		/*
		//pre defined sample players : 
		project.players[0] = new Cricketer("a", true);
		project.players[1] = new Cricketer("b", true);
		project.players[2] = new Cricketer("e", true);
		project.players[3] = new Cricketer("d", true);
		project.players[4] = new Cricketer("f", true);
		project.players[5] = new Cricketer("g", true);
		project.players[6] = new Cricketer("h", false);
		project.players[7] = new Cricketer("i", false);
		project.players[8] = new Cricketer("j", false);
		project.players[9] = new Cricketer("k", false);
		project.players[10] = new Cricketer("l", false);
		*/
		
		int choice = 0;
		while(choice!=7) {		//MenuDriven
			System.out.println("\nMenu : ");
			System.out.println("\n[1.] Add match");
			System.out.println("[2.] Display match information");
			System.out.println("[3.] Display match players information");
			System.out.println("[4.] Display player information (all match)");
			System.out.println("[5.] Display player information (top 3 match)");
			System.out.println("[6.] Display top 3 batsmen and bowlers");
			System.out.println("[7.] Exit");
			System.out.print("Enter Choice : ");
			choice = project.sc.nextInt();
			switch(choice) {
				case 1 :
					project.matches.add(project.addMatch());
					break;
					
				case 2 :
					project.displayMatchInfo();
					break;
					
				case 3 :
					project.displayMatchPlayerInfo();
					break;
					
				case 4 :
					project.displayPlayerInfo();
					break;
					
				case 5 :
					project.displayPlayerTopInfo();
					break;
					
				case 6 :
					project.topPlayers();
					break;
					
				case 7 :
					System.out.println("THANK YOU");
					break;
					
				default : 
					System.out.println("Invalid Choice :(");
					break;
			}
		}
		
	}

}