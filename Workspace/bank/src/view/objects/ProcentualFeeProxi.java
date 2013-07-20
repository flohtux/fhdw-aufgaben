package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ProcentualFeeProxi extends TransactionFeeProxi implements ProcentualFeeView{
    
    public ProcentualFeeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ProcentualFeeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi percent = null;
        String percent$String = (String)resultTable.get("percent");
        if (percent$String != null) {
            common.ProxiInformation percent$Info = common.RPCConstantsAndServices.createProxiInformation(percent$String);
            percent = view.objects.ViewProxi.createProxi(percent$Info,connectionKey);
            percent.setToString(percent$Info.getToString());
        }
        ProcentualFeeView result$$ = new ProcentualFee((PercentView)percent, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getPercent() != null) return new PercentProcentualFeeWrapper(this, originalIndex, (ViewRoot)this.getPercent());
        if(this.getPercent() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPercent() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getPercent() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getPercent() != null && this.getPercent().equals(child)) return result;
        if(this.getPercent() != null) result = result + 1;
        return -1;
    }
    
    public PercentView getPercent()throws ModelException{
        return ((ProcentualFee)this.getTheObject()).getPercent();
    }
    public void setPercent(PercentView newValue) throws ModelException {
        ((ProcentualFee)this.getTheObject()).setPercent(newValue);
    }
    
    public void accept(TransactionFeeVisitor visitor) throws ModelException {
        visitor.handleProcentualFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProcentualFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProcentualFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProcentualFee(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProcentualFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProcentualFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProcentualFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProcentualFee(this);
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
