import javax.swing.JOptionPane;

public class RPS2
{
	public static void main(String[] args) 
	{
		String player = "";
		int computer;
		String message = "";
		String instructions = "Type one of the following: \nRock\nPaper\nScissors";
		String cp;
		final int LOW = 1;
		final int HIGH = 3;
		final int NUM_GAMES = 5;
		int gameCount = 0;
		int pWins = 0;
		int cWins = 0;
		int draws = 0;

		//loop that tests how many games have been played after 5
		while(gameCount < NUM_GAMES)
		{
			player = "";
			message = "";

			//computers randomly generated selection
			computer = LOW + (int)(Math.random() * HIGH);

			while(!player.equalsIgnoreCase("RoCk") && !player.equalsIgnoreCase("pApeR") && !player.equalsIgnoreCase("sCiSsoRs"))
			{
				player = JOptionPane.showInputDialog(null, instructions);
				player = player.toLowerCase();
				if(player.startsWith("ro"))
					player = "ROCK";
				else if(player.startsWith("pa"))
					player = "PAPER";
				else if(player.startsWith("sc"))
					player = "SCISSORS";
				else
					JOptionPane.showMessageDialog(null, "You must pick ROCK, PAPER, or SCISSORS");
			}// end of inner while loop

			//turn the choice of the computer into a string for output.
			if(computer == 1)
				cp = "ROCK";
			else if(computer == 2)
				cp = "PAPER";
			else 
				cp = "SCISSORS";

			//Game mechanics
			if(player.equals(cp))
			{
				message = "We have a tie!";
				++draws;
			}
			else
				if(player.equals("ROCK"))
					if(cp.equals("PAPER"))
					{
						message = "The computers PAPER blinds your ROCK, you lose...";
						cWins++;
					}
					else
					{
						message = "Your ROCK crushes the computers SCISSORS, you win!";
						pWins++;
					}
				else
					if(player.equals("PAPER"))
						if(cp.equals("SCISSORS"))
						{
							message = "The computer uses SCISSORS to slice right through your PAPER, \nand they use the remains of the PAPER to cut you..!";
							cWins++;
						}
						else
						{
							message = "Your PAPER ingulphs the computers ROCK you have won.";
							pWins++;
						}
					else
						if(cp.equals("ROCK"))
						{
							message = "The immobile object that is your computer breaks your \nSCISSORS with it's massive, hard ROCK... you lost this one";
							cWins++;
						}
						else
						{
							message = "You have sliced all the computer PAPER with your tremendous SCISSORS. Your SCISSORS will cut!";
							pWins++;
						}
		
				++gameCount;
				// output message after each game
				JOptionPane.showMessageDialog(null, "You chose " + player + "\nThe computer picked " + cp + "\nResult: " + message + "\nYou have played " + gameCount + " game(s) so far!");

		}

	//output message dialog box displaying the total score
	JOptionPane.showMessageDialog(null, "The game is now complete. \nYou have won " + pWins + " game(s). \nThe computer won " + cWins + " game(s). \nThere was only " + draws + " draw(s).");
	}
}