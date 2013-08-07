
package model.visitor;

import persistence.*;

public interface StornoStateVisitor {
    
    public void handleRequestState(PersistentRequestState requestState) throws PersistenceException;
    public void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException;
    public void handleNotSuccessfulStornoState(PersistentNotSuccessfulStornoState notSuccessfulStornoState) throws PersistenceException;
    public void handleSuccessfulStornoState(PersistentSuccessfulStornoState successfulStornoState) throws PersistenceException;
    
}
