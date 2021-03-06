package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MoneyProxi extends ViewProxi implements MoneyView{
    
    public MoneyProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MoneyView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi amount = null;
        String amount$String = (String)resultTable.get("amount");
        if (amount$String != null) {
            common.ProxiInformation amount$Info = common.RPCConstantsAndServices.createProxiInformation(amount$String);
            amount = view.objects.ViewProxi.createProxi(amount$Info,connectionKey);
            amount.setToString(amount$Info.getToString());
        }
        ViewProxi currency = null;
        String currency$String = (String)resultTable.get("currency");
        if (currency$String != null) {
            common.ProxiInformation currency$Info = common.RPCConstantsAndServices.createProxiInformation(currency$String);
            currency = view.objects.ViewProxi.createProxi(currency$Info,connectionKey);
            currency.setToString(currency$Info.getToString());
        }
        ViewProxi account = null;
        String account$String = (String)resultTable.get("account");
        if (account$String != null) {
            common.ProxiInformation account$Info = common.RPCConstantsAndServices.createProxiInformation(account$String);
            account = view.objects.ViewProxi.createProxi(account$Info,connectionKey);
            account.setToString(account$Info.getToString());
        }
        MoneyView result$$ = new Money((AmountView)amount,(CurrencyView)currency,(AccountView)account, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getAmount() != null && index < this.getAmount().getTheObject().getChildCount())
            return this.getAmount().getTheObject().getChild(index);
        if(this.getAmount() != null) index = index - this.getAmount().getTheObject().getChildCount();
        if(this.getCurrency() != null && index < this.getCurrency().getTheObject().getChildCount())
            return this.getCurrency().getTheObject().getChild(index);
        if(this.getCurrency() != null) index = index - this.getCurrency().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAmount() == null ? 0 : this.getAmount().getTheObject().getChildCount())
            + (this.getCurrency() == null ? 0 : this.getCurrency().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAmount() == null ? true : this.getAmount().getTheObject().isLeaf())
            && (this.getCurrency() == null ? true : this.getCurrency().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAmount() != null && this.getAmount().equals(child)) return result;
        if(this.getAmount() != null) result = result + 1;
        if(this.getCurrency() != null && this.getCurrency().equals(child)) return result;
        if(this.getCurrency() != null) result = result + 1;
        return -1;
    }
    
    public AmountView getAmount()throws ModelException{
        return ((Money)this.getTheObject()).getAmount();
    }
    public void setAmount(AmountView newValue) throws ModelException {
        ((Money)this.getTheObject()).setAmount(newValue);
    }
    public CurrencyView getCurrency()throws ModelException{
        return ((Money)this.getTheObject()).getCurrency();
    }
    public void setCurrency(CurrencyView newValue) throws ModelException {
        ((Money)this.getTheObject()).setCurrency(newValue);
    }
    public AccountView getAccount()throws ModelException{
        return ((Money)this.getTheObject()).getAccount();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMoney(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMoney(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMoney(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMoney(this);
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
