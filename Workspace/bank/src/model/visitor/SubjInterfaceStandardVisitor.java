
package model.visitor;

import persistence.*;

public abstract class SubjInterfaceStandardVisitor implements SubjInterfaceVisitor {
    
    public void handleCompensation(PersistentCompensation compensation) throws PersistenceException{
        this.standardHandling(compensation);
    }
    public void handleSubj(PersistentSubj subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException{
        this.standardHandling(acceptedState);
    }
    public void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException{
        this.standardHandling(falseValue);
    }
    public void handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException{
        this.standardHandling(allCompensationListe);
    }
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException{
        this.standardHandling(currencyManager);
    }
    public void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException{
        this.standardHandling(debitTransferListe);
    }
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException{
        this.standardHandling(internalFee);
    }
    public void handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException{
        this.standardHandling(debitTransferDoubleState);
    }
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException{
        this.standardHandling(executedState);
    }
    public void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException{
        this.standardHandling(trueValue);
    }
    public void handlePercent(PersistentPercent percent) throws PersistenceException{
        this.standardHandling(percent);
    }
    public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleExchangeRateWrapper(PersistentExchangeRateWrapper exchangeRateWrapper) throws PersistenceException{
        this.standardHandling(exchangeRateWrapper);
    }
    public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException{
        this.standardHandling(successfulState);
    }
    public void handleIncomingAccountRule(PersistentIncomingAccountRule incomingAccountRule) throws PersistenceException{
        this.standardHandling(incomingAccountRule);
    }
    public void handleAmount(PersistentAmount amount) throws PersistenceException{
        this.standardHandling(amount);
    }
    public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException{
        this.standardHandling(noLimit);
    }
    public void handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException{
        this.standardHandling(noTrigger);
    }
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException{
        this.standardHandling(administrator);
    }
    public void handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx) throws PersistenceException{
        this.standardHandling(bankOwnAccountPx);
    }
    public void handleBankService(PersistentBankService bankService) throws PersistenceException{
        this.standardHandling(bankService);
    }
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException{
        this.standardHandling(procentualFee);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException{
        this.standardHandling(debitTransferTemplate);
    }
    public void handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException{
        this.standardHandling(waitingState);
    }
    public void handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException{
        this.standardHandling(subjectRule);
    }
    public void handleWaitingCompensationState(PersistentWaitingCompensationState waitingCompensationState) throws PersistenceException{
        this.standardHandling(waitingCompensationState);
    }
    public void handleCompensationRequestedState(PersistentCompensationRequestedState compensationRequestedState) throws PersistenceException{
        this.standardHandling(compensationRequestedState);
    }
    public void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException{
        this.standardHandling(triggerListe);
    }
    public void handleBankPx(PersistentBankPx bankPx) throws PersistenceException{
        this.standardHandling(bankPx);
    }
    public void handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException{
        this.standardHandling(disabledState);
    }
    public void handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException{
        this.standardHandling(compensatedState);
    }
    public void handleSuccessfulCompensationState(PersistentSuccessfulCompensationState successfulCompensationState) throws PersistenceException{
        this.standardHandling(successfulCompensationState);
    }
    public void handleDollar(PersistentDollar dollar) throws PersistenceException{
        this.standardHandling(dollar);
    }
    public void handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException{
        this.standardHandling(enabledState);
    }
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException{
        this.standardHandling(limitAccount);
    }
    public void handleFranken(PersistentFranken franken) throws PersistenceException{
        this.standardHandling(franken);
    }
    public void handleLimit(PersistentLimit limit) throws PersistenceException{
        this.standardHandling(limit);
    }
    public void handleDebit(PersistentDebit debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException{
        this.standardHandling(mixedFee);
    }
    public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException{
        this.standardHandling(debitGrantListe);
    }
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException{
        this.standardHandling(accountService);
    }
    public void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException{
        this.standardHandling(compensationRequest);
    }
    public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException{
        this.standardHandling(accountPx);
    }
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException{
        this.standardHandling(noDebitTransfer);
    }
    public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException{
        this.standardHandling(notExecutedState);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.standardHandling(euro);
    }
    public void handleTrigger(PersistentTrigger trigger) throws PersistenceException{
        this.standardHandling(trigger);
    }
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException{
        this.standardHandling(templateState);
    }
    public void handleYen(PersistentYen yen) throws PersistenceException{
        this.standardHandling(yen);
    }
    public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException{
        this.standardHandling(debitTransferNotExecuted);
    }
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException{
        this.standardHandling(notExecutableState);
    }
    public void handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException{
        this.standardHandling(compensationListe);
    }
    public void handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException{
        this.standardHandling(moneyRule);
    }
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException{
        this.standardHandling(transaction);
    }
    public void handleMoney(PersistentMoney money) throws PersistenceException{
        this.standardHandling(money);
    }
    public void handleBank(PersistentBank bank) throws PersistenceException{
        this.standardHandling(bank);
    }
    public void handleDeclinedCompensationState(PersistentDeclinedCompensationState declinedCompensationState) throws PersistenceException{
        this.standardHandling(declinedCompensationState);
    }
    public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException{
        this.standardHandling(debitTransferSuccessful);
    }
    public void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException{
        this.standardHandling(eventWrapper);
    }
    public void handlePfund(PersistentPfund pfund) throws PersistenceException{
        this.standardHandling(pfund);
    }
    public void handleBankFees(PersistentBankFees bankFees) throws PersistenceException{
        this.standardHandling(bankFees);
    }
    public void handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException{
        this.standardHandling(declinedState);
    }
    public void handleDebitGrantListePx(PersistentDebitGrantListePx debitGrantListePx) throws PersistenceException{
        this.standardHandling(debitGrantListePx);
    }
    public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException{
        this.standardHandling(debitGrant);
    }
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException{
        this.standardHandling(bankCreator);
    }
    public void handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException{
        this.standardHandling(compensationRequestListe);
    }
    protected abstract void standardHandling(SubjInterface subjInterface) throws PersistenceException;
}
