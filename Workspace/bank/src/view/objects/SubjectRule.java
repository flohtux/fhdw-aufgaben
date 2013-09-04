
package view.objects;

import view.ModelException;
import view.SubjectRuleView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.RuleExceptionVisitor;
import view.visitor.RuleReturnExceptionVisitor;
import view.visitor.RuleReturnVisitor;
import view.visitor.RuleVisitor;


/* Additional import section end */

public class SubjectRule extends view.objects.Rule implements SubjectRuleView{
    
    protected String subject;
    
    public SubjectRule(String subject,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.subject = subject;        
    }
    
    static public long getTypeId() {
        return 230;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getSubject()throws ModelException{
        return this.subject;
    }
    public void setSubject(String newValue) throws ModelException {
        this.subject = newValue;
    }
    
    public void accept(RuleVisitor visitor) throws ModelException {
        visitor.handleSubjectRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSubjectRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSubjectRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSubjectRule(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleSubjectRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleSubjectRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleSubjectRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleSubjectRule(this);
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
    public int getSubjectIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "subject";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getSubject();
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
            this.setSubject(newValue);
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
