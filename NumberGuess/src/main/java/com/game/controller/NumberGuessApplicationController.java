package com.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.service.NumberGuessApplicationService;

@RestController
@RequestMapping("/api")
public class NumberGuessApplicationController {

	@Autowired
	private NumberGuessApplicationService numberGuessApplicationService;

	@GetMapping("/restart")
	public String retart() {
		numberGuessApplicationService.restart();
		return "Game started. You have 5 attempt to guess the secret number";
	}

	@GetMapping("/guess/{number}")
	public String guess(@PathVariable int number) {

		return numberGuessApplicationService.guess(number);
	}

}
