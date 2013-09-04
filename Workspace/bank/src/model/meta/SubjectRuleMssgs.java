package model.meta;

public interface SubjectRuleMssgs {
    void accept(SubjectRuleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SubjectRuleDOWNMssgs extends RuleDOWNMssgs, SubjectRuleMssgs{}
interface SubjectRuleUPMssgs extends Mssgs, SubjectRuleMssgs{}
