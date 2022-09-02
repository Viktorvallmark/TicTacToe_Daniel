import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean gameIsOn = true;
		
		Scanner scanner = new Scanner(System.in);
		
		while(gameIsOn) {
			
			gameMenu();
			
			String userInput = scanner.nextLine();
			
			switch(userInput) {
			case "1":
				playerVsPlayer(scanner);
				break;
			case "2":
				playerVsAi(scanner);
				break;
			case "3": 
				displayRules();
				break;
			case "4": 
				System.out.println("Exiting game... Bye!\n");
				gameIsOn = false;
				break;
			default: 
				System.out.println("Unknown input \n");
				break;
			}
			
		}
		
		scanner.close();
	};

	private static void gameMenu() {
		
		System.out.println("\n xXxXxXxXxXxxXxXxXxXxXxxXxXxXxXxXxxXxXxXxXxXxxXxXxXxXxXxxXxX \n"		+ 		 
						   " \r\n"
						   + "  _______ _          _______             _______         \r\n"
						   + " |__   __(_)        |__   __|           |__   __|        \r\n"
						   + "    | |   _  ___ ______| | __ _  ___ ______| | ___   ___ \r\n"
						   + "    | |  | |/ __|______| |/ _` |/ __|______| |/ _ \\ / _ \\\r\n"
						   + "    | |  | | (__       | | (_| | (__       | | (_) |  __/\r\n"
						   + "    |_|  |_|\\___|      |_|\\__,_|\\___|      |_|\\___/ \\___|\r\n"
						   + "                                                         \r\n"
						   + "                                                         \r\n"
						   + " \n"			+		 
						   " oOoOoOoOoOooOoOoOoOoOooOoOoOoOoOooOoOoOoOoOooOoOoOoOoOooOoOoO \n\n"			+		 
						   " 1. Player vs Player \n"	+ 
						   " 2. Player vs AI \n"		+ 	 
						   " 3. Game Rules \n"		+ 		 
						   " 4. Exit");
	}
	
	private static void displayRules() {
		
		System.out.println(" ---------------------" + "\n"+
						   " RULES FOR TIC-TAC-TOE" + "\n"+
						   " ---------------------" + "\n");

		System.out.println(" 1|2|3" + "\n" + 
						   " -+-+-" + "\n" +
						   " 4|5|6" + "\n" +
						   " -+-+-" + "\n" +
						   " 7|8|9" + "\n" );
		
		System.out.println(" 1. The game is played on a grid that's 3 squares by 3 squares." + "\n" + 
						   " 2. You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares." + "\n" + 
						   " 3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner." + "\n" +
						   " 4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie. \n" );

	}

	private static void playerVsAi(Scanner scanner) {
		
		char[][] gameBoard = { 
							 { ' ', ' ', ' ' },
							 { ' ', ' ', ' ' },
							 { ' ', ' ', ' ' }};
		

		printBoard(gameBoard);

		while (true) {

			playerOneTurn(gameBoard, scanner);

			if (isGameFinishedPvA(gameBoard))
				break;

			printBoard(gameBoard);

			aiTurn(gameBoard);

			if (isGameFinishedPvA(gameBoard))
				break;

			printBoard(gameBoard);

		}
	}
	
	private static void playerVsPlayer(Scanner scanner) {
		
		char[][] gameBoard = { 
							 { ' ', ' ', ' ' },
							 { ' ', ' ', ' ' },
							 { ' ', ' ', ' ' }
							 };
		
		int coinFlip = (int) (Math.floor(Math.random()*2)+ 1);
		
		if (coinFlip > 1) {
			
			printBoard(gameBoard);

			
			while (true) {

				playerOneTurn(gameBoard, scanner);

				if (isGameFinishedPvP(gameBoard))
					break;

				printBoard(gameBoard);

				playerTwoTurn(gameBoard, scanner);

				if (isGameFinishedPvP(gameBoard))
					break;

				printBoard(gameBoard);			
			
			}
			
		} else {
			
			printBoard(gameBoard);
			
			while (true) {

				playerTwoTurn(gameBoard, scanner);

				if (isGameFinishedPvP(gameBoard))
					break;

				printBoard(gameBoard);

				playerOneTurn(gameBoard, scanner);

				if (isGameFinishedPvP(gameBoard))
					break;

				printBoard(gameBoard);			
			
			}
		}		
	}

	private static boolean isGameFinishedPvA(char[][] gameBoard) {

		if (checkWinner(gameBoard, 'X')) {

			printBoard(gameBoard);
			System.out.println("\n Player wins!" +
							   "\n Going back to main menu... \n\n");
			pause(150);

			return true;
		}

		if (checkWinner(gameBoard, 'O')) {

			printBoard(gameBoard);
			System.out.println("\n AI wins!" +
							   "\n Going back to main menu... \n\n");
			pause(150);

			return true;
		}

		for (int i = 0; i < gameBoard.length; i++) {
			
			for (int j = 0; j < gameBoard[i].length; j++) {
				
				if (gameBoard[i][j] == ' ') {
					
					return false;
				}
			}
		}

		printBoard(gameBoard);
		
		System.out.println("\n Game is a Tie!" +
						   "\n Going back to main menu...\n\n");
		
		pause(150);
		
		return true;

	}
	
	private static boolean isGameFinishedPvP(char[][] gameBoard) {

		if (checkWinner(gameBoard, 'X')) {

			printBoard(gameBoard);

			System.out.println("\n Player X wins!" +
							   "\n Going back to main menu...\n\n");
			
			pause(150);

			return true;
		}

		if (checkWinner(gameBoard, 'O')) {

			System.out.println("\n Player O wins!" +
							   "\n Going back to main menu...\n\n");
			
			pause(150);

			return true;
		}

		for (int i = 0; i < gameBoard.length; i++) {
			
			for (int j = 0; j < gameBoard[i].length; j++) {
				
				if (gameBoard[i][j] == ' ') 
					return false;
			}
		}

		printBoard(gameBoard);
	
		System.out.println("\n Game is a Tie!" +
						   "\n Going back to main menu...\n\n");
		
		pause(150);
		
		return true;

	}

	private static boolean checkWinner(char[][] gameBoard, char input) {
		
		if ((gameBoard[0][0] == input && gameBoard[0][1] == input && gameBoard[0][2] == input)
		 || (gameBoard[1][0] == input && gameBoard[1][1] == input && gameBoard[1][2] == input)
		 || (gameBoard[2][0] == input && gameBoard[2][1] == input && gameBoard[2][2] == input) 

		 ||	(gameBoard[0][0] == input && gameBoard[1][0] == input && gameBoard[2][0] == input)
	  	 || (gameBoard[0][1] == input && gameBoard[1][1] == input && gameBoard[2][1] == input)
	 	 || (gameBoard[0][2] == input && gameBoard[1][2] == input && gameBoard[2][2] == input) 

	 	 || (gameBoard[0][0] == input && gameBoard[1][1] == input && gameBoard[2][2] == input)
 		 || (gameBoard[0][2] == input && gameBoard[1][1] == input && gameBoard[2][0] == input))
			return true;
		else
			return false;
	}

	private static void aiTurn(char[][] gameBoard) {
		
		pause(150);
		
		Random random = new Random();
		
		int aiMove;
		
		while (true) {

			aiMove = random.nextInt(9) + 1;

			if (canPlace(gameBoard, Integer.toString(aiMove)))
				break;

		}

		System.out.println("\n AI chose " + aiMove);

		placeMove(gameBoard, Integer.toString(aiMove), 'O');
	}

	private static boolean canPlace(char[][] gameBoard, String position) {

		switch (position) {
		
		case "1":
			return (gameBoard[0][0] == ' ');
		case "2":
			return (gameBoard[0][1] == ' ');
		case "3":
			return (gameBoard[0][2] == ' ');
		case "4":
			return (gameBoard[1][0] == ' ');
		case "5":
			return (gameBoard[1][1] == ' ');
		case "6":
			return (gameBoard[1][2] == ' ');
		case "7":
			return (gameBoard[2][0] == ' ');
		case "8":
			return (gameBoard[2][1] == ' ');
		case "9":
			return (gameBoard[2][2] == ' ');
		default:
			return false;
		}

	}

	private static void playerOneTurn(char[][] gameBoard, Scanner scanner) {

		String userInput;

		while (true) {

			System.out.println("\n Player X turn");

			userInput = scanner.nextLine();

			if (canPlace(gameBoard, userInput))
				break;
			else
				System.out.println("\" " + userInput + " \" " + "is not a valid move.");
			
		}

		placeMove(gameBoard, userInput, 'X');
	}
	
	private static void playerTwoTurn(char[][] gameBoard, Scanner scanner) {

		String userInput;

		while (true) {

			System.out.println("\n Player O turn");

			userInput = scanner.nextLine();

			if (canPlace(gameBoard, userInput))
				break;
			else
				System.out.println("\" " + userInput + " \" " + "is not a valid move.");
		}

		placeMove(gameBoard, userInput, 'O');
	}

	private static void placeMove(char[][] gameBoard, String position, char input) {
		
		switch (position) {
		
		case "1":
			gameBoard[0][0] = input;
			break;
		case "2":
			gameBoard[0][1] = input;
			break;
		case "3":
			gameBoard[0][2] = input;
			break;
		case "4":
			gameBoard[1][0] = input;
			break;
		case "5":
			gameBoard[1][1] = input;
			break;
		case "6":
			gameBoard[1][2] = input;
			break;
		case "7":
			gameBoard[2][0] = input;
			break;
		case "8":
			gameBoard[2][1] = input;
			break;
		case "9":
			gameBoard[2][2] = input;
			break;
		default:
			
			System.out.println(" I dont understand :(");
		}
	}

	private static void printBoard(char[][] gameBoard) {
		
		System.out.println(" " + gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]);
		System.out.println(" " + "-+-+-");
		System.out.println(" " + gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]);
		System.out.println(" " + "-+-+-");
		System.out.println(" " + gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
	}
	
	private static void pause(int time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
