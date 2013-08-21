
package view.visitor;
import view.UserException;
import view.*;

public interface StornoStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNoRequestState(NoRequestStateView noRequestState) throws ModelException, E;
    public R handleRequestState(RequestStateView requestState) throws ModelException, E;
    public R handleNotSuccessfulStornoState(NotSuccessfulStornoStateView notSuccessfulStornoState) throws ModelException, E;
    public R handleSuccessfulStornoState(SuccessfulStornoStateView successfulStornoState) throws ModelException, E;
    
}
