
package view.objects;

import view.*;


/* Additional import section end */

public abstract class StornoState extends ViewObject implements StornoStateView{
    
    protected DebitNoteTransferStateView debitNoteTransfer;
    
    public StornoState(DebitNoteTransferStateView debitNoteTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.debitNoteTransfer = debitNoteTransfer;        
    }
    
    public DebitNoteTransferStateView getDebitNoteTransfer()throws ModelException{
        return this.debitNoteTransfer;
    }
    
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DebitNoteTransferStateView debitNoteTransfer = this.getDebitNoteTransfer();
        if (debitNoteTransfer != null) {
            ((ViewProxi)debitNoteTransfer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(debitNoteTransfer.getClassId(), debitNoteTransfer.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getDebitNoteTransfer() != null) return new DebitNoteTransferStornoStateWrapper(this, originalIndex, (ViewRoot)this.getDebitNoteTransfer());
        if(this.getDebitNoteTransfer() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitNoteTransfer() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDebitNoteTransfer() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}