
package model.visitor;

import persistence.*;

public interface SubjInterfaceReturnVisitor<R> extends ServiceReturnVisitor<R> ,DebitTransferTransactionReturnVisitor<R> ,DebitTransferStateReturnVisitor<R> ,StornoStateReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,CurrencyReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,LimitTypeReturnVisitor<R> {
    
    public R handleSubj(PersistentSubj subj) throws PersistenceException;
    public R handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public R handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException;
    public R handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public R handlePercent(PersistentPercent percent) throws PersistenceException;
    public R handleAmount(PersistentAmount amount) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException;
    public R handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public R handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException;
    public R handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException;
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException;
    public R handleMoney(PersistentMoney money) throws PersistenceException;
    public R handleBank(PersistentBank bank) throws PersistenceException;
    public R handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException;
    public R handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
}
