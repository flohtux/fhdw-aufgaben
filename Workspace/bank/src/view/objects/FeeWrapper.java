
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class FeeWrapper extends ViewObject implements FeeWrapperView{
    
    protected TransactionFeeView fee;
    protected InternalFeeView internalFee;
    
    public FeeWrapper(TransactionFeeView fee,InternalFeeView internalFee,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.fee = fee;
        this.internalFee = internalFee;        
    }
    
    static public long getTypeId() {
        return 242;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public TransactionFeeView getFee()throws ModelException{
        return this.fee;
    }
    public void setFee(TransactionFeeView newValue) throws ModelException {
        this.fee = newValue;
    }
    public InternalFeeView getInternalFee()throws ModelException{
        return this.internalFee;
    }
    public void setInternalFee(InternalFeeView newValue) throws ModelException {
        this.internalFee = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFeeWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFeeWrapper(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFeeWrapper(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFeeWrapper(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        TransactionFeeView fee = this.getFee();
        if (fee != null) {
            ((ViewProxi)fee).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(fee.getClassId(), fee.getId())));
        }
        InternalFeeView internalFee = this.getInternalFee();
        if (internalFee != null) {
            ((ViewProxi)internalFee).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(internalFee.getClassId(), internalFee.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getFee() != null) return new FeeFeeWrapperWrapper(this, originalIndex, (ViewRoot)this.getFee());
        if(this.getFee() != null) index = index - 1;
        if(index == 0 && this.getInternalFee() != null) return new InternalFeeFeeWrapperWrapper(this, originalIndex, (ViewRoot)this.getInternalFee());
        if(this.getInternalFee() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFee() == null ? 0 : 1)
            + (this.getInternalFee() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getFee() == null ? true : false)
            && (this.getInternalFee() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFee() != null && this.getFee().equals(child)) return result;
        if(this.getFee() != null) result = result + 1;
        if(this.getInternalFee() != null && this.getInternalFee().equals(child)) return result;
        if(this.getInternalFee() != null) result = result + 1;
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
