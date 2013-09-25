
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleExecutedState(PersistentExecutedState executedState) throws PersistenceException, E;
    public R handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException, E;
    public R handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException, E;
    public R handleCompensationRequestedState(PersistentCompensationRequestedState compensationRequestedState) throws PersistenceException, E;
    public R handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException, E;
    public R handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException, E;
    public R handleTemplateState(PersistentTemplateState templateState) throws PersistenceException, E;
    public R handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException, E;
    
}
