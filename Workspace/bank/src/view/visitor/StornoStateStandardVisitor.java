
package view.visitor;

import view.*;

public abstract class StornoStateStandardVisitor implements StornoStateVisitor {
    
    public void handleSuccessfullStornoState(SuccessfullStornoStateView successfullStornoState) throws ModelException{
        this.standardHandling(successfullStornoState);
    }
    public void handleRequestState(RequestStateView requestState) throws ModelException{
        this.standardHandling(requestState);
    }
    public void handleNotSuccessfullStorneState(NotSuccessfullStorneStateView notSuccessfullStorneState) throws ModelException{
        this.standardHandling(notSuccessfullStorneState);
    }
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException{
        this.standardHandling(noRequestState);
    }
    protected abstract void standardHandling(StornoStateView stornoState) throws ModelException;
}
