
package model.visitor;

import persistence.*;

public interface SubjInterfaceVisitor extends ServiceVisitor,TransactionFeeVisitor,StornoStateVisitor,BooleanValueVisitor,LimitTypeVisitor,CurrencyVisitor,DebitNoteTransferTransactionVisitor,DebitNoteTransferStateVisitor{
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public void handlePercent(PersistentPercent percent) throws PersistenceException;
    public void handleAmount(PersistentAmount amount) throws PersistenceException;
    public void handleMoney(PersistentMoney money) throws PersistenceException;
    public void handleBank(PersistentBank bank) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    
}
