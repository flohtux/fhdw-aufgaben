
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferStateExceptionVisitor<E extends UserException> {
    
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException, E;
    public void handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException, E;
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException, E;
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException, E;
    public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException, E;
    public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException, E;
    
}
