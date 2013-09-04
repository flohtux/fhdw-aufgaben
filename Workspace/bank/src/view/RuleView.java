package view;

import view.objects.*;

import view.visitor.*;

public interface RuleView extends Anything, AbstractViewRoot {
    
    
    public void accept(RuleVisitor visitor) throws ModelException;
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

