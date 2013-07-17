package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MinLimitStateProxi extends LimitStateProxi implements MinLimitStateView{
    
    public MinLimitStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MinLimitStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi balance = null;
        String balance$String = (String)resultTable.get("balance");
        if (balance$String != null) {
            common.ProxiInformation balance$Info = common.RPCConstantsAndServices.createProxiInformation(balance$String);
            balance = view.objects.ViewProxi.createProxi(balance$Info,connectionKey);
            balance.setToString(balance$Info.getToString());
        }
        MinLimitStateView result$$ = new MinLimitState((AmountView)balance, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getBalance() != null) return new BalanceLimitStateWrapper(this, originalIndex, (ViewRoot)this.getBalance());
        if(this.getBalance() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBalance() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getBalance() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBalance() != null && this.getBalance().equals(child)) return result;
        if(this.getBalance() != null) result = result + 1;
        return -1;
    }
    
    
    public void accept(LimitStateVisitor visitor) throws ModelException {
        visitor.handleMinLimitState(this);
    }
    public <R> R accept(LimitStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMinLimitState(this);
    }
    public <E extends UserException>  void accept(LimitStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMinLimitState(this);
    }
    public <R, E extends UserException> R accept(LimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMinLimitState(this);
    }
    public void accept(AccountLimitStateVisitor visitor) throws ModelException {
        visitor.handleMinLimitState(this);
    }
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMinLimitState(this);
    }
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMinLimitState(this);
    }
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMinLimitState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMinLimitState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMinLimitState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMinLimitState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMinLimitState(this);
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
