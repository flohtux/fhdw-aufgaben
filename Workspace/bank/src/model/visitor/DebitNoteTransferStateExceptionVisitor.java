
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitNoteTransferStateExceptionVisitor<E extends UserException> {
    
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException, E;
    public void handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException, E;
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException, E;
    public void handleNotSuccessfullState(PersistentNotSuccessfullState notSuccessfullState) throws PersistenceException, E;
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException, E;
    public void handleSuccessfullState(PersistentSuccessfullState successfullState) throws PersistenceException, E;
    
}
