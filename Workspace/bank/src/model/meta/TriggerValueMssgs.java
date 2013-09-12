package model.meta;

public interface TriggerValueMssgs {
    void accept(TriggerValueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TriggerValueDOWNMssgs extends Mssgs, TriggerValueMssgs{}
interface TriggerValueUPMssgs extends NoTriggerUPMssgs, TriggerUPMssgs, TriggerValueMssgs{}
