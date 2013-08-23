
package view.visitor;
import view.UserException;
import view.*;

public interface ServiceExceptionVisitor<E extends UserException> {
    
    public void handleAdministrator(AdministratorView administrator) throws ModelException, E;
    public void handleBankService(BankServiceView bankService) throws ModelException, E;
    public void handleAccountService(AccountServiceView accountService) throws ModelException, E;
    
}
