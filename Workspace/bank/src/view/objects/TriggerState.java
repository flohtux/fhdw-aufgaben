
package view.objects;

import view.ModelException;
import view.TriggerStateView;
import view.TriggerView;


/* Additional import section end */

public abstract class TriggerState extends ViewObject implements TriggerStateView{
    
    protected TriggerView master;
    
    public TriggerState(TriggerView master,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.master = master;        
    }
    
    public TriggerView getMaster()throws ModelException{
        return this.master;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
