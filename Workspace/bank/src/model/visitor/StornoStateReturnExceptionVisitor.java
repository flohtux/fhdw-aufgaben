
package model.visitor;
import model.UserException;
import persistence.*;

public interface StornoStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleRequestState(PersistentRequestState requestState) throws PersistenceException, E;
    public R handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException, E;
    public R handleNotSuccessfulStornoState(PersistentNotSuccessfulStornoState notSuccessfulStornoState) throws PersistenceException, E;
    public R handleSuccessfulStornoState(PersistentSuccessfulStornoState successfulStornoState) throws PersistenceException, E;
    
}
