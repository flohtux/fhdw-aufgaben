package model.meta;

public interface DebitNoteTransferMssgsVisitor extends DebitNoteTransferDOWNMssgsVisitor, DebitNoteTransferUPMssgsVisitor {}


interface DebitNoteTransferDOWNMssgsVisitor extends DebitNoteDOWNMssgsVisitor, TransferDOWNMssgsVisitor {

    
}


interface DebitNoteTransferUPMssgsVisitor extends DebitNoteTransferTransactionUPMssgsVisitor {

    
}
