
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Account extends ViewObject implements AccountView{
    
    protected long accountNumber;
    protected MoneyView money;
    protected AccountLimitStateView firstLimit;
    protected AccountLimitStateView secondLimit;
    
    public Account(long accountNumber,MoneyView money,AccountLimitStateView firstLimit,AccountLimitStateView secondLimit,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.accountNumber = accountNumber;
        this.money = money;
        this.firstLimit = firstLimit;
        this.secondLimit = secondLimit;        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getAccountNumber()throws ModelException{
        return this.accountNumber;
    }
    public void setAccountNumber(long newValue) throws ModelException {
        this.accountNumber = newValue;
    }
    public MoneyView getMoney()throws ModelException{
        return this.money;
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        this.money = newValue;
    }
    public AccountLimitStateView getFirstLimit()throws ModelException{
        return this.firstLimit;
    }
    public void setFirstLimit(AccountLimitStateView newValue) throws ModelException {
        this.firstLimit = newValue;
    }
    public AccountLimitStateView getSecondLimit()throws ModelException{
        return this.secondLimit;
    }
    public void setSecondLimit(AccountLimitStateView newValue) throws ModelException {
        this.secondLimit = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccount(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        MoneyView money = this.getMoney();
        if (money != null) {
            ((ViewProxi)money).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(money.getClassId(), money.getId())));
        }
        AccountLimitStateView firstLimit = this.getFirstLimit();
        if (firstLimit != null) {
            ((ViewProxi)firstLimit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(firstLimit.getClassId(), firstLimit.getId())));
        }
        AccountLimitStateView secondLimit = this.getSecondLimit();
        if (secondLimit != null) {
            ((ViewProxi)secondLimit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(secondLimit.getClassId(), secondLimit.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMoney() != null) return new MoneyAccountWrapper(this, originalIndex, (ViewRoot)this.getMoney());
        if(this.getMoney() != null) index = index - 1;
        if(index == 0 && this.getFirstLimit() != null) return new FirstLimitAccountWrapper(this, originalIndex, (ViewRoot)this.getFirstLimit());
        if(this.getFirstLimit() != null) index = index - 1;
        if(index == 0 && this.getSecondLimit() != null) return new SecondLimitAccountWrapper(this, originalIndex, (ViewRoot)this.getSecondLimit());
        if(this.getSecondLimit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1)
            + (this.getFirstLimit() == null ? 0 : 1)
            + (this.getSecondLimit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMoney() == null ? true : false)
            && (this.getFirstLimit() == null ? true : false)
            && (this.getSecondLimit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        if(this.getFirstLimit() != null && this.getFirstLimit().equals(child)) return result;
        if(this.getFirstLimit() != null) result = result + 1;
        if(this.getSecondLimit() != null && this.getSecondLimit().equals(child)) return result;
        if(this.getSecondLimit() != null) result = result + 1;
        return -1;
    }
    public int getAccountNumberIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "accountNumber";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getAccountNumber());
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setAccountNumber(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
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
