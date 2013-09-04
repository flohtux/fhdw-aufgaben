
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Trigger extends ViewObject implements TriggerView{
    
    protected String name;
    protected DebitTransferTransactionView action;
    protected java.util.Vector<RuleView> rule;
    
    public Trigger(String name,DebitTransferTransactionView action,java.util.Vector<RuleView> rule,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.action = action;
        this.rule = rule;        
    }
    
    static public long getTypeId() {
        return 231;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName()throws ModelException{
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public DebitTransferTransactionView getAction()throws ModelException{
        return this.action;
    }
    public void setAction(DebitTransferTransactionView newValue) throws ModelException {
        this.action = newValue;
    }
    public java.util.Vector<RuleView> getRule()throws ModelException{
        return this.rule;
    }
    public void setRule(java.util.Vector<RuleView> newValue) throws ModelException {
        this.rule = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTrigger(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTrigger(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTrigger(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTrigger(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DebitTransferTransactionView action = this.getAction();
        if (action != null) {
            ((ViewProxi)action).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(action.getClassId(), action.getId())));
        }
        java.util.Vector<?> rule = this.getRule();
        if (rule != null) {
            ViewObject.resolveVectorProxies(rule, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getAction() != null) return new ActionTriggerWrapper(this, originalIndex, (ViewRoot)this.getAction());
        if(this.getAction() != null) index = index - 1;
        if(index < this.getRule().size()) return new RuleTriggerWrapper(this, originalIndex, (ViewRoot)this.getRule().get(index));
        index = index - this.getRule().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAction() == null ? 0 : 1)
            + (this.getRule().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAction() == null ? true : false)
            && (this.getRule().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAction() != null && this.getAction().equals(child)) return result;
        if(this.getAction() != null) result = result + 1;
        java.util.Iterator<?> getRuleIterator = this.getRule().iterator();
        while(getRuleIterator.hasNext()){
            if(getRuleIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
