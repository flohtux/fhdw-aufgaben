
package model.visitor;
import model.UserException;
import persistence.*;

public interface ExecuteExceptionReturnExceptionVisitor<R, E extends UserException> extends DebitExceptionReturnExceptionVisitor<R, E> {
    
    public R handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException, E;
    public R handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException, E;
    public R handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException, E;
    public R handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException, E;
    
}
