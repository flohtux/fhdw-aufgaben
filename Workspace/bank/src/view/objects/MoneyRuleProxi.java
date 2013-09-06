package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MoneyRuleProxi extends RuleProxi implements MoneyRuleView{
    
    public MoneyRuleProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MoneyRuleView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi currency = null;
        String currency$String = (String)resultTable.get("currency");
        if (currency$String != null) {
            common.ProxiInformation currency$Info = common.RPCConstantsAndServices.createProxiInformation(currency$String);
            currency = view.objects.ViewProxi.createProxi(currency$Info,connectionKey);
            currency.setToString(currency$Info.getToString());
        }
        ViewProxi limitAccount = null;
        String limitAccount$String = (String)resultTable.get("limitAccount");
        if (limitAccount$String != null) {
            common.ProxiInformation limitAccount$Info = common.RPCConstantsAndServices.createProxiInformation(limitAccount$String);
            limitAccount = view.objects.ViewProxi.createProxi(limitAccount$Info,connectionKey);
            limitAccount.setToString(limitAccount$Info.getToString());
        }
        MoneyRuleView result$$ = new MoneyRule((CurrencyView)currency,(LimitAccountView)limitAccount, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getLimitAccount() != null) return new LimitAccountMoneyRuleWrapper(this, originalIndex, (ViewRoot)this.getLimitAccount());
        if(this.getLimitAccount() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getLimitAccount() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getLimitAccount() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getLimitAccount() != null && this.getLimitAccount().equals(child)) return result;
        if(this.getLimitAccount() != null) result = result + 1;
        return -1;
    }
    
    public CurrencyView getCurrency()throws ModelException{
        return ((MoneyRule)this.getTheObject()).getCurrency();
    }
    public void setCurrency(CurrencyView newValue) throws ModelException {
        ((MoneyRule)this.getTheObject()).setCurrency(newValue);
    }
    public LimitAccountView getLimitAccount()throws ModelException{
        return ((MoneyRule)this.getTheObject()).getLimitAccount();
    }
    public void setLimitAccount(LimitAccountView newValue) throws ModelException {
        ((MoneyRule)this.getTheObject()).setLimitAccount(newValue);
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
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
