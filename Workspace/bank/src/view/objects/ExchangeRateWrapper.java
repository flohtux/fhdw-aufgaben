
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ExchangeRateWrapper extends ViewObject implements ExchangeRateWrapperView{
    
    protected AmountView amount;
    protected CurrencyView currency;
    
    public ExchangeRateWrapper(AmountView amount,CurrencyView currency,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.amount = amount;
        this.currency = currency;        
    }
    
    static public long getTypeId() {
        return 273;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AmountView getAmount()throws ModelException{
        return this.amount;
    }
    public void setAmount(AmountView newValue) throws ModelException {
        this.amount = newValue;
    }
    public CurrencyView getCurrency()throws ModelException{
        return this.currency;
    }
    public void setCurrency(CurrencyView newValue) throws ModelException {
        this.currency = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AmountView amount = this.getAmount();
        if (amount != null) {
            ((ViewProxi)amount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(amount.getClassId(), amount.getId())));
        }
        CurrencyView currency = this.getCurrency();
        if (currency != null) {
            ((ViewProxi)currency).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(currency.getClassId(), currency.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
