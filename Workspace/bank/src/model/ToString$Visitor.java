package model;

import static serverConstants.ToStringConstants.MaxLimitPrefix;
import static serverConstants.ToStringConstants.MinLimitPrefix;
import static serverConstants.ToStringConstants.MinMaxLimitDelimiter;
import static serverConstants.ToStringConstants.NoLimitType;
import static serverConstants.ToStringConstants.PercentSign;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAcceptedState;
import persistence.PersistentAccount;
import persistence.PersistentAccountPx;
import persistence.PersistentAccountService;
import persistence.PersistentAdministrator;
import persistence.PersistentAllCompensationListe;
import persistence.PersistentAmount;
import persistence.PersistentBank;
import persistence.PersistentBankCreator;
import persistence.PersistentBankFees;
import persistence.PersistentBankOwnAccountPx;
import persistence.PersistentBankPx;
import persistence.PersistentBankService;
import persistence.PersistentCompensatedState;
import persistence.PersistentCompensation;
import persistence.PersistentCompensationListe;
import persistence.PersistentCompensationRequest;
import persistence.PersistentCompensationRequestListe;
import persistence.PersistentCompensationRequestedState;
import persistence.PersistentCurrencyManager;
import persistence.PersistentDebit;
import persistence.PersistentDebitGrant;
import persistence.PersistentDebitGrantListe;
import persistence.PersistentDebitGrantListePx;
import persistence.PersistentDebitTransferDoubleState;
import persistence.PersistentDebitTransferListe;
import persistence.PersistentDebitTransferNotExecuted;
import persistence.PersistentDebitTransferSuccessful;
import persistence.PersistentDebitTransferTemplate;
import persistence.PersistentDeclinedCompensationState;
import persistence.PersistentDeclinedState;
import persistence.PersistentDisabledState;
import persistence.PersistentDollar;
import persistence.PersistentEnabledState;
import persistence.PersistentEuro;
import persistence.PersistentEventWrapper;
import persistence.PersistentExchangeRateWrapper;
import persistence.PersistentExecutedState;
import persistence.PersistentFalseValue;
import persistence.PersistentFixTransactionFee;
import persistence.PersistentFranken;
import persistence.PersistentIncomingAccountRule;
import persistence.PersistentInternalFee;
import persistence.PersistentLimit;
import persistence.PersistentLimitAccount;
import persistence.PersistentMixedFee;
import persistence.PersistentMoney;
import persistence.PersistentMoneyRule;
import persistence.PersistentNoDebitTransfer;
import persistence.PersistentNoLimit;
import persistence.PersistentNoTrigger;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentPercent;
import persistence.PersistentPfund;
import persistence.PersistentProcentualFee;
import persistence.PersistentServer;
import persistence.PersistentSubjectRule;
import persistence.PersistentSuccessfulCompensationState;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;
import persistence.PersistentTriggerListe;
import persistence.PersistentTrueValue;
import persistence.PersistentWaitingCompensationState;
import persistence.PersistentWaitingState;
import persistence.PersistentYen;
import common.Fraction;

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
		result = anything.getClassId() + serverConstants.ToStringConstants.Semicolon + anything.getId();
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
		this.result = String.format(serverConstants.ToStringConstants.AccountPrefix, 
				new Long(account.getAccountNumber()).toString(),account.getBank() == null ? "?" : new Long(account.getBank().getBankNumber()).toString());
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
		result = serverConstants.ToStringConstants.MixedFeePrefix;
		
	}

	@Override
	public void handleFixTransactionFee(
			PersistentFixTransactionFee fixTransactionFee)
			throws PersistenceException {
		result = serverConstants.ToStringConstants.FixTransactionFeePrefix + fixTransactionFee.getValue();
		
	}
	@Override
	public void handleAmount(PersistentAmount amount)
			throws PersistenceException {
		this.result = amount.getBalance().formatDec(2);
	}
	@Override
	public void handleMoney(PersistentMoney money) throws PersistenceException {
		this.result = money.getAmount().toString(true)+ serverConstants.ToStringConstants.Space +money.getCurrency().toString(true);
	}
	@Override
	public void handleProcentualFee(PersistentProcentualFee procentualFee)
			throws PersistenceException {
		result = serverConstants.ToStringConstants.ProcentualFeePrefix + procentualFee.getPercent().toString(true);
		
	}
	@Override
	public void handleDebit(PersistentDebit Debit)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.DebitPrefix +Debit.getSubject()+serverConstants.ToStringConstants.BracketOpen+
				Debit.getMoney().toString(true) + serverConstants.ToStringConstants.SenderPrefix + Debit.getSender().toString(true)+ serverConstants.ToStringConstants.SendToSymbol +
				String.format(serverConstants.ToStringConstants.AccountPrefix, Debit.getReceiverAccountNumber(), Debit.getReceiverBankNumber()) + serverConstants.ToStringConstants.BracketClose;
	}
	@Override
	public void handleTemplateState(PersistentTemplateState templateState)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.TemplatePrefix;
	}
	@Override
	public void handleInternalFee(PersistentInternalFee internalFee)
			throws PersistenceException {
		result = serverConstants.ToStringConstants.InternalFeePrefix + internalFee.getPercent().toString();
		
	}
	@Override
	public void handleNotExecutedState(
			PersistentNotExecutedState notExecutedState)
			throws PersistenceException {
		result = serverConstants.ToStringConstants.NotExecutedState;
	}
	@Override
	public void handleExecutedState(PersistentExecutedState executedState)
			throws PersistenceException {
		result = serverConstants.ToStringConstants.ExecutedState;
	}
	@Override
	public void handleNotSuccessfulState(
			PersistentNotSuccessfulState notSuccessfulState)
			throws PersistenceException {
		result = serverConstants.ToStringConstants.NotSuccessfulState;
	}
	@Override
	public void handleNotExecutableState(
			PersistentNotExecutableState notExecutableState)
			throws PersistenceException {
		result = serverConstants.ToStringConstants.NotExecutableState;
	}
	@Override
	public void handleSuccessfulState(
			PersistentSuccessfulState SuccessfulState)
			throws PersistenceException {
		result = serverConstants.ToStringConstants.SuccessfulState;
	}
	@Override
	public void handlePercent(PersistentPercent percent)
			throws PersistenceException {
		result = percent.getValue().multiply(new Fraction(100, 1)).formatDec(3) + PercentSign;
	}
	@Override
	public void handleTransaction(PersistentTransaction transaction)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.Transaction + transaction.getSubject();
	}
	@Override
	public void handleNoLimit(PersistentNoLimit noLimit)
			throws PersistenceException {
		this.result = NoLimitType;
	}
	@Override
	public void handleTransfer(PersistentTransfer transfer)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.TransferPrefix +transfer.getSubject()+serverConstants.ToStringConstants.BracketOpen+
				transfer.getMoney().toString(true) + serverConstants.ToStringConstants.SenderPrefix + transfer.getSender().toString(true)+ serverConstants.ToStringConstants.SendToSymbol +
				String.format(serverConstants.ToStringConstants.AccountPrefix, transfer.getReceiverAccountNumber(), transfer.getReceiverBankNumber()) + serverConstants.ToStringConstants.BracketClose;
	}
	@Override
	public void handleLimitAccount(PersistentLimitAccount limitAccount)
			throws PersistenceException {
		this.result =  MinLimitPrefix + limitAccount.getMinLimit().toString(true) + MinMaxLimitDelimiter + 
				MaxLimitPrefix + limitAccount.getMaxLimit().toString(true);
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
		result = serverConstants.ToStringConstants.CurrencyManagerPrefix + 
				currencyManager.calculateExchangeRateCompensationReferenceAmount();
		
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
		this.result = serverConstants.ToStringConstants.DebitGrantPrefix + debitGrant.getPermittedAccount();
		
	}
	@Override
	public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.DebitTransferSuccessful;
		
	}
	@Override
	public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.DebitTransferNotExecuted;
		
	}
	@Override
	public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe)
			throws PersistenceException {
		this.result = "";
	}
	@Override
	public void handleAccountPx(PersistentAccountPx accountPx)
			throws PersistenceException {
//		this.result = "Account: " + new Long(accountPx.getAccount().getAccountNumber()).toString();
		this.result = accountPx.getAccount().toString(true);
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
	@Override
	public void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException {
		this.result = "No View";
	}
	@Override
	public void handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException {
		this.result = "No View";
	}
	@Override
	public void handleIncomingAccountRule(
			PersistentIncomingAccountRule incomingAccountRule)
			throws PersistenceException {
		result = String.format(serverConstants.ToStringConstants.IncomingAccountRuleFormatAccountBank, incomingAccountRule.getAccountNumber(), incomingAccountRule.getBankNumber());

	}
	@Override
	public void handleSubjectRule(PersistentSubjectRule subjectRule)
			throws PersistenceException {

		result = String.format(serverConstants.ToStringConstants.SubjectRuleFormat, subjectRule.getSubject());

	}
	@Override
	public void handleTrigger(PersistentTrigger trigger)
			throws PersistenceException {
		this.result = trigger.getName();
	}
	@Override
	public void handleMoneyRule(PersistentMoneyRule moneyRule)
			throws PersistenceException {
		result = String.format(serverConstants.ToStringConstants.MoneyRuleFormatMinMax, moneyRule.getMinLimit().toString(true), moneyRule.getMaxLimit().toString(true));

	}
	@Override
	public void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException {
		result = serverConstants.ToStringConstants.TriggerListe;
		
	}
	@Override
	public void handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.DisableState;
	}
	@Override
	public void handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.EnableState;
	}
	@Override
	public void handleBankPx(PersistentBankPx bankPx)
			throws PersistenceException {
		this.result = bankPx.getBank().toString(true);
		
	}
	@Override
	public void handleBankFees(PersistentBankFees bankFees) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.BankFees;
	}
	@Override
	public void handleNoTrigger(PersistentNoTrigger noTrigger)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCompensation(PersistentCompensation compensation) throws PersistenceException {
		result = serverConstants.ToStringConstants.Compensation;
		
	}
	@Override
	public void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException {
		result = serverConstants.ToStringConstants.CompensationRequest;
		
	}
	@Override
	public void handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException {
		result = serverConstants.ToStringConstants.CompensationListe;
		
	}
	@Override
	public void handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException {
		result = serverConstants.ToStringConstants.CompensationRequestListe;
		
	}
	
	@Override
	public void handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException {
		result = serverConstants.ToStringConstants.AllCompensationListe;
	}
	@Override
	public void handleBankOwnAccountPx(
			PersistentBankOwnAccountPx bankOwnAccountPx)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.BankOwnAccountPxPrefix+bankOwnAccountPx.getAccount().getMoney().toString(true);
	}
	@Override
	public void handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.AcceptedState;
		
	}
	@Override
	public void handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.WaitingState;
		
	}
	@Override
	public void handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.DeclinedState;
		
	}
	@Override
	public void handleExchangeRateWrapper(PersistentExchangeRateWrapper exchangeRateWrapper) throws PersistenceException {
		this.result = String.format(serverConstants.ToStringConstants.ExchangeWrapper, exchangeRateWrapper.getCurrency().toString(true), exchangeRateWrapper.getAmount().toString(true));
	}
	@Override
	public void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer)
			throws PersistenceException {
		// No-view
	}
	@Override
	public void handleWaitingCompensationState(
			PersistentWaitingCompensationState waitingCompensationState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleSuccessfulCompensationState(
			PersistentSuccessfulCompensationState successfulCompensationState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleDeclinedCompensationState(
			PersistentDeclinedCompensationState declinedCompensationState)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException {
		this.result = serverConstants.ToStringConstants.CompensatedState;
		
	}
	@Override
	public void handleCompensationRequestedState(
			PersistentCompensationRequestedState compensationRequestedState)
			throws PersistenceException {
		this.result = serverConstants.ToStringConstants.CompensationRequestedState;
		
	}
	
	@Override
	public void handleDebitGrantListePx(PersistentDebitGrantListePx debitGrantListePx) throws PersistenceException {
		this.result = debitGrantListePx.getD1().toString(true);
	}


}
