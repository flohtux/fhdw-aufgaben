package view;

import view.visitor.*;

public interface TriggerView extends TriggerValueView {
    
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    public TriggerStateView getState()throws ModelException;
    public void setState(TriggerStateView newValue) throws ModelException ;
    public DebitTransferTransactionView getAction()throws ModelException;
    public void setAction(DebitTransferTransactionView newValue) throws ModelException ;
    public java.util.Vector<RuleView> getRules()throws ModelException;
    public void setRules(java.util.Vector<RuleView> newValue) throws ModelException ;
    
    public void accept(TriggerValueVisitor visitor) throws ModelException;
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

