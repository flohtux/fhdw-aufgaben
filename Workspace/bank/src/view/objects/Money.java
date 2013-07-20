
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Money extends ViewObject implements MoneyView{
    
    protected AmountView balance;
    protected CurrencyView currency;
    
    public Money(AmountView balance,CurrencyView currency,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.balance = balance;
        this.currency = currency;        
    }
    
    static public long getTypeId() {
        return 148;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AmountView getBalance()throws ModelException{
        return this.balance;
    }
    public void setBalance(AmountView newValue) throws ModelException {
        this.balance = newValue;
    }
    public CurrencyView getCurrency()throws ModelException{
        return this.currency;
    }
    public void setCurrency(CurrencyView newValue) throws ModelException {
        this.currency = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AmountView balance = this.getBalance();
        if (balance != null) {
            ((ViewProxi)balance).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(balance.getClassId(), balance.getId())));
        }
        CurrencyView currency = this.getCurrency();
        if (currency != null) {
            ((ViewProxi)currency).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(currency.getClassId(), currency.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getBalance() != null) return new BalanceMoneyWrapper(this, originalIndex, (ViewRoot)this.getBalance());
        if(this.getBalance() != null) index = index - 1;
        if(index == 0 && this.getCurrency() != null) return new CurrencyMoneyWrapper(this, originalIndex, (ViewRoot)this.getCurrency());
        if(this.getCurrency() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBalance() == null ? 0 : 1)
            + (this.getCurrency() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getBalance() == null ? true : false)
            && (this.getCurrency() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBalance() != null && this.getBalance().equals(child)) return result;
        if(this.getBalance() != null) result = result + 1;
        if(this.getCurrency() != null && this.getCurrency().equals(child)) return result;
        if(this.getCurrency() != null) result = result + 1;
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
