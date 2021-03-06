
package view.objects;

import view.AcceptedStateView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.CompensationRequestStateExceptionVisitor;
import view.visitor.CompensationRequestStateReturnExceptionVisitor;
import view.visitor.CompensationRequestStateReturnVisitor;
import view.visitor.CompensationRequestStateVisitor;


/* Additional import section end */

public class AcceptedState extends view.objects.CompensationRequestState implements AcceptedStateView{
    
    
    public AcceptedState(long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);        
    }
    
    static public long getTypeId() {
        return 265;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(CompensationRequestStateVisitor visitor) throws ModelException {
        visitor.handleAcceptedState(this);
    }
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAcceptedState(this);
    }
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAcceptedState(this);
    }
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAcceptedState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAcceptedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAcceptedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAcceptedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAcceptedState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        
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
