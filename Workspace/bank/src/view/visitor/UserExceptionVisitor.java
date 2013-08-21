
package view.visitor;

import view.*;

public interface UserExceptionVisitor extends DebitExceptionVisitor{
    
    public void handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handlePasswordException(PasswordException passwordException) throws ModelException;
    public void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException;
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    
}
