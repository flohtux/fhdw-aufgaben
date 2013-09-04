

CREATE TABLE Cls(
    id NUMBER PRIMARY KEY,
    name VARCHAR2(2000) NOT NULL,
    concrete NUMBER NOT NULL
);

CREATE SEQUENCE SSpecialization NOCACHE;
CREATE TABLE Specialization (
    id NUMBER PRIMARY KEY,
    ancestor NUMBER,
    CONSTRAINT FSpecializationAncestor FOREIGN KEY (ancestor) REFERENCES Cls(id),
    descendant NUMBER,
    CONSTRAINT FSpecializationDescendant FOREIGN KEY (descendant) REFERENCES Cls(id)
);

CREATE TABLE Association (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(2000) NOT NULL,
    owner NUMBER NOT NULL,
    CONSTRAINT FAssociationOwner FOREIGN KEY (owner) REFERENCES Cls(id),
    target NUMBER NOT NULL,
    CONSTRAINT FAssociationTarget FOREIGN KEY (target) REFERENCES Cls(id),
    complexity NUMBER NOT NULL 
);

CREATE TABLE Association3 (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(2000) NOT NULL,
    owner NUMBER NOT NULL,
    CONSTRAINT FAssociation3Owner FOREIGN KEY (owner) REFERENCES Cls(id),
    indxx NUMBER NOT NULL,
    CONSTRAINT FAssociation3Key FOREIGN KEY (indxx) REFERENCES Cls(id),
    target NUMBER NOT NULL,
    CONSTRAINT FAssociation3Target FOREIGN KEY (target) REFERENCES Cls(id) 
);

CREATE SEQUENCE SObj NOCACHE;

CREATE TABLE Obj (
	id NUMBER PRIMARY KEY,
	instanceOf NUMBER NOT NULL,
	CONSTRAINT FObjCls FOREIGN KEY (instanceOf) REFERENCES Cls(id)
);
CREATE TABLE DeletedObjects (
	id NUMBER PRIMARY KEY,
	instanceOF NUMBER NOT NULL,
	CONSTRAINT FDltdObjCls FOREIGN KEY (instanceOf) REFERENCES Cls(id),
	CONSTRAINT FDltdObjObj FOREIGN KEY (id) REFERENCES Obj(id)
);

CREATE SEQUENCE SLnk NOCACHE;

CREATE TABLE Lnk (
    id NUMBER PRIMARY KEY,
    owner NUMBER NOT NULL,
    CONSTRAINT FLnkOwner FOREIGN KEY (owner) REFERENCES Obj(id),
    target NUMBER,
    instanceOf NUMBER NOT NULL,
    CONSTRAINT FLnkAssociation FOREIGN KEY (instanceOf) REFERENCES Association(id)
);
CREATE INDEX ILnkOwner ON Lnk (owner);
CREATE INDEX ILnkTarget ON Lnk (target);

CREATE SEQUENCE SLnk3 NOCACHE;

CREATE TABLE Lnk3 (
    id NUMBER PRIMARY KEY,
    owner NUMBER NOT NULL,
    CONSTRAINT FLnk3Owner FOREIGN KEY (owner) REFERENCES Obj(id),
    indxx NUMBER NOT NULL,
    target NUMBER NOT NULL,
    instanceOf NUMBER NOT NULL,
    CONSTRAINT FLnk3Association3 FOREIGN KEY (instanceOf) REFERENCES Association3(id)
);
CREATE INDEX ILnk3OwnerKey ON Lnk3 (owner, indxx);
CREATE INDEX ILnk3Target ON Lnk3 (target);

CREATE TABLE IntegerValue (
    id NUMBER PRIMARY KEY,
    value NUMBER NOT NULL
);
CREATE UNIQUE INDEX IntegerValueUnique ON IntegerValue (value);

CREATE TABLE StringValue (
    id NUMBER PRIMARY KEY,
    value VARCHAR2(2000)
);
CREATE UNIQUE INDEX StringValueUnique ON StringValue (value);

CREATE TABLE DateValue (
    id NUMBER PRIMARY KEY,
    value DATE NOT NULL
);
CREATE UNIQUE INDEX DateValueUnique ON DateValue (value);

CREATE TABLE TimestampValue (
    id NUMBER PRIMARY KEY,
    value TIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX TimestampValueUnique ON TimestampValue (value);

CREATE TABLE TextValue (
    id NUMBER PRIMARY KEY,
    value CLOB 
);

CREATE TABLE FractionValue (
    id NUMBER PRIMARY KEY,
    value VARCHAR2(2000)
);
CREATE UNIQUE INDEX FractionValueUnique ON FractionValue (value);
