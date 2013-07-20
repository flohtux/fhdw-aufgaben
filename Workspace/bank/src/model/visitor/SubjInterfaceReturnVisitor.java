
package model.visitor;

import persistence.*;

public interface SubjInterfaceReturnVisitor<R> extends ServiceReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,StornoStateReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,LimitTypeReturnVisitor<R> ,CurrencyReturnVisitor<R> ,DebitNoteTransferTransactionReturnVisitor<R> ,DebitNoteTransferStateReturnVisitor<R> {
    
    public R handleSubj(PersistentSubj subj) throws PersistenceException;
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public R handlePercent(PersistentPercent percent) throws PersistenceException;
    public R handleAmount(PersistentAmount amount) throws PersistenceException;
    public R handleMoney(PersistentMoney money) throws PersistenceException;
    public R handleBank(PersistentBank bank) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    public R handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    
}
