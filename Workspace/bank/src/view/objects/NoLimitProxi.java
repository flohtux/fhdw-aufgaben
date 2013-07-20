package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class NoLimitProxi extends LimitTypeProxi implements NoLimitView{
    
    public NoLimitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public NoLimitView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        NoLimitView result$$ = new NoLimit( this.getId(), this.getClassId());
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
    
    
    public void accept(LimitTypeVisitor visitor) throws ModelException {
        visitor.handleNoLimit(this);
    }
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoLimit(this);
    }
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoLimit(this);
    }
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoLimit(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNoLimit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoLimit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoLimit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoLimit(this);
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
