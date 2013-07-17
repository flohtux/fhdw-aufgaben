
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException;
    public abstract void handleAccountService(PersistentAccountService accountService) throws PersistenceException;
    public abstract void handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException;
    public abstract void handleAccount(PersistentAccount account) throws PersistenceException;
    public abstract void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException;
    public abstract void handleEuro(PersistentEuro euro) throws PersistenceException;
    public abstract void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException;
    public abstract void handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException;
    public abstract void handleTrancaction(PersistentTrancaction trancaction) throws PersistenceException;
    public abstract void handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException;
    public abstract void handleAmount(PersistentAmount amount) throws PersistenceException;
    public abstract void handleMoney(PersistentMoney money) throws PersistenceException;
    public abstract void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException;
    public abstract void handleBank(PersistentBank bank) throws PersistenceException;
    public abstract void handleBankService(PersistentBankService bankService) throws PersistenceException;
    public abstract void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    public abstract void handleDollar(PersistentDollar dollar) throws PersistenceException;
    
}
