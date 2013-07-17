
package model.visitor;

import persistence.*;

public interface ServiceVisitor {
    
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException;
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException;
    public void handleBankService(PersistentBankService bankService) throws PersistenceException;
    
}
