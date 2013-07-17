package model.meta;

public interface TrancactionMssgsVisitor extends TrancactionDOWNMssgsVisitor, TrancactionUPMssgsVisitor {}


interface TrancactionDOWNMssgsVisitor  {

    
}


interface TrancactionUPMssgsVisitor extends DebitNoteTransactionUPMssgsVisitor {

    
}
