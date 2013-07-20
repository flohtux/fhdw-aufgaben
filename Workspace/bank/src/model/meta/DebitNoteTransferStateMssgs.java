package model.meta;

public interface DebitNoteTransferStateMssgs {
    void accept(DebitNoteTransferStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitNoteTransferStateDOWNMssgs extends Mssgs, DebitNoteTransferStateMssgs{}
interface DebitNoteTransferStateUPMssgs extends TemplateStateUPMssgs, NotExecutetStateUPMssgs, ExecutedStateUPMssgs, NotSuccessfullStateUPMssgs, NotExecutableStateUPMssgs, SuccessfullStateUPMssgs, DebitNoteTransferStateMssgs{}
