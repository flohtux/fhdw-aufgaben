
package model.visitor;

import persistence.*;

public interface UserExceptionVisitor extends ExecuteExceptionVisitor{
    
    public void handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handlePasswordException(model.PasswordException passwordException) throws PersistenceException;
    public void handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
}
