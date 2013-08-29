
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class DebitTransferDoubleState extends ViewObject implements DebitTransferDoubleStateView{
    
    protected DebitTransferStateView debitTransferStateOld;
    protected DebitTransferStateView debitTransferStateNew;
    
    public DebitTransferDoubleState(DebitTransferStateView debitTransferStateOld,DebitTransferStateView debitTransferStateNew,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.debitTransferStateOld = debitTransferStateOld;
        this.debitTransferStateNew = debitTransferStateNew;        
    }
    
    static public long getTypeId() {
        return 228;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public DebitTransferStateView getDebitTransferStateOld()throws ModelException{
        return this.debitTransferStateOld;
    }
    public void setDebitTransferStateOld(DebitTransferStateView newValue) throws ModelException {
        this.debitTransferStateOld = newValue;
    }
    public DebitTransferStateView getDebitTransferStateNew()throws ModelException{
        return this.debitTransferStateNew;
    }
    public void setDebitTransferStateNew(DebitTransferStateView newValue) throws ModelException {
        this.debitTransferStateNew = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferDoubleState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferDoubleState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferDoubleState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DebitTransferStateView debitTransferStateOld = this.getDebitTransferStateOld();
        if (debitTransferStateOld != null) {
            ((ViewProxi)debitTransferStateOld).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(debitTransferStateOld.getClassId(), debitTransferStateOld.getId())));
        }
        DebitTransferStateView debitTransferStateNew = this.getDebitTransferStateNew();
        if (debitTransferStateNew != null) {
            ((ViewProxi)debitTransferStateNew).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(debitTransferStateNew.getClassId(), debitTransferStateNew.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getDebitTransferStateOld() != null) return new DebitTransferStateOldDebitTransferDoubleStateWrapper(this, originalIndex, (ViewRoot)this.getDebitTransferStateOld());
        if(this.getDebitTransferStateOld() != null) index = index - 1;
        if(index == 0 && this.getDebitTransferStateNew() != null) return new DebitTransferStateNewDebitTransferDoubleStateWrapper(this, originalIndex, (ViewRoot)this.getDebitTransferStateNew());
        if(this.getDebitTransferStateNew() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitTransferStateOld() == null ? 0 : 1)
            + (this.getDebitTransferStateNew() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDebitTransferStateOld() == null ? true : false)
            && (this.getDebitTransferStateNew() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDebitTransferStateOld() != null && this.getDebitTransferStateOld().equals(child)) return result;
        if(this.getDebitTransferStateOld() != null) result = result + 1;
        if(this.getDebitTransferStateNew() != null && this.getDebitTransferStateNew().equals(child)) return result;
        if(this.getDebitTransferStateNew() != null) result = result + 1;
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
