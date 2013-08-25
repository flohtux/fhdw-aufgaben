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
		this.result = amount.getBalance().formatDec(2);
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
	public void handleDebit(PersistentDebit Debit)
			throws PersistenceException {
		this.result = "Lastschrift";
	}
	@Override
	public void handleRequestState(PersistentRequestState requestState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleNotSuccessfulStornoState(
			PersistentNotSuccessfulStornoState notSuccessfulStornoState)
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
		this.result = "Vorlage";
	}
	@Override
	public void handleInternalFee(PersistentInternalFee internalFee)
			throws PersistenceException {
		result = "Rabatt auf interne Überweisungen=" + internalFee.getPercent().toString();
		
	}
	@Override
	public void handleNotExecutedState(
			PersistentNotExecutedState notExecutedState)
			throws PersistenceException {
		result = "Noch nicht versendet...";
	}
	@Override
	public void handleExecutedState(PersistentExecutedState executedState)
			throws PersistenceException {
		result = "abgesendet...";
	}
	@Override
	public void handleNotSuccessfulState(
			PersistentNotSuccessfulState notSuccessfulState)
			throws PersistenceException {
		result = "nich vollständig ausgefüllt...";
	}
	@Override
	public void handleNotExecutableState(
			PersistentNotExecutableState notExecutableState)
			throws PersistenceException {
		result = "Fehler...";
	}
	@Override
	public void handleSuccessfulState(
			PersistentSuccessfulState SuccessfulState)
			throws PersistenceException {
		result = "Erfolgreich";
	}
	@Override
	public void handlePercent(PersistentPercent percent)
			throws PersistenceException {
		result = percent.getValue().multiply(new Fraction(100, 1)).formatDec(3) + PercentSign;
	}
	@Override
	public void handleTransaction(PersistentTransaction transaction)
			throws PersistenceException {
		this.result = "Transaktion";
	}
	@Override
	public void handleNoLimit(PersistentNoLimit noLimit)
			throws PersistenceException {
		this.result = NoLimitType;
	}
	@Override
	public void handleTransfer(PersistentTransfer transfer)
			throws PersistenceException {
		this.result = "Überweisung: "+transfer.getMoney().toString(true) + " Absender: " + transfer.getSender().getAccountNumber();
	}
	@Override
	public void handleSuccessfulStornoState(
			PersistentSuccessfulStornoState SuccessfulStornoState)
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
	@Override
	public void handleCurrencyManager(PersistentCurrencyManager currencyManager)
			throws PersistenceException {
		result = "EZB - Kontostand: " + currencyManager.calculateExchangeRateCompensationReferenceAmount();
		
	}
	@Override
	public void handleYen(PersistentYen yen) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.YenCurrencyToString;
		
	}
	@Override
	public void handlePfund(PersistentPfund pfund) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.PfundCurrencyToString;
		
	}
	@Override
	public void handleFranken(PersistentFranken franken)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.FrankenCurrencyToString;
		
	}
	@Override
	public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException {
		this.result = "Einzugsermächtigung für " + debitGrant.getPermittedAccount();
		
	}
	@Override
	public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException {
		this.result = "Historie";
		
	}
	@Override
	public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException {
		this.result = "Noch nicht erledigte Aufträge";
		
	}
	@Override
	public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe)
			throws PersistenceException {
		this.result = "";
	}
	@Override
	public void handleAccountPx(PersistentAccountPx accountPx)
			throws PersistenceException {
		this.result = "Account: " + new Long(accountPx.getAccount().getAccountNumber()).toString();
	}
	@Override
	public void handleDebitTransferTemplate(
			PersistentDebitTransferTemplate debitTransferTemplate)
			throws PersistenceException {
		this.result = "";
	}
	@Override
	public void handleDebitTransferListe(
			PersistentDebitTransferListe debitTransferListe)
			throws PersistenceException {
		this.result = "";		
	}
	
	


}
