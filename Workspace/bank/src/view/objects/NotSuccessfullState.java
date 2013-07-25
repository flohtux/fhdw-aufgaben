
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class NotSuccessfullState extends view.objects.DebitNoteTransferState implements NotSuccessfullStateView{
    
    
    public NotSuccessfullState(DebitNoteTransferView debitNoteTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((DebitNoteTransferView)debitNoteTransfer,id, classId);        
    }
    
    static public long getTypeId() {
        return 142;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(DebitNoteTransferStateVisitor visitor) throws ModelException {
        visitor.handleNotSuccessfullState(this);
    }
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotSuccessfullState(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotSuccessfullState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotSuccessfullState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotSuccessfullState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotSuccessfullState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DebitNoteTransferView debitNoteTransfer = this.getDebitNoteTransfer();
        if (debitNoteTransfer != null) {
            ((ViewProxi)debitNoteTransfer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(debitNoteTransfer.getClassId(), debitNoteTransfer.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
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
