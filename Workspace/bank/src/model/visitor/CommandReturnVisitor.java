
package model.visitor;

public interface CommandReturnVisitor<R> extends CompensationCommandReturnVisitor<R> ,AccountCommandReturnVisitor<R> ,BankCreatorCommandReturnVisitor<R> ,DebitTransferTransactionCommandReturnVisitor<R> ,AccountServiceCommandReturnVisitor<R> ,BankCommandReturnVisitor<R> {
    
    
}
