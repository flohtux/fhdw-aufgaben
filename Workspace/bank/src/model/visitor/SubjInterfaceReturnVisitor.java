
package model.visitor;

import persistence.*;

public interface SubjInterfaceReturnVisitor<R> extends DebitTransferNoValueReturnVisitor<R> ,ServiceReturnVisitor<R> ,DebitTransferTransactionReturnVisitor<R> ,DebitTransferStateReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,CurrencyReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,CompensationRequestStateReturnVisitor<R> ,TriggerValueReturnVisitor<R> ,DebitTransferPayedFeesReturnVisitor<R> ,CompensationStateReturnVisitor<R> ,LimitTypeReturnVisitor<R> ,TriggerStateReturnVisitor<R> ,RuleReturnVisitor<R> {
    
    public R handleCompensation(PersistentCompensation compensation) throws PersistenceException;
    public R handleSubj(PersistentSubj subj) throws PersistenceException;
    public R handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException;
    public R handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public R handlePercent(PersistentPercent percent) throws PersistenceException;
    public R handleExchangeRateWrapper(PersistentExchangeRateWrapper exchangeRateWrapper) throws PersistenceException;
    public R handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException;
    public R handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException;
    public R handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException;
    public R handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleMoney(PersistentMoney money) throws PersistenceException;
    public R handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    public R handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException;
    public R handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public R handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException;
    public R handleAmount(PersistentAmount amount) throws PersistenceException;
    public R handleDebitTransferPayedFees(PersistentDebitTransferPayedFees debitTransferPayedFees) throws PersistenceException;
    public R handleBankPx(PersistentBankPx bankPx) throws PersistenceException;
    public R handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public R handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException;
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    public R handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException;
    public R handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException;
    public R handleBank(PersistentBank bank) throws PersistenceException;
    public R handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException;
    public R handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException;
    public R handleBankFees(PersistentBankFees bankFees) throws PersistenceException;
    public R handleDebitGrantListePx(PersistentDebitGrantListePx debitGrantListePx) throws PersistenceException;
    public R handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException;
    
}
