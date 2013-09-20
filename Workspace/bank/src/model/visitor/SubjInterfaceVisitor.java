
package model.visitor;

import persistence.*;

public interface SubjInterfaceVisitor extends ServiceVisitor,DebitTransferTransactionVisitor,DebitTransferStateVisitor,StornoStateVisitor,BooleanValueVisitor,CurrencyVisitor,TransactionFeeVisitor,LimitTypeVisitor,TriggerStateVisitor,CompensationRequestStateVisitor,TriggerValueVisitor,RuleVisitor{
    
    public void handleCompensation(PersistentCompensation compensation) throws PersistenceException;
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException;
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException;
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public void handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException;
    public void handlePercent(PersistentPercent percent) throws PersistenceException;
    public void handleExchangeRateWrapper(PersistentExchangeRateWrapper exchangeRateWrapper) throws PersistenceException;
    public void handleAmount(PersistentAmount amount) throws PersistenceException;
    public void handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx) throws PersistenceException;
    public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException;
    public void handleBankPx(PersistentBankPx bankPx) throws PersistenceException;
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException;
    public void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException;
    public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException;
    public void handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException;
    public void handleMoney(PersistentMoney money) throws PersistenceException;
    public void handleBank(PersistentBank bank) throws PersistenceException;
    public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException;
    public void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException;
    public void handleBankFees(PersistentBankFees bankFees) throws PersistenceException;
    public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    public void handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException;
    
}
