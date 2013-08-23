
package model.visitor;

import persistence.*;

public abstract class InvokerDirectVisitor implements InvokerVisitor {
    
    public abstract void handleService(PersistentService service) throws PersistenceException;
    
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException{
        this.handleService(accountService);
    }
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException{
        this.handleService(administrator);
    }
    public void handleBankService(PersistentBankService bankService) throws PersistenceException{
        this.handleService(bankService);
    }
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    
}
