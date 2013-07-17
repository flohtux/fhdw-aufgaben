
package view.objects;

import view.*;


/* Additional import section end */

public abstract class Component extends ViewObject implements ComponentView{
    
    protected String name;
    protected StateView currentState;
    protected java.util.Vector<QPartView> partOf;
    
    public Component(String name,StateView currentState,java.util.Vector<QPartView> partOf,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.currentState = currentState;
        this.partOf = partOf;        
    }
    
    public String getName()throws ModelException{
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public StateView getCurrentState()throws ModelException{
        return this.currentState;
    }
    public void setCurrentState(StateView newValue) throws ModelException {
        this.currentState = newValue;
    }
    public java.util.Vector<QPartView> getPartOf()throws ModelException{
        return this.partOf;
    }
    
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        StateView currentState = this.getCurrentState();
        if (currentState != null) {
            ((ViewProxi)currentState).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(currentState.getClassId(), currentState.getId())));
        }
        java.util.Vector<?> partOf = this.getPartOf();
        if (partOf != null) {
            ViewObject.resolveVectorProxies(partOf, resultTable);
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
