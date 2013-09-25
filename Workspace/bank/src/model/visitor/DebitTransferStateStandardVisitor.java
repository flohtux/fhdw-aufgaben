
package model.visitor;

import persistence.*;

public abstract class DebitTransferStateStandardVisitor implements DebitTransferStateVisitor {
    
    public void handleCompensationRequestedState(PersistentCompensationRequestedState compensationRequestedState) throws PersistenceException{
        this.standardHandling(compensationRequestedState);
    }
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException{
        this.standardHandling(executedState);
    }
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException{
        this.standardHandling(notExecutableState);
    }
    public void handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException{
        this.standardHandling(compensatedState);
    }
    public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException{
        this.standardHandling(successfulState);
    }
    public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException{
        this.standardHandling(notExecutedState);
    }
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException{
        this.standardHandling(templateState);
    }
    protected abstract void standardHandling(PersistentDebitTransferState debitTransferState) throws PersistenceException;
}
