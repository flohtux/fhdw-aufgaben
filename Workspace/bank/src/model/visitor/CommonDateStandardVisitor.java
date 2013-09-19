
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException{
        this.standardHandling(executeCompensationCommand);
    }
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException{
        this.standardHandling(createBankCommand);
    }
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException{
        this.standardHandling(useTemplateCommand);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.standardHandling(changeNameCommand);
    }
    public void handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException{
        this.standardHandling(changeSubjectCommand);
    }
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException{
        this.standardHandling(createDebitGrantCommand);
    }
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException{
        this.standardHandling(changeCurrencyCommand);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException{
        this.standardHandling(executeCommand);
    }
    public void handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException{
        this.standardHandling(changeReceiverBankCommand);
    }
    public void handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException{
        this.standardHandling(changeMoneyCommand);
    }
    public void handleCompensationDeclinedCommand(PersistentCompensationDeclinedCommand compensationDeclinedCommand) throws PersistenceException{
        this.standardHandling(compensationDeclinedCommand);
    }
    public void handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException{
        this.standardHandling(changeReceiverAccountCommand);
    }
    protected abstract void standardHandling(PersistentCommonDate commonDate) throws PersistenceException;
}
