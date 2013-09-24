package view.objects;

import view.ModelException;
import view.UserException;
import view.WaitingStateView;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.CompensationRequestStateExceptionVisitor;
import view.visitor.CompensationRequestStateReturnExceptionVisitor;
import view.visitor.CompensationRequestStateReturnVisitor;
import view.visitor.CompensationRequestStateVisitor;
import viewClient.ExceptionAndEventHandler;

public class WaitingStateProxi extends CompensationRequestStateProxi implements WaitingStateView{
    
    public WaitingStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public WaitingStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        WaitingStateView result$$ = new WaitingState( this.getId(), this.getClassId());
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
        visitor.handleWaitingState(this);
    }
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleWaitingState(this);
    }
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleWaitingState(this);
    }
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleWaitingState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleWaitingState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleWaitingState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleWaitingState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleWaitingState(this);
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
