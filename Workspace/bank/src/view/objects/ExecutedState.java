
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ExecutedState extends view.objects.DebitNoteTransferState implements ExecutedStateView{
    
    
    public ExecutedState(DebitNoteTransferStateView state,StornoStateView stornoState,DebitNoteTransferStateView debitNoteTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((DebitNoteTransferStateView)state,(StornoStateView)stornoState,(DebitNoteTransferStateView)debitNoteTransfer,id, classId);        
    }
    
    static public long getTypeId() {
        return 110;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(DebitNoteTransferStateVisitor visitor) throws ModelException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleExecutedState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleExecutedState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DebitNoteTransferStateView state = this.getState();
        if (state != null) {
            ((ViewProxi)state).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(state.getClassId(), state.getId())));
        }
        StornoStateView stornoState = this.getStornoState();
        if (stornoState != null) {
            ((ViewProxi)stornoState).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(stornoState.getClassId(), stornoState.getId())));
        }
        DebitNoteTransferStateView debitNoteTransfer = this.getDebitNoteTransfer();
        if (debitNoteTransfer != null) {
            ((ViewProxi)debitNoteTransfer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(debitNoteTransfer.getClassId(), debitNoteTransfer.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getState() != null) return new StateDebitNoteTransferStateWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        if(index == 0 && this.getStornoState() != null) return new StornoStateDebitNoteTransferStateWrapper(this, originalIndex, (ViewRoot)this.getStornoState());
        if(this.getStornoState() != null) index = index - 1;
        if(index == 0 && this.getDebitNoteTransfer() != null) return new DebitNoteTransferDebitNoteTransferStateWrapper(this, originalIndex, (ViewRoot)this.getDebitNoteTransfer());
        if(this.getDebitNoteTransfer() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getState() == null ? 0 : 1)
            + (this.getStornoState() == null ? 0 : 1)
            + (this.getDebitNoteTransfer() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getState() == null ? true : false)
            && (this.getStornoState() == null ? true : false)
            && (this.getDebitNoteTransfer() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        if(this.getStornoState() != null && this.getStornoState().equals(child)) return result;
        if(this.getStornoState() != null) result = result + 1;
        if(this.getDebitNoteTransfer() != null && this.getDebitNoteTransfer().equals(child)) return result;
        if(this.getDebitNoteTransfer() != null) result = result + 1;
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
