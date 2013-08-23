
package view.visitor;

import view.*;

public abstract class RemoteDirectVisitor implements RemoteVisitor {
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.handleService(accountService);
    }
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.handleService(administrator);
    }
    public void handleBankService(BankServiceView bankService) throws ModelException{
        this.handleService(bankService);
    }
    public abstract void handleServer(ServerView server) throws ModelException;
    
    
}
