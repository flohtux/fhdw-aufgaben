
package model.visitor;
import model.UserException;
import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends UserException> extends ExecuteExceptionReturnExceptionVisitor<R, E> {
    
    public R handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException, E;
    public R handlePasswordException(model.PasswordException passwordException) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException, E;
    public R handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException, E;
    
}
