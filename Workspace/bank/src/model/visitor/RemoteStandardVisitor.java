
package model.visitor;

import persistence.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException{
        this.standardHandling(accountService);
    }
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException{
        this.standardHandling(administrator);
    }
    public void handleBankService(PersistentBankService bankService) throws PersistenceException{
        this.standardHandling(bankService);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    protected abstract void standardHandling(Remote remote) throws PersistenceException;
}
