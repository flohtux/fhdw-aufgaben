
package model.visitor;
import model.UserException;
import persistence.*;

public interface ExecuteExceptionExceptionVisitor<E extends UserException> extends DebitExceptionExceptionVisitor<E>,AccountSearchExceptionExceptionVisitor<E>{
    
    public void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException, E;
    public void handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException, E;
    
}
