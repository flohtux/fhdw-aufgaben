
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handlePasswordException(PasswordException passwordException) throws ModelException;
    public R handleNoPermissionToExecuteDebitNoteTransferException(NoPermissionToExecuteDebitNoteTransferException noPermissionToExecuteDebitNoteTransferException) throws ModelException;
    public R handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    public R handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public R handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    
}
