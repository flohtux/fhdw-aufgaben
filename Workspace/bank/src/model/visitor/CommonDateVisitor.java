
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public void handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException;
    public void handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException;
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException;
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException;
    public void handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException;
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException;
    public void handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public void handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException;
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException;
    public void handleCompensationDeclinedCommand(PersistentCompensationDeclinedCommand compensationDeclinedCommand) throws PersistenceException;
    public void handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
