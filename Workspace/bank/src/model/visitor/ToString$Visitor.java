
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleCompensation(PersistentCompensation compensation) throws PersistenceException;
    public abstract void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException;
    public abstract void handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException;
    public abstract void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException;
    public abstract void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public abstract void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException;
    public abstract void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException;
    public abstract void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public abstract void handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException;
    public abstract void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException;
    public abstract void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException;
    public abstract void handlePercent(PersistentPercent percent) throws PersistenceException;
    public abstract void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException;
    public abstract void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException;
    public abstract void handleIncomingAccountRule(PersistentIncomingAccountRule incomingAccountRule) throws PersistenceException;
    public abstract void handleAmount(PersistentAmount amount) throws PersistenceException;
    public abstract void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException;
    public abstract void handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException;
    public abstract void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException;
    public abstract void handleBankService(PersistentBankService bankService) throws PersistenceException;
    public abstract void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException;
    public abstract void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException;
    public abstract void handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException;
    public abstract void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException;
    public abstract void handleBankPx(PersistentBankPx bankPx) throws PersistenceException;
    public abstract void handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException;
    public abstract void handleDollar(PersistentDollar dollar) throws PersistenceException;
    public abstract void handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException;
    public abstract void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public abstract void handleFranken(PersistentFranken franken) throws PersistenceException;
    public abstract void handleLimit(PersistentLimit limit) throws PersistenceException;
    public abstract void handleDebit(PersistentDebit debit) throws PersistenceException;
    public abstract void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException;
    public abstract void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException;
    public abstract void handleRequestState(PersistentRequestState requestState) throws PersistenceException;
    public abstract void handleAccountService(PersistentAccountService accountService) throws PersistenceException;
    public abstract void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException;
    public abstract void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException;
    public abstract void handleAccount(PersistentAccount account) throws PersistenceException;
    public abstract void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException;
    public abstract void handleTrigger(PersistentTrigger trigger) throws PersistenceException;
    public abstract void handleEuro(PersistentEuro euro) throws PersistenceException;
    public abstract void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException;
    public abstract void handleYen(PersistentYen yen) throws PersistenceException;
    public abstract void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException;
    public abstract void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException;
    public abstract void handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException;
    public abstract void handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException;
    public abstract void handleTransaction(PersistentTransaction transaction) throws PersistenceException;
    public abstract void handleMoney(PersistentMoney money) throws PersistenceException;
    public abstract void handleBank(PersistentBank bank) throws PersistenceException;
    public abstract void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException;
    public abstract void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException;
    public abstract void handlePfund(PersistentPfund pfund) throws PersistenceException;
    public abstract void handleBankFees(PersistentBankFees bankFees) throws PersistenceException;
    public abstract void handleNotSuccessfulStornoState(PersistentNotSuccessfulStornoState notSuccessfulStornoState) throws PersistenceException;
    public abstract void handleSuccessfulStornoState(PersistentSuccessfulStornoState successfulStornoState) throws PersistenceException;
    public abstract void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    public abstract void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    public abstract void handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException;
    
}
