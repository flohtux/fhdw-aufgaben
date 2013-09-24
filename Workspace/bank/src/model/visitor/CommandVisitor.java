
package model.visitor;

public interface CommandVisitor extends CompensationCommandVisitor,AccountCommandVisitor,BankCreatorCommandVisitor,DebitTransferTransactionCommandVisitor,AccountServiceCommandVisitor,BankCommandVisitor{
    
    
}
