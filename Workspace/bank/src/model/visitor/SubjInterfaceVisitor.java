
package model.visitor;

import persistence.*;

public interface SubjInterfaceVisitor extends ServiceVisitor,DebitTransferTransactionVisitor,DebitTransferStateVisitor,StornoStateVisitor,BooleanValueVisitor,CurrencyVisitor,TransactionFeeVisitor,LimitTypeVisitor{
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public void handlePercent(PersistentPercent percent) throws PersistenceException;
    public void handleAmount(PersistentAmount amount) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleMoney(PersistentMoney money) throws PersistenceException;
    public void handleBank(PersistentBank bank) throws PersistenceException;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
}
