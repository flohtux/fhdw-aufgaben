
package view.visitor;

import view.*;

public interface StornoStateVisitor {
    
    public void handleRequestState(RequestStateView requestState) throws ModelException;
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException;
    public void handleNotSuccessfulStornoState(NotSuccessfulStornoStateView notSuccessfulStornoState) throws ModelException;
    public void handleSuccessfulStornoState(SuccessfulStornoStateView successfulStornoState) throws ModelException;
    
}
