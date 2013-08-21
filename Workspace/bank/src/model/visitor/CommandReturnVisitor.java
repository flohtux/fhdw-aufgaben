
package model.visitor;

public interface CommandReturnVisitor<R> extends BankCreatorCommandReturnVisitor<R> ,DebitTransferTransactionCommandReturnVisitor<R> ,AccountServiceCommandReturnVisitor<R> ,BankCommandReturnVisitor<R> {
    
    
}
