
package view.visitor;

import view.*;

public abstract class StornoStateStandardVisitor implements StornoStateVisitor {
    
    public void handleNotSuccessfulStornoState(NotSuccessfulStornoStateView notSuccessfulStornoState) throws ModelException{
        this.standardHandling(notSuccessfulStornoState);
    }
    public void handleSuccessfulStornoState(SuccessfulStornoStateView successfulStornoState) throws ModelException{
        this.standardHandling(successfulStornoState);
    }
    public void handleRequestState(RequestStateView requestState) throws ModelException{
        this.standardHandling(requestState);
    }
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException{
        this.standardHandling(noRequestState);
    }
    protected abstract void standardHandling(StornoStateView stornoState) throws ModelException;
}
