
package view.visitor;

import view.*;

public interface UserExceptionVisitor {
    
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handlePasswordException(PasswordException passwordException) throws ModelException;
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    
}
