package model.meta;

public interface DebitNoteMssgsVisitor extends DebitNoteDOWNMssgsVisitor, DebitNoteUPMssgsVisitor {}


interface DebitNoteDOWNMssgsVisitor  {

    
}


interface DebitNoteUPMssgsVisitor extends DebitNoteTransactionUPMssgsVisitor {

    
}
