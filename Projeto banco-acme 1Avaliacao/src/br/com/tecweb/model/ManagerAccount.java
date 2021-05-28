package br.com.tecweb.model;

import java.util.List;

import lombok.Data;

@Data
public class ManagerAccount {

	public static void main(String[] args) {
		
		Client client1 = new Client();
		client1.setId(1L);
		client1.setEmail("joaosilva@gmail");
		client1.setName("João da silva");
		client1.setPhone("83 987630402");
		
		
		Account account = new Account();
		account.setId(1L);
		account.setAgency("001");
		account.setNumber("100");
		account.setBalance(100.0);
		account.setClient(client1);
		
		Client clientSaving = new Client();
		clientSaving.setId(2L);
		clientSaving.setName("andre");
		clientSaving.setEmail("andre@gmail");
		clientSaving.setPhone("83 988756735");
		
		SavingAccount savingAccount = new SavingAccount ( 2L, "002", "111", 50.0, clientSaving, null);
		
		account.deposit(100.00);
		savingAccount.withdraw(10.0);
		savingAccount.deposit(1000.00);
		
		System.out.println(account.extract());
		System.out.println(savingAccount.extract());
		
		
	}
	
}

