
package model.visitor;

public interface CommandVisitor extends CompensationCommandVisitor,AccountCommandVisitor,DebitTransferTransactionCommandVisitor,BankCreatorCommandVisitor,AccountServiceCommandVisitor,BankCommandVisitor{
    
    
}
