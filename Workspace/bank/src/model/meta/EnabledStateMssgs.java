package model.meta;

public interface EnabledStateMssgs {
    void accept(EnabledStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface EnabledStateDOWNMssgs extends TriggerStateDOWNMssgs, EnabledStateMssgs{}
interface EnabledStateUPMssgs extends Mssgs, EnabledStateMssgs{}
