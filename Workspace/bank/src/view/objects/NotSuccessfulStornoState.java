
package view.objects;

import view.CompensationView;
import view.ModelException;
import view.NotSuccessfulStornoStateView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.StornoStateExceptionVisitor;
import view.visitor.StornoStateReturnExceptionVisitor;
import view.visitor.StornoStateReturnVisitor;
import view.visitor.StornoStateVisitor;


/* Additional import section end */

public class NotSuccessfulStornoState extends view.objects.StornoState implements NotSuccessfulStornoStateView{
    
    
    public NotSuccessfulStornoState(CompensationView debitTransfer,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((CompensationView)debitTransfer,id, classId);        
    }
    
    static public long getTypeId() {
        return 134;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(StornoStateVisitor visitor) throws ModelException {
        visitor.handleNotSuccessfulStornoState(this);
    }
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotSuccessfulStornoState(this);
    }
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotSuccessfulStornoState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotSuccessfulStornoState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        CompensationView debitTransfer = this.getDebitTransfer();
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
