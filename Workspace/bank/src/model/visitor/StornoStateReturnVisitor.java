
package model.visitor;

import persistence.*;

public interface StornoStateReturnVisitor<R> {
    
    public R handleRequestState(PersistentRequestState requestState) throws PersistenceException;
    public R handleNotSuccessfullStorneState(PersistentNotSuccessfullStorneState notSuccessfullStorneState) throws PersistenceException;
    public R handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException;
    public R handleSuccessfullStornoState(PersistentSuccessfullStornoState successfullStornoState) throws PersistenceException;
    
}
