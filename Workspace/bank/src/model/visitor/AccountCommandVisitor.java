
package model.visitor;

import persistence.*;

public interface AccountCommandVisitor {
    
    public void handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException;
    public void handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException;
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException;
    public void handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException;
    public void handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException;
    public void handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException;
    
}
