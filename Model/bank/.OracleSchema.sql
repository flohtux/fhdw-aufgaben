create table Cls(
    id number primary key,
    name varchar2(2000) not null,
    concrete number not null
);

create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id)
);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);

create sequence SSpecialization nocache;

create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id),
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id)
);

create table Association (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociationOwner foreign key (owner) references Cls(id),
    target number,
    constraint FAssociationTarget foreign key (target) references Cls(id),
    complexity number
);

create table Association3 (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociation3Owner foreign key (owner) references Cls(id),
    indxx number,
    constraint FAssociation3Indxx foreign key (indxx) references Cls(id),
    target number,
    constraint FAssociation3Target foreign key (target) references Cls(id)
);

create sequence SSrvc nocache;

create table Srvc(
    id number primary key,
    Cls number not null,
    SrvcSbSrvc number,
    SrvcSbSrvcCls number,
    constraint FSrvcSbSrvc foreign key (SrvcSbSrvcCls) references Cls (id),
    SrvcThis number,
    SrvcThisCls number,
    constraint FSrvcThis foreign key (SrvcThisCls) references Cls (id),
    AccntSrvcAccnt number,
    AccntSrvcAccntCls number,
    constraint FAccntSrvcAccnt foreign key (AccntSrvcAccntCls) references Cls (id),
    AdmnstrtrBnks number,
    AdmnstrtrBnksCls number,
    constraint FAdmnstrtrBnks foreign key (AdmnstrtrBnksCls) references Cls (id),
    BnkSrvcBnk number,
    BnkSrvcBnkCls number,
    constraint FBnkSrvcBnk foreign key (BnkSrvcBnkCls) references Cls (id)    
);
create index IAccntAccntSrvc on Srvc (AccntSrvcAccnt, AccntSrvcAccntCls);
create index IBnkBnkSrvc on Srvc (BnkSrvcBnk, BnkSrvcBnkCls);


create sequence SSubj nocache;

create table Subj(
    id number primary key,
    Cls number not null,
    SubjThis number,
    SubjThisCls number,
    constraint FSubjThis foreign key (SubjThisCls) references Cls (id)    
);

create sequence SChngNmCMD nocache;

create table ChngNmCMD(
    id number primary key,
    Cls number not null,
    ChngNmCMDNm varchar2(2000),
    ChngNmCMDInvoker number,
    ChngNmCMDInvokerCls number,
    constraint FChngNmCMDInvoker foreign key (ChngNmCMDInvokerCls) references Cls (id),
    ChngNmCMDCReceiver number,
    ChngNmCMDCReceiverCls number,
    constraint FChngNmCMDCReceiver foreign key (ChngNmCMDCReceiverCls) references Cls (id),
    ChngNmCMDMyCmmnDt number,
    ChngNmCMDMyCmmnDtCls number,
    constraint FChngNmCMDMyCmmnDt foreign key (ChngNmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SStrnStt nocache;

create table StrnStt(
    id number primary key,
    Cls number not null,
    StrnSttSbSrvc number,
    StrnSttSbSrvcCls number,
    constraint FStrnSttSbSrvc foreign key (StrnSttSbSrvcCls) references Cls (id),
    StrnSttThis number,
    StrnSttThisCls number,
    constraint FStrnSttThis foreign key (StrnSttThisCls) references Cls (id)    
);

create sequence SCrtAccntCMD nocache;

create table CrtAccntCMD(
    id number primary key,
    Cls number not null,
    CrtAccntCMDCrrncTp varchar2(2000),
    CrtAccntCMDInvoker number,
    CrtAccntCMDInvokerCls number,
    constraint FCrtAccntCMDInvoker foreign key (CrtAccntCMDInvokerCls) references Cls (id),
    CrtAccntCMDCReceiver number,
    CrtAccntCMDCReceiverCls number,
    constraint FCrtAccntCMDCReceiver foreign key (CrtAccntCMDCReceiverCls) references Cls (id),
    CrtAccntCMDMyCmmnDt number,
    CrtAccntCMDMyCmmnDtCls number,
    constraint FCrtAccntCMDMyCmmnDt foreign key (CrtAccntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SIntrnlF nocache;

create table IntrnlF(
    id number primary key,
    Cls number not null,
    IntrnlFPrcnt number,
    IntrnlFPrcntCls number,
    constraint FIntrnlFPrcnt foreign key (IntrnlFPrcntCls) references Cls (id),
    IntrnlFSbSrvc number,
    IntrnlFSbSrvcCls number,
    constraint FIntrnlFSbSrvc foreign key (IntrnlFSbSrvcCls) references Cls (id),
    IntrnlFThis number,
    IntrnlFThisCls number,
    constraint FIntrnlFThis foreign key (IntrnlFThisCls) references Cls (id)    
);

create sequence SBlnVl nocache;

create table BlnVl(
    id number primary key,
    Cls number not null,
    BlnVlSbSrvc number,
    BlnVlSbSrvcCls number,
    constraint FBlnVlSbSrvc foreign key (BlnVlSbSrvcCls) references Cls (id),
    BlnVlThis number,
    BlnVlThisCls number,
    constraint FBlnVlThis foreign key (BlnVlThisCls) references Cls (id)    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SPrcnt nocache;

create table Prcnt(
    id number primary key,
    Cls number not null,
    PrcntVl varchar2(2000),
    PrcntSbSrvc number,
    PrcntSbSrvcCls number,
    constraint FPrcntSbSrvc foreign key (PrcntSbSrvcCls) references Cls (id),
    PrcntThis number,
    PrcntThisCls number,
    constraint FPrcntThis foreign key (PrcntThisCls) references Cls (id)    
);

create sequence SCrrnc nocache;

create table Crrnc(
    id number primary key,
    Cls number not null,
    CrrncSbSrvc number,
    CrrncSbSrvcCls number,
    constraint FCrrncSbSrvc foreign key (CrrncSbSrvcCls) references Cls (id),
    CrrncThis number,
    CrrncThisCls number,
    constraint FCrrncThis foreign key (CrrncThisCls) references Cls (id)    
);

create sequence SAmnt nocache;

create table Amnt(
    id number primary key,
    Cls number not null,
    AmntBlnc varchar2(2000),
    AmntSbSrvc number,
    AmntSbSrvcCls number,
    constraint FAmntSbSrvc foreign key (AmntSbSrvcCls) references Cls (id),
    AmntThis number,
    AmntThisCls number,
    constraint FAmntThis foreign key (AmntThisCls) references Cls (id)    
);

create sequence SCrtBnkCMD nocache;

create table CrtBnkCMD(
    id number primary key,
    Cls number not null,
    CrtBnkCMDNm varchar2(2000),
    CrtBnkCMDInvoker number,
    CrtBnkCMDInvokerCls number,
    constraint FCrtBnkCMDInvoker foreign key (CrtBnkCMDInvokerCls) references Cls (id),
    CrtBnkCMDCReceiver number,
    CrtBnkCMDCReceiverCls number,
    constraint FCrtBnkCMDCReceiver foreign key (CrtBnkCMDCReceiverCls) references Cls (id),
    CrtBnkCMDCResult number,
    CrtBnkCMDCResultCls number,
    constraint FCrtBnkCMDCResult foreign key (CrtBnkCMDCResultCls) references Cls (id),
    CrtBnkCMDMyCmmnDt number,
    CrtBnkCMDMyCmmnDtCls number,
    constraint FCrtBnkCMDMyCmmnDt foreign key (CrtBnkCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SSrvr nocache;

create table Srvr(
    id number primary key,
    Cls number not null,
    SrvrSrvc number,
    SrvrSrvcCls number,
    constraint FSrvrSrvc foreign key (SrvrSrvcCls) references Cls (id),
    SrvrSbSrvc number,
    SrvrSbSrvcCls number,
    constraint FSrvrSbSrvc foreign key (SrvrSbSrvcCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index ISrvcSrvr on Srvr (SrvrSrvc, SrvrSrvcCls);
create index IUserSrvr on Srvr (SrvrUser);


create sequence SAdmnstrtrBnks nocache;

create table AdmnstrtrBnks(
    id number primary key,
    Cls number not null,
    AdmnstrtrBnksMstr number,
    AdmnstrtrBnksMstrCls number,
    constraint FAdmnstrtrBnksMstr foreign key (AdmnstrtrBnksMstrCls) references Cls (id),
    AdmnstrtrBnksThis number,
    AdmnstrtrBnksThisCls number,
    constraint FAdmnstrtrBnksThis foreign key (AdmnstrtrBnksThisCls) references Cls (id)    
);

create sequence SLmtAccnt nocache;

create table LmtAccnt(
    id number primary key,
    Cls number not null,
    LmtAccntMnLmt number,
    LmtAccntMnLmtCls number,
    constraint FLmtAccntMnLmt foreign key (LmtAccntMnLmtCls) references Cls (id),
    LmtAccntMxLmt number,
    LmtAccntMxLmtCls number,
    constraint FLmtAccntMxLmt foreign key (LmtAccntMxLmtCls) references Cls (id),
    LmtAccntSbSrvc number,
    LmtAccntSbSrvcCls number,
    constraint FLmtAccntSbSrvc foreign key (LmtAccntSbSrvcCls) references Cls (id),
    LmtAccntThis number,
    LmtAccntThisCls number,
    constraint FLmtAccntThis foreign key (LmtAccntThisCls) references Cls (id)    
);

create sequence STrnsctnF nocache;

create table TrnsctnF(
    id number primary key,
    Cls number not null,
    TrnsctnFSbSrvc number,
    TrnsctnFSbSrvcCls number,
    constraint FTrnsctnFSbSrvc foreign key (TrnsctnFSbSrvcCls) references Cls (id),
    TrnsctnFThis number,
    TrnsctnFThisCls number,
    constraint FTrnsctnFThis foreign key (TrnsctnFThisCls) references Cls (id),
    MxdFFx number,
    MxdFFxCls number,
    constraint FMxdFFx foreign key (MxdFFxCls) references Cls (id),
    MxdFPrcntl number,
    MxdFPrcntlCls number,
    constraint FMxdFPrcntl foreign key (MxdFPrcntlCls) references Cls (id),
    MxdFLmt number,
    FxTrnsctnFVl number,
    FxTrnsctnFVlCls number,
    constraint FFxTrnsctnFVl foreign key (FxTrnsctnFVlCls) references Cls (id),
    PrcntlFPrcnt number,
    PrcntlFPrcntCls number,
    constraint FPrcntlFPrcnt foreign key (PrcntlFPrcntCls) references Cls (id)    
);

create sequence SAccnt nocache;

create table Accnt(
    id number primary key,
    Cls number not null,
    AccntAccntNmbr number,
    AccntMn number,
    AccntMnCls number,
    constraint FAccntMn foreign key (AccntMnCls) references Cls (id),
    AccntLmt number,
    AccntLmtCls number,
    constraint FAccntLmt foreign key (AccntLmtCls) references Cls (id),
    AccntSbSrvc number,
    AccntSbSrvcCls number,
    constraint FAccntSbSrvc foreign key (AccntSbSrvcCls) references Cls (id),
    AccntThis number,
    AccntThisCls number,
    constraint FAccntThis foreign key (AccntThisCls) references Cls (id)    
);
create index IMnAccnt on Accnt (AccntMn, AccntMnCls);
create index ILmtAccnt on Accnt (AccntLmt, AccntLmtCls);


create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
);

create sequence SLmtTp nocache;

create table LmtTp(
    id number primary key,
    Cls number not null,
    LmtTpSbSrvc number,
    LmtTpSbSrvcCls number,
    constraint FLmtTpSbSrvc foreign key (LmtTpSbSrvcCls) references Cls (id),
    LmtTpThis number,
    LmtTpThisCls number,
    constraint FLmtTpThis foreign key (LmtTpThisCls) references Cls (id),
    LmtMn number,
    LmtMnCls number,
    constraint FLmtMn foreign key (LmtMnCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SDebiTrfTran nocache;

create table DebiTrfTran(
    id number primary key,
    Cls number not null,
    DebiTrfTranSbSrvc number,
    DebiTrfTranSbSrvcCls number,
    constraint FDebiTrfTranSbSrvc foreign key (DebiTrfTranSbSrvcCls) references Cls (id),
    DebiTrfTranThis number,
    DebiTrfTranThisCls number,
    constraint FDebiTrfTranThis foreign key (DebiTrfTranThisCls) references Cls (id),
    DbtNtTrnsfrRecaccno number,
    DbtNtTrnsfrRcvrBnkNmbr number,
    DbtNtTrnsfrSndr number,
    DbtNtTrnsfrSndrCls number,
    constraint FDbtNtTrnsfrSndr foreign key (DbtNtTrnsfrSndrCls) references Cls (id),
    DbtNtTrnsfrMn number,
    DbtNtTrnsfrMnCls number,
    constraint FDbtNtTrnsfrMn foreign key (DbtNtTrnsfrMnCls) references Cls (id),
    DbtNtTrnsfrStt number,
    DbtNtTrnsfrSttCls number,
    constraint FDbtNtTrnsfrStt foreign key (DbtNtTrnsfrSttCls) references Cls (id),
    DbtNtTrnsfrStrnStt number,
    DbtNtTrnsfrStrnSttCls number,
    constraint FDbtNtTrnsfrStrnStt foreign key (DbtNtTrnsfrStrnSttCls) references Cls (id)    
);
create index ISttDbtNtTrnsfr on DebiTrfTran (DbtNtTrnsfrStt, DbtNtTrnsfrSttCls);
create index IStrnSttDbtNtTrnsfr on DebiTrfTran (DbtNtTrnsfrStrnStt, DbtNtTrnsfrStrnSttCls);


create sequence SMn nocache;

create table Mn(
    id number primary key,
    Cls number not null,
    MnAmnt number,
    MnAmntCls number,
    constraint FMnAmnt foreign key (MnAmntCls) references Cls (id),
    MnCrrnc number,
    MnCrrncCls number,
    constraint FMnCrrnc foreign key (MnCrrncCls) references Cls (id),
    MnSbSrvc number,
    MnSbSrvcCls number,
    constraint FMnSbSrvc foreign key (MnSbSrvcCls) references Cls (id),
    MnThis number,
    MnThisCls number,
    constraint FMnThis foreign key (MnThisCls) references Cls (id)    
);

create sequence SBnk nocache;

create table Bnk(
    id number primary key,
    Cls number not null,
    BnkBnkNmbr number,
    BnkNm varchar2(2000),
    BnkLstAccNo number,
    BnkFee number,
    BnkFeeCls number,
    constraint FBnkFee foreign key (BnkFeeCls) references Cls (id),
    BnkIntrnlF number,
    BnkIntrnlFCls number,
    constraint FBnkIntrnlF foreign key (BnkIntrnlFCls) references Cls (id),
    BnkOwnAccnt number,
    BnkOwnAccntCls number,
    constraint FBnkOwnAccnt foreign key (BnkOwnAccntCls) references Cls (id),
    BnkAdmnstrtr number,
    BnkAdmnstrtrCls number,
    constraint FBnkAdmnstrtr foreign key (BnkAdmnstrtrCls) references Cls (id),
    BnkSbSrvc number,
    BnkSbSrvcCls number,
    constraint FBnkSbSrvc foreign key (BnkSbSrvcCls) references Cls (id),
    BnkThis number,
    BnkThisCls number,
    constraint FBnkThis foreign key (BnkThisCls) references Cls (id)    
);
create index IBnkNmbrBnk on Bnk (BnkBnkNmbr);
create index INmBnk on Bnk (BnkNm);
create index IAdmnstrtrBnk on Bnk (BnkAdmnstrtr, BnkAdmnstrtrCls);


create sequence SDebiTraStat nocache;

create table DebiTraStat(
    id number primary key,
    Cls number not null,
    DebiTraStatSbSrvc number,
    DebiTraStatSbSrvcCls number,
    constraint FDebiTraStatSbSrvc foreign key (DebiTraStatSbSrvcCls) references Cls (id),
    DebiTraStatThis number,
    DebiTraStatThisCls number,
    constraint FDebiTraStatThis foreign key (DebiTraStatThisCls) references Cls (id)    
);

create sequence SBnkCrtr nocache;

create table BnkCrtr(
    id number primary key,
    Cls number not null,
    BnkCrtrLstBnkNmbr number,
    BnkCrtrSbSrvc number,
    BnkCrtrSbSrvcCls number,
    constraint FBnkCrtrSbSrvc foreign key (BnkCrtrSbSrvcCls) references Cls (id),
    BnkCrtrThis number,
    BnkCrtrThisCls number,
    constraint FBnkCrtrThis foreign key (BnkCrtrThisCls) references Cls (id)    
);

create sequence SSubjObs nocache;

create table SubjObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FSubjObsCls foreign key(Cls) references Cls(id),
    constraint FSubjObsfrm foreign key(frm) references Subj(id)
);
create index IFrmSubjObs on SubjObs(frm);

create sequence SAdmnstrtrBnksObs nocache;

create table AdmnstrtrBnksObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FAdmnstrtrBnksObsCls foreign key(Cls) references Cls(id),
    constraint FAdmnstrtrBnksObsfrm foreign key(frm) references AdmnstrtrBnks(id)
);
create index IFrmAdmnstrtrBnksObs on AdmnstrtrBnksObs(frm);

create sequence SAccntDebTrfTrans nocache;

create table AccntDebTrfTrans(
    id number primary key,
    frm number not null,
    DebTrfTrans number not null,
    Cls number not null,
    constraint FAccntDebTrfTransCls foreign key(Cls) references Cls(id),
    constraint FAccntDebTrfTransfrm foreign key(frm) references Accnt(id)
);
create index IFrmAccntDebTrfTrans on AccntDebTrfTrans(frm);

create sequence SCmmndCrdntrExctr nocache;

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id),
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create sequence SCmmndExctrCommands nocache;

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id),
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create sequence SBnkAccnts nocache;

create table BnkAccnts(
    id number primary key,
    frm number not null,
    BnkAccntsindxx number not null,
    accnts number not null,
    Cls number not null,
    constraint FBnkAccntsCls foreign key(Cls) references Cls(id),
    constraint FBnkAccntsfrm foreign key(frm) references Bnk(id)
);
create index IFrmBnkAccnts on BnkAccnts(frm);
create index IIndxxBnkAccnts on BnkAccnts(BnkAccntsindxx);


create index IAccntsBnkAccnts on BnkAccnts(accnts);
