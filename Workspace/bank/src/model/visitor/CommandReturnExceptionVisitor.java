
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends BankCreatorCommandReturnExceptionVisitor<R, E> ,DebitTransferTransactionCommandReturnExceptionVisitor<R, E> ,AccountServiceCommandReturnExceptionVisitor<R, E> ,BankCommandReturnExceptionVisitor<R, E> ,AccountCommandReturnExceptionVisitor<R, E> {
    
    
}
