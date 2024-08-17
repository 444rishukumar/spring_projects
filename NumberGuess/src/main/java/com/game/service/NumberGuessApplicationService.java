package com.game.service;

import org.springframework.stereotype.Service;

@Service
public class NumberGuessApplicationService {

	private int secretNumber;

	private int remainingAttempt;

	public void restart() {
		secretNumber = (int) ((Math.random() * 10) + 1);
		remainingAttempt = 3;
	}

	public String guess(int number) {
		if (remainingAttempt <= 0) {
			return "Sorry you have used all your attempt. The Secret Number is : " + secretNumber;
		} else if (number == secretNumber) {
			return "Congratulation!!! You guessed the secret number correctly";
		} else if (number < secretNumber) {
			remainingAttempt--;
			if (remainingAttempt == 0) {
				return "Sorry you have used all your attempt. The Secret Number is : " + secretNumber;
			}
			return "The secret number is higher then number : " + number + ". You have " + remainingAttempt
					+ " attempt left.";
		} else {
			remainingAttempt--;
			if (remainingAttempt == 0) {
				return "Sorry you have used all your attempt. The Secret Number is : " + secretNumber;
			}
			return "The secret number is lower then number : " + number + ". You have " + remainingAttempt
					+ " attempt left.";
		}

	}

}
