
package model.visitor;
import model.UserException;
public interface CommandExceptionVisitor<E extends UserException> extends BankCreatorCommandExceptionVisitor<E>,DebitTransferTransactionCommandExceptionVisitor<E>,AccountServiceCommandExceptionVisitor<E>,BankCommandExceptionVisitor<E>,AccountCommandExceptionVisitor<E>{
    
    
}
