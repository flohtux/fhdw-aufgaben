
package model.visitor;
import model.UserException;
import persistence.*;

public interface StornoStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleRequestState(PersistentRequestState requestState) throws PersistenceException, E;
    public R handleNotSuccessfullStorneState(PersistentNotSuccessfullStorneState notSuccessfullStorneState) throws PersistenceException, E;
    public R handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException, E;
    public R handleSuccessfullStornoState(PersistentSuccessfullStornoState successfullStornoState) throws PersistenceException, E;
    
}
