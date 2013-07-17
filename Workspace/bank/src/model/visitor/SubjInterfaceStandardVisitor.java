
package model.visitor;

import persistence.*;

public abstract class SubjInterfaceStandardVisitor implements SubjInterfaceVisitor {
    
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException{
        this.standardHandling(mixedFee);
    }
    public void handleAmount(PersistentAmount amount) throws PersistenceException{
        this.standardHandling(amount);
    }
    public void handleMoney(PersistentMoney money) throws PersistenceException{
        this.standardHandling(money);
    }
    public void handleSubj(PersistentSubj subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException{
        this.standardHandling(administrator);
    }
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException{
        this.standardHandling(accountService);
    }
    public void handleBank(PersistentBank bank) throws PersistenceException{
        this.standardHandling(bank);
    }
    public void handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException{
        this.standardHandling(noLimitState);
    }
    public void handleBankService(PersistentBankService bankService) throws PersistenceException{
        this.standardHandling(bankService);
    }
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException{
        this.standardHandling(procentualFee);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException{
        this.standardHandling(debitNote);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.standardHandling(euro);
    }
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException{
        this.standardHandling(minLimitState);
    }
    public void handleTrancaction(PersistentTrancaction trancaction) throws PersistenceException{
        this.standardHandling(trancaction);
    }
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException{
        this.standardHandling(bankCreator);
    }
    public void handleDollar(PersistentDollar dollar) throws PersistenceException{
        this.standardHandling(dollar);
    }
    public void handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException{
        this.standardHandling(maxLimitState);
    }
    protected abstract void standardHandling(SubjInterface subjInterface) throws PersistenceException;
}
