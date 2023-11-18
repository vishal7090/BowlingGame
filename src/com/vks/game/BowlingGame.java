package com.vks.game;

public class BowlingGame {

	private static final int MAX_ROLLS = 21; // Maximum possible rolls (10 frames * 2 rolls + 1 for possible bonus roll)
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int TEN = 10;
	private static final String SPACE = " ";
	private static final String DOUBLE_SPACE = "  ";
	private static final String DOUBLE_PIPE = "||";
	private static final String DASH = "-";
	private static final String X = "X";
	private static final String SLASH = "/";
	private static final String TAB = "\t";

	private int[] rolls = new int[MAX_ROLLS];
	private int currentRoll = ZERO;

	public void throwBall(int pins) {
		if (pins < ZERO || pins > TEN) {
			throw new IllegalArgumentException("Number of pins must be between 0 and 10.");
		}
		rolls[currentRoll++] = pins;
	}

	public int getScore() {
		int score = ZERO;
		int rollIndex = ZERO;

		for (int frame = ZERO; frame < TEN; frame++) {
			if (isStrike(rollIndex)) {
				score += TEN + strikeBonus(rollIndex);
				rollIndex++;
			} else if (isSpare(rollIndex)) {
				score += TEN + spareBonus(rollIndex);
				rollIndex += TWO;
			} else {
				score += sumOfBallsInFrame(rollIndex);
				rollIndex += TWO;
			}
		}

		return score;
	}

	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == TEN;
	}

	private boolean isSpare(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + ONE] == TEN;
	}

	private int strikeBonus(int rollIndex) {
		return rolls[rollIndex + ONE] + rolls[rollIndex + TWO];
	}

	private int spareBonus(int rollIndex) {
		return rolls[rollIndex + TWO];
	}

	private int sumOfBallsInFrame(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + ONE];
	}

	public void printScorecard() {
		int rollIndex = ZERO;
		int runningTotal = ZERO;

		System.out.println("Frame" + TAB + SPACE + DOUBLE_PIPE + " Sign" + TAB + SPACE + DOUBLE_PIPE + " Score" + TAB);

		for (int frame = ZERO; frame < TEN; frame++) {
			int firstThrow = rolls[rollIndex];
			int secondThrow = rolls[rollIndex + ONE];

			int counter = frame + ONE;
			System.out.print(DOUBLE_SPACE + counter + TAB + SPACE + DOUBLE_PIPE);

			if (isStrike(rollIndex)) {
				System.out.print(SPACE + DOUBLE_SPACE + X + TAB);
				runningTotal += TEN + strikeBonus(rollIndex);
				rollIndex++;
			} else if (isSpare(rollIndex)) {
				System.out.print(SPACE + firstThrow + SPACE + SLASH + TAB);
				runningTotal += TEN + spareBonus(rollIndex);
				rollIndex += TWO;
			} else {
				System.out.print(SPACE + firstThrow + SPACE + (secondThrow == ZERO ? DASH : secondThrow) + TAB);
				runningTotal += sumOfBallsInFrame(rollIndex);
				rollIndex += TWO;
			}

			System.out.print(TAB + SPACE + DOUBLE_PIPE + SPACE + runningTotal);
			System.out.println();
		}

		System.out.println("\n===================================");
		System.out.println("\nTotal Score: " + getScore());
	}
}
