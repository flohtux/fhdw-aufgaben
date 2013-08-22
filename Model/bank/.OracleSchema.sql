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
    AdmnstrtrCrrncMngr number,
    AdmnstrtrCrrncMngrCls number,
    constraint FAdmnstrtrCrrncMngr foreign key (AdmnstrtrCrrncMngrCls) references Cls (id),
    AdmnstrtrBnks number,
    AdmnstrtrBnksCls number,
    constraint FAdmnstrtrBnks foreign key (AdmnstrtrBnksCls) references Cls (id),
    BnkSrvcBnk number,
    BnkSrvcBnkCls number,
    constraint FBnkSrvcBnk foreign key (BnkSrvcBnkCls) references Cls (id),
    AccntSrvcAccnt number,
    AccntSrvcAccntCls number,
    constraint FAccntSrvcAccnt foreign key (AccntSrvcAccntCls) references Cls (id),
    AccntSrvcSccssfl number,
    AccntSrvcSccssflCls number,
    constraint FAccntSrvcSccssfl foreign key (AccntSrvcSccssflCls) references Cls (id),
    AccntSrvcNtExctd number,
    AccntSrvcNtExctdCls number,
    constraint FAccntSrvcNtExctd foreign key (AccntSrvcNtExctdCls) references Cls (id)    
);
create index IBnkBnkSrvc on Srvc (BnkSrvcBnk, BnkSrvcBnkCls);
create index IAccntAccntSrvc on Srvc (AccntSrvcAccnt, AccntSrvcAccntCls);


create sequence SAccntRcvdGrnt nocache;

create table AccntRcvdGrnt(
    id number primary key,
    Cls number not null,
    AccntRcvdGrntMstr number,
    AccntRcvdGrntMstrCls number,
    constraint FAccntRcvdGrntMstr foreign key (AccntRcvdGrntMstrCls) references Cls (id),
    AccntRcvdGrntObs number,
    AccntRcvdGrntObsCls number,
    constraint FAccntRcvdGrntObs foreign key (AccntRcvdGrntObsCls) references Cls (id),
    AccntRcvdGrntThis number,
    AccntRcvdGrntThisCls number,
    constraint FAccntRcvdGrntThis foreign key (AccntRcvdGrntThisCls) references Cls (id)    
);

create sequence SSubj nocache;

create table Subj(
    id number primary key,
    Cls number not null,
    SubjThis number,
    SubjThisCls number,
    constraint FSubjThis foreign key (SubjThisCls) references Cls (id)    
);

create sequence SDebiTrfTran nocache;

create table DebiTrfTran(
    id number primary key,
    Cls number not null,
    DebiTrfTranTmstmp Timestamp,
    DebiTrfTranSbSrvc number,
    DebiTrfTranSbSrvcCls number,
    constraint FDebiTrfTranSbSrvc foreign key (DebiTrfTranSbSrvcCls) references Cls (id),
    DebiTrfTranThis number,
    DebiTrfTranThisCls number,
    constraint FDebiTrfTranThis foreign key (DebiTrfTranThisCls) references Cls (id),
    DbtTrnsfrRecaccno number,
    DbtTrnsfrRcvrBnkNmbr number,
    DbtTrnsfrSndr number,
    DbtTrnsfrSndrCls number,
    constraint FDbtTrnsfrSndr foreign key (DbtTrnsfrSndrCls) references Cls (id),
    DbtTrnsfrMn number,
    DbtTrnsfrMnCls number,
    constraint FDbtTrnsfrMn foreign key (DbtTrnsfrMnCls) references Cls (id),
    DbtTrnsfrSbjct varchar2(2000),
    DbtTrnsfrStt number,
    DbtTrnsfrSttCls number,
    constraint FDbtTrnsfrStt foreign key (DbtTrnsfrSttCls) references Cls (id),
    DbtTrnsfrStrnStt number,
    DbtTrnsfrStrnSttCls number,
    constraint FDbtTrnsfrStrnStt foreign key (DbtTrnsfrStrnSttCls) references Cls (id)    
);
create index ISttDbtTrnsfr on DebiTrfTran (DbtTrnsfrStt, DbtTrnsfrSttCls);
create index IStrnSttDbtTrnsfr on DebiTrfTran (DbtTrnsfrStrnStt, DbtTrnsfrStrnSttCls);


create sequence SAccntGrntdGrnt nocache;

create table AccntGrntdGrnt(
    id number primary key,
    Cls number not null,
    AccntGrntdGrntMstr number,
    AccntGrntdGrntMstrCls number,
    constraint FAccntGrntdGrntMstr foreign key (AccntGrntdGrntMstrCls) references Cls (id),
    AccntGrntdGrntObs number,
    AccntGrntdGrntObsCls number,
    constraint FAccntGrntdGrntObs foreign key (AccntGrntdGrntObsCls) references Cls (id),
    AccntGrntdGrntThis number,
    AccntGrntdGrntThisCls number,
    constraint FAccntGrntdGrntThis foreign key (AccntGrntdGrntThisCls) references Cls (id)    
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

create sequence SCrrncMngr nocache;

create table CrrncMngr(
    id number primary key,
    Cls number not null,
    CrrncMngrSbSrvc number,
    CrrncMngrSbSrvcCls number,
    constraint FCrrncMngrSbSrvc foreign key (CrrncMngrSbSrvcCls) references Cls (id),
    CrrncMngrThis number,
    CrrncMngrThisCls number,
    constraint FCrrncMngrThis foreign key (CrrncMngrThisCls) references Cls (id)    
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
    CrtBnkCMDAdmnstrtr number,
    CrtBnkCMDAdmnstrtrCls number,
    constraint FCrtBnkCMDAdmnstrtr foreign key (CrtBnkCMDAdmnstrtrCls) references Cls (id),
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


create sequence SCrtDbtGrntCMD nocache;

create table CrtDbtGrntCMD(
    id number primary key,
    Cls number not null,
    CrtDbtGrntCMDDbtGrntLst number,
    CrtDbtGrntCMDDbtGrntLstCls number,
    constraint FCrtDbtGrntCMDDbtGrntLst foreign key (CrtDbtGrntCMDDbtGrntLstCls) references Cls (id),
    CrtDbtGrntCMDRcvrBnkNmbr number,
    CrtDbtGrntCMDRcvrAccNmbr number,
    CrtDbtGrntCMDLmtTp varchar2(2000),
    CrtDbtGrntCMDAmnt varchar2(2000),
    CrtDbtGrntCMDCr varchar2(2000),
    CrtDbtGrntCMDInvoker number,
    CrtDbtGrntCMDInvokerCls number,
    constraint FCrtDbtGrntCMDInvoker foreign key (CrtDbtGrntCMDInvokerCls) references Cls (id),
    CrtDbtGrntCMDCReceiver number,
    CrtDbtGrntCMDCReceiverCls number,
    constraint FCrtDbtGrntCMDCReceiver foreign key (CrtDbtGrntCMDCReceiverCls) references Cls (id),
    CrtDbtGrntCMDMyCmmnDt number,
    CrtDbtGrntCMDMyCmmnDtCls number,
    constraint FCrtDbtGrntCMDMyCmmnDt foreign key (CrtDbtGrntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SExctCMD nocache;

create table ExctCMD(
    id number primary key,
    Cls number not null,
    ExctCMDInvoker number,
    ExctCMDInvokerCls number,
    constraint FExctCMDInvoker foreign key (ExctCMDInvokerCls) references Cls (id),
    ExctCMDCReceiver number,
    ExctCMDCReceiverCls number,
    constraint FExctCMDCReceiver foreign key (ExctCMDCReceiverCls) references Cls (id),
    ExctCMDMyCmmnDt number,
    ExctCMDMyCmmnDtCls number,
    constraint FExctCMDMyCmmnDt foreign key (ExctCMDMyCmmnDtCls) references Cls (id)    
);

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

create sequence SAccntSrvcSccssfl nocache;

create table AccntSrvcSccssfl(
    id number primary key,
    Cls number not null,
    AccntSrvcSccssflMstr number,
    AccntSrvcSccssflMstrCls number,
    constraint FAccntSrvcSccssflMstr foreign key (AccntSrvcSccssflMstrCls) references Cls (id),
    AccntSrvcSccssflObs number,
    AccntSrvcSccssflObsCls number,
    constraint FAccntSrvcSccssflObs foreign key (AccntSrvcSccssflObsCls) references Cls (id),
    AccntSrvcSccssflThis number,
    AccntSrvcSccssflThisCls number,
    constraint FAccntSrvcSccssflThis foreign key (AccntSrvcSccssflThisCls) references Cls (id)    
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

create sequence SDbtGrntLst nocache;

create table DbtGrntLst(
    id number primary key,
    Cls number not null,
    DbtGrntLstSbSrvc number,
    DbtGrntLstSbSrvcCls number,
    constraint FDbtGrntLstSbSrvc foreign key (DbtGrntLstSbSrvcCls) references Cls (id),
    DbtGrntLstThis number,
    DbtGrntLstThisCls number,
    constraint FDbtGrntLstThis foreign key (DbtGrntLstThisCls) references Cls (id)    
);

create sequence SAccntPx nocache;

create table AccntPx(
    id number primary key,
    Cls number not null,
    AccntPxAccnt number,
    AccntPxAccntCls number,
    constraint FAccntPxAccnt foreign key (AccntPxAccntCls) references Cls (id),
    AccntPxSbSrvc number,
    AccntPxSbSrvcCls number,
    constraint FAccntPxSbSrvc foreign key (AccntPxSbSrvcCls) references Cls (id),
    AccntPxThis number,
    AccntPxThisCls number,
    constraint FAccntPxThis foreign key (AccntPxThisCls) references Cls (id)    
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
    FxTrnsctnFVl number,
    FxTrnsctnFVlCls number,
    constraint FFxTrnsctnFVl foreign key (FxTrnsctnFVlCls) references Cls (id),
    PrcntlFPrcnt number,
    PrcntlFPrcntCls number,
    constraint FPrcntlFPrcnt foreign key (PrcntlFPrcntCls) references Cls (id),
    MxdFFx number,
    MxdFFxCls number,
    constraint FMxdFFx foreign key (MxdFFxCls) references Cls (id),
    MxdFPrcntl number,
    MxdFPrcntlCls number,
    constraint FMxdFPrcntl foreign key (MxdFPrcntlCls) references Cls (id),
    MxdFLmt number,
    MxdFLmtCls number,
    constraint FMxdFLmt foreign key (MxdFLmtCls) references Cls (id)    
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
    AccntGrntdGrnt number,
    AccntGrntdGrntCls number,
    constraint FAccntGrntdGrnt foreign key (AccntGrntdGrntCls) references Cls (id),
    AccntRcvdGrnt number,
    AccntRcvdGrntCls number,
    constraint FAccntRcvdGrnt foreign key (AccntRcvdGrntCls) references Cls (id),
    AccntSbSrvc number,
    AccntSbSrvcCls number,
    constraint FAccntSbSrvc foreign key (AccntSbSrvcCls) references Cls (id),
    AccntThis number,
    AccntThisCls number,
    constraint FAccntThis foreign key (AccntThisCls) references Cls (id)    
);
create index IAccntNmbrAccnt on Accnt (AccntAccntNmbr);
create index IMnAccnt on Accnt (AccntMn, AccntMnCls);
create index ILmtAccnt on Accnt (AccntLmt, AccntLmtCls);


create sequence SAdmnstrtrCrrncMngr nocache;

create table AdmnstrtrCrrncMngr(
    id number primary key,
    Cls number not null,
    AdmnstrtrCrrncMngrMstr number,
    AdmnstrtrCrrncMngrMstrCls number,
    constraint FAdmnstrtrCrrncMngrMstr foreign key (AdmnstrtrCrrncMngrMstrCls) references Cls (id),
    AdmnstrtrCrrncMngrObs number,
    AdmnstrtrCrrncMngrObsCls number,
    constraint FAdmnstrtrCrrncMngrObs foreign key (AdmnstrtrCrrncMngrObsCls) references Cls (id),
    AdmnstrtrCrrncMngrThis number,
    AdmnstrtrCrrncMngrThisCls number,
    constraint FAdmnstrtrCrrncMngrThis foreign key (AdmnstrtrCrrncMngrThisCls) references Cls (id)    
);

create sequence SDbTrNtExec nocache;

create table DbTrNtExec(
    id number primary key,
    Cls number not null,
    DbTrNtExecSbSrvc number,
    DbTrNtExecSbSrvcCls number,
    constraint FDbTrNtExecSbSrvc foreign key (DbTrNtExecSbSrvcCls) references Cls (id),
    DbTrNtExecThis number,
    DbTrNtExecThisCls number,
    constraint FDbTrNtExecThis foreign key (DbTrNtExecThisCls) references Cls (id)    
);

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


create sequence SDbtTrnSucc nocache;

create table DbtTrnSucc(
    id number primary key,
    Cls number not null,
    DbtTrnSuccSbSrvc number,
    DbtTrnSuccSbSrvcCls number,
    constraint FDbtTrnSuccSbSrvc foreign key (DbtTrnSuccSbSrvcCls) references Cls (id),
    DbtTrnSuccThis number,
    DbtTrnSuccThisCls number,
    constraint FDbtTrnSuccThis foreign key (DbtTrnSuccThisCls) references Cls (id)    
);

create sequence SAccntSrvcNtExctd nocache;

create table AccntSrvcNtExctd(
    id number primary key,
    Cls number not null,
    AccntSrvcNtExctdMstr number,
    AccntSrvcNtExctdMstrCls number,
    constraint FAccntSrvcNtExctdMstr foreign key (AccntSrvcNtExctdMstrCls) references Cls (id),
    AccntSrvcNtExctdObs number,
    AccntSrvcNtExctdObsCls number,
    constraint FAccntSrvcNtExctdObs foreign key (AccntSrvcNtExctdObsCls) references Cls (id),
    AccntSrvcNtExctdThis number,
    AccntSrvcNtExctdThisCls number,
    constraint FAccntSrvcNtExctdThis foreign key (AccntSrvcNtExctdThisCls) references Cls (id)    
);

create sequence SDbtGrnt nocache;

create table DbtGrnt(
    id number primary key,
    Cls number not null,
    DbtGrntPrmttdAccnt number,
    DbtGrntPrmttdAccntCls number,
    constraint FDbtGrntPrmttdAccnt foreign key (DbtGrntPrmttdAccntCls) references Cls (id),
    DbtGrntLmts number,
    DbtGrntLmtsCls number,
    constraint FDbtGrntLmts foreign key (DbtGrntLmtsCls) references Cls (id),
    DbtGrntSbSrvc number,
    DbtGrntSbSrvcCls number,
    constraint FDbtGrntSbSrvc foreign key (DbtGrntSbSrvcCls) references Cls (id),
    DbtGrntThis number,
    DbtGrntThisCls number,
    constraint FDbtGrntThis foreign key (DbtGrntThisCls) references Cls (id)    
);

create sequence SExctTrnsfrCMD nocache;

create table ExctTrnsfrCMD(
    id number primary key,
    Cls number not null,
    ExctTrnsfrCMDDbtTrnsfr number,
    ExctTrnsfrCMDDbtTrnsfrCls number,
    constraint FExctTrnsfrCMDDbtTrnsfr foreign key (ExctTrnsfrCMDDbtTrnsfrCls) references Cls (id),
    ExctTrnsfrCMDInvoker number,
    ExctTrnsfrCMDInvokerCls number,
    constraint FExctTrnsfrCMDInvoker foreign key (ExctTrnsfrCMDInvokerCls) references Cls (id),
    ExctTrnsfrCMDCReceiver number,
    ExctTrnsfrCMDCReceiverCls number,
    constraint FExctTrnsfrCMDCReceiver foreign key (ExctTrnsfrCMDCReceiverCls) references Cls (id),
    ExctTrnsfrCMDMyCmmnDt number,
    ExctTrnsfrCMDMyCmmnDtCls number,
    constraint FExctTrnsfrCMDMyCmmnDt foreign key (ExctTrnsfrCMDMyCmmnDtCls) references Cls (id)    
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

create sequence SCrrncMngrExchngRts nocache;

create table CrrncMngrExchngRts(
    id number primary key,
    frm number not null,
    CrrncMngrExchngRtsindxx number not null,
    CrrncMngrExchngRtsindxxCls number not null,
    constraint FCrrncMngrExchngRtsindxx foreign key (CrrncMngrExchngRtsindxxCls) references Cls (id),
    exchngRts number not null,
    Cls number not null,
    constraint FCrrncMngrExchngRtsCls foreign key(Cls) references Cls(id),
    constraint FCrrncMngrExchngRtsfrm foreign key(frm) references CrrncMngr(id)
);
create index IFrmCrrncMngrExchngRts on CrrncMngrExchngRts(frm);
create index IIndxxCrrncMngrExchngRts on CrrncMngrExchngRts(CrrncMngrExchngRtsindxx);

create sequence SCrrncMngrCrrncStck nocache;

create table CrrncMngrCrrncStck(
    id number primary key,
    frm number not null,
    crrncStck number not null,
    Cls number not null,
    constraint FCrrncMngrCrrncStckCls foreign key(Cls) references Cls(id),
    constraint FCrrncMngrCrrncStckfrm foreign key(frm) references CrrncMngr(id)
);
create index IFrmCrrncMngrCrrncStck on CrrncMngrCrrncStck(frm);

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

create sequence SDbtGrntLstDbtGrnts nocache;

create table DbtGrntLstDbtGrnts(
    id number primary key,
    frm number not null,
    dbtGrnts number not null,
    Cls number not null,
    constraint FDbtGrntLstDbtGrntsCls foreign key(Cls) references Cls(id),
    constraint FDbtGrntLstDbtGrntsfrm foreign key(frm) references DbtGrntLst(id)
);
create index IFrmDbtGrntLstDbtGrnts on DbtGrntLstDbtGrnts(frm);

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

create sequence SDbTrNtExecNtExctds nocache;

create table DbTrNtExecNtExctds(
    id number primary key,
    frm number not null,
    ntExctds number not null,
    Cls number not null,
    constraint FDbTrNtExecNtExctdsCls foreign key(Cls) references Cls(id),
    constraint FDbTrNtExecNtExctdsfrm foreign key(frm) references DbTrNtExec(id)
);
create index IFrmDbTrNtExecNtExctds on DbTrNtExecNtExctds(frm);

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
create sequence SDbtTrnSuccSccssfls nocache;

create table DbtTrnSuccSccssfls(
    id number primary key,
    frm number not null,
    sccssfls number not null,
    Cls number not null,
    constraint FDbtTrnSuccSccssflsCls foreign key(Cls) references Cls(id),
    constraint FDbtTrnSuccSccssflsfrm foreign key(frm) references DbtTrnSucc(id)
);
create index IFrmDbtTrnSuccSccssfls on DbtTrnSuccSccssfls(frm);

