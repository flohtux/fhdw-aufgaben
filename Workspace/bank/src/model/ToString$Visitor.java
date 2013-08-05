package model;

import common.Fraction;
import static serverConstants.ToStringConstants.*;

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
		this.result = "Account:" + new Long(account.getAccountNumber()).toString();
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
		this.result = serverConstants.ToStringConstants.EuroCurrencyToString;
	}
	@Override
	public void handleDollar(PersistentDollar dollar)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.DollarCurrencyToString;
	}
	@Override
	public void handleMixedFee(PersistentMixedFee mixedFee)
			throws PersistenceException {
		result = "gemischte Überweisungskosten=" + mixedFee.getFix() + " bis " + mixedFee.getLimit() + " danach " + mixedFee.getProcentual().toString(true);
		
	}

	@Override
	public void handleFixTransactionFee(
			PersistentFixTransactionFee fixTransactionFee)
			throws PersistenceException {
		result = "fixe Überweisungskosten=" + fixTransactionFee.getValue();
		
	}
	@Override
	public void handleAmount(PersistentAmount amount)
			throws PersistenceException {
		this.result = amount.getBalance().toString();
	}
	@Override
	public void handleMoney(PersistentMoney money) throws PersistenceException {
		this.result = money.getAmount().toString(true)+ " "+money.getCurrency().toString(true);
	}
	@Override
	public void handleProcentualFee(PersistentProcentualFee procentualFee)
			throws PersistenceException {
		result = "prozentuale Überweisungskosten=" + procentualFee.getPercent().toString(true);
		
	}
	@Override
	public void handleDebitNote(PersistentDebitNote debitNote)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleRequestState(PersistentRequestState requestState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNotSuccessfullStorneState(
			PersistentNotSuccessfullStorneState notSuccessfullStorneState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNoRequestState(PersistentNoRequestState noRequestState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTemplateState(PersistentTemplateState templateState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleInternalFee(PersistentInternalFee internalFee)
			throws PersistenceException {
		result = "Rabatt auf interne Überweisungen=" + internalFee.getPercent().toString();
		
	}
	@Override
	public void handleNotExecutetState(
			PersistentNotExecutetState notExecutetState)
			throws PersistenceException {
		// TODO Auto-generated method stub

	}
	@Override
	public void handleExecutedState(PersistentExecutedState executedState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNotSuccessfullState(
			PersistentNotSuccessfullState notSuccessfullState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNotExecutableState(
			PersistentNotExecutableState notExecutableState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleSuccessfullState(
			PersistentSuccessfullState successfullState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handlePercent(PersistentPercent percent)
			throws PersistenceException {
		result = percent.getValue().multiply(new Fraction(100, 1)).toString() + PercentSign;
		
	}
	@Override
	public void handleTransaction(PersistentTransaction transaction)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNoLimit(PersistentNoLimit noLimit)
			throws PersistenceException {
		this.result = NoLimitType;
	}
	@Override
	public void handleTransfer(PersistentTransfer transfer)
			throws PersistenceException {
		this.result = "Überweisung: "+transfer.getMoney().getAmount().toString(true);
	}
	@Override
	public void handleSuccessfullStornoState(
			PersistentSuccessfullStornoState successfullStornoState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleLimitAccount(PersistentLimitAccount limitAccount)
			throws PersistenceException {
		this.result = MaxLimitPrefix + limitAccount.getMaxLimit().toString(true) + MinMaxLimitDelimiter + MinLimitPrefix + limitAccount.getMinLimit().toString(true);
	}
	@Override
	public void handleLimit(PersistentLimit limit) throws PersistenceException {
		this.result = limit.getMoney().toString(true);
	}
	@Override
	public void handleFalseValue(PersistentFalseValue falseValue)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTrueValue(PersistentTrueValue trueValue)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}


}
