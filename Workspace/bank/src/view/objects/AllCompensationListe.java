
package view.objects;

import view.AllCompensationListeView;
import view.CompensationListeView;
import view.CompensationRequestListeView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class AllCompensationListe extends ViewObject implements AllCompensationListeView{
    
    protected CompensationListeView outgoingCompensations;
    protected CompensationRequestListeView pendingCompensationRequests;
    
    public AllCompensationListe(CompensationListeView outgoingCompensations,CompensationRequestListeView pendingCompensationRequests,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.outgoingCompensations = outgoingCompensations;
        this.pendingCompensationRequests = pendingCompensationRequests;        
    }
    
    static public long getTypeId() {
        return 261;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public CompensationListeView getOutgoingCompensations()throws ModelException{
        return this.outgoingCompensations;
    }
    public void setOutgoingCompensations(CompensationListeView newValue) throws ModelException {
        this.outgoingCompensations = newValue;
    }
    public CompensationRequestListeView getPendingCompensationRequests()throws ModelException{
        return this.pendingCompensationRequests;
    }
    public void setPendingCompensationRequests(CompensationRequestListeView newValue) throws ModelException {
        this.pendingCompensationRequests = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAllCompensationListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAllCompensationListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAllCompensationListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAllCompensationListe(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        CompensationListeView outgoingCompensations = this.getOutgoingCompensations();
        if (outgoingCompensations != null) {
            ((ViewProxi)outgoingCompensations).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(outgoingCompensations.getClassId(), outgoingCompensations.getId())));
        }
        CompensationRequestListeView pendingCompensationRequests = this.getPendingCompensationRequests();
        if (pendingCompensationRequests != null) {
            ((ViewProxi)pendingCompensationRequests).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(pendingCompensationRequests.getClassId(), pendingCompensationRequests.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getOutgoingCompensations() != null) return new OutgoingCompensationsAllCompensationListeWrapper(this, originalIndex, (ViewRoot)this.getOutgoingCompensations());
        if(this.getOutgoingCompensations() != null) index = index - 1;
        if(index == 0 && this.getPendingCompensationRequests() != null) return new PendingCompensationRequestsAllCompensationListeWrapper(this, originalIndex, (ViewRoot)this.getPendingCompensationRequests());
        if(this.getPendingCompensationRequests() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getOutgoingCompensations() == null ? 0 : 1)
            + (this.getPendingCompensationRequests() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getOutgoingCompensations() == null ? true : false)
            && (this.getPendingCompensationRequests() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getOutgoingCompensations() != null && this.getOutgoingCompensations().equals(child)) return result;
        if(this.getOutgoingCompensations() != null) result = result + 1;
        if(this.getPendingCompensationRequests() != null && this.getPendingCompensationRequests().equals(child)) return result;
        if(this.getPendingCompensationRequests() != null) result = result + 1;
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
