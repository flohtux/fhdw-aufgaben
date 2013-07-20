
package view.visitor;
import view.UserException;
import view.*;

public interface StornoStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleRequestState(RequestStateView requestState) throws ModelException, E;
    public R handleNotSuccessfullStorneState(NotSuccessfullStorneStateView notSuccessfullStorneState) throws ModelException, E;
    public R handleNoRequestState(NoRequestStateView noRequestState) throws ModelException, E;
    public R handleSuccessfullStornoState(SuccessfullStornoStateView successfullStornoState) throws ModelException, E;
    
}
