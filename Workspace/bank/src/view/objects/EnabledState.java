
package view.objects;

import view.EnabledStateView;
import view.ModelException;
import view.TriggerView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.TriggerStateExceptionVisitor;
import view.visitor.TriggerStateReturnExceptionVisitor;
import view.visitor.TriggerStateReturnVisitor;
import view.visitor.TriggerStateVisitor;


/* Additional import section end */

public class EnabledState extends view.objects.TriggerState implements EnabledStateView{
    
    
    public EnabledState(TriggerView master,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((TriggerView)master,id, classId);        
    }
    
    static public long getTypeId() {
        return 238;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(TriggerStateVisitor visitor) throws ModelException {
        visitor.handleEnabledState(this);
    }
    public <R> R accept(TriggerStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleEnabledState(this);
    }
    public <E extends UserException>  void accept(TriggerStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleEnabledState(this);
    }
    public <R, E extends UserException> R accept(TriggerStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleEnabledState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleEnabledState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleEnabledState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleEnabledState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleEnabledState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        TriggerView master = this.getMaster();
        if (master != null) {
            ((ViewProxi)master).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(master.getClassId(), master.getId())));
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
