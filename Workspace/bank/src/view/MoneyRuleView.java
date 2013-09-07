package view;

import view.visitor.*;

public interface MoneyRuleView extends RuleView {
    
    public CurrencyView getCurrency()throws ModelException;
    public void setCurrency(CurrencyView newValue) throws ModelException ;
    public LimitAccountView getLimitAccount()throws ModelException;
    public void setLimitAccount(LimitAccountView newValue) throws ModelException ;
    
    public void accept(RuleVisitor visitor) throws ModelException;
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

