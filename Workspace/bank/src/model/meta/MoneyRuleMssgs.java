package model.meta;

public interface MoneyRuleMssgs {
    void accept(MoneyRuleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MoneyRuleDOWNMssgs extends RuleDOWNMssgs, MoneyRuleMssgs{}
interface MoneyRuleUPMssgs extends Mssgs, MoneyRuleMssgs{}
