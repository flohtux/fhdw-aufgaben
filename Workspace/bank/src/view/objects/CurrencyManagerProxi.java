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
        java.util.Vector<String> exchange_string = (java.util.Vector<String>)resultTable.get("exchange");
        java.util.Vector<AmountView> exchange = ViewProxi.getProxiVector(exchange_string, connectionKey);
        CurrencyManagerView result$$ = new CurrencyManager(exchange, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getExchange().size()) return new ExchangeCurrencyManagerWrapper(this, originalIndex, (ViewRoot)this.getExchange().get(index));
        index = index - this.getExchange().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getExchange().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getExchange().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getExchangeIterator = this.getExchange().iterator();
        while(getExchangeIterator.hasNext()){
            if(getExchangeIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AmountView> getExchange()throws ModelException{
        return ((CurrencyManager)this.getTheObject()).getExchange();
    }
    public void setExchange(java.util.Vector<AmountView> newValue) throws ModelException {
        ((CurrencyManager)this.getTheObject()).setExchange(newValue);
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
