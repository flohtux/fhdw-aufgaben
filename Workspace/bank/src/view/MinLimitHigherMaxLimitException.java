
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class MinLimitHigherMaxLimitException extends view.UserException{
    
    public static MinLimitHigherMaxLimitException fromHashtableToMinLimitHigherMaxLimitException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new MinLimitHigherMaxLimitException(message);
    }
    
    public MinLimitHigherMaxLimitException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleMinLimitHigherMaxLimitException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMinLimitHigherMaxLimitException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMinLimitHigherMaxLimitException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMinLimitHigherMaxLimitException(this);
    }
    
    
}
