
package view.visitor;

import view.*;

public interface ExecuteExceptionVisitor extends DebitExceptionVisitor{
    
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    
}
