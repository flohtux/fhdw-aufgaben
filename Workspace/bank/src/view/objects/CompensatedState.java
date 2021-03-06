
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class CompensatedState extends view.objects.DebitTransferState implements CompensatedStateView{
    
    
    public CompensatedState(DebitTransferTransactionView debitTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((DebitTransferTransactionView)debitTransfer,id, classId);        
    }
    
    static public long getTypeId() {
        return 282;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(DebitTransferStateVisitor visitor) throws ModelException {
        visitor.handleCompensatedState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensatedState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensatedState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensatedState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompensatedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensatedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensatedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensatedState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DebitTransferTransactionView debitTransfer = this.getDebitTransfer();
        if (debitTransfer != null) {
            ((ViewProxi)debitTransfer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(debitTransfer.getClassId(), debitTransfer.getId())));
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
