
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Transaction extends view.objects.DebitTransferTransaction implements TransactionView{
    
    protected DebitTransferListeView debitTransfer;
    
    public Transaction(java.util.Date timestamp,AccountView sender,DebitTransferStateView state,DebitTransferListeView debitTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((java.util.Date)timestamp,(AccountView)sender,(DebitTransferStateView)state,id, classId);
        this.debitTransfer = debitTransfer;        
    }
    
    static public long getTypeId() {
        return 146;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public DebitTransferListeView getDebitTransfer()throws ModelException{
        return this.debitTransfer;
    }
    public void setDebitTransfer(DebitTransferListeView newValue) throws ModelException {
        this.debitTransfer = newValue;
    }
    
    public void accept(DebitTransferTransactionVisitor visitor) throws ModelException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransaction(this);
    }
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransaction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransaction(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AccountView sender = this.getSender();
        if (sender != null) {
            ((ViewProxi)sender).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(sender.getClassId(), sender.getId())));
        }
        DebitTransferStateView state = this.getState();
        if (state != null) {
            ((ViewProxi)state).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(state.getClassId(), state.getId())));
        }
        DebitTransferListeView debitTransfer = this.getDebitTransfer();
        if (debitTransfer != null) {
            ((ViewProxi)debitTransfer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(debitTransfer.getClassId(), debitTransfer.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getState() != null) return new StateDebitTransferTransactionWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        if(this.getDebitTransfer() != null && index < this.getDebitTransfer().getTheObject().getChildCount())
            return this.getDebitTransfer().getTheObject().getChild(index);
        if(this.getDebitTransfer() != null) index = index - this.getDebitTransfer().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getState() == null ? 0 : 1)
            + (this.getDebitTransfer() == null ? 0 : this.getDebitTransfer().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getState() == null ? true : false)
            && (this.getDebitTransfer() == null ? true : this.getDebitTransfer().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        if(this.getDebitTransfer() != null && this.getDebitTransfer().equals(child)) return result;
        if(this.getDebitTransfer() != null) result = result + 1;
        return -1;
    }
    public int getTimestampIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "Zeitstempel";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return ViewRoot.toString(getTimestamp(), true );
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
            this.setTimestamp(new java.text.SimpleDateFormat(TIMESTAMPFORMAT).parse(newValue));
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
