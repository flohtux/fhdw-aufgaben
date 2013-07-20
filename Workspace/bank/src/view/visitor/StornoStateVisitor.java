
package view.visitor;

import view.*;

public interface StornoStateVisitor {
    
    public void handleRequestState(RequestStateView requestState) throws ModelException;
    public void handleNotSuccessfullStorneState(NotSuccessfullStorneStateView notSuccessfullStorneState) throws ModelException;
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException;
    public void handleSuccessfullStornoState(SuccessfullStornoStateView successfullStornoState) throws ModelException;
    
}
