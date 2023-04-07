package com.codercampus.Assignment11.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionsController {

	@GetMapping("")
	public String demo() {
		return "transactions";
	}
}
