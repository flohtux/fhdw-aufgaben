
package view.visitor;
import view.UserException;
import view.*;

public interface ExecuteExceptionReturnExceptionVisitor<R, E extends UserException> extends DebitExceptionReturnExceptionVisitor<R, E> {
    
    public R handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException, E;
    public R handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException, E;
    public R handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException, E;
    
}
