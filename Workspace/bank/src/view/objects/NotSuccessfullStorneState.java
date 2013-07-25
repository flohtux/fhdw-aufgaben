
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class NotSuccessfullStorneState extends view.objects.StornoState implements NotSuccessfullStorneStateView{
    
    
    public NotSuccessfullStorneState(DebitNoteTransferView debitNoteTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((DebitNoteTransferView)debitNoteTransfer,id, classId);        
    }
    
    static public long getTypeId() {
        return 134;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(StornoStateVisitor visitor) throws ModelException {
        visitor.handleNotSuccessfullStorneState(this);
    }
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotSuccessfullStorneState(this);
    }
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotSuccessfullStorneState(this);
    }
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotSuccessfullStorneState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotSuccessfullStorneState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotSuccessfullStorneState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotSuccessfullStorneState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotSuccessfullStorneState(this);
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
