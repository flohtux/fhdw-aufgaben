
package model.visitor;

import persistence.*;

public interface DebitNoteTransferStateVisitor {
    
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException;
    public void handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException;
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException;
    public void handleNotSuccessfullState(PersistentNotSuccessfullState notSuccessfullState) throws PersistenceException;
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException;
    public void handleSuccessfullState(PersistentSuccessfullState successfullState) throws PersistenceException;
    
}
