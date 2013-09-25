
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferStateExceptionVisitor<E extends UserException> {
    
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException, E;
    public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException, E;
    public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException, E;
    public void handleCompensationRequestedState(PersistentCompensationRequestedState compensationRequestedState) throws PersistenceException, E;
    public void handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException, E;
    public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException, E;
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException, E;
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException, E;
    
}
