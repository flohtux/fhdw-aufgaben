
package model.visitor;

import persistence.*;

public interface DebitNoteTransferStateReturnVisitor<R> {
    
    public R handleTemplateState(PersistentTemplateState templateState) throws PersistenceException;
    public R handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException;
    public R handleExecutedState(PersistentExecutedState executedState) throws PersistenceException;
    public R handleNotSuccessfullState(PersistentNotSuccessfullState notSuccessfullState) throws PersistenceException;
    public R handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException;
    public R handleSuccessfullState(PersistentSuccessfullState successfullState) throws PersistenceException;
    
}
