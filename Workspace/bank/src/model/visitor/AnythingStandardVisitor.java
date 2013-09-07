
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException{
        this.standardHandling(accountReceivedDebitGrant);
    }
    public void handleSubj(PersistentSubj subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException{
        this.standardHandling(falseValue);
    }
    public void handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException{
        this.standardHandling(accountGrantedDebitGrant);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.standardHandling(changeNameCommand);
    }
    public void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException{
        this.standardHandling(noRequestState);
    }
    public void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException{
        this.standardHandling(debitTransferListe);
    }
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException{
        this.standardHandling(currencyManager);
    }
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
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
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException{
        this.standardHandling(trueValue);
    }
    public void handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException{
        this.standardHandling(changeReceiverBankCommand);
    }
    public void handlePercent(PersistentPercent percent) throws PersistenceException{
        this.standardHandling(percent);
    }
    public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException{
        this.standardHandling(successfulState);
    }
    public void handleAccountServiceTemplate(PersistentAccountServiceTemplate accountServiceTemplate) throws PersistenceException{
        this.standardHandling(accountServiceTemplate);
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
    public void handleFeeWrapper(PersistentFeeWrapper feeWrapper) throws PersistenceException{
        this.standardHandling(feeWrapper);
    }
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException{
        this.standardHandling(administrator);
    }
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException{
        this.standardHandling(createBankCommand);
    }
    public void handleBankService(PersistentBankService bankService) throws PersistenceException{
        this.standardHandling(bankService);
    }
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException{
        this.standardHandling(procentualFee);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException{
        this.standardHandling(debitTransferTemplate);
    }
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException{
        this.standardHandling(createDebitGrantCommand);
    }
    public void handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException{
        this.standardHandling(subjectRule);
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
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException{
        this.standardHandling(administratorBanks);
    }
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException{
        this.standardHandling(executeCommand);
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
    public void handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException{
        this.standardHandling(accountServiceSuccessful);
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
    public void handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException{
        this.standardHandling(changeReceiverAccountCommand);
    }
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException{
        this.standardHandling(mixedFee);
    }
    public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException{
        this.standardHandling(debitGrantListe);
    }
    public void handleAccountTriggerListe(PersistentAccountTriggerListe accountTriggerListe) throws PersistenceException{
        this.standardHandling(accountTriggerListe);
    }
    public void handleRequestState(PersistentRequestState requestState) throws PersistenceException{
        this.standardHandling(requestState);
    }
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException{
        this.standardHandling(accountService);
    }
    public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException{
        this.standardHandling(accountPx);
    }
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException{
        this.standardHandling(administratorCurrencyManager);
    }
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException{
        this.standardHandling(useTemplateCommand);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException{
        this.standardHandling(notExecutedState);
    }
    public void handleTrigger(PersistentTrigger trigger) throws PersistenceException{
        this.standardHandling(trigger);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.standardHandling(euro);
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
    public void handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException{
        this.standardHandling(changeCurrencyCommand);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException{
        this.standardHandling(accountDebitTransferTransactions);
    }
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException{
        this.standardHandling(notExecutableState);
    }
    public void handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException{
        this.standardHandling(changeMoneyCommand);
    }
    public void handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException{
        this.standardHandling(moneyRule);
    }
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
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
    public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException{
        this.standardHandling(debitTransferSuccessful);
    }
    public void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException{
        this.standardHandling(eventWrapper);
    }
    public void handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException{
        this.standardHandling(accountServiceNotExecuted);
    }
    public void handlePfund(PersistentPfund pfund) throws PersistenceException{
        this.standardHandling(pfund);
    }
    public void handleNotSuccessfulStornoState(PersistentNotSuccessfulStornoState notSuccessfulStornoState) throws PersistenceException{
        this.standardHandling(notSuccessfulStornoState);
    }
    public void handleSuccessfulStornoState(PersistentSuccessfulStornoState successfulStornoState) throws PersistenceException{
        this.standardHandling(successfulStornoState);
    }
    public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException{
        this.standardHandling(debitGrant);
    }
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException{
        this.standardHandling(bankCreator);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
