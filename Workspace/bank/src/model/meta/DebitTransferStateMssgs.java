package model.meta;

public interface DebitTransferStateMssgs {
    void accept(DebitTransferStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferStateDOWNMssgs extends Mssgs, DebitTransferStateMssgs{}
interface DebitTransferStateUPMssgs extends TemplateStateUPMssgs, NotExecutetStateUPMssgs, ExecutedStateUPMssgs, NotExecutableStateUPMssgs, NotSuccessfulStateUPMssgs, SuccessfulStateUPMssgs, DebitTransferStateMssgs{}
