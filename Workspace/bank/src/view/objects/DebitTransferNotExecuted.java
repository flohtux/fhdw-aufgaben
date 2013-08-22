
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class DebitTransferNotExecuted extends ViewObject implements DebitTransferNotExecutedView{
    
    protected java.util.Vector<DebitTransferView> notExecuteds;
    
    public DebitTransferNotExecuted(java.util.Vector<DebitTransferView> notExecuteds,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.notExecuteds = notExecuteds;        
    }
    
    static public long getTypeId() {
        return 200;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<DebitTransferView> getNotExecuteds()throws ModelException{
        return this.notExecuteds;
    }
    public void setNotExecuteds(java.util.Vector<DebitTransferView> newValue) throws ModelException {
        this.notExecuteds = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferNotExecuted(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferNotExecuted(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferNotExecuted(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferNotExecuted(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> notExecuteds = this.getNotExecuteds();
        if (notExecuteds != null) {
            ViewObject.resolveVectorProxies(notExecuteds, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getNotExecuteds().size()) return new NotExecutedsDebitTransferNotExecutedWrapper(this, originalIndex, (ViewRoot)this.getNotExecuteds().get(index));
        index = index - this.getNotExecuteds().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getNotExecuteds().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getNotExecuteds().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getNotExecutedsIterator = this.getNotExecuteds().iterator();
        while(getNotExecutedsIterator.hasNext()){
            if(getNotExecutedsIterator.next().equals(child)) return result;
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
