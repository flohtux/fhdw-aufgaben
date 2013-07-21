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
        MoneyView result$$ = new Money((AmountView)amount,(CurrencyView)currency, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getAmount() != null) return new AmountMoneyWrapper(this, originalIndex, (ViewRoot)this.getAmount());
        if(this.getAmount() != null) index = index - 1;
        if(index == 0 && this.getCurrency() != null) return new CurrencyMoneyWrapper(this, originalIndex, (ViewRoot)this.getCurrency());
        if(this.getCurrency() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAmount() == null ? 0 : 1)
            + (this.getCurrency() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAmount() == null ? true : false)
            && (this.getCurrency() == null ? true : false);
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
