
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends PartsListManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
