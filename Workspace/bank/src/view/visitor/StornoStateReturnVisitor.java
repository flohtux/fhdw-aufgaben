
package view.visitor;

import view.*;

public interface StornoStateReturnVisitor<R> {
    
    public R handleRequestState(RequestStateView requestState) throws ModelException;
    public R handleNoRequestState(NoRequestStateView noRequestState) throws ModelException;
    public R handleNotSuccessfulStornoState(NotSuccessfulStornoStateView notSuccessfulStornoState) throws ModelException;
    public R handleSuccessfulStornoState(SuccessfulStornoStateView successfulStornoState) throws ModelException;
    
}
