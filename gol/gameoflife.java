//This program is a simulation of life, taking the user through numerous journeys and fun minigames! Enjoy

import java.io.*;
class GameOfLife
{
    public static void main (String args[])
	throws java.io.IOException
    {
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String input;
	String name;
	String answer;

	System.out.println ("WELCOME TO THE GAME OF LIFE");
	System.out.println ("Enter your name");
	name = br.readLine ();

	System.out.println ("Have you played before?");
	answer = br.readLine ();
	if (answer.equalsIgnoreCase ("no")) //start of if they havent played
	{
	    Minigames mg = new Minigames (); //creates a object to call minigame
	    int skillIncreaser = 0; //allows for the skill to be increased by a value, that can change based on scenarios
	    int honourIncreaser = 0; //allows for honour to be increased by a changeable value
	    int friendIncreaser = 0; //allows for friends to be increased by a changeable value
	    int allowance = 0; //the amount of money the user gets per advancement
	    int lifeSkill = 0; //life skill level
	    int money = 0; //total money
	    int friends = 0; //total friends
	    int honour = 50; //honour level
	    String ans; //users answers
	    boolean hasPassed = false; //checks if the user passed the minigames
	    boolean validFlag = false; //checks if user has a valid input
	    int Age1passes = 0; //checks if user passes the age one games which are needed for age 2
	    int wealthPicker = (int) (Math.random () * 2) + 1; //chooses poorer or richer option
	    int childnum = (int) (Math.random () * 3) + 1; //Random num for # of children
	    boolean attemptedstealing = false; // checks if they attempted the stealing in final mission
	    // Introduction to game
	    System.out.println ("Welcome to the Game of Life");
	    System.out.println ("The following stats will be tracked: Money - Friends - Self Honour - Life Skill Level");
	    System.out.println ("You will be presented with many options or will be given scenario's based on your stats");
	    System.out.println ("NOT ALL OPTIONS REGARDING BEING A \"GOOD\" PERSON PROVIDE THE BEST OUTCOME.");
	    System.out.println ("JUST LIKE LIFE, THIS GAME IS ABOUT RISKS AND SOMETIMES DANGEROUS RISKS MAY HELP");
	    System.out.println ("If any stats dip below 0, you die");
	    System.out.println ();
	    System.out.println ();
	    System.out.println ("PROLOGUE... ");
	    System.out.println ("You will be given allowance till the age of 20, if you are born into a poor family, allowance = $10\nIf you are born into a rich family, allowance = $20");
	    System.out.println ("Enjoy");
	    if (wealthPicker == 1)
	    {
		allowance = 10; //the poorer option
		System.out.println ("Born into poor family...");
	    }
	    else if (wealthPicker == 2)
	    {
		allowance = 20; //the richer option
		System.out.println ("Born into wealthy family...");
	    }
	    do //whole game do while
	    {
		System.out.println ("");
		//Age 1 Start
		money += allowance; //adding allowance to total money
		System.out.println ("AGE ONE");
		System.out.println ("Allowance: Money +$" + allowance);
		System.out.println ("Stats: Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		hasPassed = mg.WalkingGame (); //calling the first game
		if (hasPassed == true)
		{ //start of age one checking
		    Age1passes++; //int flag to check if they pass both games
		} //start of age one checking

		hasPassed = mg.SpeakingGame ();
		if (hasPassed == true)
		{ //start of age one checking
		    Age1passes++; //int flag to check if they pass both games
		} //end of age one checking
		//end of age 1
		System.out.println ("");
		//Age 2
		money += allowance; //adding allowance to total money
		System.out.println ("AGE TWO");
		System.out.println ("Allowance: Money +$" + allowance);
		System.out.println ("Stats: Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		if (Age1passes == 2) //if they passed one of the games
		{
		    System.out.println ("You managed to learn how to walk and speak");
		}
		else if (Age1passes != 2) //if they passed both games
		{
		    System.out.println ("You couldn't learn both english and learn to walk");
		    System.out.println ("Your mom took you to tutoring -$5");
		    money -= 5;
		}

		//end of Age 2
		System.out.println ("");
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ("");

		//start of Age 5
		money += allowance;
		System.out.println ("AGE FIVE");
		System.out.println ("Allowance: Money +$" + allowance);
		System.out.println ("Stats: Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("3 kids come up to you in kindergarten, asking you to play"); //a choice upcoming
		System.out.println ("You have three options:\nA. Ignore \nB. Yes\nC. Antagonize");
		validFlag = false;
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A, B, or C");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("You decided to ignore them!");
		    System.out.println ("You made no new friends and your self honour went down\nHonour -3");
		    honour -= 3;
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You decided to play with them!");
		    System.out.println ("You made 3 new friends\nHonour +5\nFriends +3");
		    honour += 5;
		    friends += 3;
		}
		else if (ans.equalsIgnoreCase ("C"))
		{
		    System.out.println ("You decided to be mean towards them!");
		    System.out.println ("You made no new friends\nHonour -5");
		    honour -= 5;
		}
		System.out.println ("");
		System.out.println ("You are now old enough to learn how to count");
		hasPassed = mg.CountingGame ();
		if (hasPassed == true)
		{
		    System.out.println ("Great Job, you passed the counting game\nLife Skill Level+5");
		    lifeSkill += 5;
		}
		else if (hasPassed == false)
		{
		    System.out.println ("You failed the counting game, no punishment... THIS TIME");
		}
		//end of Age 5
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ("");
		//start of Age 10
		money += allowance;
		System.out.println ("AGE TEN");
		System.out.println ("Allowance: Money +$" + allowance);
		System.out.println ("Stats: Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("Rummaging in you basement, you find a treasure map that leads to treasure in your backyard\nUnsure if it's real, Do you go digging in your backyard?");
		System.out.println ("A. Yes\nB. No"); //user choice
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    hasPassed = mg.DiggingGame (); //digging game
		    if (hasPassed == false)
		    {
			System.out.println ("You have died...");
			System.out.println ("GAME OVER");
			break;
		    }
		    else if (hasPassed == true)
		    {
			System.out.println ("You found the treausre! Money +$200\n Honour +10\nLife Skill Level +10");
			money += 200;
			honour += 10;
			lifeSkill += 10;
		    }
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You decide it's not worth the risk,\nYour mom is happy with you and increases your allowance by $2");
		    allowance += 2;
		    System.out.println ("New Allowance: " + allowance);
		}
		System.out.println ("");
		System.out.println ("A group of 5 kids come to you to go out and chill with them at the mall");
		System.out.println ("Do you go out with them?\nA. Yes\nB. No");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("You decide to go out with them and have a blast!\nFriends +5\nLife Skill Level +10\nMoney -$20");
		    money -= 20;
		    lifeSkill += 10;
		    friends += 5;
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You decide stay home to study for an upcoming test\nLife Skill Level +10 ");
		    lifeSkill += 10;
		}
		System.out.println ("Your birthday is here!");
		if (friends == 0)
		{
		    System.out.println ("You have no friends and you got no money from them,\nSelf Honour -5");
		    honour -= 5;
		}
		else if (friends == 3 || friends == 5)
		{
		    System.out.println ("Your friends gave you a combined of $50 for your birthday\nMoney +$50");
		    money += 50;
		}
		else if (friends == 8)
		{
		    System.out.println ("Each of your friends gave you $10\nMoney +$80");
		    money += 80;
		}
		System.out.println ();
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		//end of Age 10

		System.out.println ("");
		//Start of Age 15
		money += allowance;
		System.out.println ("AGE FIFTEEN");
		System.out.println ("Allowance: Money +$" + allowance);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("You are walking back home from school and a stranger offers you drugs");
		System.out.println ("Do you take it?\nA. Yes\nB. No");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("Intrigued, you take the drugs, however, the seller was an undercover cop and now you are in jail for a day");
		    System.out.println ("You feel bad, your self honour goes down by 50 and you lose all your friends and money trying to get bail\nSelf Honour -50\nFriends = 0\nMoney = 0");
		    money = 0;
		    friends = 0;
		    honour -= 50;
		}
		if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You run away from the man, and go tell the cops");
		    System.out.println ("Feeling good about yourself, you gain 10 honour and the cops reward you $30\nSelf Honour +10\nMoney +$30 ");
		    honour += 10;
		    money += 30;
		}
		System.out.println ("It nearing the time where you must choose a future career");
		int career = mg.Sudoku ();
		if (career == 3) // if they got bad score
		{
		    System.out.println ("Based on your score, your future career is plumber:");
		    System.out.println ("Each advance you will recieve: +$10, +0 Life Skill Level, +10 Friends, -5 Self Honour");
		    skillIncreaser = 0; //increases life skill every advancement
		    allowance = 10; //allowance is no more, but need to use variable to add money every advance
		    friendIncreaser = 10; //increases friends per advance
		    honourIncreaser = 10; //increases honour per advance

		}
		else if (career == 2) // if the got ok score
		{
		    System.out.println ("Based on your score, your future carreer is electrician");
		    System.out.println ("Each advance you will recieve: + $15, +3 Life Skill Level, +6 Friends, +5 Self Honour");
		    skillIncreaser = 3; //increases life skill every advancement
		    allowance = 15; //allowance is no more, but need to use variable to add money every advance
		    friendIncreaser = 6; //increases friends per advance
		    honourIncreaser = 5; //increases honour per advance
		}

		else if (career == 1) // if they got a good score on minigame
		{
		    System.out.println ("Based on your score you will be working a doctor job");
		    System.out.println ("Each advance you will recieve: +$30, +5 Life Skill Level, +15 Friends, +10 Self Honour");
		    skillIncreaser = 5; //increases life skill every advancement
		    allowance = 30; //allowance is no more, but need to use variable to add money every advance
		    friendIncreaser = 15; //increases friends per advance
		    honourIncreaser = 10; //increases honour per advance
		}
		System.out.println ("You are hoping to join a team\nSoccer - Basketball - Debate - Business");
		System.out.println ("You must take the Ultimate Student Minigame to find out what team is compatible for you");
		hasPassed = mg.UltimateStudentMinigame ();
		if (hasPassed == false) // if they fail, random team
		{
		    int sportPicker = (int) (Math.random () * 4) + 1; //randomly choosing team
		    if (sportPicker == 1)
		    {
			System.out.println ("You joined the soccer team, you made 10 friends\nFriends +10");
			friends += 10;

		    }
		    else if (sportPicker == 2)
		    {
			System.out.println ("You joined the basketball team, you made 10 friends\nFriends +10");
			friends += 10;

		    }
		    else if (sportPicker == 3)
		    {
			System.out.println ("You joined the debate team, you made 5 friends and got 5 skill level points\nFriends +5\nLife Skill Level +5");
			friends += 5;
			lifeSkill += 5;

		    }
		    else if (sportPicker == 4)
		    {
			System.out.println ("You joined the buisness team, you got 5 honour and skill level\nHonour +5\nLife Skill Level +5");
			lifeSkill += 5;
			honour += 5;
		    }
		}
		else if (hasPassed == true) //if they pass, they choose their own team
		{
		    System.out.println ("Since you passed the game, you can choose your team");
		    System.out.println ("A. Soccer, B. Basketball, C. Debate, D. Business");
		    validFlag = false; //checks answer, then only can user move on
		    do //answer valid checking
		    {
			ans = br.readLine ();
			if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C") || ans.equalsIgnoreCase ("D")) //checking if valid
			{
			    validFlag = true;
			    break;
			}
			else
			{
			    System.out.println ("Invalid Input, Enter A or B");
			    validFlag = false;
			}
		    }
		    while (validFlag == false);
		    if (ans.equalsIgnoreCase ("A"))
		    {
			System.out.println ("You joined the soccer team, you made 10 friends\nFriends +10");
			friends += 10;

		    }
		    else if (ans.equalsIgnoreCase ("B"))
		    {
			System.out.println ("You joined the basketball team, you made 10 friends\nFriends +10");
			friends += 10;

		    }
		    else if (ans.equalsIgnoreCase ("C"))
		    {
			System.out.println ("You joined the debate team, you made 5 friends and got 5 skill level points\nFriends +5\nLife Skill Level +5");
			friends += 5;
			lifeSkill += 5;

		    }
		    else if (ans.equalsIgnoreCase ("D"))
		    {
			System.out.println ("You joined the buisness team, you got 5 honour and skill level\nHonour +5\nLife Skill Level +5");
			lifeSkill += 5;
			honour += 5;
		    }
		}
		System.out.println ("A Month Later");
		System.out.println ("You are in the final round of your team");
		System.out.println ("The Pressure is on YOU to win for your team");
		hasPassed = mg.WordSearch ();
		if (hasPassed == true)
		{
		    money += 200;
		    lifeSkill += 20;
		    honour += 20;
		    friends += 10;
		}
		else if (hasPassed == false)
		{
		    lifeSkill -= 20;
		    honour -= 20;
		    friends -= 10;
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		//why did you put this here and not before?
		System.out.println ("High School Over, Moving to adulthood, allowance has now stopped because you have a job");
		//end of 15
		System.out.println ();
		//Starting Age 20

		System.out.println ("AGE TWENTY");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Each Advance: Money will now go up by $" + allowance + "\nLife Skill Level will go up by " + skillIncreaser + "\nFriends will go up by " + friendIncreaser + "\nHonour will go up by " + honourIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		if (money < 250)
		{
		    System.out.println ("You are desperate for money, you decide to rob a bank...");
		    hasPassed = mg.BankRobbery_1 ();
		    if (hasPassed == true) //if user passes robbery
		    {
			System.out.println ("You walkaway from the heist with $500, - 30 honour, -20 friends, -20 life skill level");
			money += 500;
			honour -= 30;
			friends -= 20;
			lifeSkill -= 20;
		    }
		    else if (hasPassed == false) //if they fail it
		    {
			System.out.println ("You died in the heist");
			System.out.println ("GAME OVER");
			break;
		    }
		}
		System.out.println ("Your parents have kicked you out, it's time you find a house");
		System.out.println ("**Rent Per Advancement**");
		System.out.println ("Option A. Apartment(rent: -$10)\nOption B. Condo(rent: -$15)\nOption C. Basement(rent: -$20)\nD. Streets(rent: -$0/-5 self honour");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C") || ans.equalsIgnoreCase ("D")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A, B, C, or D");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("You chose Apartment, -$10 per advancement");
		    allowance -= 10; //deducting 20 dollars from allowance which deducts 20 dollars every advancement
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You chose Condo, -$15 per advancement");
		    allowance -= 15; //deducting 15 dollars from allowance which deducts 15 dollars every advancement
		}
		else if (ans.equalsIgnoreCase ("C"))
		{
		    System.out.println ("You chose Basement, -$20 per advancement");
		    allowance -= 20; //deducting 10 dollars from allowance which deducts 10 dollars every advancement
		}
		else if (ans.equalsIgnoreCase ("D"))
		{
		    System.out.println ("You chose streets, -5 self honour per advancement");
		    allowance -= 0;
		    honourIncreaser -= 5;
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ();
		//Age 20 ends
		//
		//Age 25 starts
		System.out.println ("AGE TWENTY FIVE");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		if (honour > 50 && lifeSkill > 10) //if your life skill level meets a certain range
		{
		    System.out.println ("You have been doing good so far, and your honour and life skill level have been decent");
		    System.out.println ("For this your boss has given you a promotion:\nEach advance extra +$5\nA bonus of: +20 Life Skill Level, +20 Honour, +5 friends");
		    allowance += 5;
		    lifeSkill += 20;
		    honour += 20;
		    friends += 5;
		}
		System.out.println ("You met a girl and it is time for you to start thinking about a relationship. To take her on a date, you have three restaurants in mind: ");
		//user gets a choice
		System.out.println ("Option A. Auberge du Pommier, $50 dinner");
		System.out.println ("Option B. Van Der Linde Diners $20 dinner");
		System.out.println ("Option C. Virgil's Indian Tacos $10 dinner");
		System.out.println ("Be careful when choosing, ensure you have the sufficient funds");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A, B, C");
			validFlag = false;
		    }
		}
		while (validFlag == false); //end of valid checking

		if (ans.equalsIgnoreCase ("A")) //choice 1
		{
		    money -= 50;
		    honour += 15;
		    System.out.println ("You took her to the fanciest restaurant you know! She loved it!");
		    System.out.println ("Money -50, honour +15");
		}
		else if (ans.equalsIgnoreCase ("B")) //choice 2
		{
		    money -= 20;
		    honour += 10;
		    System.out.println ("You took her to a decent restaurant, and it went alright. Could have been better though");
		    System.out.println ("Money -20, honour +10");
		}
		else if (ans.equalsIgnoreCase ("C")) //choice 3
		{
		    money -= 10;
		    honour -= 5;
		    System.out.println ("You took her to the worst restaurant in town and the food was disgusting.");
		    System.out.println ("Money -10, honour -5");
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ();

		System.out.println ("AGE THIRTY");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("You want to get married to the girl after years of interest");
		if (money >= 250) //if your money is over 250, you can buy girlfriend expensive ring
		{
		    System.out.println ("Since you have over $250, you buy a gold wedding ring!");
		    System.out.println ("Life Skill Level +30, Money -$200, Honour +30");
		    lifeSkill += 30;
		    money -= 200;
		    honour += 30;
		}
		else //if money isn't then you play lying game
		{
		    System.out.println ("You can't afford the ring, so you decide to buy a fake ring and tell your wife its expensive");
		    hasPassed = mg.LyingGame ();
		    if (hasPassed == true) //if they pass, they get away with it
		    {
			System.out.println ("You got away with your lie!");
			System.out.println ("Life Skill Level: +30, Self honour -50");
			lifeSkill += 30;
			honour -= 50;
		    }
		    else //if they don't, they don't get away with lying
		    {
			System.out.println ("You failed your lie and your wife caught you!");
			System.out.println ("Life skill level -45, Self honor -60");
			lifeSkill -= 45;
			honour -= 60;
		    }

		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0) //an extra check for stat drops
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ("You want to buy a car: ");
		if (friends > 50) //if friends are above 50, they buy car for you
		{
		    System.out.println ("Since you have so many friends, they all chip in to buy the car for you!");
		}
		else //if not, you play discount game which tell you your discount for the car
		{
		    System.out.println ("You have a chance to get a discount for the car, priced at $200");
		    int discount = mg.DiscountMinigame ();
		    int discountpercentage = discount / 100;
		    money = money - (200 - (200 * discountpercentage)); //calc. for discount of $200 car
		    System.out.println ("Car cost after discount: " + (200 - (200 * discountpercentage)));
		    System.out.println ("Money -" + (200 - (200 * discountpercentage)));
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ();
		System.out.println ("AGE THIRTY FIVE");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("You and wife want to have kids --> 33% chance of having either 1 kid, 2 kids, or three kids...");
		if (childnum == 1) //if randompicker chooses 1, then you have 1 kid, if 2, then 2 kids. If 3, then 3 kids
		{
		    System.out.println ("You and your wide ended up having 1 kid! You will now get $10 per advancement");
		    allowance += 10;
		}
		else if (childnum == 2)
		{
		    System.out.println ("You and your wide ended up having 2 kids! You will now get $20 per advancement");
		    allowance += 20;
		}
		else if (childnum == 3)
		{
		    System.out.println ("You and your wide ended up having 3 kids! You will now get $30 per advancement");
		    allowance += 30;
		}
		System.out.println ();
		System.out.println ("AGE FOURTY");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("Now that you have a whole family... Its time to move out.");
		System.out.println ("Option A. 2 bedroom house  -$25 per advancement to pay off loan");
		System.out.println ("Option B. 3 bedroom house - $30 per advancement to pay off loan, +5 life skill level");
		System.out.println ("Option C. 4 bedroom house - $40 per advancement to pay off loan, +10 life skill level");
		System.out.println ("Be careful when choosing, ensure you have the sufficient funds");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A, B, C");
			validFlag = false;
		    }
		}
		while (validFlag == false);

		if (ans.equalsIgnoreCase ("A")) //different choices, based on type of house
		{
		    allowance -= 25;
		    System.out.println ("2 Bedroom House!");
		    System.out.println ("Money -25 per advance");
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    allowance -= 30;
		    lifeSkill += 5;
		    System.out.println ("3 Bedroom House!");
		    System.out.println ("Money -$30 per advance, +5 Life Skill Level");
		}
		else if (ans.equalsIgnoreCase ("C"))
		{
		    allowance -= 40;
		    lifeSkill += 10;
		    System.out.println ("4 Bedroom House!");
		    System.out.println ("Money -$40 per advance, +10 Life Skill Level");
		}

		System.out.println ("You plan to go fishing with your friends to take sometime off");
		System.out.println ("However, your boss calls telling you they need assistance at this moment");
		System.out.println ("Option A. Go fishing");
		System.out.println ("Option B. Go to work");

		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);

		if (ans.equalsIgnoreCase ("A")) //if user goes fishing
		{
		    friends += 5;
		    lifeSkill += 5;
		    money -= 20;
		    honour += 5;
		    System.out.println ("You decide to go fishing! You have a blast and even spend some money while playing around!");
		    System.out.println ("+5 Friends, +5 Life Skill Level, - $20, +5 Honour");
		}
		else if (ans.equalsIgnoreCase ("B")) //if user goes to work
		{
		    friends -= 5;
		    lifeSkill += 5;
		    money += 40;
		    honour += 10;
		    System.out.println ("You decide to go to work! Your boss is pleased and gives you extra money!");
		    System.out.println ("-5 friends, +5 Life Skill Level, + $40, + 10 Honor");
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ("Your feeling low because of aging... Your life has gone by so quickly!");
		System.out.println ("You decide to go racing with your friend");
		System.out.println ("He challenges you to a race for $50");
		hasPassed = mg.Wordle ();
		if (hasPassed == true) //if you win minigame
		{
		    System.out.println ("You guessed the word!\nYou beat your friend in the race!\n+$50\n+20 Self Honour\n+10 Life Skill Level");
		    money += 50;
		    honour += 20;
		    lifeSkill += 10;
		}
		else //if you lose
		{
		    System.out.println ("GAME OVER! You got into a FATAL car accident while driving, resulting in your death!");
		    break;
		}
		System.out.println ();
		System.out.println ("AGE FOURTY FIVE");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("You want to retire soon and your kids are incredibly gifted at such a young age.");
		System.out.println ("They have a chance to be something big, and have recieved the chance of a life time from one of the most prestigious schools in the world... BUT, its way too costly and out of your budget");
		System.out.println ("Your descision: There is a museum called the Louvre Museum holding the most famous pieces of art and you know some people who can help you... STEAL IT");
		System.out.println ("OR you can miss out on this chance for your kids and let them grow and pay for university...");
		System.out.println ("Your call:");
		System.out.println ("Option A. The Big Heist");
		System.out.println ("Option B. Leave it to your kids");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);

		if (ans.equalsIgnoreCase ("A")) //if they choose to do robbery
		{
		    int success = mg.WhoWantsToBeAMillionaire ();
		    attemptedstealing = true;
		    if (success == 3) //if user gets a high score in the millionaire game, they get the highest prize
		    {
			attemptedstealing = true;
			money += 1000;
			lifeSkill += 30;
			honour -= 50;
			System.out.println ("You successfully stole: Monalisa, The Coronation of Napoleon, and The Raft of the Medusa");
			System.out.println ("+$1000");
			System.out.println ("Life Skill level +30");
			System.out.println ("Self Honour -50");
		    }
		    else if (success == 2) //second best prize
		    {
			money += 500;
			lifeSkill += 15;
			honour -= 50;
			System.out.println ("You successfully stole: Monalisa and The Raft of the Medusa");
			System.out.println ("+$500");
			System.out.println ("Life Skill level +15");
			System.out.println ("Self Honour -50");
		    }
		    else if (success == 1) //lowest prize
		    {
			money += 250;
			lifeSkill += 10;
			honour -= 50;
			System.out.println ("You successfully stole: The Raft of the Medusa");
			System.out.println ("+$250");
			System.out.println ("Life Skill level +10");
			System.out.println ("Self Honour -50");
		    }
		    else //if anything less, they die
		    {
			System.out.println ("You died during the robbery... GAME OVER");
			break;
		    }
		}
		else if (ans.equalsIgnoreCase ("B")) //if they don't do the robbery
		{
		    System.out.println ("You realize that being a criminal is a terrible thing and at this age it shouldn't even be an option. You let your kids grow and think about university.");
		    System.out.println ("+50 Honour, +50 Life Skill Level");
		    honour += 50;
		    lifeSkill += 50;
		}

		System.out.println ();
		System.out.println ("AGE FIFTY"); //last level, ending it off
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("EPILOGUE...");
		System.out.println ("Well, this is it. You worked your last day, and you made it.");
		System.out.println ("Your house is paid off, and life is now a journey of emotions rather than work");
		System.out.println ("Age 50, the end of a exciting life...");

		if (attemptedstealing == true) //if the user decided to rob bank
		{
		    System.out.println ("You still think about the robbery 5 years ago... was it a good choice? Stealing from the innocent for personal gain");
		    System.out.println ("That is for you to decide.");
		    System.out.println ("Your kids are extremely succesful and you still have lots of money left after everything");
		    System.out.println ("There is good and there is bad, but somewhere in between there is life...");
		}
		else //if they did not
		{
		    System.out.println ("You think to yourself everyday, what if you stole from the museum?");
		    System.out.println ("That is for you to decide.");
		    System.out.println ("Your wife is proud of you, your kids got a scholarship and are successful");
		    System.out.println ("There is good and there is bad, but somewhere in between there is life...");
		}
		break; //exit game once reached age 50



	    } //end of whole game do while
	    while (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0 || hasPassed == false);
	    System.out.println ("Good Game");
	    System.out.println ("84|104|97|110|107|115|32|102|111|114|32|112|108|97|121|105|110|103");
	    double score = (money + honour + friends + lifeSkill) / 4;
	    System.out.println ("Final Score: " + score);



	    //END OF GAME


	    //writing all neccesary info to file so that the user, can see thier old score the next time they play
	    FileWriter fw = new FileWriter (name + ".txt");
	    fw.write (score + "\r\n");
	    fw.write (money + "\r\n");
	    fw.write (friends + "\r\n");
	    fw.write (honour + "\r\n");
	    fw.write (lifeSkill + "\r\n");
	    fw.close ();
	} //end of if they havent played before

	else if (answer.equalsIgnoreCase ("yes")) //start of if they have played before
	{
	    FileReader fr = new FileReader (name + ".txt");
	    BufferedReader bfr = new BufferedReader (fr);
	    int FRmoney, FRfriends, FRlifeSkill, FRhonour; //reading in the users, score if they have played before
	    double FRscore; //values written in
	    input = bfr.readLine ();
	    FRscore = Double.parseDouble (input);
	    System.out.println ("Your score from your previous game: " + FRscore);

	    input = bfr.readLine ();
	    FRmoney = Integer.parseInt (input);
	    System.out.println ("Your money from your previous game: " + FRmoney);

	    input = bfr.readLine ();
	    FRfriends = Integer.parseInt (input);
	    System.out.println ("Your friends from your previous game: " + FRfriends);

	    input = bfr.readLine ();
	    FRhonour = Integer.parseInt (input);
	    System.out.println ("Your honour from your previous game: " + FRhonour);

	    input = bfr.readLine ();
	    FRlifeSkill = Integer.parseInt (input);
	    System.out.println ("Your life skill level from your previous game: " + FRlifeSkill);
	    fr.close (); //closing file reading


	    Minigames mg = new Minigames ();
	    int skillIncreaser = 0; //allows for the skill to be increased by a value, that can change based on scenarios
	    int honourIncreaser = 0; //allows for honour to be increased by a changeable value
	    int friendIncreaser = 0; //allows for friends to be increased by a changeable value
	    int allowance = 0; //the amount of money the user gets per advancement
	    int lifeSkill = 0; //life skill level
	    int money = 0; //total money
	    int friends = 0; //total friends
	    int honour = 50; //honour level
	    String ans; //users answers
	    boolean hasPassed = false; //checks if the user passed the minigames
	    boolean validFlag = false; //checks if user has a valid input
	    int Age1passes = 0; //checks if user passes the age one games which are needed for age 2
	    int wealthPicker = (int) (Math.random () * 2) + 1; //chooses poorer or richer option
	    int childnum = (int) (Math.random () * 3) + 1;
	    boolean attemptedstealing = false;
	    System.out.println ("Welcome to the Game of Life(REPLAY)");
	    System.out.println ("The following stats will be tracked: Money - Friends - Self Honour - Life Skill Level");
	    System.out.println ("You will be presented with many options or will be given scenario's based on your stats");
	    System.out.println ("NOT ALL OPTIONS REGARDING BEING A \"GOOD\" PERSON PROVIDE THE BEST OUTCOME.");
	    System.out.println ("JUST LIKE LIFE, THIS GAME IS ABOUT RISKS AND SOMETIMES DANGEROUS RISKS MAY HELP");
	    System.out.println ("If any stats dip below 0, you die");
	    System.out.println ();
	    System.out.println ();
	    System.out.println ("PROLOGUE... ");
	    System.out.println ("You will be given allowance till the age of 20, if you are born into a poor family, allowance = $10\nIf you are born into a rich family, allowance = $20");
	    System.out.println ("Enjoy");
	    if (wealthPicker == 1)
	    {
		allowance = 10; //the poorer option
		System.out.println ("Born into poor family...");
	    }
	    else if (wealthPicker == 2)
	    {
		allowance = 20; //the richer option
		System.out.println ("Born into wealthy family...");
	    }
	    do //whole game do while
	    {
		System.out.println ("");
		//Age 1 Start
		money += allowance; //adding allowance to total money
		System.out.println ("AGE ONE");
		System.out.println ("Allowance: Money +" + allowance);
		System.out.println ("Stats: Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		hasPassed = mg.WalkingGame (); //calling the first game
		if (hasPassed == true)
		{ //start of age one checking
		    Age1passes++; //int flag to check if they pass both games
		} //start of age one checking
		hasPassed = mg.SpeakingGame ();
		if (hasPassed == true)
		{ //start of age one checking
		    Age1passes++; //int flag to check if they pass both games
		} //end of age one checking
		//end of age 1
		System.out.println ("");
		//Age 2
		money += allowance; //adding allowance to total money
		System.out.println ("AGE TWO");
		System.out.println ("Allowance: Money +" + allowance);
		System.out.println ("Stats: Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		if (Age1passes == 2) //if they passed one of the games
		{
		    System.out.println ("You managed to learn how to walk and speak");
		}
		else if (Age1passes != 2) //if they passed both games
		{
		    System.out.println ("You couldn't learn both english and learn to walk");
		    System.out.println ("Your mom took you to tutoring -$5");
		    money -= 5;
		}

		//end of Age 2
		System.out.println ("");
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ("");

		//start of Age 5
		money += allowance;
		System.out.println ("AGE FIVE");
		System.out.println ("Allowance: Money +" + allowance);
		System.out.println ("Stats: Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("3 kids come up to you in kindergarten, asking you to play"); //a choice upcoming
		System.out.println ("You have three options:\nA. Ignore \nB. Yes\nC. Antagonize");
		validFlag = false;
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A, B, or C");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("You decided to ignore them!");
		    System.out.println ("You made no new friends and your self honour went down\nHonour -3");
		    honour -= 3;
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You decided to play with them!");
		    System.out.println ("You made 3 new friends\nHonour +5\nFriends +3");
		    honour += 5;
		    friends += 3;
		}
		else if (ans.equalsIgnoreCase ("C"))
		{
		    System.out.println ("You decided to be mean towards them!");
		    System.out.println ("You made no new friends\nHonour -5");
		    honour -= 5;
		}
		System.out.println ("");
		System.out.println ("You are now old enough to learn how to count");
		hasPassed = mg.CountingGame ();
		if (hasPassed == true)
		{
		    System.out.println ("Great Job, you passed the counting game\nLife Skill Level+5");
		    lifeSkill += 5;
		}
		else if (hasPassed == false)
		{
		    System.out.println ("You failed the counting game, no punishment... THIS TIME");
		}
		//end of Age 5
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ("");
		//start of Age 10
		money += allowance;
		System.out.println ("AGE TEN");
		System.out.println ("Allowance: Money +" + allowance);
		System.out.println ("Stats: Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("Rummaging in you basement, you find a treasure map that leads to treasure in your backyard\nUnsure if it's real, Do you go digging in your backyard?");
		System.out.println ("A. Yes\nB. No"); //user choice
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    hasPassed = mg.DiggingGame (); //digging game
		    if (hasPassed == false)
		    {
			System.out.println ("You have died...");
			System.out.println ("GAME OVER");
			break;
		    }
		    else if (hasPassed == true)
		    {
			System.out.println ("You found the treausre! Money +$200\n Honour +10\nLife Skill Level +10");
			money += 200;
			honour += 10;
			lifeSkill += 10;
		    }
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You decide it's not worth the risk,\nYour mom is happy with you and increases your allowance by $2");
		    allowance += 2;
		    System.out.println ("New Allowance: " + allowance);
		}
		System.out.println ("");
		System.out.println ("A group of 5 kids come to you to go out and chill with them at the mall");
		System.out.println ("Do you go out with them?\nA. Yes\nB. No");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("You decide to go out with them and have a blast!\nFriends +5\nLife Skill Level +10\nMoney -$20");
		    money -= 20;
		    lifeSkill += 10;
		    friends += 5;
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You decide stay home to study for an upcoming test\nLife Skill Level +10 ");
		    lifeSkill += 10;
		}
		System.out.println ("Your birthday is here!");
		if (friends == 0)
		{
		    System.out.println ("You have no friends and you got no money from them,\nSelf Honour -5");
		    honour -= 5;
		}
		else if (friends == 3 || friends == 5)
		{
		    System.out.println ("Your friends gave you a combined of $50 for your birthday\nMoney +$50");
		    money += 50;
		}
		else if (friends == 8)
		{
		    System.out.println ("Each of your friends gave you $10\nMoney +$80");
		    money += 80;
		}
		System.out.println ();
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		//end of Age 10

		System.out.println ("");
		//Start of Age 15
		money += allowance;
		System.out.println ("AGE FIFTEEN");
		System.out.println ("Allowance: Money +$" + allowance);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("You are walking back home from school and a stranger offers you drugs");
		System.out.println ("Do you take it?\nA. Yes\nB. No");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("Intrigued, you take the drugs, however, the seller was an undercover cop and now you are in jail for a day");
		    System.out.println ("You feel bad, your self honour goes down by 50 and you lose all your friends and money trying to get bail\nSelf Honour -50\nFriends = 0\nMoney = 0");
		    money = 0;
		    friends = 0;
		    honour -= 50;
		}
		if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You run away from the man, and go tell the cops");
		    System.out.println ("Feeling good about yourself, you gain 10 honour and the cops reward you $30\nSelf Honour +10\nMoney +$30 ");
		    honour += 10;
		    money += 30;
		}
		System.out.println ("It nearing the time where you must choose a future career");
		int career = mg.Sudoku ();
		if (career == 3) // if they got bad score
		{
		    System.out.println ("Based on your score, your future career is plumber:");
		    System.out.println ("Each advance you will recieve: +$10, +0 Life Skill Level, +10 Friends, -5 Self Honour");
		    skillIncreaser = 0; //increases life skill every advancement
		    allowance = 10; //allowance is no more, but need to use variable to add money every advance
		    friendIncreaser = 10; //increases friends per advance
		    honourIncreaser = 10; //increases honour per advance

		}
		else if (career == 2) // if the got ok score
		{
		    System.out.println ("Based on your score, your future carreer is electrician");
		    System.out.println ("Each advance you will recieve: + $15, +3 Life Skill Level, +6 Friends, +5 Self Honour");
		    skillIncreaser = 3; //increases life skill every advancement
		    allowance = 15; //allowance is no more, but need to use variable to add money every advance
		    friendIncreaser = 6; //increases friends per advance
		    honourIncreaser = 5; //increases honour per advance
		}

		else if (career == 1) // if they got a good score on minigame
		{
		    System.out.println ("Based on your score you will be working a doctor job");
		    System.out.println ("Each advance you will recieve: +$30, +5 Life Skill Level, +15 Friends, +10 Self Honour");
		    skillIncreaser = 5; //increases life skill every advancement
		    allowance = 30; //allowance is no more, but need to use variable to add money every advance
		    friendIncreaser = 15; //increases friends per advance
		    honourIncreaser = 10; //increases honour per advance
		}
		System.out.println ("You are hoping to join a team\nSoccer - Basketball - Debate - Business");
		System.out.println ("You must take the Ultimate Student Minigame to find out what team is compatible for you");
		hasPassed = mg.UltimateStudentMinigame ();
		if (hasPassed == false) // if they fail, random team
		{
		    int sportPicker = (int) (Math.random () * 4) + 1; //randomly choosing team
		    if (sportPicker == 1)
		    {
			System.out.println ("You joined the soccer team, you made 10 friends\nFriends +10");
			friends += 10;

		    }
		    else if (sportPicker == 2)
		    {
			System.out.println ("You joined the basketball team, you made 10 friends\nFriends +10");
			friends += 10;

		    }
		    else if (sportPicker == 3)
		    {
			System.out.println ("You joined the debate team, you made 5 friends and got 5 skill level points\nFriends +5\nLife Skill Level +5");
			friends += 5;
			lifeSkill += 5;

		    }
		    else if (sportPicker == 4)
		    {
			System.out.println ("You joined the buisness team, you got 5 honour and skill level\nHonour +5\nLife Skill Level +5");
			lifeSkill += 5;
			honour += 5;
		    }
		}
		else if (hasPassed == true) //if they pass, they choose their own team
		{
		    System.out.println ("Since you passed the game, you can choose your team");
		    System.out.println ("A. Soccer, B. Basketball, C. Debate, D. Business");
		    validFlag = false; //checks answer, then only can user move on
		    do //answer valid checking
		    {
			ans = br.readLine ();
			if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C") || ans.equalsIgnoreCase ("D")) //checking if valid
			{
			    validFlag = true;
			    break;
			}
			else
			{
			    System.out.println ("Invalid Input, Enter A or B");
			    validFlag = false;
			}
		    }
		    while (validFlag == false);
		    if (ans.equalsIgnoreCase ("A"))
		    {
			System.out.println ("You joined the soccer team, you made 10 friends\nFriends +10");
			friends += 10;

		    }
		    else if (ans.equalsIgnoreCase ("B"))
		    {
			System.out.println ("You joined the basketball team, you made 10 friends\nFriends +10");
			friends += 10;

		    }
		    else if (ans.equalsIgnoreCase ("C"))
		    {
			System.out.println ("You joined the debate team, you made 5 friends and got 5 skill level points\nFriends +5\nLife Skill Level +5");
			friends += 5;
			lifeSkill += 5;

		    }
		    else if (ans.equalsIgnoreCase ("D"))
		    {
			System.out.println ("You joined the buisness team, you got 5 honour and skill level\nHonour +5\nLife Skill Level +5");
			lifeSkill += 5;
			honour += 5;
		    }
		}
		System.out.println ("A Month Later");
		System.out.println ("You are in the final round of your team");
		System.out.println ("The Pressure is on YOU to win for your team");
		hasPassed = mg.WordSearch ();
		if (hasPassed == true)
		{
		    money += 200;
		    lifeSkill += 20;
		    honour += 20;
		    friends += 10;
		}
		else if (hasPassed == false)
		{
		    lifeSkill -= 20;
		    honour -= 20;
		    friends -= 10;
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}

		System.out.println ("High School Over, Moving to adulthood, allowance has now stopped because you have a job");
		//end of 15
		System.out.println ();
		//Starting Age 20

		System.out.println ("AGE TWENTY");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Each Advance: Money will now go up by $" + allowance + "\nLife Skill Level will go up by " + skillIncreaser + "\nFriends will go up by " + friendIncreaser + "\nHonour will go up by " + honourIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		if (money < 250)
		{
		    System.out.println ("You are desperate for money, you decide to rob a bank...");
		    hasPassed = mg.BankRobbery_1 ();
		    if (hasPassed == true)
		    {
			System.out.println ("You walkaway from the heist with $500, - 30 honour, -20 friends, -20 life skill level");
			money += 500;
			honour -= 30;
			friends -= 20;
			lifeSkill -= 20;
		    }
		    else if (hasPassed == false)
		    {
			System.out.println ("You died in the heist");
			System.out.println ("GAME OVER");
			break;
		    }
		}
		System.out.println ("Your parents have kicked you out, it's time you find a house");
		System.out.println ("**Rent Per Advancement**");
		System.out.println ("Option A. Apartment(rent: -$10)\nOption B. Condo(rent: -$15)\nOption C. Basement(rent: -$20)\nD. Streets(rent: -$0/-5 self honour");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C") || ans.equalsIgnoreCase ("D")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A, B, C, or D");
			validFlag = false;
		    }
		}
		while (validFlag == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("You chose Apartment, -$20 per advancement");
		    allowance -= 20; //deducting 20 dollars from allowance which deducts 20 dollars every advancement
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You chose Condo, -$15 per advancement");
		    allowance -= 15; //deducting 15 dollars from allowance which deducts 15 dollars every advancement
		}
		else if (ans.equalsIgnoreCase ("C"))
		{
		    System.out.println ("You chose Basement, -$10 per advancement");
		    allowance -= 10; //deducting 10 dollars from allowance which deducts 10 dollars every advancement
		}
		else if (ans.equalsIgnoreCase ("D"))
		{
		    System.out.println ("You chose streets, -5 self honour per advancement");
		    allowance -= 0;
		    honourIncreaser -= 5;
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		//Age 20 ends
		//
		//Age 25 starts
		System.out.println ();
		System.out.println ("AGE TWENTY FIVE");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		if (honour > 50 && lifeSkill > 10)
		{
		    System.out.println ("You have been doing good so far, and your honour and life skill level have been decent");
		    System.out.println ("For this your boss has given you a promotion:\nEach advance extra +$5\nA bonus of: +20 Life Skill Level, +20 Honour, +5 friends");
		    allowance += 5;
		    lifeSkill += 20;
		    honour += 20;
		    friends += 5;
		}
		System.out.println ("You met a girl and it is time for you to start thinking about a relationship. To take her on a date, you have three restaurants in mind: ");

		System.out.println ("Option A. Auberge du Pommier, $50 dinner");
		System.out.println ("Option B. Van Der Linde Diners $20 dinner");
		System.out.println ("Option C. Virgil's Indian Tacos $10 dinner");
		System.out.println ("Be careful when choosing, ensure you have the sufficient funds");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A, B, C");
			validFlag = false;
		    }
		}
		while (validFlag == false);

		if (ans.equalsIgnoreCase ("A"))
		{
		    money -= 50;
		    honour += 15;
		    System.out.println ("You took her to the fanciest restaurant you know! She loved it!");
		    System.out.println ("Money -50, honour +15");
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    money -= 20;
		    honour += 10;
		    System.out.println ("You took her to a decent restaurant, and it went alright. Could have been better though");
		    System.out.println ("Money -20, honour +10");
		}
		else if (ans.equalsIgnoreCase ("C"))
		{
		    money -= 10;
		    honour -= 5;
		    System.out.println ("You took her to the worst restaurant in town and the food was disgusting.");
		    System.out.println ("Money -10, honour -5");
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ();
		System.out.println ("AGE THIRTY");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("You want to get married to the girl after years of interest");
		if (money >= 250)
		{
		    System.out.println ("Since you have over $250, you buy a gold wedding ring!");
		    System.out.println ("Life Skill Level +30, Money -$200, Honour +30");
		    lifeSkill += 30;
		    money -= 200;
		    honour += 30;
		}
		else
		{
		    System.out.println ("You can't afford the ring, so you decide to buy a fake ring and tell your wife its expensive");
		    hasPassed = mg.LyingGame ();
		    if (hasPassed == true)
		    {
			System.out.println ("You got away with your lie!");
			System.out.println ("Life Skill Level: +30, Self honour -50");
			lifeSkill += 30;
			honour -= 50;
		    }
		    else
		    {
			System.out.println ("You failed your lie and your wife caught you!");
			System.out.println ("Life skill level -45, Self honor -60");
			lifeSkill -= 45;
			honour -= 60;
		    }

		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ("You want to buy a car: ");
		if (friends > 50)
		{
		    System.out.println ("Since you have so many friends, they all chip in to buy the car for you!");
		}
		else
		{
		    System.out.println ("You have a chance to get a discount for the car, priced at $200");
		    int discount = mg.DiscountMinigame ();
		    int discountpercentage = discount / 100;
		    money = money - (200 - (200 * discountpercentage));
		    System.out.println ("Car cost after discount: " + (200 - (200 * discountpercentage)));
		    System.out.println ("Money -" + (200 - (200 * discountpercentage)));
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ();
		System.out.println ("AGE THIRTY FIVE");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("You and wife want to have kids --> 33% chance of having either 1 kid, 2 kids, or three kids...");
		if (childnum == 1)
		{
		    System.out.println ("You and your wide ended up having 1 kid! You will now get $10 per advancement");
		    allowance += 10;
		}
		else if (childnum == 2)
		{
		    System.out.println ("You and your wide ended up having 2 kids! You will now get $20 per advancement");
		    allowance += 20;
		}
		else if (childnum == 3)
		{
		    System.out.println ("You and your wide ended up having 3 kids! You will now get $30 per advancement");
		    allowance += 30;
		}
		System.out.println ();
		System.out.println ("AGE FOURTY");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("Now that you have a whole family... Its time to move out.");
		System.out.println ("Option A. 2 bedroom house  -$25 per advancement to pay off loan");
		System.out.println ("Option B. 3 bedroom house - $30 per advancement to pay off loan, +5 life skill level");
		System.out.println ("Option C. 4 bedroom house - $40 per advancement to pay off loan, +10 life skill level");
		System.out.println ("Be careful when choosing, ensure you have the sufficient funds");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A, B, C");
			validFlag = false;
		    }
		}
		while (validFlag == false);

		if (ans.equalsIgnoreCase ("A"))
		{
		    allowance -= 25;
		    System.out.println ("2 Bedroom House!");
		    System.out.println ("Money -25 per advance");
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    allowance -= 30;
		    lifeSkill += 5;
		    System.out.println ("3 Bedroom House!");
		    System.out.println ("Money -$30 per advance, +5 Life Skill Level");
		}
		else if (ans.equalsIgnoreCase ("C"))
		{
		    allowance -= 40;
		    lifeSkill += 10;
		    System.out.println ("4 Bedroom House!");
		    System.out.println ("Money -$40 per advance, +10 Life Skill Level");
		}

		System.out.println ("You plan to go fishing with your friends to take sometime off");
		System.out.println ("However, your boss calls telling you they need assistance at this moment");
		System.out.println ("Option A. Go fishing");
		System.out.println ("Option B. Go to work");

		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);

		if (ans.equalsIgnoreCase ("A"))
		{
		    friends += 5;
		    lifeSkill += 5;
		    money -= 20;
		    honour += 5;
		    System.out.println ("You decide to go fishing! You have a blast and even spend some money while playing around!");
		    System.out.println ("+5 Friends, +5 Life Skill Level, - $20, +5 Honour");
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    friends -= 5;
		    lifeSkill += 5;
		    money += 40;
		    honour += 10;
		    System.out.println ("You decide to go to work! Your boss is pleased and gives you extra money!");
		    System.out.println ("-5 friends, +5 Life Skill Level, + $40, + 10 Honor");
		}
		if (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0)
		{
		    System.out.println ("Uh Oh");
		    System.out.println ("One of your stats dropped below 0, and you died");
		    System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		    System.out.println ("GAME OVER");
		    break;
		}
		System.out.println ("Your feeling low because of aging... Your life has gone by so quickly!");
		System.out.println ("You decide to go racing with your friend");
		System.out.println ("He challenges you to a race for $50");
		hasPassed = mg.Wordle ();
		if (hasPassed == true)
		{
		    System.out.println ("You guessed the word!\nYou beat your friend in the race!\n+$50\n+20 Self Honour\n+10 Life Skill Level");
		    money += 50;
		    honour += 20;
		    lifeSkill += 10;
		}
		else
		{
		    System.out.println ("GAME OVER! You got into a FATAL car accident while driving, resulting in your death!");
		    break;
		}
		System.out.println ();
		System.out.println ("AGE FOURTY FIVE");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("You want to retire soon and your kids are incredibly gifted at such a young age.");
		System.out.println ("They have a chance to be something big, and have recieved the chance of a life time from one of the most prestigious schools in the world... BUT, its way too costly and out of your budget");
		System.out.println ("Your descision: There is a museum called the Louvre Museum holding the most famous pieces of art and you know some people who can help you... STEAL IT");
		System.out.println ("OR you can miss out on this chance for your kids and let them grow and pay for university...");
		System.out.println ("Your call:");
		System.out.println ("Option A. The Big Heist");
		System.out.println ("Option B. Leave it to your kids");
		validFlag = false; //checks answer, then only can user move on
		do //answer valid checking
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //checking if valid
		    {
			validFlag = true;
			break;
		    }
		    else
		    {
			System.out.println ("Invalid Input, Enter A or B");
			validFlag = false;
		    }
		}
		while (validFlag == false);

		if (ans.equalsIgnoreCase ("A"))
		{
		    int success = mg.WhoWantsToBeAMillionaire ();
		    attemptedstealing = true;
		    if (success == 3)
		    {
			attemptedstealing = true;
			money += 1000;
			lifeSkill += 30;
			honour -= 50;
			System.out.println ("You successfully stole: Monalisa, The Coronation of Napoleon, and The Raft of the Medusa");
			System.out.println ("+$1000");
			System.out.println ("Life Skill level +30");
			System.out.println ("Self Honour -50");
		    }
		    else if (success == 2)
		    {
			money += 500;
			lifeSkill += 15;
			honour -= 50;
			System.out.println ("You successfully stole: Monalisa and The Raft of the Medusa");
			System.out.println ("+$500");
			System.out.println ("Life Skill level +15");
			System.out.println ("Self Honour -50");
		    }
		    else if (success == 1)
		    {
			money += 250;
			lifeSkill += 10;
			honour -= 50;
			System.out.println ("You successfully stole: The Raft of the Medusa");
			System.out.println ("+$250");
			System.out.println ("Life Skill level +10");
			System.out.println ("Self Honour -50");
		    }
		    else
		    {
			System.out.println ("You died during the robbery... GAME OVER");
			break;
		    }
		}
		else if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("You realize that being a criminal is a terrible thing and at this age it shouldn't even be an option. You let your kids grow and think about university.");
		    System.out.println ("+50 Honour, +50 Life Skill Level");
		    honour += 50;
		    lifeSkill += 50;
		}
		System.out.println ();
		System.out.println ("AGE FIFTY");
		money += allowance;
		lifeSkill += skillIncreaser;
		friends += friendIncreaser;
		honour += honourIncreaser;
		System.out.println ("Salary: Money +$" + allowance + "\nFriends +" + friendIncreaser + "\nHonour +" + honourIncreaser + "\nLife Skill Level +" + skillIncreaser);
		System.out.println ("Stats - Money: " + money + ", Friends: " + friends + ", Life Skill: " + lifeSkill + ", Honour: " + honour);
		System.out.println ("EPILOGUE...");
		System.out.println ("Well, this is it. You worked your last day, and you made it.");
		System.out.println ("Your house is paid off, and life is now a journey of emotions rather than work");
		System.out.println ("Age 50, the end of a exciting life...");

		if (attemptedstealing == true)
		{
		    System.out.println ("You still think about the robbery 5 years ago... was it a good choice? Stealing from the innocent for personal gain");
		    System.out.println ("That is for you to decide.");
		    System.out.println ("Your kids are extremely succesful and you still have lots of money left after everything");
		    System.out.println ("There is good and there is bad, but somewhere in between there is life...");
		}
		else
		{
		    System.out.println ("You think to yourself everyday, what if you stole from the museum?");
		    System.out.println ("That is for you to decide.");
		    System.out.println ("Your wife is proud of you, your kids got a scholarship and are successful");
		    System.out.println ("There is good and there is bad, but somewhere in between there is life...");
		}
		break;



	    } //end of whole game do while
	    while (money < 0 || friends < 0 || honour < 0 || lifeSkill < 0 || hasPassed == false);
	    System.out.println ();
	    System.out.println ("Good Game");
	    System.out.println ("84|104|97|110|107|115|32|102|111|114|32|112|108|97|121|105|110|103");
	    double score = (money + honour + friends + lifeSkill) / 4;
	    System.out.println ("Final Score: " + score);

	    FileWriter fw = new FileWriter (name + ".txt");
	    fw.write (score + "\r\n");
	    fw.write (money + "\r\n");
	    fw.write (friends + "\r\n");
	    fw.write (honour + "\r\n");
	    fw.write (lifeSkill + "\r\n");
	    fw.close ();
	}
    } //end of main
} //end of class

class Minigames
{
    boolean hasPassed = false; //delete has passed from the minigames
    //make +, - for stats
    //print the increases each time
    //Check over millionaire
    //Ensure that stats are being increased in main only(like no printing)
    // MAKING SURE THE CODE WORK --> Walking and speaking game
    //when stating stats add a checker if under 0
    boolean WalkingGame ()
	throws java.io.IOException
    {
	System.out.println ();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	int balanceLeft = 0; //Variable to display the % of balance on left side
	int balanceRight = 0; //Variable to display the % of balance on right side
	String answer;
	hasPassed = false;
	System.out.println ("You are learning to WALK and want to get to the other side of the room: ");
	for (int count = 1 ; count <= 5 ; count++)
	{
	    balanceRight = (int) (Math.random () * 99) + 1; // Gets a random number from 1-99(not 100% since complete balance on one side means you've already fallen over)
	    do
	    {
		balanceLeft = (int) (Math.random () * 100) + 1; //randoom num from 1- 100
		if (balanceLeft + balanceRight == 100) //finds the number to make it a 100%
		{
		    break;
		}
	    }
	    while (balanceLeft + balanceRight != 100);
	    do
	    {
		System.out.println ("You have " + balanceRight + "% balance on your rightfoot and " + balanceLeft + "% balance on your left foot\nWhich way do you lean to not fall?[Pick \"Left\" or \"Right\"]"); //prints question
		answer = br.readLine ();
		if (!answer.equalsIgnoreCase ("Left") && !answer.equalsIgnoreCase ("Right")) // checks if the answer is valid(loops until they enter a valid answer)
		{
		    System.out.println ("Invalid"); //checks if the answer is one of the options
		}
		else
		{
		    break; // breaks when valid answer is entered
		}
	    }
	    while (!answer.equalsIgnoreCase ("Left") && !answer.equalsIgnoreCase ("Right"));
	    if (balanceRight > balanceLeft) //if the balance on rightfoot is greater than leftfoot
	    {
		if (!answer.equalsIgnoreCase ("left")) //if user entered left(which is wrong)
		{
		    System.out.println ("Wrong! You fell over and couldn't learn to walk.");
		    hasPassed = false; //they havent passed
		    break; // breakout
		}
		else // else its right
		{
		    System.out.println ("Good Stuff! a successful step");
		    hasPassed = true; // they got it right and made a step and can continue
		}
	    }
	    else if (balanceRight < balanceLeft) //if the balance on leftfoot is greater than rightfoot
	    {
		if (!answer.equalsIgnoreCase ("Right")) //if the user entered right(which is wrong)
		{
		    System.out.println ("Wrong! You fell over and couldn't learn to walk.");
		    hasPassed = false; // they havent passed
		    break; // breakout
		}
		else
		{
		    System.out.println ("Good Stuff! a successful step");
		    hasPassed = true; // they got it right and made a step and can continue
		}
	    }


	}
	if (hasPassed == true)
	{
	    System.out.println ("You made it to the end of the room and have learned to walk!"); // Message telling them they did it
	}
	return hasPassed; //return the variable to the main
    }


    boolean SpeakingGame ()  // this minigame will give the user a nursery rhyme and the user has to eneter the word that is missing
	throws java.io.IOException
    {
	System.out.println ();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String userans; //this is the users choice to fill in the word
	int usertries = 0; //calcualtes number of tries
	boolean Iscorrect = false; //checks if the answer is correct
	boolean hasPassed = false; //checks if the user passses the whole minigames
	System.out.println ("Welcome to the language minigame"); //rules of the game
	System.out.println ("You will enter the missing word in the nursery rhyme");
	do //the question will repeat until they get it right or they used up all three attempts
	{
	    System.out.println ("Mary had a little lamb, little lamb, little lab. Mary had a little lamb,\nIt's _ _ _ _ _ _ was white as snow");
	    System.out.println ("Enter the missing word");
	    userans = br.readLine ();
	    if (userans.equalsIgnoreCase ("fleece")) //if they get the right answer


		{
		    Iscorrect = true;
		    System.out.println ("You passed this question, moving onto the next");
		    break;
		}


	    else if (!userans.equalsIgnoreCase ("fleece")) //if they ger the wrong answer
	    {
		System.out.println ("Wrong");
		usertries++; //3 tries for the whole game
		if (usertries == 3) //if the user uses all 3 attempts
		{
		    System.out.println ("You have failed the language test");
		    Iscorrect = false;
		    break;
		}
	    }
	}
	while (Iscorrect == false); //run until the user doesn't get question right


	if (usertries < 3) //checking if the user has used up all three attempts
	{
	    Iscorrect = false; //resetting flag
	    do //next nursery rhyme
	    {
		System.out.println ("Twinkle Twinkle little star, how I wonder what you are.\nUp _ _ _ _ _ the world so high,");
		System.out.println ("Enter the missing word");
		userans = br.readLine ();
		if (userans.equalsIgnoreCase ("above")) //if they get the right answer
		{
		    Iscorrect = true;
		    System.out.println ("You passed this question, moving onto the next");
		    break;
		}


		else if (!userans.equalsIgnoreCase ("above")) //if they get the wrong answer
		{
		    System.out.println ("Wrong");
		    usertries++; //3 tries for the whole game
		    if (usertries == 3)
		    {
			System.out.println ("You have failed the language test");
			Iscorrect = false;
			break;
		    }
		}
	    }


	    while (Iscorrect == false);
	}
	if (usertries < 3) //checking if the user has used up all three lifelines
	{
	    Iscorrect = false; //resets flag
	    do //next nursery rhyme
	    {
		System.out.println ("Humpty Dumpty sat on the wal, Humpty Dumpty had a great fall;\nAll the kings _ _ _ _ _ _ and all the king's men.");
		System.out.println ("Enter the missing word");
		userans = br.readLine ();
		if (userans.equalsIgnoreCase ("horses")) //if they get the right answer


		    {
			Iscorrect = true;
			System.out.println ("You passed this question, moving onto the next");
			break;
		    }


		else if (!userans.equalsIgnoreCase ("horses")) //if they get the wrong answer


		    {
			System.out.println ("Wrong");
			usertries++; //3 tries for the whole game
			if (usertries == 3)
			{
			    System.out.println ("You have failed the language test");
			    Iscorrect = false;
			    break;
			}
		    }
	    }
	    while (Iscorrect == false);


	}


	if (usertries < 3) //checking if the user has used up all three lifelines
	{
	    Iscorrect = false; //resets flag
	    do //next nursery rhyme
	    {
		System.out.println ("Baa, baa, black sheep, Have you any wool? Yes, sir, yes, sir, _ _ _ _ _ bags full;");
		System.out.println ("Enter the missing word");
		userans = br.readLine ();
		if (userans.equalsIgnoreCase ("three")) //if they get the right answer


		    {
			Iscorrect = true;
			System.out.println ("You passed this question, moving onto the next");
			break;
		    }


		else if (!userans.equalsIgnoreCase ("three")) //if they get the wrong answer


		    {
			System.out.println ("Wrong");
			usertries++; //3 tries for the whole game
			if (usertries == 3)
			{
			    System.out.println ("You have failed the language test");
			    Iscorrect = false;
			    break;
			}
		    }
	    }
	    while (Iscorrect == false);


	}
	if (usertries < 3) //checking if the user has used up all three lifelines
	{
	    Iscorrect = false; //resets flag
	    do //next nursery rhyme
	    {
		System.out.println ("Row, row, row your boat. Gently down the stream. _ _ _ _ _ _ _, merrily,");
		System.out.println ("Enter the missing word");
		userans = br.readLine ();
		if (userans.equalsIgnoreCase ("Merrily")) //if they get the right answer


		    {
			Iscorrect = true;
			System.out.println ("You passed this question,");
			break;
		    }


		else if (!userans.equalsIgnoreCase ("Merrily")) //if they get the wrong answer


		    {
			System.out.println ("Wrong");
			usertries++; //3 tries for the whole game
			if (usertries == 3)
			{
			    System.out.println ("You have failed the language test");
			    Iscorrect = false;
			    break;
			}
		    }
	    }
	    while (Iscorrect == false);




	}


	if (usertries < 3) //if the user manages to get to the end without using all three attempts, then they pass, or else they dont
	{
	    hasPassed = true;
	    System.out.println ("You learned english");
	}
	if (usertries >= 3)
	{
	    hasPassed = false;
	    System.out.println ("You failed to learn english");
	}
	return hasPassed; //sending flag back to main

    }


    boolean CountingGame ()
	throws java.io.IOException
    {
	System.out.println();
	//counting minigame
	//user has to get three numbers that can add up to a given number
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String input;
	boolean hasPassed = false; //this is the overall flag that confirms if the user passed the game
	int givenNum; //the given number for which the user has to find three numbers to add
	int num; //placeholder for user nums
	int userNums[] = new int [3]; //the user's chosen numbers
	int correctBin = 0; //how many times the user gets the right answer
	int wrongBin = 0; // how many times the user gets the wrong answer
	int totalbin = 0; //total of all the nums
	boolean numChecker = false; // checks if the number is between 1 and 9
	int attempts = 3; // this is to tell the user how many attempts they have remaining


	System.out.println ("Welcome to the counting game,\nFigure out three numbers that add to the given number."); //rules
	System.out.println ("You have to get the 3 correct answers to pass the counting game.");
	System.out.println ("You fail if you get three different questions wrong.");
	System.out.println ("One attempt per question");
	System.out.println ("Numbers entered must be within the following range: 1 - 9");
	System.out.println ("Game has started now");




	do //runs whole game
	{
	    System.out.println ("");
	    givenNum = (int) (Math.random () * 13) + 3; //generatiing a random number between 3 and 15
	    System.out.println ("Enter three numbers that add to " + givenNum);
	    for (int count = 0 ; count < 3 ; count++)
	    {
		do //checking if the number is between one and nine
		{
		    System.out.println ("Enter number " + (count + 1));
		    input = br.readLine ();
		    num = Integer.parseInt (input);
		    if (num <= 0 || num > 9) //if user entered num isnt between  1 and 9, they have to enter a valid input
		    {
			System.out.println ("Invalid Input, Try Again");
			numChecker = false;
		    }
		    else if (num > 0 && num <= 9) // if it is between 1 and 9, sent flag to true which can break out of the num checker loop
		    {
			numChecker = true;
		    }


		}
		while (numChecker != true); //end of checking valid number
		userNums [count] = num; //num gets added to an array of three


	    }
	    totalbin = 0;
	    for (int count = 0 ; count < 3 ; count++)
	    {
		totalbin += (userNums [count]); //totalbin counts all the values in the array
	    }


	    if (totalbin != givenNum) //checks if the sum of all the numbers in the array equal to the given number
	    {
		System.out.println ("Wrong answer");
		attempts--;
		System.out.println ("You have " + attempts + " attempts remaining"); //tells user remaining attempts
		wrongBin++; //adds one point to wrong bin if the number is wrong
	    }


	    if (totalbin == givenNum) //checking if the sum of all the numbers in the array equal to the given number
	    {
		System.out.println ("Right answer");
		correctBin++; //adds point to right bin if number is right
	    }
	    if (wrongBin == 3) //if wrongbin reaches 3
	    {


		hasPassed = false; // overall pass flag is false
		break;
	    }
	    if (correctBin == 3) //if rightbin reaches 3
	    {


		hasPassed = true; //overall pass flag is true
		break;
	    }


	}
	while (wrongBin != 3 || correctBin != 3); //when user hits 3 on any bin, then break because they either passed or failed


	System.out.println ("");


	if (hasPassed == true)
	{
	    System.out.println ("Congrats you passed.+5 Skill Life Level");
	}
	if (hasPassed != true)
	{
	    System.out.println ("You failed because you got three questions wrong! No stat changes");
	}
	return hasPassed;
    }


    boolean DiggingGame ()
	throws java.io.IOException
    {
	//Digging Game
	//Treasure chest is in a random place from 1-15
	//they have 5 "digs". They can go down 1ft, 2 ft, 3ft.
	//With the maximum of 5 digs they have to dig down to the random number between 1-15. When done their attempt it will tell them if they are close(around 5 range of the number)
	//If they dont get it in 3 tries they die
	//Walking Minigame - The user is presented with the balance on each foot, they have to choose the right direction in order to not fall.
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	int chestLocation = (int) (Math.random () * 15) + 1; //location of chest
	boolean hasPassed = false; //checks if they passed it
	int userlocation = 0; //variable to store users location
	String userIncrement; //Variable to check which increment is chosen
	System.out.println ("DIGGING GAME");
	System.out.println ("The chest is anywhere between 1 - 15 feet.\nYou will have a total of three guesses\nEach guess finalized will tell you if you are within 5 feet of the chest.");
	System.out.println ("HOW TO DIG:\nTo dig, you can only dig 1 feet, 2 feet, or 3 feet at a time.\nYou have a total of 5 \"digs\" to get to your guess, however you can enter your confirm your guess at anytime");
	System.out.println ("\n\nLets Start! Your chest is located anywhere between 1-15 feet, Good Luck!"); //Instructions
	for (int count = 1 ; count <= 3 ; count++) //Three final guesses
	{
	    userlocation = 0; //resets user location each time
	    for (int counter = 1 ; counter <= 5 ; counter++) // 5 digs
	    {
		System.out.println ("(a) - +1\t(b) - +2\t(c) - +3\t(d) - Finalize Guess");
		System.out.println ("Digs remaining: " + (5 - counter + 1));
		userIncrement = br.readLine ();
		if (userIncrement.equalsIgnoreCase ("a")) //checks if they chose (a)
		{
		    userlocation += 1; //adds to the depth they've dug
		    System.out.println ("You have dug " + userlocation + " feet");
		}
		else if (userIncrement.equalsIgnoreCase ("b")) //checks if they chose (b)
		{
		    userlocation += 2; //adds to the depth they've dug
		    System.out.println ("You have dug " + userlocation + " feet");
		}
		else if (userIncrement.equalsIgnoreCase ("c")) //checks if they chose (c)
		{
		    userlocation += 3; //adds to the depth they've dug
		    System.out.println ("You have dug " + userlocation + " feet");
		}
		else if (userIncrement.equalsIgnoreCase ("d")) //checks if they chose (d)
		{
		    System.out.println ("Your final guess was " + userlocation + " feet"); // they're final guess
		    break;
		}
		else //Invalid
		{
		    System.out.println ("Invalid");
		    counter -= 1; //if its invalid, it will get rid of an attempt since it adds in the for loop(to ensure it doesn't count invalid attempts)

		}
	    }
	    if (userlocation == chestLocation) //if they got the right location
	    {
		hasPassed = true; //they passed
		break; //get out
	    }
	    else if (count == 3)
	    {
		break; //max attempts, get out
	    }
	    else if (userlocation >= chestLocation && userlocation <= chestLocation + 4)
	    {
		System.out.println ("Wrong, but within range of 5 from the chest"); // giving hints if they are within 5 feet(above)
	    }
	    else if (userlocation <= chestLocation && userlocation >= chestLocation - 4) // giving hints if they are within 5 feet(below)
	    {
		System.out.println ("Wrong but within range of 5 from the chest");
	    }
	    else
	    {
		System.out.println ("Wrong! Try again");
	    }
	    System.out.println ("Guesses Remaing: " + (3 - count)); //print guesses

	}

	if (hasPassed == true)
	{
	    System.out.println ("You did it! You get: Money +200\tLife Skill Level +10\tHonour +10"); // they did it!
	}
	if (hasPassed == false)
	{
	    System.out.println ("The treasure was at " + chestLocation + " feet");
	    System.out.println ("You couldn't find the treasure and ended up hitting an electrical wire. GAME OVER"); //couldn't do it, dead

	}
	return hasPassed; //return
    }


    int Sudoku ()
	throws java.io.IOException
    {
	System.out.println();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	System.out.println ("Welcome to SODOKU --> Based on your score, your career choice will be decided\nYou will have a maximum of 2 tries to solve the puzzle\nTo replace numbers, scroll to the top and look at the reference of letter locations");
	System.out.println ("HINT: In sudoku the same number cannot repeat in the same row or column\nGood luck");
	String userInput; //user input
	boolean unequalFlag = false;
	int numtries = 0; //tracks the number of tries they use
	String numPos; //position on board
	int career = 0; //depending on the user's score, they get a number which determines their carreer that gets sent back to main
	//doctor = 1, electrician = 2, plumber = 3
	//2D arrays, this is a board set up. 2D arrays consist of rows and collums and use  two square brackets[][]. the first represents the element of the row and the second
	//represents the element of collums. They all start at index 0 --> for example [2][2] means in the third row, third element in that row.
	String plainBoard[] [] = {  //a plain version of the board
		{"4", "|", "c", "|", "3", "|", "h"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"2", "|", "d", "|", "e", "|", "i"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"a", "|", "4", "|", "f", "|", "j"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"b", "|", "2", "|", "g", "|", "k"}
	    };
	String gameBoard[] [] = {  //the actual board the user plays on
		{"4", "|", "c", "|", "3", "|", "h"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"2", "|", "d", "|", "e", "|", "i"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"a", "|", "4", "|", "f", "|", "j"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"b", "|", "2", "|", "g", "|", "k"}
	    };
	String answerBoard[] [] = {  // the answer key to the sudoku game
		{"4", "|", "1", "|", "3", "|", "2"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"2", "|", "3", "|", "1", "|", "4"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"1", "|", "4", "|", "2", "|", "3"},
		{"-", "+", "-", "+", "-", "+", "-"},
		{"3", "|", "2", "|", "4", "|", "1"}
	    };
	for (int i = 0 ; i <= 6 ; i++) //this is the loop for row
	{
	    for (int j = 0 ; j <= 6 ; j++) //prints all in that row
	    {
		System.out.print (gameBoard [i] [j]); //"i" and "j" are just variables used to print array, hence no complex name.
	    }
	    System.out.println (); //cursor to next line
	}

	for (int count = 1 ; count <= 2 ; count++)
	{
	    numtries = count; //tries increases as the loop does

	    do
	    {
		System.out.println ("Enter-->[a], [b], [c], [d], [e], [f], [g], [h], [i], [j], [k] | [\"Done\"]"); //enter one of the positions
		userInput = br.readLine ();
		if (userInput.equalsIgnoreCase ("a")) //if they enter "a"
		{
		    System.out.println ("Enter number for position \"a\""); //add the number into position a
		    numPos = br.readLine ();
		    gameBoard [4] [0] = numPos; //set it at the gameboard
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]); //display updated gameboard
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("b"))
		{
		    System.out.println ("Enter number for position \"b\"");
		    numPos = br.readLine ();
		    gameBoard [6] [0] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("c"))
		{
		    System.out.println ("Enter number for position \"c\"");
		    numPos = br.readLine ();
		    gameBoard [0] [2] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("d"))
		{
		    System.out.println ("Enter number for position \"d\"");
		    numPos = br.readLine ();
		    gameBoard [2] [2] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("e"))
		{
		    System.out.println ("Enter number for position \"e\"");
		    numPos = br.readLine ();
		    gameBoard [2] [4] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("f"))
		{
		    System.out.println ("Enter number for position \"f\"");
		    numPos = br.readLine ();
		    gameBoard [4] [4] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("g"))
		{
		    System.out.println ("Enter number for position \"g\"");
		    numPos = br.readLine ();
		    gameBoard [6] [4] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("h"))
		{
		    System.out.println ("Enter number for position \"h\"");
		    numPos = br.readLine ();
		    gameBoard [0] [6] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("i"))
		{
		    System.out.println ("Enter number for position \"i\"");
		    numPos = br.readLine ();
		    gameBoard [2] [6] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("j"))
		{
		    System.out.println ("Enter number for position \"j\"");
		    numPos = br.readLine ();
		    gameBoard [4] [6] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("k"))
		{
		    System.out.println ("Enter number for position \"k\"");
		    numPos = br.readLine ();
		    gameBoard [6] [6] = numPos;
		    for (int i = 0 ; i <= 6 ; i++)
		    {
			for (int j = 0 ; j <= 6 ; j++)
			{
			    System.out.print (gameBoard [i] [j]);
			}
			System.out.println ();
		    }
		}
		else if (userInput.equalsIgnoreCase ("done"))
		{
		    break;
		}
		else
		{
		    System.out.println ("INVALID!");
		}
	    }
	    while (!userInput.equalsIgnoreCase ("done")); //runs game until done with their attempt
	    for (int i = 0 ; i <= 6 ; i++)
	    {
		for (int j = 0 ; j <= 6 ; j++)
		{
		    if (!gameBoard [i] [j].equals (answerBoard [i] [j]))
		    {
			unequalFlag = true; // if they don't equal, the unequal flag will be true
		    }
		}
	    }
	    if (unequalFlag == true) //unequal flag is already true
	    {
		if (count == 2) //couldn't get it after 2 tries
		{
		    numtries++; //numtries = 3
		    break;
		}
		System.out.println ("Wrong! Try again"); //couldn't get it after one try
		for (int i = 0 ; i <= 6 ; i++)
		{
		    for (int j = 0 ; j <= 6 ; j++)
		    {

			gameBoard [i] [j] = plainBoard [i] [j]; //resets board

		    }
		}
		for (int i = 0 ; i <= 6 ; i++)
		{
		    for (int j = 0 ; j <= 6 ; j++)
		    {
			System.out.print (gameBoard [i] [j]); //reprints board
		    }
		    System.out.println ();
		}
		unequalFlag = false;

	    }
	    else
	    {
		System.out.println ("Thats right!"); //got it after one try
		break;
	    }
	}
	if (numtries == 3) //three tries
	{
	    career = 3; //career is three, worst
	}
	else if (numtries == 2) //two tries
	{

	    career = 2; //career is 2, 2nd best
	}
	else if (numtries == 1) //1 try
	{

	    career = 1; //career is one, best
	}
	return career; //return
    }


    boolean UltimateStudentMinigame ()
	throws java.io.IOException
    {
	System.out.println();
	//Ultimate Student Minigame
	//A riddles game - The user gets 8 riddles
	// If they get %100, they get to choose their own team
	//if they get anything less, a random number will choose a random team for you
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String input;
	String answer; //users answer to riddle
	boolean hasPassed = false; //overall passing of game
	int correctAns = 0; //number of right answers
	int wrongAns = 0; //number of wrong answers
	int userTries = 0; //how many times the user has gotten the same question
	int attempts = 3; //to tell user how many remaining attempts
	boolean isCorrect = false; //to check if they got a riddle correct
	System.out.println ("Welcome to the riddle game");
	System.out.println ("This game will allow you to choose your team");
	System.out.println ("You will be given a riddle with a one word answer");
	System.out.println ("You have to solve the riddle to be allowed to choose your team");
	System.out.println ("You will get 3 attempts per riddle, and one hint after the second failed attempt");
	System.out.println ("Only write a single word that you think is the answer");
	System.out.println ("Remove any words before it such as: \"My\",\"Your\",\"The\",\"A\".");
	System.out.println ("");


	do //riddle one will keep running as long as the user doesn't use all 3 attempts or they don't get it right
	{
	    System.out.println ("Riddle One");
	    System.out.println ("What has to be broken before you can use it?");
	    if (attempts == 1) //if the user has one attempt left, they get the hint
	    {
		System.out.println ("Your hint: Its white, fragile and it has protein");
	    }
	    answer = br.readLine ();
	    if (answer.equalsIgnoreCase ("Egg")) //if they get it right
	    {
		System.out.println ("Correct answer");
		isCorrect = true;
		break;
	    }
	    else if (!answer.equalsIgnoreCase ("Egg")) //if they get it wrong
	    {
		userTries++;
		if (userTries == 3) //once they use all their attempts, tell answer, and move onto next game
		{
		    System.out.println ("The answer was: \"Egg\"");
		    System.out.println ("You got the question wrong and used up your attempts, moving onto the next");
		    isCorrect = false;
		    break;
		}
		else //if they havent used all attempts, tell them its wrong and # of remaining attempts
		{
		    System.out.println ("Wrong answer");
		    attempts--;
		    System.out.println ("You have " + attempts + " attempts remaining");
		}
	    }
	}
	while (isCorrect == false || userTries != 3); //if user either has too many attempts

	if (isCorrect != false) //checkes if user got the riddle above, correct or wrong, then will show how many they got right, and how many wrong
	{
	    correctAns++;
	}

	else if (isCorrect != true)
	{
	    wrongAns++;
	} //end of riddle one
	attempts = 3;
	userTries = 0; //resetting both bins
	do //riddle three
	{
	    System.out.println ("Riddle Two");
	    System.out.println ("I have branches, but no fruit, trunk or leaves. What am I?");
	    if (attempts == 1)
	    {
		System.out.println ("Your hint: think: $$$");
	    }
	    answer = br.readLine ();
	    if (answer.equalsIgnoreCase ("Bank"))
	    {
		System.out.println ("Correct answer");
		isCorrect = true;
		break;
	    }
	    else if (!answer.equalsIgnoreCase ("Bank"))
	    {
		userTries++;
		if (userTries == 3)
		{
		    System.out.println ("The answer was: \"Bank\"");
		    System.out.println ("You got the question wrong and used up your attempts, moving onto the next");
		    isCorrect = false;
		    break;
		}
		else
		{
		    System.out.println ("Wrong answer");
		    attempts--;
		    System.out.println ("You have " + attempts + " attempts remaining");
		}
	    }
	}
	while (isCorrect == false || userTries != 3); //if user either has too many attempts

	if (isCorrect != false)
	{
	    correctAns++;
	}

	else if (isCorrect != true)
	{
	    wrongAns++;
	} //end of riddle two
	attempts = 3;
	userTries = 0;
	do //riddle three
	{
	    System.out.println ("Riddle Three");
	    System.out.println ("What gets wet while drying?");
	    if (attempts == 1)
	    {
		System.out.println ("Your hint: You use it everyday");
	    }
	    answer = br.readLine ();
	    if (answer.equalsIgnoreCase ("Towel"))
	    {
		System.out.println ("Correct answer");
		isCorrect = true;
		break;
	    }
	    else if (!answer.equalsIgnoreCase ("Towel"))
	    {
		userTries++;
		if (userTries == 3)
		{
		    System.out.println ("The answer was: \"Towel\"");
		    System.out.println ("You got the question wrong and used up your attempts, moving onto the next");
		    isCorrect = false;
		    break;
		}
		else
		{
		    System.out.println ("Wrong answer");
		    attempts--;
		    System.out.println ("You have " + attempts + " attempts remaining");
		}
	    }
	}
	while (isCorrect == false || userTries != 3); //if user either has too many attempts

	if (isCorrect != false)
	{
	    correctAns++;
	}

	else if (isCorrect != true)
	{
	    wrongAns++;
	} //end of riddle three
	attempts = 3;
	userTries = 0;
	do //riddle 4
	{
	    System.out.println ("Riddle Four");
	    System.out.println ("What can't talk but will reply when spoken to?");
	    if (attempts == 1)
	    {
		System.out.println ("Your hint: What happens when you speak in a big empty area?");
	    }
	    answer = br.readLine ();
	    if (answer.equalsIgnoreCase ("Echo"))
	    {
		System.out.println ("Correct answer");
		isCorrect = true;
		break;
	    }
	    else if (!answer.equalsIgnoreCase ("Echo"))
	    {
		userTries++;
		if (userTries == 3)
		{
		    System.out.println ("The answer was: \"Echo\"");
		    System.out.println ("You got the question wrong and used up your attempts, moving onto the next");
		    isCorrect = false;
		    break;
		}
		else
		{
		    System.out.println ("Wrong answer");
		    attempts--;
		    System.out.println ("You have " + attempts + " attempts remaining");
		}
	    }
	}
	while (isCorrect == false || userTries != 3); //if user either has too many attempts

	if (isCorrect != false)
	{
	    correctAns++;
	}

	else if (isCorrect != true)
	{
	    wrongAns++;
	} //end of riddle four
	attempts = 3;
	userTries = 0;
	do //riddle five
	{
	    System.out.println ("Riddle Five");
	    System.out.println ("What belongs to you, but other people use it more than you?");
	    if (attempts == 1)
	    {
		System.out.println ("Your hint: You often use it around new people");
	    }
	    answer = br.readLine ();
	    if (answer.equalsIgnoreCase ("Name"))
	    {
		System.out.println ("Correct answer");
		isCorrect = true;
		break;
	    }
	    else if (!answer.equalsIgnoreCase ("Name"))
	    {
		userTries++;
		if (userTries == 3)
		{
		    System.out.println ("The answer was: \"Name\"");
		    System.out.println ("You got the question wrong and used up your attempts, moving onto the next");
		    isCorrect = false;
		    break;
		}
		else
		{
		    System.out.println ("Wrong answer");
		    attempts--;
		    System.out.println ("You have " + attempts + " attempts remaining");
		}
	    }
	}
	while (isCorrect == false || userTries != 3); //if user either has too many attempts

	if (isCorrect != false)
	{
	    correctAns++;
	}

	else if (isCorrect != true)
	{
	    wrongAns++;
	} //end of riddle five
	attempts = 3;
	userTries = 0;
	do //riddle six
	{
	    System.out.println ("Riddle Six");
	    System.out.println ("What has six faces, but does not wear makeup, and twenty-one eyes, but cannot see?");
	    if (attempts == 1)
	    {
		System.out.println ("Your hint: you can roll it");
	    }
	    answer = br.readLine ();
	    if (answer.equalsIgnoreCase ("Dice"))
	    {
		System.out.println ("Correct answer");
		isCorrect = true;
		break;
	    }
	    else if (!answer.equalsIgnoreCase ("Dice"))
	    {
		userTries++;
		if (userTries == 3)
		{
		    System.out.println ("The answer was: \"Dice\"");
		    System.out.println ("You got the question wrong and used up your attempts, moving onto the next");
		    isCorrect = false;
		    break;
		}
		else
		{
		    System.out.println ("Wrong answer");
		    attempts--;
		    System.out.println ("You have " + attempts + " attempts remaining");
		}
	    }
	}
	while (isCorrect == false || userTries != 3); //if user either has too many attempts

	if (isCorrect != false)
	{
	    correctAns++;
	}

	else if (isCorrect != true)
	{
	    wrongAns++;
	} //end of riddle six
	attempts = 3;
	userTries = 0;
	do //riddle seven
	{
	    System.out.println ("Riddle Seven");
	    System.out.println ("What is light as a feather, yet no man can hold it for very long?");
	    if (attempts == 1)
	    {
		System.out.println ("Your hint: You don't hold it in your hands");
	    }
	    answer = br.readLine ();
	    if (answer.equalsIgnoreCase ("breath"))
	    {
		System.out.println ("Correct answer");
		isCorrect = true;
		break;
	    }
	    else if (!answer.equalsIgnoreCase ("breath"))
	    {
		userTries++;
		if (userTries == 3)
		{
		    System.out.println ("The answer was: \"breath\"");
		    System.out.println ("You got the question wrong and used up your attempts, moving onto the next");
		    isCorrect = false;
		    break;
		}
		else
		{
		    System.out.println ("Wrong answer");
		    attempts--;
		    System.out.println ("You have " + attempts + " attempts remaining");
		}
	    }
	}
	while (isCorrect == false || userTries != 3); //if user either has too many attempts

	if (isCorrect != false)
	{
	    correctAns++;
	}

	else if (isCorrect != true)
	{
	    wrongAns++;
	} //end of riddle seven
	attempts = 3;
	userTries = 0;
	do //riddle right
	{
	    System.out.println ("Riddle Eight");
	    System.out.println ("What disappears as soon as you say its name?");
	    if (attempts == 1)
	    {
		System.out.println ("Your hint: It also disappears when you make a sound");
	    }
	    answer = br.readLine ();
	    if (answer.equalsIgnoreCase ("silence"))
	    {
		System.out.println ("Correct answer");
		isCorrect = true;
		break;
	    }
	    else if (!answer.equalsIgnoreCase ("silence"))
	    {
		userTries++;
		if (userTries == 3)
		{
		    System.out.println ("The answer was: \"silence\"");
		    System.out.println ("You got the question wrong and used up your attempts, moving onto the next");
		    isCorrect = false;
		    break;
		}
		else
		{
		    System.out.println ("Wrong answer");
		    attempts--;
		    System.out.println ("You have " + attempts + " attempts remaining");
		}
	    }
	}
	while (isCorrect == false || userTries != 3); //if user either has too many attempts

	if (isCorrect != false)
	{
	    correctAns++;
	}

	else if (isCorrect != true)
	{
	    wrongAns++;
	} //end of riddle eight

	System.out.println ("Those were all the questions");
	System.out.println ("Riddles answered correctly " + correctAns + "/8"); //showing how many correct
	System.out.println ("Riddles answered incorrectly " + wrongAns + "/8"); //showing how many wrong


	if (correctAns >= 4) //if user has scored higher than 50 they pass
	{
	    System.out.println ("Congrats you passed");
	    hasPassed = true;
	}

	if (correctAns < 4) //if user has scored less than 50 they fail
	{
	    System.out.println ("You failed");
	    hasPassed = false;
	}
	return hasPassed;

    }





    boolean WordSearch ()
	throws java.io.IOException
    {
	System.out.println();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String userGuess; //their guess
	hasPassed = false; //boolean to check if they passed
	System.out.println ("Welcome to the Word Search");
	System.out.println ("The game is simple, all you have to do is find as many words as you can.\nGet all the words, win the tournament.\nGood luck.");

	String gameBoard[] [] = {  //array representing the board
		{"B", "|", "Q", "|", "H", "|", "Z", "|", "A", "|", "J", "|", "A", "|", "B"},
		{"-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-"},
		{"P", "|", "L", "|", "E", "|", "J", "|", "N", "|", "O", "|", "M", "|", "S"},
		{"-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-"},
		{"Y", "|", "U", "|", "V", "|", "C", "|", "O", "|", "W", "|", "K", "|", "I"},
		{"-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-"},
		{"G", "|", "R", "|", "B", "|", "J", "|", "J", "|", "A", "|", "V", "|", "A"},
		{"-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-"},
		{"A", "|", "C", "|", "A", "|", "J", "|", "C", "|", "X", "|", "D", "|", "Y"},
		{"-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-"},
		{"R", "|", "K", "|", "C", "|", "N", "|", "V", "|", "T", "|", "U", "|", "I"},
		{"-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-"},
		{"C", "|", "A", "|", "G", "|", "N", "|", "I", "|", "R", "|", "T", "|", "S"},
		{"-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-"},
		{"B", "|", "R", "|", "Q", "|", "H", "|", "P", "|", "B", "|", "P", "|", "E"}
	    };

	String answerlist[] = {"String", "Java", "Binary"}; //array of wordlist
	boolean isCorrect[] = {false, false, false}; //array to check which ones they got
	for (int i = 0 ; i <= 14 ; i++)
	{
	    for (int j = 0 ; j <= 14 ; j++)
	    {
		System.out.print (gameBoard [i] [j]); //prints board
	    }
	    System.out.println ();
	}
	do
	{
	    System.out.println ("Try to find as many words as you can, enter \"Done\" when done: ");
	    userGuess = br.readLine ();
	    if (userGuess.equalsIgnoreCase (answerlist [0])) //if they found the first word in array
	    {
		System.out.println ("Correct!");
		isCorrect [0] = true; //first word in array found
		gameBoard [12] [14] = "-"; // sets these positions to dashes to represent a cross
		gameBoard [12] [12] = "-";
		gameBoard [12] [10] = "-";
		gameBoard [12] [8] = "-";
		gameBoard [12] [6] = "-";
		gameBoard [12] [4] = "-";
		for (int i = 0 ; i <= 14 ; i++)
		{
		    for (int j = 0 ; j <= 14 ; j++)
		    {
			System.out.print (gameBoard [i] [j]);
		    }
		    System.out.println ();
		}
	    }
	    else if (userGuess.equalsIgnoreCase (answerlist [1]))
	    {
		System.out.println ("Correct!");
		isCorrect [1] = true; //second word in array found
		gameBoard [6] [14] = "-"; // sets these positions to dashes to represent a cross
		gameBoard [6] [12] = "-";
		gameBoard [6] [10] = "-";
		gameBoard [6] [8] = "-";
		for (int i = 0 ; i <= 14 ; i++)
		{
		    for (int j = 0 ; j <= 14 ; j++)
		    {
			System.out.print (gameBoard [i] [j]);
		    }
		    System.out.println ();
		}
	    }
	    else if (userGuess.equalsIgnoreCase (answerlist [2]))
	    {
		System.out.println ("Correct!");
		isCorrect [2] = true; //third word in array found
		gameBoard [14] [10] = "\\"; // sets these positions to dashes to represent a diagonal cross
		gameBoard [12] [8] = "\\";
		gameBoard [10] [6] = "\\";
		gameBoard [8] [4] = "\\";
		gameBoard [6] [2] = "\\";
		gameBoard [4] [0] = "\\";
		for (int i = 0 ; i <= 14 ; i++)
		{
		    for (int j = 0 ; j <= 14 ; j++)
		    {
			System.out.print (gameBoard [i] [j]);
		    }
		    System.out.println ();
		}
	    }
	    else if (userGuess.equalsIgnoreCase ("Done"))
	    {
		break; //break out when done
	    }
	    else
	    {
		System.out.println ("There's no word like that"); //if they're wrong then
	    }
	}
	while (!userGuess.equalsIgnoreCase ("Done"));

	if (isCorrect [0] == true && isCorrect [1] == true && isCorrect [2] == true) //if they found all the words
	{
	    System.out.println ("You got all the words!\nYou won the final of your tournament!"); //display the things they got
	    System.out.println ("+$100");
	    System.out.println ("Life Skill level +20");
	    System.out.println ("Self honour +20");
	    System.out.println ("Friends +10");
	    hasPassed = true;

	}
	else
	{
	    System.out.println ("You couldn't find all the words --> \"String\", \"Java\" and \"Binary\""); //display the consequences of failing
	    System.out.println ("You lost the tournament final, and lost the opportunity to advance greatly");
	    System.out.println ("Life skill level -20");
	    System.out.println ("Self honour -20");
	    System.out.println ("Friends -10");
	    hasPassed = false;
	}


	return hasPassed;

    }





    boolean BankRobbery_1 ()
	throws java.io.IOException
    {
	System.out.println();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String input;
	int choice; //checking choice to see what they did
	boolean validChoice = false; //if the user madde a valid choice
	boolean hasPassed = false;
	System.out.println ("Welcome to the bank robbery");
	System.out.println ("You will be given choices throughout the bank robbery, using your witt you must decide the best approach to successfully pulling off the heist");
	System.out.println ("");
	System.out.println ("You walk into the bank and have a choice to go in guns blazing\nOR\nFollow the bank manager into the bathroom for a stealthier appraoch");

	do
	{ //runs untill user makes a valid choice

	    System.out.println ("Option 1: Guns Blazing");
	    System.out.println ("Option 2: Stealth");
	    System.out.println ("Enter 1 or 2");
	    input = br.readLine ();
	    choice = Integer.parseInt (input);

	    if (choice == 1 || choice == 2 && input.length () == 1)
	    {

		validChoice = true;
	    }

	}
	while (validChoice != true);
	if (choice == 1) //Guns Blazing option, Start of the IF
	{
	    System.out.println ("You decide to pull out your gun and decide you need a hostage");
	    System.out.println ("Do you take everyone hostage into the vault\nOR\njust one person?");

	    validChoice = false;
	    do
	    {
		System.out.println ("Option 1: Take everyone");
		System.out.println ("Option 2: Take one person");
		System.out.println ("Enter 1 or 2"); //hostage situation of guns blazing
		input = br.readLine ();
		choice = Integer.parseInt (input);

		if (choice == 1 || choice == 2 && input.length () == 1)
		{

		    validChoice = true;
		}

	    }
	    while (validChoice != true);

	    if (choice == 1) //choice 1 in hostage situation(take everyone)
	    {
		System.out.println ("You took everyone hostage to the vault, however, you didn't see one guy pressing the emergency lockdown button\nWhich dropped a gate around you and released poisonous gas killing you.");
		System.out.println ("You have died - GAME OVER");
		hasPassed = false;
	    } //end of choice 1
	    else if (choice == 2) //choice 2 in hostage situation(one person)
	    {
		System.out.println ("You enter the vault with a single hostage");
		System.out.println ("You leave the bank with the hostage as cover");
		System.out.println ("The cops have surrounded the building and are encouraging you to let him go");
		System.out.println ("You take the guy in your car and drive away, but the cops are chasing you");
		System.out.println ("You have a choice");
		System.out.println ("Do you throw the hostage away mid getaway to run away without a witness?");
		System.out.println ("OR");
		System.out.println ("Do you make the hostage a part of your crew and give him a cut of the money?");

		validChoice = false;
		do
		{
		    System.out.println ("Option 1: Mid-car throwout");
		    System.out.println ("Option 2: Make part of crew");
		    System.out.println ("Enter 1 or 2");
		    input = br.readLine ();
		    choice = Integer.parseInt (input);
		    if (choice == 1 || choice == 2 && input.length () == 1)
		    {
			validChoice = true;
		    }

		}
		while (validChoice != true);
		if (choice == 1) //option 1 for making hostage accomplice
		{
		    System.out.println ("You decide you don't need the hostage anymore and throw him out");
		    System.out.println ("You try to getaway, however the cops have no reason to be carefull");
		    System.out.println ("They run you off the road and the car falls off a cliff and blows up");
		    System.out.println ("You Died - GAME OVER");
		    hasPassed = false;
		} //end of option 1 for hostage accomplice
		else if (choice == 2) //option 2 for making hostage accomplice
		{
		    System.out.println ("You make the hostage an accomplice, and use him as a ploy to get the cops to leave you alone");
		    System.out.println ("You both get to the safe house");
		    System.out.println ("You don't know if you should trust him or not");
		    System.out.println ("Do you betray him and leave\nOR\nTrust him and split the money");

		    validChoice = false;
		    do
		    {
			System.out.println ("Option 1: Betray him"); //option for what to do with hostage
			System.out.println ("Option 2: Trust him");
			System.out.println ("Enter 1 or 2");
			input = br.readLine ();
			choice = Integer.parseInt (input);
			if (choice == 1 || choice == 2 && input.length () == 1)
			{
			    validChoice = true;
			}

		    }
		    while (validChoice != true);
		    if (choice == 1)
		    {
			int betrayOutcome = (int) (Math.random () * 2) + 1; // a random chance of who betrays who
			if (betrayOutcome == 1) //if its 1, he betrays you
			{
			    System.out.println ("You go to shoot him in the back, however, he expects it and shoots you first");
			    System.out.println ("You Died - Game Over");
			    hasPassed = false;
			}
			else if (betrayOutcome == 2) //if its 2,you betray him
			{
			    System.out.println ("You turn around and shoot him in the back as he grabs his cut");
			    System.out.println ("You succesfully manage to rob the bank and get out");
			    hasPassed = true;
			}

		    }
		    else if (choice == 2)
		    {
			System.out.println ("You don't betray him and both getaway with the money");
			System.out.println ("You succesfully manage to rob the bank and get out");
			hasPassed = true;


		    }
		} //end of option 2 for hostage accomplice
	    } //end of taking one person into the vault
	} //end of guns blazing

	else if (choice == 2) //start of stealthier option
	{
	    System.out.println ("You follow the bank manager, Sal, into the bathroom and knock him unconscious and steal his clothes to make his way into the vault\nYou notice his employee number 47, and ID number 157936");
	    System.out.println ("You walk into the vault corridor as the bank manager");
	    System.out.println ("Are you ready to continue?");
	    System.out.println ("Yes\nOR\nNo");
	    input = br.readLine ();
	    for (int count = 0 ; count <= 100 ; count++) //once user answers, yes or no. multiple lines will be spammed, to avoid them for seeing the id # for next question
	    {
		System.out.println ("");
	    }
	    if (input.equalsIgnoreCase ("Yes"))
	    {
		System.out.println ("Good, lets do this");
	    }
	    else if (input.equalsIgnoreCase ("No"))
	    {
		System.out.println ("Too bad, lets do this");
	    }
	    else
	    {
		System.out.println ("I didn't understand but the show shall go on");
	    }
	    System.out.println ("Before you enter the vault, you need to enter the employee ID of the bank manager");
	    System.out.println ("Do you remember it? Please Enter It");
	    String idNum = br.readLine ();
	    if (!idNum.equalsIgnoreCase ("157936")) //checking if ID # matches
	    {
		System.out.println ("ERROR ERROR ERROR!");
		System.out.println ("You entered the wrong code and the corridor filled with poisonous gas");
		System.out.println ("You died - GAME OVER");
		hasPassed = false;
	    }
	    else if (idNum.equalsIgnoreCase ("157936"))
	    {
		System.out.println ("DING DING DING");
		System.out.println ("You entered the right code");
		System.out.println ("You walk out the vault with a briefcase full of cash");
		System.out.println ("!BEEP BEEP BEEP!");
		System.out.println ("Uh Oh, they did a spot check on the vault and know you stole money from the vault, but they don't know where you are");
		System.out.println ("Do you run through the main door near your parked car\nOR\nTake the side service exit which is further from the car");

		validChoice = false;
		do
		{
		    System.out.println ("Option 1: Main Door");
		    System.out.println ("Option 2: Side Door");
		    System.out.println ("Enter 1 or 2");
		    input = br.readLine ();
		    choice = Integer.parseInt (input);
		    if (choice == 1 || choice == 2 && input.length () == 1)
		    {
			validChoice = true;
		    }

		}
		while (validChoice != true);
		if (choice == 1)
		{
		    System.out.println ("You make a valiant effort to run through the main door, however, the cops see you at shoot at sight");
		    System.out.println ("You died - GAME OVER");
		    hasPassed = false;
		}
		else if (choice == 2)
		{
		    System.out.println ("You bolt through the side door undetected and make your way to the parking lot");
		    System.out.println ("Uh Oh, turns out the cops are patrolling the parking lot");
		    System.out.println ("Do you sneak to your car and drive off\nOR\nSteal a police outfit from a nearby van and sneak off");

		    validChoice = false;
		    do
		    {
			System.out.println ("Option 1: Sneak to the car");
			System.out.println ("Option 2: Steal police outfit");
			System.out.println ("Enter 1 or 2");
			input = br.readLine ();
			choice = Integer.parseInt (input);
			if (choice == 1 || choice == 2 && input.length () == 1)
			{
			    validChoice = true;
			}

		    }
		    while (validChoice != true);
		    if (choice == 1)
		    {
			System.out.println ("You managed to sneak to your car undetected and drove away from the bank unnoticed");
			System.out.println ("Congratualtions, you managed to escape the bank undetected");
			hasPassed = true;
		    }
		    else if (choice == 2) //at any time the user dies, hasPassed becomes false
		    {
			System.out.println ("You manage to steal the police outfit, however the cops realise you're not a real cop and shoot at sight");
			System.out.println ("You died - GAME OVER");
			hasPassed = false;
		    }
		} //end of going through side door
	    } // end of getting id number correct
	} // end of stealthier option
	return hasPassed;
    }


    //Two Truths - One Lie Game
    //User will be given three statements with 2 truths and a lie, they must find the lie in three different sets of statements to win, they lose if they get the answer wrong three times

    boolean LyingGame ()
	throws java.io.IOException
    {
	System.out.println();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String input;
	String ans; //user ans
	//random number generator will generate a number which will correspond to a position in the array, which will printout the statement
	String Truths1[] = {"Tomatoes and avocadoes are fruits, not vegatables", "Sounds do not carry in space", "An ostrich's eye is bigger than it's brain", "The largest dinosaurs were vegetarions", "The most commonly used letter of the English alphabet is \"E\""};
	String Truths2[] = {"Water cover 70% of the Earth", "Hippopotamus milk is pink in colour", "We have learned about 9 variables in ICS 3U1", "\"Xanthophobia\" is fear of the color yellow", "The driest place in the wor;d - the Atacame Desrt in Northern Chile - is located next to the biggest body of water"};
	String Lies[] = {"Neptune is no longer a planet", "French fries originated in France", "The large intestine is the largest internal organ in your body", "Australia was never a British colony", "The LEGO factory produces around 36,000 lego blocks every minute"};
	int wrongBin = 0; //stores wrong answers
	int rightBin = 0; //stores right answers
	boolean hasPassed = false; //overal game pass flag
	int randPos1; //different randnum for truth 1
	int randPos2; //different rand num for truth 2
	int randPos3; //the random number that calls the position in the arrays for lies array
	int randConfig;
	boolean validChoice = false; //checks if user entered input is valid
	System.out.println ("Welcome to the 2 truths, One Lie Game");
	System.out.println ("Your goal is to spot the lie in the three statements given");
	System.out.println ("You get one guess per round, and 3 incorrect guesses means you failed to lie to your wife");
	System.out.println ("The game will end when you either get 3 questions right OR 3 questions wrong");
	System.out.println ("Good Luck");
	do //whole game runs as long as user has 3 right or 3 wrong answers
	{
	    randConfig = (int) (Math.random () * 3) + 1; //this will assign a random number which chooses the layout of the questions, which prevents the answer from being in the same place everytime
	    if (randConfig == 1) //configuaration one with lie in the last line
	    {
		if (wrongBin == 3) //break out if user has gotten three questions wrong
		{


		    hasPassed = false;
		    break;


		}
		else if (rightBin == 3) //break out if user has gotten three questions right
		{
		    hasPassed = true;
		    break;


		}
		randPos1 = (int) (Math.random () * 5) + 1; //assigning different values to the randnums, which will call different array position
		randPos2 = (int) (Math.random () * 5) + 1;
		randPos3 = (int) (Math.random () * 5) + 1;
		System.out.println ("You have " + wrongBin + " wrong answers"); //tells users their current stats
		System.out.println ("You have " + rightBin + " right answers");
		System.out.println ("Which statement is a lie?");
		System.out.println ("A. " + Truths1 [randPos1 - 1]); //calling array to output the sentences
		System.out.println ("B. " + Truths2 [randPos2 - 1]);
		System.out.println ("C. " + Lies [randPos3 - 1]);
		System.out.println ("Enter either \"A\",\"B\", or \"C\"");
		do //checking if user input is a valid choice
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C") && ans.length () == 1) //they move on if their answer meets the guidelines
		    {
			validChoice = true;
		    }
		    else if (!ans.equalsIgnoreCase ("A") || !ans.equalsIgnoreCase ("B") || !ans.equalsIgnoreCase ("C") || ans.length () > 1) //they keep  reentering till there answer has met the guidelines
		    {
			System.out.println ("Invalid Input, Enter either \"A\",\"B\", or \"C\"");
			validChoice = false;
		    }


		}
		while (validChoice == false);
		if (ans.equalsIgnoreCase ("C")) //if they get it right, they get a point
		{
		    System.out.println ("That is correct");
		    rightBin++;
		}


		else if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B")) //if wrong, they loose a point
		{
		    System.out.println ("That is incorrect");
		    wrongBin++;
		}




	    }
	    //layout 2
	    else if (randConfig == 2) //this is layout two with the answer in the middle instead of the last line
	    {
		if (wrongBin == 3)
		{


		    hasPassed = false;
		    break;




		}
		else if (rightBin == 3)
		{


		    hasPassed = true;
		    break;
		}
		randPos1 = (int) (Math.random () * 5) + 1;
		randPos2 = (int) (Math.random () * 5) + 1;
		randPos3 = (int) (Math.random () * 5) + 1;
		System.out.println ("You have " + wrongBin + " wrong answers");
		System.out.println ("You have " + rightBin + " right answers");
		System.out.println ("Which statement is a lie?");
		System.out.println ("A. " + Truths1 [randPos1 - 1]);
		System.out.println ("B. " + Lies [randPos3 - 1]);
		System.out.println ("C. " + Truths2 [randPos2 - 1]);
		System.out.println ("Enter either \"A\",\"B\", or \"C\"");
		do
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C") && ans.length () == 1)
		    {
			validChoice = true;
		    }
		    else if (!ans.equalsIgnoreCase ("A") || !ans.equalsIgnoreCase ("B") || !ans.equalsIgnoreCase ("C") || ans.length () > 1)
		    {
			System.out.println ("Invalid Input, Enter either \"A\",\"B\", or \"C\"");
			validChoice = false;
		    }


		}
		while (validChoice == false);
		if (ans.equalsIgnoreCase ("B"))
		{
		    System.out.println ("That is correct");
		    rightBin++;
		}


		else if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("C"))
		{
		    System.out.println ("That is incorrect");
		    wrongBin++;
		}


	    }
	    //layout 3


	    else if (randConfig == 3) //this is layout 3 where the answer is at the top
	    {
		if (wrongBin == 3)
		{
		    hasPassed = false;
		    break;


		}
		else if (rightBin == 3)
		{
		    hasPassed = true;
		    break;


		}
		randPos1 = (int) (Math.random () * 5) + 1;
		randPos2 = (int) (Math.random () * 5) + 1;
		randPos3 = (int) (Math.random () * 5) + 1;
		System.out.println ("You have " + wrongBin + " wrong answers");
		System.out.println ("You have " + rightBin + " right answers");
		System.out.println ("Which statement is a lie?");
		System.out.println ("A. " + Lies [randPos3 - 1]);
		System.out.println ("B. " + Truths1 [randPos1 - 1]);
		System.out.println ("C. " + Truths2 [randPos2 - 1]);
		System.out.println ("Enter either \"A\",\"B\", or \"C\"");
		do
		{
		    ans = br.readLine ();
		    if (ans.equalsIgnoreCase ("A") || ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C") && ans.length () == 1)
		    {
			validChoice = true;
		    }
		    else if (!ans.equalsIgnoreCase ("A") || !ans.equalsIgnoreCase ("B") || !ans.equalsIgnoreCase ("C") || ans.length () > 1)
		    {
			System.out.println ("Invalid Input, Enter either \"A\",\"B\", or \"C\"");
			validChoice = false;
		    }


		}
		while (validChoice == false);
		if (ans.equalsIgnoreCase ("A"))
		{
		    System.out.println ("That is correct");
		    rightBin++;
		}


		else if (ans.equalsIgnoreCase ("B") || ans.equalsIgnoreCase ("C"))
		{
		    System.out.println ("That is incorrect");
		    wrongBin++;
		}


	    }


	}
	while (rightBin != 3 || wrongBin != 3); //
	if (hasPassed == true) //if they pass, they win
	{
	    System.out.println ("Congrats, you passed the Lying Minigame");
	}
	else if (hasPassed == false) //if they fail, they lose
	{
	    System.out.println ("Unfortunately, you failed the Lying Minigame");
	}

	return hasPassed;
    }


    //a game where the user has to find all ten letters in a word
    //every time the user gets a letter right, they get a ten percent discount on the car
    //if they get all the letters they get a free car
    //at the end, after ten guesses, they will get the amount of letters guessed right worth on discount
    int DiscountMinigame ()
	throws java.io.IOException
    {
	System.out.println();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String input;
	String letter; //users answer
	String answerWord[] = {"S", "T", "R", "A", "W", "B", "E", "R", "R", "Y"}; //the answerkey
	String guessWord[] = {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_"}; //the line for the user to guess
	int invalidPos[] = {11, 11, 11, 11, 11, 11, 11, 11, 11, 11}; //once a correct letter is guessed, that position will stored into this array so the same position won't be accesed again
	int attempts = 0; //total attempts by the user
	int rightAns = 0; //amount of right answers
	int remtries = 10; //remaining tries
	int position = 11; //checks what position the letter is
	boolean ansCorrect = false; //checks if every letter was correct otherwise givers error msg
	char ch; //checks if the letter entered is a number
	boolean validInput = true; //checks if the user entered a valid input
	System.out.println ("Welcome to the discount game");
	System.out.println ("You have been given a ten letter word, which you must find every letter for.\nFor every letter you get correct, you get 10 percent off your new car\nYou get ten turns to guess a letter,\nOne letter at a time even if the letter repeats in the word");


	System.out.println ("Your word has 10 letters, here is the word:");
	do
	{
	    for (int count = 0 ; count < 10 ; count++) //prints out a blank line the first time, then once letters are added it updates the array
	    {
		System.out.print (guessWord [count] + " "); //this is the updated word after every letter

	    }
	    do //this is to check for valid inputs
	    {
		System.out.println ("You have " + remtries + " tries remaining"); //10 tries only , 1 letter per 10% discount
		System.out.println ("Enter a letter");
		letter = br.readLine (); //reading in the letter
		ch = letter.charAt (0); //checking is the letter entered was accidentally a num
		if (letter.length () > 1 || Character.isDigit (ch) == true) //checking if letter is a valid input
		{
		    System.out.println ("You entered a wrong input, enter a valid input, no tries will be deducted");
		    validInput = false;
		}
		else if (letter.length () == 1 && Character.isLetter (ch) == true)
		{
		    validInput = true;
		    break;
		}
	    }
	    while (validInput == false);

	    ansCorrect = false;
	    for (int count = 0 ; count < 10 ; count++)
	    {
		if (letter.equalsIgnoreCase (answerWord [count])) //checking answerkey if the letter is found
		{

		    position = count; //saving the position
		    if (position != invalidPos [count]) //checking if the position is invalid or not, if its not then
		    {
			guessWord [position] = letter; //stores the letter into the array
			invalidPos [count] = position; //stores the position into the invalid position array, so if the same letter appears again it won't be accessed in the same position
			rightAns++; //adding to right answerbin
			ansCorrect = true; //setting flag to true to show that the user got the letter correct
			break;
		    }

		}


	    }
	    if (ansCorrect == false) //if the letter entered by the user isn't in the array, or the letter is in an invalid position
	    {
		System.out.println ("That letter is incorrect or you have no need for that letter anymore\n(All occurences of the letter are in the word)");
	    }

	    attempts++; //adding the attempts
	    remtries--;
	}
	while (attempts != 10); //once ten attempts are done
	System.out.println ("Your guessed answer: ");
	for (int count = 0 ; count < 10 ; count++) //printing out the final word
	{
	    System.out.print (guessWord [count] + " ");

	}

	System.out.println ("\nThe answer key: ");
	for (int count = 0 ; count < 10 ; count++) //printing out the final word
	{
	    System.out.print (answerWord [count] + " ");

	}
	int discount = (rightAns * 10); //the amount of discount
	System.out.println ("\nYou get a " + discount + "% discount on the car");

	return discount;

    }


    boolean Wordle ()
	throws java.io.IOException
    {
	System.out.println();
	System.out.println ("Welcome to wordle!\nNOTE: Each hint regarding the letter(like if its in the right sport, or if its in the word) is respective to the order you entered it in");
	System.out.println ("You must find the word to win the race, else... Goodluck!");
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String answer[] = {"D", "r", "i", "v", "e"};

	String userGuess[] = {"_ ", " _ ", " _ ", " _ ", " _ "};
	String plain[] = {"_ ", " _ ", " _ ", " _ ", " _ "};
	hasPassed = false;

	for (int count = 5 ; count >= 1 ; count--)
	{
	    System.out.println ("You have " + count + " attempts remaining");
	    for (int counter = 0 ; counter <= 4 ; counter++)
	    {
		System.out.print (userGuess [counter]);
	    }
	    System.out.println ();
	    for (int counter = 1 ; counter <= 5 ; counter++)
	    {
		System.out.println ("Enter a letter for position " + counter);
		userGuess [counter - 1] = br.readLine ();
		if (userGuess [counter - 1].length () != 1)
		{
		    do
		    {
			System.out.println ("Invalid, must only be 1 letter");
			System.out.println ("Enter a letter for position " + counter);
			userGuess [counter - 1] = br.readLine ();
		    }
		    while (userGuess [counter - 1].length () != 1);
		}


	    }
	    System.out.print ("You entered \"");
	    for (int counter = 0 ; counter <= 4 ; counter++)
	    {
		System.out.print (userGuess [counter]);
	    }
	    System.out.println ("\"");
	    for (int counter = 0 ; counter <= 4 ; counter++)
	    {
		if (userGuess [counter].equalsIgnoreCase (answer [counter]))
		{
		    hasPassed = true;
		}
		else
		{
		    hasPassed = false;
		    break;
		}

	    }
	    if (hasPassed == true)
	    {
		break;
	    }
	    hasPassed = false;
	    System.out.println ("That is not the right word");
	    for (int count2 = 0 ; count2 <= 4 ; count2++)
	    {

		if (userGuess [count2].equalsIgnoreCase (answer [count2]))
		{
		    System.out.println ("\"" + userGuess [count2] + "\" is in the word and in the right spot");
		}
		else
		{
		    for (int count3 = 0 ; count3 <= 4 ; count3++)
		    {
			if (userGuess [count2].equalsIgnoreCase (answer [count3]))
			{
			    System.out.println ("\"" + userGuess [count2] + "\" is in the word but not in the right spot");
			    break;
			}
		    }


		}

	    }

	    for (int counter = 0 ; counter <= 4 ; counter++)
	    {
		userGuess [counter] = plain [counter];
	    }


	}


	return hasPassed;
    }




    int WhoWantsToBeAMillionaire ()
	throws java.io.IOException
    {
	System.out.println();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	System.out.println ("Welcome to \"Who. Wants. To. Be. A. Millionaire\"");
	System.out.println ("If you win at least $5,000 you survive the robbery and get away with a small amount, if you 500,000 you get away with a decent score, and if you 1,000,000 you get the best score.\nGood Luck");
	String input;
	int money = 0; //total money won
	String userGuess; //the users guess
	String correctAnswer;
	hasPassed = false; //if they got the question correct
	boolean audiencepoll = true; //flags for all the lifelines, once they are triggered, they cannot be used again
	boolean fiftyfifty = true;
	boolean phoneafriend = true;
	boolean validChoice = false; //a flag to check if the users answer is a valid option
	boolean ansChosen = false; //lifelines don't count as an asnwer, so a flag will be there incase, they choose a lifeline and not a real answer(A,B,C,D)
	int randPicker = 0; //this is to pick a random number, which affects the configuration of the lifelines
	int choiceA = 0, choiceB = 0, choiceC = 0, choiceD = 0, remaining = 0; //choices the audience may pick
	int success = 0; // scale of 1-3, judging user success


	//Q1

	System.out.println ("Your $100 question: in the \"Road Runner and Coyote\" cartoons, what famous sound does the Road Runner make? 15s"); //question and displaying options
	System.out.println ("A: Ping! Ping!   | B: Beep! Beep!");
	System.out.println ("-----------------+------------------");
	System.out.println ("C: Aooga! Aooga! | D: Vroom! Vroom!");
	System.out.println ("E: Phone A Friend"); //lifelines
	System.out.println ("F: 50 - 50");
	System.out.println ("G: AudiencePoll");
	System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
	validChoice = false; //the user will only move on if they have a valid choice
	do
	{
	    do //checking for valid choice
	    {
		userGuess = br.readLine ();
		if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
		{
		    validChoice = true; //boolean to ensure their input is valid
		    break; //will get out when they finally enter a valid input
		}
		else
		{
		    System.out.println ("INVALID INPUT"); //if invalid
		    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		}
	    }
	    while (validChoice == false);


	    if (userGuess.equalsIgnoreCase ("B")) //if they answer right, they get the money
	    {
		System.out.println ("Congrats, you win $100");
		money = 100;
		ansChosen = true; //they have chosen an answer
		hasPassed = true; //they have chosen the right answer
		break;
	    }
	    else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D")) //if they answer wrong
	    {
		System.out.println ("You got the question wrong!");
		System.out.println ("You walk away with $" + money);
		System.out.println ("GAME OVER");
		ansChosen = true; //they have chosen an answer
		hasPassed = false; //they have chosen the wrong answer
		break;
	    }
	    else if (userGuess.equalsIgnoreCase ("F")) //start of fiftyfifty lifeline
	    {
		if (fiftyfifty == true) //if they havent used life line before
		{
		    fiftyfifty = false;
		    System.out.println ("The Remaining Answers:"); //the game will show them the remaining answers

		    randPicker = (int) (Math.random () * 3) + 1; // a random picker will choose a number from 1 to 3, based on the number there will be a different configuration for the answers
		    if (randPicker == 1) //config 1
		    {
			System.out.println ("A: Ping! Ping!   | B: Beep! Beep!");
			System.out.println ("-----------------+------------------");
			System.out.println ("                 |               ");
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		    }
		    else if (randPicker == 2) //config 2
		    {

			System.out.println ("                 | B: Beep! Beep!");
			System.out.println ("-----------------+------------------");
			System.out.println ("C: Aooga! Aooga! |               ");
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		    }
		    else if (randPicker == 3) //config 3
		    {

			System.out.println ("                 | B: Beep! Beep!");
			System.out.println ("-----------------+------------------");
			System.out.println ("                 | D: Vroom! Vroom!");
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		    }
		}
		else if (fiftyfifty == false) //if they have used the lifeline before then error msg
		{
		    System.out.println ("You have already used the lifeline");
		    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[G]: ");
		}
	    } //end of fiftyfifty lifeline

	    else if (userGuess.equalsIgnoreCase ("G")) //audience poll lifeline
	    {
		if (audiencepoll == true) //if its available
		{
		    audiencepoll = false; // set it to false since its already used now
		    randPicker = (int) (Math.random () * 100) + 1; //gets a random number, 1-100
		    if (randPicker <= 80) //if less than 80(80% chance the audience knows the answer and they display a higher vote)
		    {
			choiceB = (int) (Math.random () * 21) + 80; // audience will get a number from 80-100, displaying the correct answer as a high number of votes
			remaining = 100 - choiceB; //sees what percentage is remaining after the "big vote"
			do
			{
			    //gets choices for options randomly
			    choiceA = (int) (Math.random () * remaining) + 0;
			    choiceC = (int) (Math.random () * remaining) + 0;
			    choiceD = (int) (Math.random () * remaining) + 0;

			    if ((choiceA + choiceB + choiceC + choiceD) == 100) //goes until the options add up to 100
			    {
				break;
			    }


			}
			while ((choiceA + choiceC + choiceD) != 100);
		    }
		    else if (randPicker > 80) //if its greater than 80(everything thing is random -- only 20% chance of this happening)
		    {
			do
			{
			    choiceA = (int) (Math.random () * 100) + 0; //numbers from 0 - 100 randomly
			    choiceB = (int) (Math.random () * 100) + 0;
			    choiceC = (int) (Math.random () * 100) + 0;
			    choiceD = (int) (Math.random () * 100) + 0;


			    if ((choiceA + choiceB + choiceC + choiceD) == 100) //breaks when it all adds to 100
			    {
				break;
			    }

			}
			while ((choiceA + choiceB + choiceC + choiceD) != 100);

		    }
		    System.out.println ("Audience Picked"); //displays audience vote
		    System.out.println ("A: " + choiceA + "%");
		    System.out.println ("B: " + choiceB + "%");
		    System.out.println ("C: " + choiceC + "%");
		    System.out.println ("D: " + choiceD + "%");
		    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		}
		else
		{
		    System.out.println ("You have already used the lifeline"); //if not equal to true(not available), they have used the lifeline
		    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		}
	    }
	    else if (userGuess.equalsIgnoreCase ("E"))
	    {
		if (phoneafriend == true)
		{
		    phoneafriend = false;
		    randPicker = (int) (Math.random () * 100) + 1;
		    if (randPicker <= 80)
		    {
			System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"B\"."); //80% chance your friend knows the answer
		    }
		    else
		    {
			System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though."); //20& chance your friend knows the answer
		    }
		    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		}
		else
		{
		    System.out.println ("You have already used this lifeline"); //if not equal to true, they've already used the lifeline
		    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		}
	    }

	}
	while (ansChosen == false); // the question will keep going until the user has chosen an answer
	ansChosen = false;
	System.out.println ();
	System.out.println ();

	if (hasPassed == true) //if the user passed the question before, only will it move on
	{
	    //Q2,corect = b, money =200
	    System.out.println ("Your $200 question: Which of these U.S. Presidents appeared on the television series \"Laugh-In\"? 15s");
	    System.out.println ("A: Lyndon Johnson   | B: Richard Nixon");
	    System.out.println ("--------------------+------------------");
	    System.out.println ("C: Jimmy Carter     | D: Gerald Ford");
	    System.out.println ("E: Phone A Friend");
	    System.out.println ("F: 50 - 50");
	    System.out.println ("G: AudiencePoll");
	    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
	    validChoice = false;
	    do
	    {
		do
		{
		    userGuess = br.readLine ();
		    if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
		    {
			validChoice = true;
			break;
		    }
		    else
		    {
			System.out.println ("INVALID INPUT");
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		    }
		}
		while (validChoice == false);


		if (userGuess.equalsIgnoreCase ("B"))
		{
		    System.out.println ("Congrats, you won $200");
		    money = 200;
		    ansChosen = true;
		    hasPassed = true;
		    break;
		}
		else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D"))
		{
		    System.out.println ("You got the question wrong!");
		    System.out.println ("GAME OVER");
		    ansChosen = true;
		    hasPassed = false;
		    break;
		}
		else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		{
		    if (fiftyfifty == true)
		    {
			fiftyfifty = false;
			System.out.println ("The Remaining Answer:");

			randPicker = (int) (Math.random () * 3) + 1;
			if (randPicker == 1)
			{
			    System.out.println ("A: Lyndon Johnson   | B: Richard Nixon");
			    System.out.println ("--------------------+------------------");
			    System.out.println ("                    |                  ");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else if (randPicker == 2)
			{

			    System.out.println ("                    | B: Richard Nixon");
			    System.out.println ("--------------------+------------------");
			    System.out.println ("C: Jimmy Carter     |                 ");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else if (randPicker == 3)
			{
			    System.out.println ("                    | B: Richard Nixon");
			    System.out.println ("--------------------+------------------");
			    System.out.println ("                    | D: Gerald Ford");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (fiftyfifty == false)
		    {
			System.out.println ("You have already used the lifeline");
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");

		    }
		} //end of fiftyfifty
		else if (userGuess.equalsIgnoreCase ("G"))
		{
		    if (audiencepoll == true)
		    {
			audiencepoll = false;
			randPicker = (int) (Math.random () * 100) + 1;
			if (randPicker <= 80)
			{
			    choiceB = (int) (Math.random () * 21) + 80;
			    remaining = 100 - choiceB;
			    do
			    {
				choiceA = (int) (Math.random () * remaining) + 0;
				choiceC = (int) (Math.random () * remaining) + 0;
				choiceD = (int) (Math.random () * remaining) + 0;

				if ((choiceA + choiceB + choiceC + choiceD) == 100)
				{
				    break;
				}


			    }
			    while ((choiceA + choiceC + choiceD) != 100);
			}
			else if (randPicker > 80)
			{
			    do
			    {
				choiceA = (int) (Math.random () * 100) + 0;
				choiceB = (int) (Math.random () * 100) + 0;
				choiceC = (int) (Math.random () * 100) + 0;
				choiceD = (int) (Math.random () * 100) + 0;


				if ((choiceA + choiceB + choiceC + choiceD) == 100)
				{
				    break;
				}

			    }
			    while ((choiceA + choiceB + choiceC + choiceD) != 100);

			}
			System.out.println ("Audience Picked");
			System.out.println ("A: " + choiceA + "%");
			System.out.println ("B: " + choiceB + "%");
			System.out.println ("C: " + choiceC + "%");
			System.out.println ("D: " + choiceD + "%");
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		    }
		    else
		    {
			System.out.println ("You have already used the lifeline");
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		    }
		}
		else if (userGuess.equalsIgnoreCase ("E"))
		{
		    if (phoneafriend == true)
		    {
			phoneafriend = false;
			randPicker = (int) (Math.random () * 100) + 1;
			if (randPicker <= 80)
			{
			    System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"B\".");
			}
			else
			{
			    System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			}
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		    }
		    else
		    {
			System.out.println ("You have already used this lifeline");
			System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		    }
		}

	    }
	    while (ansChosen == false);
	    ansChosen = false;
	    System.out.println ();
	    System.out.println ();

	    //Q3, D
	    if (hasPassed == true)
	    {
		System.out.println ("Your $300 question: Which of these dance names is used to describe a fashionable dot? 45s");
		System.out.println ("A: Hora     | B: Swing");
		System.out.println ("------------+----------");
		System.out.println ("C: Lambada  | D: Polka");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("Congrats, you won $300");
			money = 300;
			ansChosen = true;
			hasPassed = true;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("B"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: Hora     |         ");
				System.out.println ("------------+----------");
				System.out.println ("            | D: Polka");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("            |         ");
				System.out.println ("------------+----------");
				System.out.println ("C: Lambada  | D: Polka");
				System.out.print ("Select --> Option: [D], [C],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("            | B: Swing");
				System.out.println ("------------+----------");
				System.out.println ("            | D: Polka");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");

			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceD = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceD;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceC + choiceB) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }

		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"D\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }
	    if (hasPassed == true)
	    {
		// //Q4//D,500
		System.out.println ("Your $500 question: \"language\" would you say \"ello-hay\" to greet your friends? 45s");
		System.out.println ("A: Bull Latin | B: Dog Latin");
		System.out.println ("--------------+--------------");
		System.out.println ("C: Duck Latin | D: Pig Latin");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C], [D], [E], [F], [G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("Congrats, you won $500");
			money = 500;
			ansChosen = true;
			hasPassed = true;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("B"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: Bull Latin |             ");
				System.out.println ("--------------+--------------");
				System.out.println ("              | D: Pig Latin");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("              |             ");
				System.out.println ("--------------+--------------");
				System.out.println ("C: Duck Latin | D: Pig Latin");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("A:            | B: Dog Latin");
				System.out.println ("--------------+--------------");
				System.out.println ("C:            | D: Pig Latin");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceD = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceD;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceC + choiceB) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"D\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }

		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }


	    if (hasPassed == true)
	    {
		//Q5 c,1000
		System.out.println ("Your $1,000 question: What part of a chicken is commonly called the \"drumstick\"? 45s");
		System.out.println ("A: Breast | B: Wing");
		System.out.println ("----------+------------");
		System.out.println ("C: Leg    | D: Gizzard");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("C"))
		    {
			System.out.println ("Congrats, you won $1000");
			money = 1000;
			ansChosen = true;
			hasPassed = true;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("B"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: Breast |            ");
				System.out.println ("----------+------------");
				System.out.println ("C: Leg    |            ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("          |          ");
				System.out.println ("----------+------------");
				System.out.println ("C: Leg    | D: Gizzard");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("          | B: Wing");
				System.out.println ("----------+------------");
				System.out.println ("C: Leg    |            ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");

			}
		    } //end of fiftyfifty

		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceC = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceC;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;
				    choiceD = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceB + choiceD) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"C\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }
	    if (hasPassed == true)
	    {
		// //Q6 D, 2000
		System.out.println ("Your $2,000 question: What is the only position on a football team that can be \"sacked\"? 45s");
		System.out.println ("A: Center     | B: Wide receiver");
		System.out.println ("--------------+------------------");
		System.out.println ("C: Tight end  | D: Quarterback");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("Congrats, you won $2000");
			money = 2000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("B"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: Center     |               ");
				System.out.println ("--------------+------------------");
				System.out.println ("              | D: Quarterback");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("              |                  ");
				System.out.println ("--------------+------------------");
				System.out.println ("C: Tight end  | D: Quarterback");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("              | B: Wide receiver");
				System.out.println ("--------------+------------------");
				System.out.println ("              | D: Quarterback");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");

			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceD = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceD;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceC + choiceB) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"D\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }

		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }
	    if (hasPassed == true)
	    { // //Q7 c,4000
		System.out.println ("Your $4,000 question: What god of love is often depicted as a chubby winged infant with a bow and arrow? 45s");
		System.out.println ("A: Zeus   | B: Mercury");
		System.out.println ("----------+-------------");
		System.out.println ("C: Cupid  | D: Poseidon");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("C"))
		    {
			System.out.println ("Congrats, you won $4000");
			money = 4000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("B"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: Zeus   | ");
				System.out.println ("----------+-------------");
				System.out.println ("C: Cupid  | ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("          |            ");
				System.out.println ("----------+-------------");
				System.out.println ("C: Cupid  | D: Poseidon");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("          | B: Mercury");
				System.out.println ("----------+-------------");
				System.out.println ("C: Cupid  |");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceC = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceC;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;
				    choiceD = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceB + choiceD) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"C\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }

		}
		while (ansChosen == false);

		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }
	    if (hasPassed == true)
	    {
		//Q8, D, 8000
		System.out.println ("Your $8,000 question: What Steven Spielberg film climaxes at a place called Devil's Tower?");
		System.out.println ("A: E.T: The Extra-Terrestrial   | B: Jurassic Park");
		System.out.println ("--------------------------------+---------------------------------------");
		System.out.println ("C: Raiders of the Lost Ark      | D: Close Encounters of the Third Kind");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("Congrats, you won $8000");
			money = 8000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("B"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("                                | B: Jurassic Park");
				System.out.println ("--------------------------------+---------------------------------------");
				System.out.println ("                                | D: Close Encounters of the Third Kind");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("A: E.T: The Extra-Terrestrial   |");
				System.out.println ("--------------------------------+---------------------------------------");
				System.out.println ("                                | D: Close Encounters of the Third Kind");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("                                | ");
				System.out.println ("--------------------------------+---------------------------------------");
				System.out.println ("C: Raiders of the Lost Ark      | D: Close Encounters of the Third Kind");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceD = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceD;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceC + choiceB) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    ;
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"D\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }
	    if (hasPassed == true)
	    {
		// //Q9 16000, B
		System.out.println ("Your $16,000 question: In what U.S. town did the famous 1881 shoot-out at the O.K. Corral take place?");
		System.out.println ("A: Laramie   | B: Tombstone");
		System.out.println ("-------------+--------------");
		System.out.println ("C: El Paso   | D: Dodge City");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("B"))
		    {
			System.out.println ("Congrats, you won $16000");
			money = 16000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: Laramie   | B: Tombstone");
				System.out.println ("-------------+--------------");
				System.out.println ("             |              ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("             | B: Tombstone");
				System.out.println ("-------------+--------------");
				System.out.println ("C: El Paso   | ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("             | B: Tombstone");
				System.out.println ("-------------+--------------");
				System.out.println ("             | D: Dodge City");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceB = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceB;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 1;
				    choiceC = (int) (Math.random () * remaining) + 1;
				    choiceD = (int) (Math.random () * remaining) + 1;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceC + choiceD) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 1;
				    choiceB = (int) (Math.random () * 100) + 1;
				    choiceC = (int) (Math.random () * 100) + 1;
				    choiceD = (int) (Math.random () * 100) + 1;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"B\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }
	    if (hasPassed == true)
	    {
		// //Q10 a 3200
		System.out.println ("Your $32,000 question: Which of the following months has no U.S. federal holiday?");
		System.out.println ("A: August    | B: February");
		System.out.println ("-------------+-------------");
		System.out.println ("C: September | D: November");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("A"))
		    {
			System.out.println ("Congrats, you won $32000");
			money = 32000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: August    |");
				System.out.println ("-------------+-------------");
				System.out.println ("C: September |");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("A: August    | B: February");
				System.out.println ("-------------+-------------");
				System.out.println ("             | ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("A: August    |");
				System.out.println ("-------------+-------------");
				System.out.println ("             | D: November");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceA = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceA;
				do
				{
				    choiceB = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceD = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceB + choiceC + choiceD) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"A\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }
	    if (hasPassed == true)
	    {
		// //Q11 a 64000
		System.out.println ("Your $64,000 question: What mythological beast is reborn from its own ashes?");
		System.out.println ("A: Phoenix   | B: Minotaur");
		System.out.println ("-------------+-------------");
		System.out.println ("C: Dragon    | D: Golem");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("A"))
		    {
			System.out.println ("Congrats, you won $64000");
			money = 64000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: Phoenix   |");
				System.out.println ("-------------+-------------");
				System.out.println ("C: Dragon    |");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("A: Phoenix   | B: Minotaur");
				System.out.println ("-------------+-------------");
				System.out.println ("             |             ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("A: Phoenix   | ");
				System.out.println ("-------------+-------------");
				System.out.println ("             | D: Golem");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceA = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceA;
				do
				{
				    choiceB = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceD = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceB + choiceC + choiceD) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    ;
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"A\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }
	    if (hasPassed == true)
	    {
		// //Q12 d. 125000
		System.out.println ("Your $125,000 question: Who developed the first effective vaccine against polio?");
		System.out.println ("A: Albert Sabin  | B: Niels Bohr");
		System.out.println ("-----------------+---------------");
		System.out.println ("C: Louis Pasteur | D: Jonas Salk");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("Congrats, you won $125000");
			money = 125000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("A"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("                 | ");
				System.out.println ("-----------------+---------------");
				System.out.println ("C: Louis Pasteur | D: Jonas Salk");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("A: Albert Sabin  |              ");
				System.out.println ("-----------------+---------------");
				System.out.println ("                 | D: Jonas Salk");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("                 | B: Niels Bohr");
				System.out.println ("-----------------+---------------");
				System.out.println ("C:               | D: Jonas Salk");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceD = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceD;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceC + choiceB) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"D\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }



	    if (hasPassed == true)
	    {
		// //Q13 c 250000
		System.out.println ("Your $250,000 question: Which of the following is not a monotheistic religion?");
		System.out.println ("A: Islam    | B: Judaism");
		System.out.println ("------------+-----------------");
		System.out.println ("C: Hinduism | D: Christianity");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("C"))
		    {
			System.out.println ("Congrats, you won $250000");
			money = 250000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("A"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("A: Islam    |");
				System.out.println ("------------+-----------------");
				System.out.println ("C: Hinduism |");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("            | ");
				System.out.println ("------------+-----------------");
				System.out.println ("C: Hinduism | D: Christianity");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("            | B: Judaism");
				System.out.println ("------------+-----------------");
				System.out.println ("C: Hinduism |            ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceC = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceC;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;
				    choiceD = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceB + choiceD) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"C\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }



	    if (hasPassed == true)
	    {
		// //Q14 D,500,000
		System.out.println ("Your $500,000 question: What architect designed the glass pyramid in the courtyard of the Louvre?");
		System.out.println ("A: Philip Johnson| B: Le Corbusier");
		System.out.println ("-----------------+----------------");
		System.out.println ("C: Frank Gehry   | D: I.M. Pei");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("D"))
		    {
			System.out.println ("Congrats, you won $500,000");
			money = 500000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("A"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answer:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("                 | ");
				System.out.println ("-----------------+----------------");
				System.out.println ("C: Frank Gehry   | D: I.M. Pei");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("A: Philip Johnson| ");
				System.out.println ("-----------------+----------------");
				System.out.println ("                 | D: I.M. Pei");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("                 | B: Le Corbusier");
				System.out.println ("-----------------+----------------");
				System.out.println ("                 | D: I.M. Pei");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceD = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceD;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceB = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceC + choiceB) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"D\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);
		ansChosen = false;
		System.out.println ();
		System.out.println ();
	    }



	    if (hasPassed == true)
	    {
		// //Q15 B
		System.out.println ("Your $1,000,000 question: Which programming language does Mrs. Ganesan teach in Grade 11");
		System.out.println ("A: Python   | B: Java");
		System.out.println ("------------+---------");
		System.out.println ("C: Turing   | D: French");
		System.out.println ("E: Phone A Friend");
		System.out.println ("F: 50 - 50");
		System.out.println ("G: AudiencePoll");
		System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
		validChoice = false;
		do
		{
		    do
		    {
			userGuess = br.readLine ();
			if (userGuess.equalsIgnoreCase ("A") || userGuess.equalsIgnoreCase ("B") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("E") || userGuess.equalsIgnoreCase ("F") || userGuess.equalsIgnoreCase ("G") && userGuess.length () == 1)
			{
			    validChoice = true;
			    break;
			}
			else
			{
			    System.out.println ("INVALID INPUT");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    while (validChoice == false);


		    if (userGuess.equalsIgnoreCase ("B"))
		    {
			System.out.println ("Congrats, you won $1,000,000");
			money = 1000000;
			ansChosen = true;
			hasPassed = true; //check
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("D") || userGuess.equalsIgnoreCase ("C") || userGuess.equalsIgnoreCase ("A"))
		    {
			System.out.println ("You got the question wrong!");
			System.out.println ("GAME OVER");
			ansChosen = true;
			hasPassed = false;
			break;
		    }
		    else if (userGuess.equalsIgnoreCase ("F")) //start of fifty
		    {
			if (fiftyfifty == true)
			{
			    fiftyfifty = false;
			    System.out.println ("The Remaining Answers:");

			    randPicker = (int) (Math.random () * 3) + 1;
			    if (randPicker == 1)
			    {
				System.out.println ("            | B: Java");
				System.out.println ("------------+---------");
				System.out.println ("            | D: French");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 2)
			    {

				System.out.println ("A: Python   | B: Java");
				System.out.println ("------------+---------");
				System.out.println ("            | ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			    else if (randPicker == 3)
			    {
				System.out.println ("            | B: Java");
				System.out.println ("------------+---------");
				System.out.println ("C: Turing   |         ");
				System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			    }
			}
			else if (fiftyfifty == false)
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    } //end of fiftyfifty
		    else if (userGuess.equalsIgnoreCase ("G"))
		    {
			if (audiencepoll == true)
			{
			    audiencepoll = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				choiceB = (int) (Math.random () * 21) + 80;
				remaining = 100 - choiceB;
				do
				{
				    choiceA = (int) (Math.random () * remaining) + 0;
				    choiceC = (int) (Math.random () * remaining) + 0;
				    choiceD = (int) (Math.random () * remaining) + 0;

				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }


				}
				while ((choiceA + choiceC + choiceD) != 100);
			    }
			    else if (randPicker > 80)
			    {
				do
				{
				    choiceA = (int) (Math.random () * 100) + 0;
				    choiceB = (int) (Math.random () * 100) + 0;
				    choiceC = (int) (Math.random () * 100) + 0;
				    choiceD = (int) (Math.random () * 100) + 0;


				    if ((choiceA + choiceB + choiceC + choiceD) == 100)
				    {
					break;
				    }

				}
				while ((choiceA + choiceB + choiceC + choiceD) != 100);

			    }
			    System.out.println ("Audience Picked");
			    System.out.println ("A: " + choiceA + "%");
			    System.out.println ("B: " + choiceB + "%");
			    System.out.println ("C: " + choiceC + "%");
			    System.out.println ("D: " + choiceD + "%");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}


			else
			{
			    System.out.println ("You have already used the lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		    else if (userGuess.equalsIgnoreCase ("E"))
		    {
			if (phoneafriend == true)
			{
			    phoneafriend = false;
			    randPicker = (int) (Math.random () * 100) + 1;
			    if (randPicker <= 80)
			    {
				System.out.println ("Hey its your friend Sam. I think I know this one, I feel like its \"B\".");
			    }
			    else
			    {
				System.out.println ("Hey its your friend Sam. Man... I don't know! I'm sorry, good luck though.");
			    }
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
			else
			{
			    System.out.println ("You have already used this lifeline");
			    System.out.print ("Select --> Option: [A], [B], [C],[D],[E],[F],[G]: ");
			}
		    }
		}
		while (ansChosen == false);

		System.out.println ();
		System.out.println ();


	    }

	}

	if (money >= 5000)
	{
	    success = 1;
	    if (money == 500000)
	    {
		success = 2;
	    }
	    else if (money == 1000000)
	    {
		success = 3;
	    }
	}
	else
	{
	    success = 0;
	}
	return success;
    }
}






