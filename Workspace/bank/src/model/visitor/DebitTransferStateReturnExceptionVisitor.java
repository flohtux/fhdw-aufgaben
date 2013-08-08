
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleTemplateState(PersistentTemplateState templateState) throws PersistenceException, E;
    public R handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException, E;
    public R handleExecutedState(PersistentExecutedState executedState) throws PersistenceException, E;
    public R handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException, E;
    public R handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException, E;
    public R handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException, E;
    
}
