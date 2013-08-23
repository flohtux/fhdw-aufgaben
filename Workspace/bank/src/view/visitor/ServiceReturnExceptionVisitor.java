
package view.visitor;
import view.UserException;
import view.*;

public interface ServiceReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAdministrator(AdministratorView administrator) throws ModelException, E;
    public R handleBankService(BankServiceView bankService) throws ModelException, E;
    public R handleAccountService(AccountServiceView accountService) throws ModelException, E;
    
}
