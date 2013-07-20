
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ProcentualFee extends view.objects.TransactionFee implements ProcentualFeeView{
    
    protected PercentView percent;
    
    public ProcentualFee(PercentView percent,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.percent = percent;        
    }
    
    static public long getTypeId() {
        return 120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PercentView getPercent()throws ModelException{
        return this.percent;
    }
    public void setPercent(PercentView newValue) throws ModelException {
        this.percent = newValue;
    }
    
    public void accept(TransactionFeeVisitor visitor) throws ModelException {
        visitor.handleProcentualFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProcentualFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProcentualFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProcentualFee(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProcentualFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProcentualFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProcentualFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProcentualFee(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        PercentView percent = this.getPercent();
        if (percent != null) {
            ((ViewProxi)percent).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(percent.getClassId(), percent.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getPercent() != null) return new PercentProcentualFeeWrapper(this, originalIndex, (ViewRoot)this.getPercent());
        if(this.getPercent() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPercent() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getPercent() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getPercent() != null && this.getPercent().equals(child)) return result;
        if(this.getPercent() != null) result = result + 1;
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
