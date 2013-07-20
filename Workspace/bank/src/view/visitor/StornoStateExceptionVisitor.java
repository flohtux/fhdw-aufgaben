
package view.visitor;
import view.UserException;
import view.*;

public interface StornoStateExceptionVisitor<E extends UserException> {
    
    public void handleRequestState(RequestStateView requestState) throws ModelException, E;
    public void handleNotSuccessfullStorneState(NotSuccessfullStorneStateView notSuccessfullStorneState) throws ModelException, E;
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException, E;
    public void handleSuccessfullStornoState(SuccessfullStornoStateView successfullStornoState) throws ModelException, E;
    
}
