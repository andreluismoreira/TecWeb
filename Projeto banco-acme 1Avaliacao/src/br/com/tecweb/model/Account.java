package br.com.tecweb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Account {

	private Long id;
	private String number;
	private String agency;
	private Double balance;
	private Client client;
	private List <Transaction> transactions = new ArrayList<Transaction>();
	
	public Double withdraw(Double value) {
		if (this.balance >= value) {
			this.balance -= value;
		}
		transactions.add(createTransaction(this, value, "withdraw"));
		return this.balance;
	}
	
	public Double deposit(Double value) {
		transactions.add(createTransaction(this, value, "deposit"));
		return this.balance += value;
		
	}
	
	public Double transfer(Account account,Double value) {
		if (this.balance >= value) {
			this.withdraw(value);
			account.deposit(value);
		}
		transactions.add(createTransaction(this, value, "transfer"));
		return this.balance;
	}
	
	public List<Transaction> listarTransacoes(){
		return transactions;
	}
	
	
	public Transaction createTransaction(Account account, Double value, String typeTransaction) {
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setValue(value);
		transaction.setTypeTransaction(typeTransaction);
		transaction.setDataTimeTransaction(LocalDateTime.now());
		
		return transaction;
	}
	
	public String formatDate(LocalDateTime date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateNow = date.format(formatter);
		
		return dateNow;
		
	}
	
	public String extract() {
		String bank = "==== Acme Bank ====\n";
		for (Transaction transaction : transactions) {
			if (this.equals(transaction.getAccount())) {
				bank += transaction.getTypeTransaction() + "\n" 
						+ transaction.getValue() + "\n"
						+ transaction.getAccount().client.getName() + "\n"
						+ formatDate(transaction.getDataTimeTransaction()) + "\n";
					
		}
	
	 }
		bank += "Balance = R$: " + this.balance + "\n";
		return bank;
	}
	
}




