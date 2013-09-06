package model.meta;

public interface RuleSwitchPARAMETER{
    persistence.PersistentSubjectRule handleSubjectRule() throws persistence.PersistenceException;
    persistence.PersistentMoneyRule handleMoneyRule() throws persistence.PersistenceException;
    persistence.PersistentIncomingAccountRule handleIncomingAccountRule() throws persistence.PersistenceException;
}
