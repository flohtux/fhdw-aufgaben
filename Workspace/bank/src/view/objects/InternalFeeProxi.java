package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class InternalFeeProxi extends ViewProxi implements InternalFeeView{
    
    public InternalFeeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public InternalFeeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi percent = null;
        String percent$String = (String)resultTable.get("percent");
        if (percent$String != null) {
            common.ProxiInformation percent$Info = common.RPCConstantsAndServices.createProxiInformation(percent$String);
            percent = view.objects.ViewProxi.createProxi(percent$Info,connectionKey);
            percent.setToString(percent$Info.getToString());
        }
        InternalFeeView result$$ = new InternalFee((PercentView)percent, this.getId(), this.getClassId());
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
    
    public PercentView getPercent()throws ModelException{
        return ((InternalFee)this.getTheObject()).getPercent();
    }
    public void setPercent(PercentView newValue) throws ModelException {
        ((InternalFee)this.getTheObject()).setPercent(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleInternalFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleInternalFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleInternalFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleInternalFee(this);
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
