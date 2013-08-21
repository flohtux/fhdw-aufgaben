
package model.visitor;
import model.UserException;
import persistence.*;

public interface ServiceExceptionVisitor<E extends UserException> {
    
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException, E;
    public void handleBankService(PersistentBankService bankService) throws PersistenceException, E;
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException, E;
    
}
