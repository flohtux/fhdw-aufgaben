
package view.objects;

import view.DebitTransferSuccessfulView;
import view.DebitTransferTransactionView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class DebitTransferSuccessful extends ViewObject implements DebitTransferSuccessfulView{
    
    protected java.util.Vector<DebitTransferTransactionView> successfuls;
    
    public DebitTransferSuccessful(java.util.Vector<DebitTransferTransactionView> successfuls,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.successfuls = successfuls;        
    }
    
    static public long getTypeId() {
        return 197;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<DebitTransferTransactionView> getSuccessfuls()throws ModelException{
        return this.successfuls;
    }
    public void setSuccessfuls(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        this.successfuls = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferSuccessful(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferSuccessful(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferSuccessful(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> successfuls = this.getSuccessfuls();
        if (successfuls != null) {
            ViewObject.resolveVectorProxies(successfuls, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getSuccessfuls().size()) return new SuccessfulsDebitTransferSuccessfulWrapper(this, originalIndex, (ViewRoot)this.getSuccessfuls().get(index));
        index = index - this.getSuccessfuls().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSuccessfuls().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getSuccessfuls().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getSuccessfulsIterator = this.getSuccessfuls().iterator();
        while(getSuccessfulsIterator.hasNext()){
            if(getSuccessfulsIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
