
package model.visitor;
import model.UserException;
import persistence.*;

public interface StornoStateExceptionVisitor<E extends UserException> {
    
    public void handleRequestState(PersistentRequestState requestState) throws PersistenceException, E;
    public void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException, E;
    public void handleNotSuccessfulStornoState(PersistentNotSuccessfulStornoState notSuccessfulStornoState) throws PersistenceException, E;
    public void handleSuccessfulStornoState(PersistentSuccessfulStornoState successfulStornoState) throws PersistenceException, E;
    
}
