
package model.visitor;

import persistence.*;

public interface DebitTransferStateReturnVisitor<R> {
    
    public R handleExecutedState(PersistentExecutedState executedState) throws PersistenceException;
    public R handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException;
    public R handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException;
    public R handleCompensationRequestedState(PersistentCompensationRequestedState compensationRequestedState) throws PersistenceException;
    public R handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException;
    public R handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException;
    public R handleTemplateState(PersistentTemplateState templateState) throws PersistenceException;
    public R handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException;
    
}
