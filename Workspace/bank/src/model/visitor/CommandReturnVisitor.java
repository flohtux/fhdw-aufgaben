
package model.visitor;

public interface CommandReturnVisitor<R> extends CompensationCommandReturnVisitor<R> ,AccountCommandReturnVisitor<R> ,DebitTransferTransactionCommandReturnVisitor<R> ,BankCreatorCommandReturnVisitor<R> ,AccountServiceCommandReturnVisitor<R> ,BankCommandReturnVisitor<R> {
    
    
}
