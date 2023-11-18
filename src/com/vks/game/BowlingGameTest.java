package com.vks.game;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

	@Test
	public void testAllZeros() {
		BowlingGame game = new BowlingGame();
		for (int i = 0; i < 20; i++) {
			game.throwBall(0);
		}
		assertEquals(0, game.getScore());
	}

	@Test
	public void testAllStrikes() {
		BowlingGame game = new BowlingGame();
		for (int i = 0; i < 12; i++) {
			game.throwBall(10);
		}
		assertEquals(300, game.getScore());
	}

	@Test
	public void testAllSpares() {
		BowlingGame game = new BowlingGame();
		for (int i = 0; i < 21; i++) {
			game.throwBall(5);
		}
		assertEquals(150, game.getScore());
	}

	@Test
	public void testRandomGame() {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.throwBall(10); // Strike
		bowlingGame.throwBall(9);
		bowlingGame.throwBall(1); // Spare
		bowlingGame.throwBall(5);
		bowlingGame.throwBall(5); // Spare
		bowlingGame.throwBall(7);
		bowlingGame.throwBall(2);
		bowlingGame.throwBall(10); // Strike
		bowlingGame.throwBall(10); // Strike
		bowlingGame.throwBall(10); // Strike
		bowlingGame.throwBall(9);
		bowlingGame.throwBall(0);
		bowlingGame.throwBall(8);
		bowlingGame.throwBall(2);
		bowlingGame.throwBall(9);
		bowlingGame.throwBall(1); // Spare
		bowlingGame.throwBall(10); // Bonus ball for the last spare

		assertEquals(187, bowlingGame.getScore());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidThrow() {
		BowlingGame game = new BowlingGame();
		game.throwBall(11); // Throws more than 10 pins, should throw an exception
	}
}
