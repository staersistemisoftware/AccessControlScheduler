-- begin ACCESSCONTROLSCHEDULER_TRACCIATO_BADGE_RL_SOSTITUTIVI
create table ACCESSCONTROLSCHEDULER_TRACCIATO_BADGE_RL_SOSTITUTIVI (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SERIAL_NUMBER_BADGE_RL varchar(16),
    TIPOLOGIA_TESSERA_BADGE_RL varchar(1),
    DESCRIZIONE_TIPOLOGIA_BADGE varchar(255),
    TIME_STAMP date,
    --
    primary key (ID)
)^
-- end ACCESSCONTROLSCHEDULER_TRACCIATO_BADGE_RL_SOSTITUTIVI
