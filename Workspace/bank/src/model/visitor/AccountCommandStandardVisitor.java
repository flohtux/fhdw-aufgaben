
package model.visitor;

import persistence.*;

public abstract class AccountCommandStandardVisitor implements AccountCommandVisitor {
    
    public void handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException{
        this.standardHandling(changeCurrencyCommand);
    }
    public void handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException{
        this.standardHandling(changeReceiverBankCommand);
    }
    public void handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException{
        this.standardHandling(changeMoneyCommand);
    }
    public void handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException{
        this.standardHandling(changeSubjectCommand);
    }
    public void handleCompensationDeclinedCommand(PersistentCompensationDeclinedCommand compensationDeclinedCommand) throws PersistenceException{
        this.standardHandling(compensationDeclinedCommand);
    }
    public void handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException{
        this.standardHandling(changeReceiverAccountCommand);
    }
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException{
        this.standardHandling(createDebitGrantCommand);
    }
    protected abstract void standardHandling(AccountCommand accountCommand) throws PersistenceException;
}
