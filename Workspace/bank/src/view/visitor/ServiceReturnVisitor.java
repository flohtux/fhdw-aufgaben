
package view.visitor;

import view.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleAdministrator(AdministratorView administrator) throws ModelException;
    public R handleBankService(BankServiceView bankService) throws ModelException;
    public R handleAccountService(AccountServiceView accountService) throws ModelException;
    
}
