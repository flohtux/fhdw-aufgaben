package model.meta;

public interface NoTriggerMssgs {
    void accept(NoTriggerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoTriggerDOWNMssgs extends TriggerValueDOWNMssgs, NoTriggerMssgs{}
interface NoTriggerUPMssgs extends Mssgs, NoTriggerMssgs{}
