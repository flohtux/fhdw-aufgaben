
package model.visitor;

import model.*;
import persistence.*;

public abstract class UserExceptionDirectVisitor implements UserExceptionVisitor {
    
    public abstract void handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException;
    
    public abstract void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    
    public abstract void handlePasswordException(model.PasswordException passwordException) throws PersistenceException;
    
    public abstract void handleDebitException(model.DebitException debitException) throws PersistenceException;
    
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException{
        this.handleDebitException(limitViolatedException);
    }
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException{
        this.handleDebitException(debitNotGrantedException);
    }
    public abstract void handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException;
    
    public abstract void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException;
    
    public abstract void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException;
    
    public abstract void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
    public abstract void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException;
    
    
}
