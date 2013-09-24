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
import viewClient.ExceptionAndEventHandler;

public class CompensationRequestProxi extends ViewProxi implements CompensationRequestView{
    
    public CompensationRequestProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public CompensationRequestView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi debitTransfer = null;
        String debitTransfer$String = (String)resultTable.get("debitTransfer");
        if (debitTransfer$String != null) {
            common.ProxiInformation debitTransfer$Info = common.RPCConstantsAndServices.createProxiInformation(debitTransfer$String);
            debitTransfer = view.objects.ViewProxi.createProxi(debitTransfer$Info,connectionKey);
            debitTransfer.setToString(debitTransfer$Info.getToString());
        }
        ViewProxi masterCompensation = null;
        String masterCompensation$String = (String)resultTable.get("masterCompensation");
        if (masterCompensation$String != null) {
            common.ProxiInformation masterCompensation$Info = common.RPCConstantsAndServices.createProxiInformation(masterCompensation$String);
            masterCompensation = view.objects.ViewProxi.createProxi(masterCompensation$Info,connectionKey);
            masterCompensation.setToString(masterCompensation$Info.getToString());
        }
        ViewProxi state = null;
        String state$String = (String)resultTable.get("state");
        if (state$String != null) {
            common.ProxiInformation state$Info = common.RPCConstantsAndServices.createProxiInformation(state$String);
            state = view.objects.ViewProxi.createProxi(state$Info,connectionKey);
            state.setToString(state$Info.getToString());
        }
        CompensationRequestView result$$ = new CompensationRequest((DebitTransferView)debitTransfer,(CompensationView)masterCompensation,(CompensationRequestStateView)state, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public DebitTransferView getDebitTransfer()throws ModelException{
        return ((CompensationRequest)this.getTheObject()).getDebitTransfer();
    }
    public void setDebitTransfer(DebitTransferView newValue) throws ModelException {
        ((CompensationRequest)this.getTheObject()).setDebitTransfer(newValue);
    }
    public CompensationView getMasterCompensation()throws ModelException{
        return ((CompensationRequest)this.getTheObject()).getMasterCompensation();
    }
    public void setMasterCompensation(CompensationView newValue) throws ModelException {
        ((CompensationRequest)this.getTheObject()).setMasterCompensation(newValue);
    }
    public CompensationRequestStateView getState()throws ModelException{
        return ((CompensationRequest)this.getTheObject()).getState();
    }
    public void setState(CompensationRequestStateView newValue) throws ModelException {
        ((CompensationRequest)this.getTheObject()).setState(newValue);
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
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
