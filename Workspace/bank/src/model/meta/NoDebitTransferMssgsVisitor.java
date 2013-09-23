package model.meta;

public interface NoDebitTransferMssgsVisitor extends NoDebitTransferDOWNMssgsVisitor, NoDebitTransferUPMssgsVisitor {}


interface NoDebitTransferDOWNMssgsVisitor  {

    
}


interface NoDebitTransferUPMssgsVisitor extends DebitTransferNoValueUPMssgsVisitor {

    
}
