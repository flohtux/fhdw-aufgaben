
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handlePasswordException(model.PasswordException passwordException) throws PersistenceException{
        this.standardHandling(passwordException);
    }
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException{
        this.standardHandling(invalidAccountNumberException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
