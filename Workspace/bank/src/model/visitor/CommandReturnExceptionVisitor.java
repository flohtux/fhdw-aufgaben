
package model.visitor;
import model.UserException;
public interface CommandReturnExceptionVisitor<R, E extends UserException> extends CompensationCommandReturnExceptionVisitor<R, E> ,AccountCommandReturnExceptionVisitor<R, E> ,DebitTransferTransactionCommandReturnExceptionVisitor<R, E> ,BankCreatorCommandReturnExceptionVisitor<R, E> ,AccountServiceCommandReturnExceptionVisitor<R, E> ,BankCommandReturnExceptionVisitor<R, E> {
    
    
}
