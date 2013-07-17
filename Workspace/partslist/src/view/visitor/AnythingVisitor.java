
package view.visitor;

import view.*;

public interface AnythingVisitor extends StateVisitor,ComponentVisitor{
    
    public void handlePartsListManager(PartsListManagerView partsListManager) throws ModelException;
    public void handleQPart(QPartView qPart) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleMateriallist(MateriallistView materiallist) throws ModelException;
    public void handleMateriallistValue(MateriallistValueView materiallistValue) throws ModelException;
    
}
