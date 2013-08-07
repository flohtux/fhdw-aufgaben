
package view.visitor;
import view.UserException;
import view.*;

public interface UserExceptionExceptionVisitor<E extends UserException> {
    
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handlePasswordException(PasswordException passwordException) throws ModelException, E;
    public void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException, E;
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException, E;
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException, E;
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException, E;
    
}
