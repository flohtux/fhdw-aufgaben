package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

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
        ViewProxi hasToAnswer = null;
        String hasToAnswer$String = (String)resultTable.get("hasToAnswer");
        if (hasToAnswer$String != null) {
            common.ProxiInformation hasToAnswer$Info = common.RPCConstantsAndServices.createProxiInformation(hasToAnswer$String);
            hasToAnswer = view.objects.ViewProxi.createProxi(hasToAnswer$Info,connectionKey);
            hasToAnswer.setToString(hasToAnswer$Info.getToString());
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
        CompensationRequestView result$$ = new CompensationRequest((DebitTransferView)debitTransfer,(AccountView)hasToAnswer,(CompensationView)masterCompensation,(CompensationRequestStateView)state, this.getId(), this.getClassId());
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
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitTransfer() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getDebitTransfer() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDebitTransfer() != null && this.getDebitTransfer().equals(child)) return result;
        if(this.getDebitTransfer() != null) result = result + 1;
        return -1;
    }
    
    public DebitTransferView getDebitTransfer()throws ModelException{
        return ((CompensationRequest)this.getTheObject()).getDebitTransfer();
    }
    public void setDebitTransfer(DebitTransferView newValue) throws ModelException {
        ((CompensationRequest)this.getTheObject()).setDebitTransfer(newValue);
    }
    public AccountView getHasToAnswer()throws ModelException{
        return ((CompensationRequest)this.getTheObject()).getHasToAnswer();
    }
    public void setHasToAnswer(AccountView newValue) throws ModelException {
        ((CompensationRequest)this.getTheObject()).setHasToAnswer(newValue);
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
