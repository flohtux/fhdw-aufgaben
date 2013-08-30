
package view.visitor;
import view.UserException;
import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends UserException> extends ExecuteExceptionReturnExceptionVisitor<R, E> {
    
    public R handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException, E;
    public R handlePasswordException(PasswordException passwordException) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException, E;
    public R handleGrantAlreadyGivenException(GrantAlreadyGivenException grantAlreadyGivenException) throws ModelException, E;
    
}
