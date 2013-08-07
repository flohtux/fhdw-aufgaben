
package model.visitor;

import persistence.*;

public abstract class StornoStateStandardVisitor implements StornoStateVisitor {
    
    public void handleNotSuccessfulStornoState(PersistentNotSuccessfulStornoState notSuccessfulStornoState) throws PersistenceException{
        this.standardHandling(notSuccessfulStornoState);
    }
    public void handleSuccessfulStornoState(PersistentSuccessfulStornoState successfulStornoState) throws PersistenceException{
        this.standardHandling(successfulStornoState);
    }
    public void handleRequestState(PersistentRequestState requestState) throws PersistenceException{
        this.standardHandling(requestState);
    }
    public void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException{
        this.standardHandling(noRequestState);
    }
    protected abstract void standardHandling(PersistentStornoState stornoState) throws PersistenceException;
}
