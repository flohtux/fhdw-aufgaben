package model.meta;

public interface DisabledStateMssgs {
    void accept(DisabledStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DisabledStateDOWNMssgs extends TriggerStateDOWNMssgs, DisabledStateMssgs{}
interface DisabledStateUPMssgs extends Mssgs, DisabledStateMssgs{}
