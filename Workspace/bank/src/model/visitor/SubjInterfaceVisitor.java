
package model.visitor;

import persistence.*;

public interface SubjInterfaceVisitor extends ServiceVisitor,TransactionFeeVisitor,AccountLimitStateVisitor,CurrencyVisitor,DebitNoteTransactionVisitor{
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleAmount(PersistentAmount amount) throws PersistenceException;
    public void handleMoney(PersistentMoney money) throws PersistenceException;
    public void handleBank(PersistentBank bank) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
}