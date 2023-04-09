package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionsController {
	@Autowired
	TransactionService service;

	@GetMapping("transactions")
	public String demo(ModelMap model) {
		service.populateData();
//		model.addAttribute("transactions",service.findAll());
		List<Transaction> transactions = service.findAll();
		Transaction transaction = new Transaction();
		model.put("transactions", transactions);
		model.put("transaction", transaction);
		return "transactions";
	}
	
	@GetMapping("transaction.html")
	public String getTransaction(@RequestParam Long transactionId, ModelMap model) {	
		System.out.println(transactionId);
	Transaction transaction = service.findById(transactionId);
	model.put("date", transaction.getDate());
	model.put("amount", transaction.getAmount());
	model.put("transactionId", transactionId);
	model.put("description", transaction.getDescription());
	model.put("type", transaction.getType());
	return "transaction";
}
}
