
package view.objects;

import view.DebitTransferTransactionView;
import view.ModelException;
import view.RuleView;
import view.TriggerView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class Trigger extends ViewObject implements TriggerView{
    
    protected String name;
    protected DebitTransferTransactionView action;
    protected java.util.Vector<RuleView> rules;
    
    public Trigger(String name,DebitTransferTransactionView action,java.util.Vector<RuleView> rules,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.action = action;
        this.rules = rules;        
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
    public java.util.Vector<RuleView> getRules()throws ModelException{
        return this.rules;
    }
    public void setRules(java.util.Vector<RuleView> newValue) throws ModelException {
        this.rules = newValue;
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
        java.util.Vector<?> rules = this.getRules();
        if (rules != null) {
            ViewObject.resolveVectorProxies(rules, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getAction() != null) return new ActionTriggerWrapper(this, originalIndex, (ViewRoot)this.getAction());
        if(this.getAction() != null) index = index - 1;
        if(index < this.getRules().size()) return new RulesTriggerWrapper(this, originalIndex, (ViewRoot)this.getRules().get(index));
        index = index - this.getRules().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAction() == null ? 0 : 1)
            + (this.getRules().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getAction() == null ? true : false)
            && (this.getRules().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAction() != null && this.getAction().equals(child)) return result;
        if(this.getAction() != null) result = result + 1;
        java.util.Iterator<?> getRulesIterator = this.getRules().iterator();
        while(getRulesIterator.hasNext()){
            if(getRulesIterator.next().equals(child)) return result;
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
