
package view.objects;

import view.AmountView;
import view.CurrencyManagerView;
import view.ExchangeRateWrapperView;
import view.ModelException;
import view.MoneyView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class CurrencyManager extends ViewObject implements CurrencyManagerView{
    
    protected java.util.Vector<ExchangeRateWrapperView> exchangeRatesGUI;
    protected java.util.Vector<AmountView> exchangeRates;
    protected java.util.Vector<MoneyView> currencyStock;
    
    public CurrencyManager(java.util.Vector<ExchangeRateWrapperView> exchangeRatesGUI,java.util.Vector<AmountView> exchangeRates,java.util.Vector<MoneyView> currencyStock,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.exchangeRatesGUI = exchangeRatesGUI;
        this.exchangeRates = exchangeRates;
        this.currencyStock = currencyStock;        
    }
    
    static public long getTypeId() {
        return 179;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ExchangeRateWrapperView> getExchangeRatesGUI()throws ModelException{
        return this.exchangeRatesGUI;
    }
    public void setExchangeRatesGUI(java.util.Vector<ExchangeRateWrapperView> newValue) throws ModelException {
        this.exchangeRatesGUI = newValue;
    }
    public java.util.Vector<AmountView> getExchangeRates()throws ModelException{
        return this.exchangeRates;
    }
    public void setExchangeRates(java.util.Vector<AmountView> newValue) throws ModelException {
        this.exchangeRates = newValue;
    }
    public java.util.Vector<MoneyView> getCurrencyStock()throws ModelException{
        return this.currencyStock;
    }
    public void setCurrencyStock(java.util.Vector<MoneyView> newValue) throws ModelException {
        this.currencyStock = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> exchangeRatesGUI = this.getExchangeRatesGUI();
        if (exchangeRatesGUI != null) {
            ViewObject.resolveVectorProxies(exchangeRatesGUI, resultTable);
        }
        java.util.Vector<?> exchangeRates = this.getExchangeRates();
        if (exchangeRates != null) {
            ViewObject.resolveVectorProxies(exchangeRates, resultTable);
        }
        java.util.Vector<?> currencyStock = this.getCurrencyStock();
        if (currencyStock != null) {
            ViewObject.resolveVectorProxies(currencyStock, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
