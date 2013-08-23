
package model.visitor;
import model.UserException;
import persistence.*;

public interface ServiceReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAdministrator(PersistentAdministrator administrator) throws PersistenceException, E;
    public R handleBankService(PersistentBankService bankService) throws PersistenceException, E;
    public R handleAccountService(PersistentAccountService accountService) throws PersistenceException, E;
    
}
