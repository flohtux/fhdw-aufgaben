
package model.visitor;

import persistence.*;

public interface StornoStateVisitor {
    
    public void handleRequestState(PersistentRequestState requestState) throws PersistenceException;
    public void handleNotSuccessfullStorneState(PersistentNotSuccessfullStorneState notSuccessfullStorneState) throws PersistenceException;
    public void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException;
    public void handleSuccessfullStornoState(PersistentSuccessfullStornoState successfullStornoState) throws PersistenceException;
    
}
