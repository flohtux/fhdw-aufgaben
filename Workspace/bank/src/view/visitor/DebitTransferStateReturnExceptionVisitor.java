
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleTemplateState(TemplateStateView templateState) throws ModelException, E;
    public R handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException, E;
    public R handleExecutedState(ExecutedStateView executedState) throws ModelException, E;
    public R handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException, E;
    public R handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException, E;
    public R handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException, E;
    
}
