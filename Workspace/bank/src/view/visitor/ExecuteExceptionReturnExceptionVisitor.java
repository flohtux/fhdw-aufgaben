
package view.visitor;
import view.UserException;
import view.*;

public interface ExecuteExceptionReturnExceptionVisitor<R, E extends UserException> extends DebitExceptionReturnExceptionVisitor<R, E> ,AccountSearchExceptionReturnExceptionVisitor<R, E> {
    
    public R handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException, E;
    public R handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException, E;
    
}
