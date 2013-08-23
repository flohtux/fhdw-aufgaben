
package view.visitor;

import view.*;

public interface ServiceVisitor {
    
    public void handleAdministrator(AdministratorView administrator) throws ModelException;
    public void handleBankService(BankServiceView bankService) throws ModelException;
    public void handleAccountService(AccountServiceView accountService) throws ModelException;
    
}
