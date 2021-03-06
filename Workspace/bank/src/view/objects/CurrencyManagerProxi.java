package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class CurrencyManagerProxi extends ViewProxi implements CurrencyManagerView{
    
    public CurrencyManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public CurrencyManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> exchangeRatesGUI_string = (java.util.Vector<String>)resultTable.get("exchangeRatesGUI");
        java.util.Vector<ExchangeRateWrapperView> exchangeRatesGUI = ViewProxi.getProxiVector(exchangeRatesGUI_string, connectionKey);
        java.util.Vector<String> exchangeRates_string = (java.util.Vector<String>)resultTable.get("exchangeRates");
        java.util.Vector<AmountView> exchangeRates = ViewProxi.getProxiVector(exchangeRates_string, connectionKey);
        java.util.Vector<String> currencyStock_string = (java.util.Vector<String>)resultTable.get("currencyStock");
        java.util.Vector<MoneyView> currencyStock = ViewProxi.getProxiVector(currencyStock_string, connectionKey);
        CurrencyManagerView result$$ = new CurrencyManager(exchangeRatesGUI,exchangeRates,currencyStock, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getExchangeRatesGUI().size()) return new ExchangeRatesGUICurrencyManagerWrapper(this, originalIndex, (ViewRoot)this.getExchangeRatesGUI().get(index));
        index = index - this.getExchangeRatesGUI().size();
        if(index < this.getCurrencyStock().size()) return new CurrencyStockCurrencyManagerWrapper(this, originalIndex, (ViewRoot)this.getCurrencyStock().get(index));
        index = index - this.getCurrencyStock().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getExchangeRatesGUI().size())
            + (this.getCurrencyStock().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getExchangeRatesGUI().size() == 0)
            && (this.getCurrencyStock().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getExchangeRatesGUIIterator = this.getExchangeRatesGUI().iterator();
        while(getExchangeRatesGUIIterator.hasNext()){
            if(getExchangeRatesGUIIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getCurrencyStockIterator = this.getCurrencyStock().iterator();
        while(getCurrencyStockIterator.hasNext()){
            if(getCurrencyStockIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ExchangeRateWrapperView> getExchangeRatesGUI()throws ModelException{
        return ((CurrencyManager)this.getTheObject()).getExchangeRatesGUI();
    }
    public void setExchangeRatesGUI(java.util.Vector<ExchangeRateWrapperView> newValue) throws ModelException {
        ((CurrencyManager)this.getTheObject()).setExchangeRatesGUI(newValue);
    }
    public java.util.Vector<AmountView> getExchangeRates()throws ModelException{
        return ((CurrencyManager)this.getTheObject()).getExchangeRates();
    }
    public void setExchangeRates(java.util.Vector<AmountView> newValue) throws ModelException {
        ((CurrencyManager)this.getTheObject()).setExchangeRates(newValue);
    }
    public java.util.Vector<MoneyView> getCurrencyStock()throws ModelException{
        return ((CurrencyManager)this.getTheObject()).getCurrencyStock();
    }
    public void setCurrencyStock(java.util.Vector<MoneyView> newValue) throws ModelException {
        ((CurrencyManager)this.getTheObject()).setCurrencyStock(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCurrencyManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCurrencyManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCurrencyManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCurrencyManager(this);
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
