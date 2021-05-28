package br.com.tecweb.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SavingAccount extends Account {

	private Double yieldsaving;
	
	public SavingAccount (Long id, String number, String agency, Double balance, Client client, Double yielsaving) {
		setId(id);
		setAgency(agency);
		setBalance(balance);
		setClient(client);
		setNumber(number);
		this.yieldsaving = 0.05;
	}
	

	public Double setYielsaving() {
		yieldsaving = getBalance() * (yieldsaving/100);
		if (LocalDateTime.now().getDayOfMonth() == 10);
		this.setBalance(getBalance() + yieldsaving);
		getTransactions().add(createTransaction(this, yieldsaving, "yieldsaving"));
		return getBalance();
		
		
	}
	
}
