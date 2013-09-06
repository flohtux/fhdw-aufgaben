package model.meta;

public interface TriggerStateMssgs {
    void accept(TriggerStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TriggerStateDOWNMssgs extends Mssgs, TriggerStateMssgs{}
interface TriggerStateUPMssgs extends DisabledStateUPMssgs, EnabledStateUPMssgs, TriggerStateMssgs{}
