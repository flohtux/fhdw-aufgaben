drop sequence SSpecialization;
create sequence SSpecialization nocache;

drop table Specialization cascade constraints;
create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id),
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id)
);




alter table DebiTrfTran  add (DebiTrfTranSbjct varchar2(2000));
insert into Association(id, name, owner, target, complexity) values (10309, 'DebiTrfTranSbjct', 147, 2, 0);
















































