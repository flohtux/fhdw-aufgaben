
package view.objects;

import view.CompensationRequestStateView;
import view.CompensationRequestView;
import view.CompensationView;
import view.DebitTransferView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;


/* Additional import section end */

public class CompensationRequest extends ViewObject implements CompensationRequestView{
    
    protected DebitTransferView debitTransfer;
    protected CompensationView masterCompensation;
    protected CompensationRequestStateView state;
    
    public CompensationRequest(DebitTransferView debitTransfer,CompensationView masterCompensation,CompensationRequestStateView state,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.debitTransfer = debitTransfer;
        this.masterCompensation = masterCompensation;
        this.state = state;        
    }
    
    static public long getTypeId() {
        return 256;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public DebitTransferView getDebitTransfer()throws ModelException{
        return this.debitTransfer;
    }
    public void setDebitTransfer(DebitTransferView newValue) throws ModelException {
        this.debitTransfer = newValue;
    }
    public CompensationView getMasterCompensation()throws ModelException{
        return this.masterCompensation;
    }
    public void setMasterCompensation(CompensationView newValue) throws ModelException {
        this.masterCompensation = newValue;
    }
    public CompensationRequestStateView getState()throws ModelException{
        return this.state;
    }
    public void setState(CompensationRequestStateView newValue) throws ModelException {
        this.state = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompensationRequest(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensationRequest(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensationRequest(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensationRequest(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DebitTransferView debitTransfer = this.getDebitTransfer();
        if (debitTransfer != null) {
            ((ViewProxi)debitTransfer).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(debitTransfer.getClassId(), debitTransfer.getId())));
        }
        CompensationView masterCompensation = this.getMasterCompensation();
        if (masterCompensation != null) {
            ((ViewProxi)masterCompensation).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(masterCompensation.getClassId(), masterCompensation.getId())));
        }
        CompensationRequestStateView state = this.getState();
        if (state != null) {
            ((ViewProxi)state).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(state.getClassId(), state.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getDebitTransfer() != null) return new DebitTransferCompensationRequestWrapper(this, originalIndex, (ViewRoot)this.getDebitTransfer());
        if(this.getDebitTransfer() != null) index = index - 1;
        if(index == 0 && this.getMasterCompensation() != null) return new MasterCompensationCompensationRequestWrapper(this, originalIndex, (ViewRoot)this.getMasterCompensation());
        if(this.getMasterCompensation() != null) index = index - 1;
        if(index == 0 && this.getState() != null) return new StateCompensationRequestWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitTransfer() == null ? 0 : 1)
            + (this.getMasterCompensation() == null ? 0 : 1)
            + (this.getState() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getDebitTransfer() == null ? true : false)
            && (this.getMasterCompensation() == null ? true : false)
            && (this.getState() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDebitTransfer() != null && this.getDebitTransfer().equals(child)) return result;
        if(this.getDebitTransfer() != null) result = result + 1;
        if(this.getMasterCompensation() != null && this.getMasterCompensation().equals(child)) return result;
        if(this.getMasterCompensation() != null) result = result + 1;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
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
