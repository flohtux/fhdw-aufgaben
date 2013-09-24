package view.objects;

import view.AmountView;
import view.CurrencyView;
import view.ExchangeRateWrapperView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class ExchangeRateWrapperProxi extends ViewProxi implements ExchangeRateWrapperView{
    
    public ExchangeRateWrapperProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ExchangeRateWrapperView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
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
        ExchangeRateWrapperView result$$ = new ExchangeRateWrapper((AmountView)amount,(CurrencyView)currency, this.getId(), this.getClassId());
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
    
    public AmountView getAmount()throws ModelException{
        return ((ExchangeRateWrapper)this.getTheObject()).getAmount();
    }
    public void setAmount(AmountView newValue) throws ModelException {
        ((ExchangeRateWrapper)this.getTheObject()).setAmount(newValue);
    }
    public CurrencyView getCurrency()throws ModelException{
        return ((ExchangeRateWrapper)this.getTheObject()).getCurrency();
    }
    public void setCurrency(CurrencyView newValue) throws ModelException {
        ((ExchangeRateWrapper)this.getTheObject()).setCurrency(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleExchangeRateWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleExchangeRateWrapper(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleExchangeRateWrapper(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleExchangeRateWrapper(this);
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
