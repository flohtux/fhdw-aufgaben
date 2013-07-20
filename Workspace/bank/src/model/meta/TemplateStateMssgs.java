package model.meta;

public interface TemplateStateMssgs {
    void accept(TemplateStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TemplateStateDOWNMssgs extends DebitNoteTransferStateDOWNMssgs, TemplateStateMssgs{}
interface TemplateStateUPMssgs extends Mssgs, TemplateStateMssgs{}
