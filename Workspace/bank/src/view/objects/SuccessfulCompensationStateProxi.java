package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class SuccessfulCompensationStateProxi extends CompensationStateProxi implements SuccessfulCompensationStateView{
    
    public SuccessfulCompensationStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public SuccessfulCompensationStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi compensation = null;
        String compensation$String = (String)resultTable.get("compensation");
        if (compensation$String != null) {
            common.ProxiInformation compensation$Info = common.RPCConstantsAndServices.createProxiInformation(compensation$String);
            compensation = view.objects.ViewProxi.createProxi(compensation$Info,connectionKey);
            compensation.setToString(compensation$Info.getToString());
        }
        SuccessfulCompensationStateView result$$ = new SuccessfulCompensationState((CompensationView)compensation, this.getId(), this.getClassId());
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
    
    
    public void accept(CompensationStateVisitor visitor) throws ModelException {
        visitor.handleSuccessfulCompensationState(this);
    }
    public <R> R accept(CompensationStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSuccessfulCompensationState(this);
    }
    public <E extends UserException>  void accept(CompensationStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSuccessfulCompensationState(this);
    }
    public <R, E extends UserException> R accept(CompensationStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSuccessfulCompensationState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleSuccessfulCompensationState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSuccessfulCompensationState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSuccessfulCompensationState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSuccessfulCompensationState(this);
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
