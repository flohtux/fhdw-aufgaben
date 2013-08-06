
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Account extends ViewObject implements AccountView{
    
    protected long accountNumber;
    protected MoneyView money;
    protected LimitAccountView limit;
    protected java.util.Vector<DebitNoteTransferTransactionView> debitNoteTransferTransactions;
    
    public Account(long accountNumber,MoneyView money,LimitAccountView limit,java.util.Vector<DebitNoteTransferTransactionView> debitNoteTransferTransactions,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.accountNumber = accountNumber;
        this.money = money;
        this.limit = limit;
        this.debitNoteTransferTransactions = debitNoteTransferTransactions;        
    }
    
    static public long getTypeId() {
        return 133;
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
    public LimitAccountView getLimit()throws ModelException{
        return this.limit;
    }
    public void setLimit(LimitAccountView newValue) throws ModelException {
        this.limit = newValue;
    }
    public java.util.Vector<DebitNoteTransferTransactionView> getDebitNoteTransferTransactions()throws ModelException{
        return this.debitNoteTransferTransactions;
    }
    public void setDebitNoteTransferTransactions(java.util.Vector<DebitNoteTransferTransactionView> newValue) throws ModelException {
        this.debitNoteTransferTransactions = newValue;
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
        LimitAccountView limit = this.getLimit();
        if (limit != null) {
            ((ViewProxi)limit).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(limit.getClassId(), limit.getId())));
        }
        java.util.Vector<?> debitNoteTransferTransactions = this.getDebitNoteTransferTransactions();
        if (debitNoteTransferTransactions != null) {
            ViewObject.resolveVectorProxies(debitNoteTransferTransactions, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMoney() != null) return new MoneyAccountWrapper(this, originalIndex, (ViewRoot)this.getMoney());
        if(this.getMoney() != null) index = index - 1;
        if(index == 0 && this.getLimit() != null) return new LimitAccountWrapper(this, originalIndex, (ViewRoot)this.getLimit());
        if(this.getLimit() != null) index = index - 1;
        if(index < this.getDebitNoteTransferTransactions().size()) return new DebitNoteTransferTransactionsAccountWrapper(this, originalIndex, (ViewRoot)this.getDebitNoteTransferTransactions().get(index));
        index = index - this.getDebitNoteTransferTransactions().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1)
            + (this.getLimit() == null ? 0 : 1)
            + (this.getDebitNoteTransferTransactions().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMoney() == null ? true : false)
            && (this.getLimit() == null ? true : false)
            && (this.getDebitNoteTransferTransactions().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        if(this.getLimit() != null && this.getLimit().equals(child)) return result;
        if(this.getLimit() != null) result = result + 1;
        java.util.Iterator<?> getDebitNoteTransferTransactionsIterator = this.getDebitNoteTransferTransactions().iterator();
        while(getDebitNoteTransferTransactionsIterator.hasNext()){
            if(getDebitNoteTransferTransactionsIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
