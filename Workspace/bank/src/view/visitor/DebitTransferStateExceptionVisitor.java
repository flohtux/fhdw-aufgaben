
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferStateExceptionVisitor<E extends UserException> {
    
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException, E;
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException, E;
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException, E;
    public void handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException, E;
    public void handleTemplateState(TemplateStateView templateState) throws ModelException, E;
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException, E;
    
}
