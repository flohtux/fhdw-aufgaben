package model.meta;

public interface TriggerMssgs {
    void accept(TriggerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TriggerDOWNMssgs extends TriggerValueDOWNMssgs, TriggerMssgs{}
interface TriggerUPMssgs extends Mssgs, TriggerMssgs{}
