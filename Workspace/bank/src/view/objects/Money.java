
package view.objects;

import view.AccountView;
import view.AmountView;
import view.CurrencyView;
import view.ModelException;
import view.MoneyView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Money extends ViewObject implements MoneyView{
    
    protected AmountView amount;
    protected CurrencyView currency;
    protected AccountView account;
    
    public Money(AmountView amount,CurrencyView currency,AccountView account,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.amount = amount;
        this.currency = currency;
        this.account = account;        
    }
    
    static public long getTypeId() {
        return 148;
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
    public AccountView getAccount()throws ModelException{
        return this.account;
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
        AmountView amount = this.getAmount();
        if (amount != null) {
            ((ViewProxi)amount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(amount.getClassId(), amount.getId())));
        }
        CurrencyView currency = this.getCurrency();
        if (currency != null) {
            ((ViewProxi)currency).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(currency.getClassId(), currency.getId())));
        }
        AccountView account = this.getAccount();
        if (account != null) {
            ((ViewProxi)account).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(account.getClassId(), account.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
