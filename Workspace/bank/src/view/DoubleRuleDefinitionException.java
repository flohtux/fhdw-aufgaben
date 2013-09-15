
package view;


import view.visitor.UserExceptionExceptionVisitor;
import view.visitor.UserExceptionReturnExceptionVisitor;
import view.visitor.UserExceptionReturnVisitor;
import view.visitor.UserExceptionVisitor;
import viewClient.ExceptionAndEventHandler;


/* Additional import section end */

@SuppressWarnings("serial")
public class DoubleRuleDefinitionException extends view.UserException{
    
    public static DoubleRuleDefinitionException fromHashtableToDoubleRuleDefinitionException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new DoubleRuleDefinitionException(message);
    }
    
    public DoubleRuleDefinitionException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleDoubleRuleDefinitionException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDoubleRuleDefinitionException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDoubleRuleDefinitionException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDoubleRuleDefinitionException(this);
    }
    
    
}
