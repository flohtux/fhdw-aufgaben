
package model.visitor;

import persistence.*;

public interface ExecuteExceptionReturnVisitor<R> extends DebitExceptionReturnVisitor<R> {
    
    public R handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException;
    public R handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException;
    public R handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException;
    
}
