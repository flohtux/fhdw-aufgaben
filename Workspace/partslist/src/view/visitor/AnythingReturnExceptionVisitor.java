
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends StateReturnExceptionVisitor<R, E> ,ComponentReturnExceptionVisitor<R, E> {
    
    public R handlePartsListManager(PartsListManagerView partsListManager) throws ModelException, E;
    public R handleQPart(QPartView qPart) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleMateriallist(MateriallistView materiallist) throws ModelException, E;
    public R handleMateriallistValue(MateriallistValueView materiallistValue) throws ModelException, E;
    
}
