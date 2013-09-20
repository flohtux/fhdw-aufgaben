
package view.visitor;
import view.UserException;
import view.*;

public interface ExecuteExceptionExceptionVisitor<E extends UserException> extends DebitExceptionExceptionVisitor<E>,AccountSearchExceptionExceptionVisitor<E>{
    
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException, E;
    public void handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException, E;
    
}
