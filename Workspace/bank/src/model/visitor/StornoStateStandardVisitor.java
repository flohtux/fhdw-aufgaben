
package model.visitor;

import persistence.*;

public abstract class StornoStateStandardVisitor implements StornoStateVisitor {
    
    public void handleSuccessfullStornoState(PersistentSuccessfullStornoState successfullStornoState) throws PersistenceException{
        this.standardHandling(successfullStornoState);
    }
    public void handleRequestState(PersistentRequestState requestState) throws PersistenceException{
        this.standardHandling(requestState);
    }
    public void handleNotSuccessfullStorneState(PersistentNotSuccessfullStorneState notSuccessfullStorneState) throws PersistenceException{
        this.standardHandling(notSuccessfullStorneState);
    }
    public void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException{
        this.standardHandling(noRequestState);
    }
    protected abstract void standardHandling(PersistentStornoState stornoState) throws PersistenceException;
}
