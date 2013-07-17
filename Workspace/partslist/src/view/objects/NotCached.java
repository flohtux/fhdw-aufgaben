
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class NotCached extends view.objects.State implements NotCachedView{
    
    
    public NotCached(ComponentView master,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((ComponentView)master,id, classId);        
    }
    
    static public long getTypeId() {
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(StateVisitor visitor) throws ModelException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(StateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotCached(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotCached(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ComponentView master = this.getMaster();
        if (master != null) {
            ((ViewProxi)master).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(master.getClassId(), master.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMaster() != null) return new MasterStateWrapper(this, originalIndex, (ViewRoot)this.getMaster());
        if(this.getMaster() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMaster() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMaster() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMaster() != null && this.getMaster().equals(child)) return result;
        if(this.getMaster() != null) result = result + 1;
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
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
