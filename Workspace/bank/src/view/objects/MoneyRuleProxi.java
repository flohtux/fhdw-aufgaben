package view.objects;

import view.AmountView;
import view.CurrencyView;
import view.ModelException;
import view.MoneyRuleView;
import view.TriggerView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.RuleExceptionVisitor;
import view.visitor.RuleReturnExceptionVisitor;
import view.visitor.RuleReturnVisitor;
import view.visitor.RuleVisitor;
import viewClient.ExceptionAndEventHandler;

public class MoneyRuleProxi extends RuleProxi implements MoneyRuleView{
    
    public MoneyRuleProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MoneyRuleView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi masterTrigger = null;
        String masterTrigger$String = (String)resultTable.get("masterTrigger");
        if (masterTrigger$String != null) {
            common.ProxiInformation masterTrigger$Info = common.RPCConstantsAndServices.createProxiInformation(masterTrigger$String);
            masterTrigger = view.objects.ViewProxi.createProxi(masterTrigger$Info,connectionKey);
            masterTrigger.setToString(masterTrigger$Info.getToString());
        }
        ViewProxi currency = null;
        String currency$String = (String)resultTable.get("currency");
        if (currency$String != null) {
            common.ProxiInformation currency$Info = common.RPCConstantsAndServices.createProxiInformation(currency$String);
            currency = view.objects.ViewProxi.createProxi(currency$Info,connectionKey);
            currency.setToString(currency$Info.getToString());
        }
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
        MoneyRuleView result$$ = new MoneyRule((TriggerView)masterTrigger,(CurrencyView)currency,(AmountView)minLimit,(AmountView)maxLimit, this.getId(), this.getClassId());
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
        if(this.getMinLimit() != null && index < this.getMinLimit().getTheObject().getChildCount())
            return this.getMinLimit().getTheObject().getChild(index);
        if(this.getMinLimit() != null) index = index - this.getMinLimit().getTheObject().getChildCount();
        if(this.getMaxLimit() != null && index < this.getMaxLimit().getTheObject().getChildCount())
            return this.getMaxLimit().getTheObject().getChild(index);
        if(this.getMaxLimit() != null) index = index - this.getMaxLimit().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMasterTrigger() == null ? 0 : 1)
            + (this.getMinLimit() == null ? 0 : this.getMinLimit().getTheObject().getChildCount())
            + (this.getMaxLimit() == null ? 0 : this.getMaxLimit().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMasterTrigger() == null ? true : false)
            && (this.getMinLimit() == null ? true : this.getMinLimit().getTheObject().isLeaf())
            && (this.getMaxLimit() == null ? true : this.getMaxLimit().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMasterTrigger() != null && this.getMasterTrigger().equals(child)) return result;
        if(this.getMasterTrigger() != null) result = result + 1;
        if(this.getMinLimit() != null && this.getMinLimit().equals(child)) return result;
        if(this.getMinLimit() != null) result = result + 1;
        if(this.getMaxLimit() != null && this.getMaxLimit().equals(child)) return result;
        if(this.getMaxLimit() != null) result = result + 1;
        return -1;
    }
    
    public CurrencyView getCurrency()throws ModelException{
        return ((MoneyRule)this.getTheObject()).getCurrency();
    }
    public void setCurrency(CurrencyView newValue) throws ModelException {
        ((MoneyRule)this.getTheObject()).setCurrency(newValue);
    }
    public AmountView getMinLimit()throws ModelException{
        return ((MoneyRule)this.getTheObject()).getMinLimit();
    }
    public void setMinLimit(AmountView newValue) throws ModelException {
        ((MoneyRule)this.getTheObject()).setMinLimit(newValue);
    }
    public AmountView getMaxLimit()throws ModelException{
        return ((MoneyRule)this.getTheObject()).getMaxLimit();
    }
    public void setMaxLimit(AmountView newValue) throws ModelException {
        ((MoneyRule)this.getTheObject()).setMaxLimit(newValue);
    }
    
    public void accept(RuleVisitor visitor) throws ModelException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMoneyRule(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMoneyRule(this);
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
