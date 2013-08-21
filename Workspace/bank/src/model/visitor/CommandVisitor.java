
package model.visitor;

public interface CommandVisitor extends BankCreatorCommandVisitor,DebitTransferTransactionCommandVisitor,AccountServiceCommandVisitor,BankCommandVisitor{
    
    
}
