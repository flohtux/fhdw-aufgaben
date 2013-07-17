
package model.visitor;

import persistence.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleAccountService(PersistentAccountService accountService) throws PersistenceException;
    public R handleAdministrator(PersistentAdministrator administrator) throws PersistenceException;
    public R handleBankService(PersistentBankService bankService) throws PersistenceException;
    
}
