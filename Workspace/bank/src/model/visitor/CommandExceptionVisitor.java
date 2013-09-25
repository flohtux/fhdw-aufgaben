
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends CompensationCommandExceptionVisitor<E>,AccountCommandExceptionVisitor<E>,DebitTransferTransactionCommandExceptionVisitor<E>,BankCreatorCommandExceptionVisitor<E>,AccountServiceCommandExceptionVisitor<E>,BankCommandExceptionVisitor<E>{
    
    
}
