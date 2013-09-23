package model.meta;

public interface DebitTransferNoValueMssgsVisitor extends DebitTransferNoValueDOWNMssgsVisitor, DebitTransferNoValueUPMssgsVisitor {}


interface DebitTransferNoValueDOWNMssgsVisitor extends DebitTransferDOWNMssgsVisitor, NoDebitTransferDOWNMssgsVisitor, DebitTransferTransactionUPMssgsVisitor {

    
}


interface DebitTransferNoValueUPMssgsVisitor  {

    
}
