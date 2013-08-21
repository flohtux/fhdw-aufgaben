
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Account extends ViewObject implements AccountView{
    
    protected long accountNumber;
    protected MoneyView money;
    protected LimitAccountView limit;
    protected java.util.Vector<DebitTransferTransactionView> debitTransferTransactions;
    protected java.util.Vector<DebitGrantView> grantedDebitGrants;
    protected java.util.Vector<DebitGrantView> receivedDebitGrants;
    
    public Account(long accountNumber,MoneyView money,LimitAccountView limit,java.util.Vector<DebitTransferTransactionView> debitTransferTransactions,java.util.Vector<DebitGrantView> grantedDebitGrants,java.util.Vector<DebitGrantView> receivedDebitGrants,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.accountNumber = accountNumber;
        this.money = money;
        this.limit = limit;
        this.debitTransferTransactions = debitTransferTransactions;
        this.grantedDebitGrants = grantedDebitGrants;
        this.receivedDebitGrants = receivedDebitGrants;        
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
    public java.util.Vector<DebitTransferTransactionView> getDebitTransferTransactions()throws ModelException{
        return this.debitTransferTransactions;
    }
    public void setDebitTransferTransactions(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        this.debitTransferTransactions = newValue;
    }
    public java.util.Vector<DebitGrantView> getGrantedDebitGrants()throws ModelException{
        return this.grantedDebitGrants;
    }
    public void setGrantedDebitGrants(java.util.Vector<DebitGrantView> newValue) throws ModelException {
        this.grantedDebitGrants = newValue;
    }
    public java.util.Vector<DebitGrantView> getReceivedDebitGrants()throws ModelException{
        return this.receivedDebitGrants;
    }
    public void setReceivedDebitGrants(java.util.Vector<DebitGrantView> newValue) throws ModelException {
        this.receivedDebitGrants = newValue;
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
        java.util.Vector<?> debitTransferTransactions = this.getDebitTransferTransactions();
        if (debitTransferTransactions != null) {
            ViewObject.resolveVectorProxies(debitTransferTransactions, resultTable);
        }
        java.util.Vector<?> grantedDebitGrants = this.getGrantedDebitGrants();
        if (grantedDebitGrants != null) {
            ViewObject.resolveVectorProxies(grantedDebitGrants, resultTable);
        }
        java.util.Vector<?> receivedDebitGrants = this.getReceivedDebitGrants();
        if (receivedDebitGrants != null) {
            ViewObject.resolveVectorProxies(receivedDebitGrants, resultTable);
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
        if(index < this.getDebitTransferTransactions().size()) return new DebitTransferTransactionsAccountWrapper(this, originalIndex, (ViewRoot)this.getDebitTransferTransactions().get(index));
        index = index - this.getDebitTransferTransactions().size();
        if(index < this.getGrantedDebitGrants().size()) return new GrantedDebitGrantsAccountWrapper(this, originalIndex, (ViewRoot)this.getGrantedDebitGrants().get(index));
        index = index - this.getGrantedDebitGrants().size();
        if(index < this.getReceivedDebitGrants().size()) return new ReceivedDebitGrantsAccountWrapper(this, originalIndex, (ViewRoot)this.getReceivedDebitGrants().get(index));
        index = index - this.getReceivedDebitGrants().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1)
            + (this.getLimit() == null ? 0 : 1)
            + (this.getDebitTransferTransactions().size())
            + (this.getGrantedDebitGrants().size())
            + (this.getReceivedDebitGrants().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMoney() == null ? true : false)
            && (this.getLimit() == null ? true : false)
            && (this.getDebitTransferTransactions().size() == 0)
            && (this.getGrantedDebitGrants().size() == 0)
            && (this.getReceivedDebitGrants().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        if(this.getLimit() != null && this.getLimit().equals(child)) return result;
        if(this.getLimit() != null) result = result + 1;
        java.util.Iterator<?> getDebitTransferTransactionsIterator = this.getDebitTransferTransactions().iterator();
        while(getDebitTransferTransactionsIterator.hasNext()){
            if(getDebitTransferTransactionsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getGrantedDebitGrantsIterator = this.getGrantedDebitGrants().iterator();
        while(getGrantedDebitGrantsIterator.hasNext()){
            if(getGrantedDebitGrantsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getReceivedDebitGrantsIterator = this.getReceivedDebitGrants().iterator();
        while(getReceivedDebitGrantsIterator.hasNext()){
            if(getReceivedDebitGrantsIterator.next().equals(child)) return result;
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
                if(rowIndex == 0) return "Kontonummer";
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
