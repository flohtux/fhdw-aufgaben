package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DebitGrantProxi extends ViewProxi implements DebitGrantView{
    
    public DebitGrantProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public DebitGrantView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi permittedAccount = null;
        String permittedAccount$String = (String)resultTable.get("permittedAccount");
        if (permittedAccount$String != null) {
            common.ProxiInformation permittedAccount$Info = common.RPCConstantsAndServices.createProxiInformation(permittedAccount$String);
            permittedAccount = view.objects.ViewProxi.createProxi(permittedAccount$Info,connectionKey);
            permittedAccount.setToString(permittedAccount$Info.getToString());
        }
        ViewProxi limits = null;
        String limits$String = (String)resultTable.get("limits");
        if (limits$String != null) {
            common.ProxiInformation limits$Info = common.RPCConstantsAndServices.createProxiInformation(limits$String);
            limits = view.objects.ViewProxi.createProxi(limits$Info,connectionKey);
            limits.setToString(limits$Info.getToString());
        }
        DebitGrantView result$$ = new DebitGrant((AccountPxView)permittedAccount,(LimitTypeView)limits, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getPermittedAccount() != null) return new PermittedAccountDebitGrantWrapper(this, originalIndex, (ViewRoot)this.getPermittedAccount());
        if(this.getPermittedAccount() != null) index = index - 1;
        if(index == 0 && this.getLimits() != null) return new LimitsDebitGrantWrapper(this, originalIndex, (ViewRoot)this.getLimits());
        if(this.getLimits() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPermittedAccount() == null ? 0 : 1)
            + (this.getLimits() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getPermittedAccount() == null ? true : false)
            && (this.getLimits() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getPermittedAccount() != null && this.getPermittedAccount().equals(child)) return result;
        if(this.getPermittedAccount() != null) result = result + 1;
        if(this.getLimits() != null && this.getLimits().equals(child)) return result;
        if(this.getLimits() != null) result = result + 1;
        return -1;
    }
    
    public AccountPxView getPermittedAccount()throws ModelException{
        return ((DebitGrant)this.getTheObject()).getPermittedAccount();
    }
    public void setPermittedAccount(AccountPxView newValue) throws ModelException {
        ((DebitGrant)this.getTheObject()).setPermittedAccount(newValue);
    }
    public LimitTypeView getLimits()throws ModelException{
        return ((DebitGrant)this.getTheObject()).getLimits();
    }
    public void setLimits(LimitTypeView newValue) throws ModelException {
        ((DebitGrant)this.getTheObject()).setLimits(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitGrant(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitGrant(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitGrant(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitGrant(this);
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
