
package view.objects;

import view.ModelException;
import view.RuleView;
import view.TriggerView;


/* Additional import section end */

public abstract class Rule extends ViewObject implements RuleView{
    
    protected TriggerView masterTrigger;
    
    public Rule(TriggerView masterTrigger,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.masterTrigger = masterTrigger;        
    }
    
    public TriggerView getMasterTrigger()throws ModelException{
        return this.masterTrigger;
    }
    
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        TriggerView masterTrigger = this.getMasterTrigger();
        if (masterTrigger != null) {
            ((ViewProxi)masterTrigger).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(masterTrigger.getClassId(), masterTrigger.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMasterTrigger() != null) return new MasterTriggerRuleWrapper(this, originalIndex, (ViewRoot)this.getMasterTrigger());
        if(this.getMasterTrigger() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMasterTrigger() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMasterTrigger() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMasterTrigger() != null && this.getMasterTrigger().equals(child)) return result;
        if(this.getMasterTrigger() != null) result = result + 1;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
