
package view.visitor;

import view.*;

public interface StornoStateReturnVisitor<R> {
    
    public R handleRequestState(RequestStateView requestState) throws ModelException;
    public R handleNotSuccessfullStorneState(NotSuccessfullStorneStateView notSuccessfullStorneState) throws ModelException;
    public R handleNoRequestState(NoRequestStateView noRequestState) throws ModelException;
    public R handleSuccessfullStornoState(SuccessfullStornoStateView successfullStornoState) throws ModelException;
    
}
