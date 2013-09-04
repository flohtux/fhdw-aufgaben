package model.meta;

public interface RuleMssgs {
    void accept(RuleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface RuleDOWNMssgs extends Mssgs, RuleMssgs{}
interface RuleUPMssgs extends IncomingAccountRuleUPMssgs, SubjectRuleUPMssgs, MoneyRuleUPMssgs, RuleMssgs{}
