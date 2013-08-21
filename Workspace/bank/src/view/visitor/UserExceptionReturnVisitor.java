
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> extends DebitExceptionReturnVisitor<R> {
    
    public R handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException;
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handlePasswordException(PasswordException passwordException) throws ModelException;
    public R handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException;
    public R handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    public R handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public R handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    
}
