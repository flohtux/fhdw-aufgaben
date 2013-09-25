
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleExecutedState(ExecutedStateView executedState) throws ModelException, E;
    public R handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException, E;
    public R handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException, E;
    public R handleCompensationRequestedState(CompensationRequestedStateView compensationRequestedState) throws ModelException, E;
    public R handleCompensatedState(CompensatedStateView compensatedState) throws ModelException, E;
    public R handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException, E;
    public R handleTemplateState(TemplateStateView templateState) throws ModelException, E;
    public R handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException, E;
    
}
