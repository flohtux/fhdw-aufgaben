
package view.objects;

import view.AccountView;
import view.CompensationRequestView;
import view.CompensationView;
import view.DebitTransferTransactionView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Compensation extends ViewObject implements CompensationView{
    
    protected java.util.Vector<DebitTransferTransactionView> transactionsToBeCompensated;
    protected AccountView requestingAccount;
    protected java.util.Vector<CompensationRequestView> pendingRequests;
    
    public Compensation(java.util.Vector<DebitTransferTransactionView> transactionsToBeCompensated,AccountView requestingAccount,java.util.Vector<CompensationRequestView> pendingRequests,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.transactionsToBeCompensated = transactionsToBeCompensated;
        this.requestingAccount = requestingAccount;
        this.pendingRequests = pendingRequests;        
    }
    
    static public long getTypeId() {
        return 254;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<DebitTransferTransactionView> getTransactionsToBeCompensated()throws ModelException{
        return this.transactionsToBeCompensated;
    }
    public void setTransactionsToBeCompensated(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        this.transactionsToBeCompensated = newValue;
    }
    public AccountView getRequestingAccount()throws ModelException{
        return this.requestingAccount;
    }
    public void setRequestingAccount(AccountView newValue) throws ModelException {
        this.requestingAccount = newValue;
    }
    public java.util.Vector<CompensationRequestView> getPendingRequests()throws ModelException{
        return this.pendingRequests;
    }
    public void setPendingRequests(java.util.Vector<CompensationRequestView> newValue) throws ModelException {
        this.pendingRequests = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompensation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensation(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> transactionsToBeCompensated = this.getTransactionsToBeCompensated();
        if (transactionsToBeCompensated != null) {
            ViewObject.resolveVectorProxies(transactionsToBeCompensated, resultTable);
        }
        AccountView requestingAccount = this.getRequestingAccount();
        if (requestingAccount != null) {
            ((ViewProxi)requestingAccount).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(requestingAccount.getClassId(), requestingAccount.getId())));
        }
        java.util.Vector<?> pendingRequests = this.getPendingRequests();
        if (pendingRequests != null) {
            ViewObject.resolveVectorProxies(pendingRequests, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTransactionsToBeCompensated().size()) return new TransactionsToBeCompensatedCompensationWrapper(this, originalIndex, (ViewRoot)this.getTransactionsToBeCompensated().get(index));
        index = index - this.getTransactionsToBeCompensated().size();
        if(index == 0 && this.getRequestingAccount() != null) return new RequestingAccountCompensationWrapper(this, originalIndex, (ViewRoot)this.getRequestingAccount());
        if(this.getRequestingAccount() != null) index = index - 1;
        if(index < this.getPendingRequests().size()) return new PendingRequestsCompensationWrapper(this, originalIndex, (ViewRoot)this.getPendingRequests().get(index));
        index = index - this.getPendingRequests().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTransactionsToBeCompensated().size())
            + (this.getRequestingAccount() == null ? 0 : 1)
            + (this.getPendingRequests().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getTransactionsToBeCompensated().size() == 0)
            && (this.getRequestingAccount() == null ? true : false)
            && (this.getPendingRequests().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTransactionsToBeCompensatedIterator = this.getTransactionsToBeCompensated().iterator();
        while(getTransactionsToBeCompensatedIterator.hasNext()){
            if(getTransactionsToBeCompensatedIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getRequestingAccount() != null && this.getRequestingAccount().equals(child)) return result;
        if(this.getRequestingAccount() != null) result = result + 1;
        java.util.Iterator<?> getPendingRequestsIterator = this.getPendingRequests().iterator();
        while(getPendingRequestsIterator.hasNext()){
            if(getPendingRequestsIterator.next().equals(child)) return result;
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
