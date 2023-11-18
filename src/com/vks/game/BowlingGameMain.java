package com.vks.game;

public class BowlingGameMain {

	public static void main(String[] args) {
		BowlingGame bowlingGame = new BowlingGame();

		// Simulate a game by making throws
		//1
		bowlingGame.throwBall(10); // Strike
		
		//2
		bowlingGame.throwBall(9);
		bowlingGame.throwBall(1);  // Spare
		
		//3
		bowlingGame.throwBall(5);
		bowlingGame.throwBall(5); // Spare
		
		//4
		bowlingGame.throwBall(7);
		bowlingGame.throwBall(2); 
		
		//5
		bowlingGame.throwBall(10); // Strike
		
		//6
		bowlingGame.throwBall(10); // Strike
		
		//7
		bowlingGame.throwBall(10); // Strike
		
		//8
		bowlingGame.throwBall(9);
		bowlingGame.throwBall(0);
		
		//9
		bowlingGame.throwBall(8);
		bowlingGame.throwBall(2);
		
		//10
		bowlingGame.throwBall(9);
		bowlingGame.throwBall(1); // Spare
		bowlingGame.throwBall(10); // Bonus ball for the last spare

		// Print the scorecard
		bowlingGame.printScorecard();
	}

}
