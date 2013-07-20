package model.meta;

public interface TransferMssgsVisitor extends TransferDOWNMssgsVisitor, TransferUPMssgsVisitor {}


interface TransferDOWNMssgsVisitor  {

    
}


interface TransferUPMssgsVisitor extends DebitNoteTransferUPMssgsVisitor {

    
}
