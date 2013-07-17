
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends StateReturnVisitor<R> ,ComponentReturnVisitor<R> {
    
    public R handlePartsListManager(PartsListManagerView partsListManager) throws ModelException;
    public R handleQPart(QPartView qPart) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleMateriallist(MateriallistView materiallist) throws ModelException;
    public R handleMateriallistValue(MateriallistValueView materiallistValue) throws ModelException;
    
}
