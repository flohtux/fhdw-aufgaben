package model.meta;

public interface DebitTransferMssgsVisitor extends DebitTransferDOWNMssgsVisitor, DebitTransferUPMssgsVisitor {}


interface DebitTransferDOWNMssgsVisitor extends TransferDOWNMssgsVisitor, DebitDOWNMssgsVisitor {

    
}


interface DebitTransferUPMssgsVisitor extends DebitTransferTransactionUPMssgsVisitor {

    
}
