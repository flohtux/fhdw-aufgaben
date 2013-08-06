
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class DebitNote extends view.objects.DebitNoteTransfer implements DebitNoteView{
    
    
    public DebitNote(long receiverAccountNumber,long receiverBankNumber,AccountView sender,MoneyView money,DebitNoteTransferStateView state,StornoStateView stornoState,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((long)receiverAccountNumber,(long)receiverBankNumber,(AccountView)sender,(MoneyView)money,(DebitNoteTransferStateView)state,(StornoStateView)stornoState,id, classId);        
    }
    
    static public long getTypeId() {
        return 136;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(DebitNoteTransferVisitor visitor) throws ModelException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNote(this);
    }
    public void accept(DebitNoteTransferTransactionVisitor visitor) throws ModelException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(DebitNoteTransferTransactionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferTransactionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNote(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNote(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AccountView sender = this.getSender();
        if (sender != null) {
            ((ViewProxi)sender).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(sender.getClassId(), sender.getId())));
        }
        MoneyView money = this.getMoney();
        if (money != null) {
            ((ViewProxi)money).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(money.getClassId(), money.getId())));
        }
        DebitNoteTransferStateView state = this.getState();
        if (state != null) {
            ((ViewProxi)state).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(state.getClassId(), state.getId())));
        }
        StornoStateView stornoState = this.getStornoState();
        if (stornoState != null) {
            ((ViewProxi)stornoState).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(stornoState.getClassId(), stornoState.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getState() != null) return new StateDebitNoteTransferWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getState() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getState() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        return -1;
    }
    public int getReceiverAccountNumberIndex() throws ModelException {
        return 0;
    }
    public int getReceiverBankNumberIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "Empfänger Konto";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "Empfänger Bank";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getReceiverAccountNumber());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getReceiverBankNumber());
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
            this.setReceiverAccountNumber(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setReceiverBankNumber(Long.parseLong(newValue));
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
