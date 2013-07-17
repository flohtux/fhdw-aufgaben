package model;

import persistence.*;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		result = null;
		anything.accept(this);
		if (result == null) {
			this.standardHandling(anything);
		}
		return result;
	}
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
	}
	@Override
	public void handleAdministrator(PersistentAdministrator administrator)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.AdministratorPrefix + administrator.getAccess().getUser();
	}
	@Override
	public void handleBank(PersistentBank bank) throws PersistenceException {
		this.result = bank.getName() + 
					  serverConstants.ToStringConstants.BankNameAndNumberSeparator + 
					  bank.getBankNumber() + 
					  serverConstants.ToStringConstants.BankNumberCloser;
	}
	@Override
	public void handleAccount(PersistentAccount account)
			throws PersistenceException {
		this.result = new Long(account.getAccountNumber()).toString();
	}
	@Override
	public void handleBankCreator(PersistentBankCreator bankCreator)
			throws PersistenceException {
	}
	@Override
	public void handleAccountService(PersistentAccountService accountService)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.BankPrefix +
		accountService.getAccount().getBank().toString(true) +
		serverConstants.ToStringConstants.BankAndAccountSeparator +
		accountService.getAccount().toString(true);

	}
	@Override
	public void handleBankService(PersistentBankService bankService)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.BankPrefix + bankService.getBank().toString(true); 
	}
	@Override
	public void handleEuro(PersistentEuro euro) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleDollar(PersistentDollar dollar)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleMixedFee(PersistentMixedFee mixedFee)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNoLimitState(PersistentNoLimitState noLimitState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleFixTransactionFee(
			PersistentFixTransactionFee fixTransactionFee)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleMinLimitState(PersistentMinLimitState minLimitState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleMaxLimitState(PersistentMaxLimitState maxLimitState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleAmount(PersistentAmount amount)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleMoney(PersistentMoney money) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleProcentualFee(PersistentProcentualFee procentualFee)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleDebitNote(PersistentDebitNote debitNote)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTrancaction(PersistentTrancaction trancaction)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}


}
