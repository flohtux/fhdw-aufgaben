
package model.visitor;

import persistence.*;

public interface DebitTransferStateVisitor {
    
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException;
    public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException;
    public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException;
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException;
    public void handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException;
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException;
    
}
