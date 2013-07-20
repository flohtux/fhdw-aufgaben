
package view.visitor;
import view.UserException;
import view.*;

public interface DebitNoteTransferStateExceptionVisitor<E extends UserException> {
    
    public void handleTemplateState(TemplateStateView templateState) throws ModelException, E;
    public void handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException, E;
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException, E;
    public void handleNotSuccessfullState(NotSuccessfullStateView notSuccessfullState) throws ModelException, E;
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException, E;
    public void handleSuccessfullState(SuccessfullStateView successfullState) throws ModelException, E;
    
}
