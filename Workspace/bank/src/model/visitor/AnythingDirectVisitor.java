
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleService(PersistentService service) throws PersistenceException;
    
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException{
        this.handleService(accountService);
    }
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException{
        this.handleService(administrator);
    }
    public void handleBankService(PersistentBankService bankService) throws PersistenceException{
        this.handleService(bankService);
    }
    public abstract void handleCompensation(PersistentCompensation compensation) throws PersistenceException;
    
    public abstract void handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException;
    
    public abstract void handleDebitTransferTransaction(PersistentDebitTransferTransaction debitTransferTransaction) throws PersistenceException;
    
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException{
        this.handleDebitTransferTransaction(transaction);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.handleDebitTransferTransaction(transfer);
    }
    public void handleDebit(PersistentDebit debit) throws PersistenceException{
        this.handleDebitTransferTransaction(debit);
    }
    public abstract void handleSubj(PersistentSubj subj) throws PersistenceException;
    
    public abstract void handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException;
    
    public abstract void handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException;
    
    public abstract void handleDebitTransferState(PersistentDebitTransferState debitTransferState) throws PersistenceException;
    
    public void handleCompensationRequestedState(PersistentCompensationRequestedState compensationRequestedState) throws PersistenceException{
        this.handleDebitTransferState(compensationRequestedState);
    }
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException{
        this.handleDebitTransferState(executedState);
    }
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException{
        this.handleDebitTransferState(notExecutableState);
    }
    public void handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException{
        this.handleDebitTransferState(compensatedState);
    }
    public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException{
        this.handleDebitTransferState(notSuccessfulState);
    }
    public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException{
        this.handleDebitTransferState(successfulState);
    }
    public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException{
        this.handleDebitTransferState(notExecutedState);
    }
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException{
        this.handleDebitTransferState(templateState);
    }
    public abstract void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    
    public abstract void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException;
    
    public abstract void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    
    public abstract void handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException;
    
    public abstract void handleBooleanValue(PersistentBooleanValue booleanValue) throws PersistenceException;
    
    public void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException{
        this.handleBooleanValue(falseValue);
    }
    public void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException{
        this.handleBooleanValue(trueValue);
    }
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.handleCommonDate(createAccountCommand);
    }
    public void handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException{
        this.handleCommonDate(executeCompensationCommand);
    }
    public void handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException{
        this.handleCommonDate(changeCurrencyCommand);
    }
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException{
        this.handleCommonDate(createBankCommand);
    }
    public void handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException{
        this.handleCommonDate(changeReceiverBankCommand);
    }
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException{
        this.handleCommonDate(executeCommand);
    }
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException{
        this.handleCommonDate(useTemplateCommand);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.handleCommonDate(changeNameCommand);
    }
    public void handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException{
        this.handleCommonDate(changeMoneyCommand);
    }
    public void handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException{
        this.handleCommonDate(changeSubjectCommand);
    }
    public void handleCompensationDeclinedCommand(PersistentCompensationDeclinedCommand compensationDeclinedCommand) throws PersistenceException{
        this.handleCommonDate(compensationDeclinedCommand);
    }
    public void handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException{
        this.handleCommonDate(changeReceiverAccountCommand);
    }
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException{
        this.handleCommonDate(createDebitGrantCommand);
    }
    public abstract void handlePercent(PersistentPercent percent) throws PersistenceException;
    
    public abstract void handleExchangeRateWrapper(PersistentExchangeRateWrapper exchangeRateWrapper) throws PersistenceException;
    
    public abstract void handleAccountServiceTemplate(PersistentAccountServiceTemplate accountServiceTemplate) throws PersistenceException;
    
    public abstract void handleCurrency(PersistentCurrency currency) throws PersistenceException;
    
    public void handleDollar(PersistentDollar dollar) throws PersistenceException{
        this.handleCurrency(dollar);
    }
    public void handlePfund(PersistentPfund pfund) throws PersistenceException{
        this.handleCurrency(pfund);
    }
    public void handleFranken(PersistentFranken franken) throws PersistenceException{
        this.handleCurrency(franken);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.handleCurrency(euro);
    }
    public void handleYen(PersistentYen yen) throws PersistenceException{
        this.handleCurrency(yen);
    }
    public abstract void handleAmount(PersistentAmount amount) throws PersistenceException;
    
    public abstract void handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException;
    
    public abstract void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException;
    
    public abstract void handleCompensationState(PersistentCompensationState compensationState) throws PersistenceException;
    
    public void handleWaitingCompensationState(PersistentWaitingCompensationState waitingCompensationState) throws PersistenceException{
        this.handleCompensationState(waitingCompensationState);
    }
    public void handleDeclinedCompensationState(PersistentDeclinedCompensationState declinedCompensationState) throws PersistenceException{
        this.handleCompensationState(declinedCompensationState);
    }
    public void handleSuccessfulCompensationState(PersistentSuccessfulCompensationState successfulCompensationState) throws PersistenceException{
        this.handleCompensationState(successfulCompensationState);
    }
    public abstract void handleBankPx(PersistentBankPx bankPx) throws PersistenceException;
    
    public abstract void handleCompensationPendingRequests(PersistentCompensationPendingRequests compensationPendingRequests) throws PersistenceException;
    
    public abstract void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    
    public abstract void handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException;
    
    public abstract void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    
    public abstract void handleAccountTriggerListe(PersistentAccountTriggerListe accountTriggerListe) throws PersistenceException;
    
    public abstract void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException;
    
    public abstract void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException;
    
    public abstract void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException;
    
    public abstract void handleAccountAllCompensation(PersistentAccountAllCompensation accountAllCompensation) throws PersistenceException;
    
    public abstract void handleTransactionFee(PersistentTransactionFee transactionFee) throws PersistenceException;
    
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException{
        this.handleTransactionFee(mixedFee);
    }
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException{
        this.handleTransactionFee(fixTransactionFee);
    }
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException{
        this.handleTransactionFee(procentualFee);
    }
    public abstract void handleAccount(PersistentAccount account) throws PersistenceException;
    
    public abstract void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException;
    
    public abstract void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException;
    
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException;
    
    public abstract void handleLimitType(PersistentLimitType limitType) throws PersistenceException;
    
    public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException{
        this.handleLimitType(noLimit);
    }
    public void handleLimit(PersistentLimit limit) throws PersistenceException{
        this.handleLimitType(limit);
    }
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleTriggerState(PersistentTriggerState triggerState) throws PersistenceException;
    
    public void handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException{
        this.handleTriggerState(disabledState);
    }
    public void handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException{
        this.handleTriggerState(enabledState);
    }
    public abstract void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    
    public abstract void handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException;
    
    public abstract void handleAllCompensationListePendingCompensationRequests(PersistentAllCompensationListePendingCompensationRequests allCompensationListePendingCompensationRequests) throws PersistenceException;
    
    public abstract void handleCompensationRequestState(PersistentCompensationRequestState compensationRequestState) throws PersistenceException;
    
    public void handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException{
        this.handleCompensationRequestState(waitingState);
    }
    public void handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException{
        this.handleCompensationRequestState(declinedState);
    }
    public void handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException{
        this.handleCompensationRequestState(acceptedState);
    }
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleMoney(PersistentMoney money) throws PersistenceException;
    
    public abstract void handleBank(PersistentBank bank) throws PersistenceException;
    
    public abstract void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException;
    
    public abstract void handleTriggerValue(PersistentTriggerValue triggerValue) throws PersistenceException;
    
    public void handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException{
        this.handleTriggerValue(noTrigger);
    }
    public void handleTrigger(PersistentTrigger trigger) throws PersistenceException{
        this.handleTriggerValue(trigger);
    }
    public abstract void handleRule(PersistentRule rule) throws PersistenceException;
    
    public void handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException{
        this.handleRule(subjectRule);
    }
    public void handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException{
        this.handleRule(moneyRule);
    }
    public void handleIncomingAccountRule(PersistentIncomingAccountRule incomingAccountRule) throws PersistenceException{
        this.handleRule(incomingAccountRule);
    }
    public abstract void handleAllCompensationListeOutgoingCompensations(PersistentAllCompensationListeOutgoingCompensations allCompensationListeOutgoingCompensations) throws PersistenceException;
    
    public abstract void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException;
    
    public abstract void handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException;
    
    public abstract void handleBankFees(PersistentBankFees bankFees) throws PersistenceException;
    
    public abstract void handleDebitGrantListePx(PersistentDebitGrantListePx debitGrantListePx) throws PersistenceException;
    
    public abstract void handleAccountServiceBankFees(PersistentAccountServiceBankFees accountServiceBankFees) throws PersistenceException;
    
    public abstract void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    
    public abstract void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
    public abstract void handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException;
    
    
}
