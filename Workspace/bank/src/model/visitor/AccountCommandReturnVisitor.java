
package model.visitor;

import persistence.*;

public interface AccountCommandReturnVisitor<R> {
    
    public R handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException;
    public R handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException;
    public R handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException;
    public R handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException;
    public R handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException;
    public R handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException;
    
}
