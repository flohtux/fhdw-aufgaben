
package view.objects;

import view.DebitTransferListeView;
import view.DebitTransferView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class DebitTransferListe extends ViewObject implements DebitTransferListeView{
    
    protected java.util.Vector<DebitTransferView> debitTransfers;
    
    public DebitTransferListe(java.util.Vector<DebitTransferView> debitTransfers,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.debitTransfers = debitTransfers;        
    }
    
    static public long getTypeId() {
        return 211;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<DebitTransferView> getDebitTransfers()throws ModelException{
        return this.debitTransfers;
    }
    public void setDebitTransfers(java.util.Vector<DebitTransferView> newValue) throws ModelException {
        this.debitTransfers = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferListe(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> debitTransfers = this.getDebitTransfers();
        if (debitTransfers != null) {
            ViewObject.resolveVectorProxies(debitTransfers, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getDebitTransfers().size()) return new DebitTransfersDebitTransferListeWrapper(this, originalIndex, (ViewRoot)this.getDebitTransfers().get(index));
        index = index - this.getDebitTransfers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitTransfers().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDebitTransfers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getDebitTransfersIterator = this.getDebitTransfers().iterator();
        while(getDebitTransfersIterator.hasNext()){
            if(getDebitTransfersIterator.next().equals(child)) return result;
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
