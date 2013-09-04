
package view.objects;

import view.ModelException;
import view.TriggerListeView;
import view.TriggerView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class TriggerListe extends ViewObject implements TriggerListeView{
    
    protected java.util.Vector<TriggerView> triggers;
    
    public TriggerListe(java.util.Vector<TriggerView> triggers,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.triggers = triggers;        
    }
    
    static public long getTypeId() {
        return 234;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<TriggerView> getTriggers()throws ModelException{
        return this.triggers;
    }
    public void setTriggers(java.util.Vector<TriggerView> newValue) throws ModelException {
        this.triggers = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTriggerListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTriggerListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTriggerListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTriggerListe(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> triggers = this.getTriggers();
        if (triggers != null) {
            ViewObject.resolveVectorProxies(triggers, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTriggers().size()) return new TriggersTriggerListeWrapper(this, originalIndex, (ViewRoot)this.getTriggers().get(index));
        index = index - this.getTriggers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTriggers().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getTriggers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTriggersIterator = this.getTriggers().iterator();
        while(getTriggersIterator.hasNext()){
            if(getTriggersIterator.next().equals(child)) return result;
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
