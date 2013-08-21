
package view.visitor;
import view.UserException;
import view.*;

public interface StornoStateExceptionVisitor<E extends UserException> {
    
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException, E;
    public void handleRequestState(RequestStateView requestState) throws ModelException, E;
    public void handleNotSuccessfulStornoState(NotSuccessfulStornoStateView notSuccessfulStornoState) throws ModelException, E;
    public void handleSuccessfulStornoState(SuccessfulStornoStateView successfulStornoState) throws ModelException, E;
    
}
