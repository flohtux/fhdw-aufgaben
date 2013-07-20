
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitNoteTransferStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleTemplateState(PersistentTemplateState templateState) throws PersistenceException, E;
    public R handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException, E;
    public R handleExecutedState(PersistentExecutedState executedState) throws PersistenceException, E;
    public R handleNotSuccessfullState(PersistentNotSuccessfullState notSuccessfullState) throws PersistenceException, E;
    public R handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException, E;
    public R handleSuccessfullState(PersistentSuccessfullState successfullState) throws PersistenceException, E;
    
}
