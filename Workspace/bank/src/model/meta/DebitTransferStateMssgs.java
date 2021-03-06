package model.meta;

public interface DebitTransferStateMssgs {
    void accept(DebitTransferStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferStateDOWNMssgs extends Mssgs, DebitTransferStateMssgs{}
interface DebitTransferStateUPMssgs extends ExecutedStateUPMssgs, NotSuccessfulStateUPMssgs, SuccessfulStateUPMssgs, CompensationRequestedStateUPMssgs, CompensatedStateUPMssgs, NotExecutedStateUPMssgs, TemplateStateUPMssgs, NotExecutableStateUPMssgs, DebitTransferStateMssgs{}
