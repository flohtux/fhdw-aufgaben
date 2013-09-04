package model.meta;

public interface IncomingAccountRuleMssgs {
    void accept(IncomingAccountRuleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface IncomingAccountRuleDOWNMssgs extends RuleDOWNMssgs, IncomingAccountRuleMssgs{}
interface IncomingAccountRuleUPMssgs extends Mssgs, IncomingAccountRuleMssgs{}
