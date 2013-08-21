
package model.visitor;

import persistence.*;

public interface StornoStateReturnVisitor<R> {
    
    public R handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException;
    public R handleRequestState(PersistentRequestState requestState) throws PersistenceException;
    public R handleNotSuccessfulStornoState(PersistentNotSuccessfulStornoState notSuccessfulStornoState) throws PersistenceException;
    public R handleSuccessfulStornoState(PersistentSuccessfulStornoState successfulStornoState) throws PersistenceException;
    
}
