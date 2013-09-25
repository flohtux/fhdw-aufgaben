package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DeclinedStateProxi extends CompensationRequestStateProxi implements DeclinedStateView{
    
    public DeclinedStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public DeclinedStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        DeclinedStateView result$$ = new DeclinedState( this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(CompensationRequestStateVisitor visitor) throws ModelException {
        visitor.handleDeclinedState(this);
    }
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDeclinedState(this);
    }
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDeclinedState(this);
    }
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDeclinedState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDeclinedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDeclinedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDeclinedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDeclinedState(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
