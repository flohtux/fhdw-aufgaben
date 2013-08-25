
package view.visitor;

import view.*;

public interface UserExceptionVisitor extends ExecuteExceptionVisitor{
    
    public void handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handlePasswordException(PasswordException passwordException) throws ModelException;
    public void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
}
