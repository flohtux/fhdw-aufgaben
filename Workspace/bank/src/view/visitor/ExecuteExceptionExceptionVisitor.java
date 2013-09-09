
package view.visitor;
import view.UserException;
import view.*;

public interface ExecuteExceptionExceptionVisitor<E extends UserException> extends DebitExceptionExceptionVisitor<E>{
    
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException, E;
    public void handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException, E;
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException, E;
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException, E;
    
}
