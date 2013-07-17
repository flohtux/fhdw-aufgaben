
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends StateExceptionVisitor<E>,ComponentExceptionVisitor<E>{
    
    public void handlePartsListManager(PartsListManagerView partsListManager) throws ModelException, E;
    public void handleQPart(QPartView qPart) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleMateriallist(MateriallistView materiallist) throws ModelException, E;
    public void handleMateriallistValue(MateriallistValueView materiallistValue) throws ModelException, E;
    
}
