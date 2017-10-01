package it.myefm.accesscontrolscheduler.core;

import java.util.HashMap;

public class Helper {
    public final static String VAM="vam";
    public final static String DESIGO="desigo";
    public final static String EBI="ebi";
    public final static String BLANK_CHARACTER=" ";

    public final static String Z1="01";
    public final static String Z0="00";
    public final static String ZD="ZD";

    public final static String ZD01=ZD+Z1;
    public final static String ZD00=ZD+Z0;

    public final static String HRM="HRM";
    public final static String START_START="**";
    public final static String FLAG_CONTROLLO="0";
    public final static String LINGUA="I";


    public final static String CODICE_INFORMAZIONE="*FZY5B";
    public final static String CODICE_MOVIMENTO="0";

    public final static String ENTRATA="E";
    public final static String USCITA="U";


    public final static String FILLER00="00";

    private final static HashMap<String,String> DIREZIONE=new HashMap<>();

    public static void initDirezione(){

        if(DIREZIONE.isEmpty()){
            DIREZIONE.put(ENTRATA, "Entrata");
            DIREZIONE.put(USCITA, "Uscita");
        }
    }

    public static String getDescrizioneVersoFromVerso(String verso){
        String out="Sconosciuto";

        if(DIREZIONE.get(verso)!=null && !DIREZIONE.get(verso).isEmpty()){
            out=DIREZIONE.get(verso);
        }

        return out;
    }


    public final static HashMap<String,String> REPERTORI_HASH=new HashMap<String,String>();


    public static void initRepertoriHash(){
        // 7 livelli di accesso
        REPERTORI_HASH.put("Z13","Codice Diritto di Accesso Perimetrale Presenza");				REPERTORI_HASH.put("Z15","Codice Fascia Oraria Perimetrale Presenza");
        REPERTORI_HASH.put("Z14","Codice Diritto di Accesso Perimetrale Transito");				REPERTORI_HASH.put("Z16","Codice Fascia Oraria Perimetrale Transito");
        REPERTORI_HASH.put("Z17","Codice Diritto di Accesso Parcheggio");						REPERTORI_HASH.put("Z19","Codice Fascia Oraria Parcheggi");
        REPERTORI_HASH.put("Z18","Codice Diritto di Accesso Parcheggi  Carraio / Pedonale");	REPERTORI_HASH.put("Z20","Codice Fascia Oraria Parcheggi Carraio / Pedonale");
        REPERTORI_HASH.put("Z21","Codice Diritto di Accesso II Livello Riservata");				REPERTORI_HASH.put("Z23","Codice Fascia Oraria II Livello Riservata");
        REPERTORI_HASH.put("Z22","Codice Diritto di Accesso II Livello Dedicata");				REPERTORI_HASH.put("Z24","Codice Fascia Oraria II Livello Dedicata");
        REPERTORI_HASH.put("Z25","Codice Diritto di Accesso Ascensore");						REPERTORI_HASH.put("Z26","Codice Fascia Oraria di Accesso Ascensore");

        REPERTORI_HASH.put("Z27","Codice Terminale/Varco");
    }


    private final static HashMap<String,String> DESCRIZIONE_CODICE_LIVELLO_BUILDING=new HashMap<>();

    public final static String PRESENZA_ACCESSO_VARCO_PERIMETRALE = "1";
    public final static String ACCESSO_VARCO_SICUREZZA_IILIVELLO = "2";
    public final static String ACCESSO_VARCO_PARCHEGGI = "3";
    public final static String ACCESSO_VARCO_PERIMETRALE="4";
    public final static String ACCESSO_BIS_SICUREZZA_IILIVELLO="5";
    public final static String ACCESSO_BIS_VARCO_PARCHEGGI="6";
    public final static String ACCESSO_VARCO_ASCENSORI="7";

    public static void initDescrizioneCodiceLievelloBuilding(){

        if(DESCRIZIONE_CODICE_LIVELLO_BUILDING.isEmpty()){

            DESCRIZIONE_CODICE_LIVELLO_BUILDING.put(PRESENZA_ACCESSO_VARCO_PERIMETRALE, "Presenza  e accesso su varco perimetrale");
            DESCRIZIONE_CODICE_LIVELLO_BUILDING.put(ACCESSO_VARCO_SICUREZZA_IILIVELLO, "Accesso su varco di Sicurezza di II Livello");
            DESCRIZIONE_CODICE_LIVELLO_BUILDING.put(ACCESSO_VARCO_PARCHEGGI, "Accesso su varco ai Parcheggi");
            DESCRIZIONE_CODICE_LIVELLO_BUILDING.put(ACCESSO_VARCO_PERIMETRALE, "Accesso su varco perimetrale");
            DESCRIZIONE_CODICE_LIVELLO_BUILDING.put(ACCESSO_BIS_SICUREZZA_IILIVELLO, "Accesso bis su varco di Sicurezza di II Livello");
            DESCRIZIONE_CODICE_LIVELLO_BUILDING.put(ACCESSO_BIS_VARCO_PARCHEGGI, "Accesso bis su varco ai Parcheggi");
            DESCRIZIONE_CODICE_LIVELLO_BUILDING.put(ACCESSO_VARCO_ASCENSORI, "Accesso su varco Ascensori");
        }
    }

    public static String getDescrizioneCodiceLievelloBuildingFromCodiceLievelloBuilding(String codiceLievelloBuilding){
        String out="Sconosciuto";

        if(DESCRIZIONE_CODICE_LIVELLO_BUILDING.get(codiceLievelloBuilding)!=null && !DESCRIZIONE_CODICE_LIVELLO_BUILDING.get(codiceLievelloBuilding).isEmpty()){
            out=DESCRIZIONE_CODICE_LIVELLO_BUILDING.get(codiceLievelloBuilding);
        }

        return out;
    }


    public final static String BADGERL = "2";
    public final static String BADGERL_SPECIAL = "3";
    public final static String BADGERL_SOSTITUTIVO = "4";
    public final static String BADGERL_VISITATORE_OCCASIONALE="5";
    public final static String BADGERL_AUTO_SERVIZIO_REGISTRATE="6"; //6 = CRS Personale ???
    public final static String BADGERL_PERSONALE_PARTICOLARE="7";

    private final static HashMap<String,String> DESCRIZIONE_BADGE=new HashMap<>();

    public static void initDescrizioneBadge(){

        if(DESCRIZIONE_BADGE.isEmpty()){
            DESCRIZIONE_BADGE.put(BADGERL, "Badge RL");
            DESCRIZIONE_BADGE.put(BADGERL_SPECIAL, "Badge RL special");
            DESCRIZIONE_BADGE.put(BADGERL_SOSTITUTIVO, "Badge RL sostitutivo");
            DESCRIZIONE_BADGE.put(BADGERL_VISITATORE_OCCASIONALE, "Badge RL visitatore occasionale");
            DESCRIZIONE_BADGE.put(BADGERL_AUTO_SERVIZIO_REGISTRATE, "Badge RL auto di servizio registrate"); //6 = CRS Personale ???
            DESCRIZIONE_BADGE.put(BADGERL_PERSONALE_PARTICOLARE, "Badge RL Personale particolare");
        }
    }


    public static String getDescrizioneTipologiaBadgeFromTipologiaBadge(String tipologiaBadge){
        String out="Sconosciuto";

        if(DESCRIZIONE_BADGE.get(tipologiaBadge)!=null && !DESCRIZIONE_BADGE.get(tipologiaBadge).isEmpty()){
            out=DESCRIZIONE_BADGE.get(tipologiaBadge);
        }

        return out;
    }

    public final static String USCITA_PER_SERVIZIO = "1";
    public final static String ANNULLAMENTO_ANTIPASS_BACK = "2";
    public final static String USCITA_PAUSA_FUMATORE = "3";

    private final static HashMap<String,String> DESCRIZIONE_CODICE_CAUSALIZZAZIONE=new HashMap<>();

    public static void initDescrizioneCodiceCausalizzazione(){

        if(DESCRIZIONE_CODICE_CAUSALIZZAZIONE.isEmpty()){
            DESCRIZIONE_CODICE_CAUSALIZZAZIONE.put(USCITA_PER_SERVIZIO, "Uscita per Servizio");
            DESCRIZIONE_CODICE_CAUSALIZZAZIONE.put(ANNULLAMENTO_ANTIPASS_BACK, "Annullamento antipass-back");
            DESCRIZIONE_CODICE_CAUSALIZZAZIONE.put(USCITA_PAUSA_FUMATORE, "Uscita per pausa Fumatore");
        }
    }

    public static String getDescrizioneCodiceCausalizzazioneFromCodiceCausalizzazione(String codiceCausalizzazione){
        String out="Sconosciuto";

        if(DESCRIZIONE_CODICE_CAUSALIZZAZIONE.get(codiceCausalizzazione)!=null && !DESCRIZIONE_CODICE_CAUSALIZZAZIONE.get(codiceCausalizzazione).isEmpty()){
            out=DESCRIZIONE_CODICE_CAUSALIZZAZIONE.get(codiceCausalizzazione);
        }
        return out;
    }


    public final static String MOTO = "M";
    public final static String GPL = "GPL";

    private final static HashMap<String,String> TIPO_VEICOLO_ALIMENTAZIONE=new HashMap<>();

    public static void initDescrizioneTipoVeico_Alimentazione(){

        if(TIPO_VEICOLO_ALIMENTAZIONE.isEmpty()){
            TIPO_VEICOLO_ALIMENTAZIONE.put(MOTO, "M");
            TIPO_VEICOLO_ALIMENTAZIONE.put(GPL, "GPL");
        }
    }

    public static String getDescrizioneTipoVeico_Alimentazione(String tipoVeicolo_Alimentazione){
        String out="Sconosciuto";

        if(TIPO_VEICOLO_ALIMENTAZIONE.get(tipoVeicolo_Alimentazione)!=null && !TIPO_VEICOLO_ALIMENTAZIONE.get(tipoVeicolo_Alimentazione).isEmpty()){
            out=TIPO_VEICOLO_ALIMENTAZIONE.get(tipoVeicolo_Alimentazione);
        }
        return out;
    }


    public final static String CODICE_APPLICATIVO_VAM = "5";
    public final static String DESCRIZIONE_CODICE_APPLICATIVO_VAM = "CA VAM Selesta";

    public final static String NATURA_B = "B";
    public final static String DESCRIZIONE_NATURA_B = "timbratura da terminale Badge RL";

    public static String getBlankFiller(int numberOfCharacter){
        String out="";

        for(int i=0;i<numberOfCharacter;i++){
            out=out+BLANK_CHARACTER;
        }

        return out;
    }


    public static String getBlankPadding(String value,int numberOfCharacter){
        String out=value;

        if(value.length()<numberOfCharacter){
            for(int i=value.length();i<numberOfCharacter;i++){
                out=out+BLANK_CHARACTER;
            }
        }else{
            out=out.substring(0, numberOfCharacter);
        }
        return out;
    }


    private String searchForRepertori(String repertorio){
        String description="";

        for(String riferimento: REPERTORI_HASH.keySet() ){
            if(riferimento.equalsIgnoreCase(repertorio)){
                description=REPERTORI_HASH.get(riferimento);
                break;
            }
        }

        return description;
    }

}
