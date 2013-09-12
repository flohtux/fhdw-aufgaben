
package view.visitor;

import view.*;

public interface ExecuteExceptionReturnVisitor<R> extends DebitExceptionReturnVisitor<R> {
    
    public R handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    public R handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException;
    public R handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    public R handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    
}
