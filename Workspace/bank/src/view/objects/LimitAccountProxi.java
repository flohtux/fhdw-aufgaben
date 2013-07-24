package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class LimitAccountProxi extends ViewProxi implements LimitAccountView{
    
    public LimitAccountProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public LimitAccountView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi minLimit = null;
        String minLimit$String = (String)resultTable.get("minLimit");
        if (minLimit$String != null) {
            common.ProxiInformation minLimit$Info = common.RPCConstantsAndServices.createProxiInformation(minLimit$String);
            minLimit = view.objects.ViewProxi.createProxi(minLimit$Info,connectionKey);
            minLimit.setToString(minLimit$Info.getToString());
        }
        ViewProxi maxLimit = null;
        String maxLimit$String = (String)resultTable.get("maxLimit");
        if (maxLimit$String != null) {
            common.ProxiInformation maxLimit$Info = common.RPCConstantsAndServices.createProxiInformation(maxLimit$String);
            maxLimit = view.objects.ViewProxi.createProxi(maxLimit$Info,connectionKey);
            maxLimit.setToString(maxLimit$Info.getToString());
        }
        ViewProxi account = null;
        String account$String = (String)resultTable.get("account");
        if (account$String != null) {
            common.ProxiInformation account$Info = common.RPCConstantsAndServices.createProxiInformation(account$String);
            account = view.objects.ViewProxi.createProxi(account$Info,connectionKey);
            account.setToString(account$Info.getToString());
        }
        LimitAccountView result$$ = new LimitAccount((LimitTypeView)minLimit,(LimitTypeView)maxLimit,(AccountView)account, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMinLimit() != null) return new MinLimitLimitAccountWrapper(this, originalIndex, (ViewRoot)this.getMinLimit());
        if(this.getMinLimit() != null) index = index - 1;
        if(index == 0 && this.getMaxLimit() != null) return new MaxLimitLimitAccountWrapper(this, originalIndex, (ViewRoot)this.getMaxLimit());
        if(this.getMaxLimit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMinLimit() == null ? 0 : 1)
            + (this.getMaxLimit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMinLimit() == null ? true : false)
            && (this.getMaxLimit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMinLimit() != null && this.getMinLimit().equals(child)) return result;
        if(this.getMinLimit() != null) result = result + 1;
        if(this.getMaxLimit() != null && this.getMaxLimit().equals(child)) return result;
        if(this.getMaxLimit() != null) result = result + 1;
        return -1;
    }
    
    public LimitTypeView getMinLimit()throws ModelException{
        return ((LimitAccount)this.getTheObject()).getMinLimit();
    }
    public void setMinLimit(LimitTypeView newValue) throws ModelException {
        ((LimitAccount)this.getTheObject()).setMinLimit(newValue);
    }
    public LimitTypeView getMaxLimit()throws ModelException{
        return ((LimitAccount)this.getTheObject()).getMaxLimit();
    }
    public void setMaxLimit(LimitTypeView newValue) throws ModelException {
        ((LimitAccount)this.getTheObject()).setMaxLimit(newValue);
    }
    public AccountView getAccount()throws ModelException{
        return ((LimitAccount)this.getTheObject()).getAccount();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLimitAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLimitAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLimitAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLimitAccount(this);
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
