
package view.objects;

import view.*;
import view.visitor.*;


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
        if(index == 0 && this.getAmount() != null) return new AmountMoneyWrapper(this, originalIndex, (ViewRoot)this.getAmount());
        if(this.getAmount() != null) index = index - 1;
        if(index == 0 && this.getCurrency() != null) return new CurrencyMoneyWrapper(this, originalIndex, (ViewRoot)this.getCurrency());
        if(this.getCurrency() != null) index = index - 1;
        if(index == 0 && this.getAccount() != null) return new AccountMoneyWrapper(this, originalIndex, (ViewRoot)this.getAccount());
        if(this.getAccount() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAmount() == null ? 0 : 1)
            + (this.getCurrency() == null ? 0 : 1)
            + (this.getAccount() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAmount() == null ? true : false)
            && (this.getCurrency() == null ? true : false)
            && (this.getAccount() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAmount() != null && this.getAmount().equals(child)) return result;
        if(this.getAmount() != null) result = result + 1;
        if(this.getCurrency() != null && this.getCurrency().equals(child)) return result;
        if(this.getCurrency() != null) result = result + 1;
        if(this.getAccount() != null && this.getAccount().equals(child)) return result;
        if(this.getAccount() != null) result = result + 1;
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
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
