
package model.visitor;

import model.*;
import persistence.*;

public abstract class UserExceptionDirectVisitor implements UserExceptionVisitor {
    
    public abstract void handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException;
    
    public abstract void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    
    public abstract void handlePasswordException(model.PasswordException passwordException) throws PersistenceException;
    
    public abstract void handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException;
    
    public abstract void handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException;
    
    public abstract void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
    public abstract void handleExecuteException(model.ExecuteException executeException) throws PersistenceException;
    
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException{
        this.handleExecuteException(invalidBankNumberException);
    }
    public void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException{
        this.handleExecuteException(noPermissionToExecuteDebitTransferException);
    }
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException{
        this.handleExecuteException(limitViolatedException);
    }
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException{
        this.handleExecuteException(invalidAccountNumberException);
    }
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException{
        this.handleExecuteException(debitNotGrantedException);
    }
    
}
