
package model.visitor;

import persistence.*;

public interface ServiceVisitor {
    
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException;
    public void handleBankService(PersistentBankService bankService) throws PersistenceException;
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException;
    
}
