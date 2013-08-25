
package model.visitor;

import persistence.*;

public interface SubjInterfaceVisitor extends ServiceVisitor,DebitTransferTransactionVisitor,DebitTransferStateVisitor,StornoStateVisitor,BooleanValueVisitor,CurrencyVisitor,TransactionFeeVisitor,LimitTypeVisitor{
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException;
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public void handlePercent(PersistentPercent percent) throws PersistenceException;
    public void handleAmount(PersistentAmount amount) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException;
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException;
    public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException;
    public void handleMoney(PersistentMoney money) throws PersistenceException;
    public void handleBank(PersistentBank bank) throws PersistenceException;
    public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException;
    public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
}
