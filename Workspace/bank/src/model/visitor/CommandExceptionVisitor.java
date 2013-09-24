
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends CompensationCommandExceptionVisitor<E>,AccountCommandExceptionVisitor<E>,BankCreatorCommandExceptionVisitor<E>,DebitTransferTransactionCommandExceptionVisitor<E>,AccountServiceCommandExceptionVisitor<E>,BankCommandExceptionVisitor<E>{
    
    
}
