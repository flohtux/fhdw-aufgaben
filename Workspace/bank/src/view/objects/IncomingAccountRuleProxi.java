package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class IncomingAccountRuleProxi extends RuleProxi implements IncomingAccountRuleView{
    
    public IncomingAccountRuleProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public IncomingAccountRuleView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi masterTrigger = null;
        String masterTrigger$String = (String)resultTable.get("masterTrigger");
        if (masterTrigger$String != null) {
            common.ProxiInformation masterTrigger$Info = common.RPCConstantsAndServices.createProxiInformation(masterTrigger$String);
            masterTrigger = view.objects.ViewProxi.createProxi(masterTrigger$Info,connectionKey);
            masterTrigger.setToString(masterTrigger$Info.getToString());
        }
        long accountNumber = new Long((String)resultTable.get("accountNumber")).longValue();
        long bankNumber = new Long((String)resultTable.get("bankNumber")).longValue();
        IncomingAccountRuleView result$$ = new IncomingAccountRule((TriggerView)masterTrigger,(long)accountNumber,(long)bankNumber, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMasterTrigger() != null) return new MasterTriggerRuleWrapper(this, originalIndex, (ViewRoot)this.getMasterTrigger());
        if(this.getMasterTrigger() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMasterTrigger() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMasterTrigger() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMasterTrigger() != null && this.getMasterTrigger().equals(child)) return result;
        if(this.getMasterTrigger() != null) result = result + 1;
        return -1;
    }
    
    public long getAccountNumber()throws ModelException{
        return ((IncomingAccountRule)this.getTheObject()).getAccountNumber();
    }
    public void setAccountNumber(long newValue) throws ModelException {
        ((IncomingAccountRule)this.getTheObject()).setAccountNumber(newValue);
    }
    public long getBankNumber()throws ModelException{
        return ((IncomingAccountRule)this.getTheObject()).getBankNumber();
    }
    public void setBankNumber(long newValue) throws ModelException {
        ((IncomingAccountRule)this.getTheObject()).setBankNumber(newValue);
    }
    
    public void accept(RuleVisitor visitor) throws ModelException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
