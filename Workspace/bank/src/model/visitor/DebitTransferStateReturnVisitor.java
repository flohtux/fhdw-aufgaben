
package model.visitor;

import persistence.*;

public interface DebitTransferStateReturnVisitor<R> {
    
    public R handleTemplateState(PersistentTemplateState templateState) throws PersistenceException;
    public R handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException;
    public R handleExecutedState(PersistentExecutedState executedState) throws PersistenceException;
    public R handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException;
    public R handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException;
    public R handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException;
    
}
