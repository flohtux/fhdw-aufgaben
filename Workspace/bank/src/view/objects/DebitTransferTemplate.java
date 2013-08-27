
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class DebitTransferTemplate extends ViewObject implements DebitTransferTemplateView{
    
    protected java.util.Vector<DebitTransferTransactionView> templates;
    
    public DebitTransferTemplate(java.util.Vector<DebitTransferTransactionView> templates,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.templates = templates;        
    }
    
    static public long getTypeId() {
        return 208;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<DebitTransferTransactionView> getTemplates()throws ModelException{
        return this.templates;
    }
    public void setTemplates(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        this.templates = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferTemplate(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferTemplate(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferTemplate(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferTemplate(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> templates = this.getTemplates();
        if (templates != null) {
            ViewObject.resolveVectorProxies(templates, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTemplates().size()) return new TemplatesDebitTransferTemplateWrapper(this, originalIndex, (ViewRoot)this.getTemplates().get(index));
        index = index - this.getTemplates().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTemplates().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getTemplates().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTemplatesIterator = this.getTemplates().iterator();
        while(getTemplatesIterator.hasNext()){
            if(getTemplatesIterator.next().equals(child)) return result;
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
