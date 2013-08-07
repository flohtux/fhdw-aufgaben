
package model.visitor;
import model.UserException;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends UserException> {
    
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handlePasswordException(model.PasswordException passwordException) throws PersistenceException, E;
    public void handleNoPermissionToExecuteDebitNoteTransferException(model.NoPermissionToExecuteDebitNoteTransferException noPermissionToExecuteDebitNoteTransferException) throws PersistenceException, E;
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException, E;
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException, E;
    
}
