package it.myefm.accesscontrolscheduler.core;

import com.github.ffpojo.FFPojoHelper;
import com.github.ffpojo.exception.FFPojoException;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import it.myefm.accesscontrolscheduler.entity.IFlusso;
import it.myefm.accesscontrolscheduler.entity.TracciatoBadgeRLSostitutivi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.LinkedHashMap;

public class Factory {

    private static Logger log = LoggerFactory.getLogger(ReadTracciatoBadgeRLSostitutiviCron.class);

    protected DataManager dataManager = AppBeans.get(DataManager.class);
    private CommitContext commitContext;


   //sistema di campo
    private String typeOfCA;

    private long sequence=0L;

    // contiene una collezione di items di uno dei 5 flussi ammessi: TracciatoAnagrafiche, TracciatoRiferimentiImpianto, TracciatoBadgeRLSostitutivi, TracciatoDatiCARilevati, TracciatoParametriChallengeResponse
    // l'indicizzazione dipende da typeOfFlusso, per consetire il ripetersi delle chiavi viene aggiunta una sequence

    // TracciatoAnagrafiche: codiceFiscale_sequence
    // TracciatoRiferimentiImpianto: codice_sequence
    // TracciatoBadgeRLSostitutivi: serialNumber_sequence
    // TracciatoDatiCARilevati: codiceFiscale_sequence
    // TracciatoParametriChallengeResponse: serialNumber_sequence
    private LinkedHashMap<String,IFlusso> elementsOfFlusso=new LinkedHashMap<String,IFlusso>();

    public void insertElementOfFlusso(String key,IFlusso elementOfFlusso){
        elementsOfFlusso.put(key+"_"+sequence, elementOfFlusso);
        sequence++;
    }

    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String errorMessage) {
        this.message = errorMessage;
    }

    public String getTypeOfCA() {
        return typeOfCA;
    }

    public void setTypeOfCA(String typeOfCA) {
        this.typeOfCA = typeOfCA;
    }



    public boolean readBadgeRLSostitutiviFromText(String fileName) {

        boolean returnStatus=false;

        if(getTypeOfCA().equalsIgnoreCase(Helper.VAM)){
            returnStatus=readBadgeRLSostitutiviFromTextVAM(fileName);
        }else if(getTypeOfCA().equalsIgnoreCase(Helper.DESIGO)){
            //TBD
        }else if(getTypeOfCA().equalsIgnoreCase(Helper.EBI)){
            //TBD
        }

        return returnStatus;
    }

    public boolean readBadgeRLSostitutiviFromTextVAM(String fileName) {

        commitContext = new CommitContext();

        boolean returnStatus=false;
        String message=""+new Date()+" problem parsing "+fileName;
        int lineNumber=0;

        FFPojoHelper ffpojo = FFPojoHelper.getInstance();

        try{
            FileReader in = new FileReader(fileName);
            BufferedReader textFileReader = new BufferedReader(in);

            String line;

            while ( (line = textFileReader.readLine()) != null) {

                try{
                    TracciatoBadgeRLSostitutivi badgeRLSostitutivi=ffpojo.createFromText(TracciatoBadgeRLSostitutivi.class, line);
                    log.info(badgeRLSostitutivi.toString()+"\nline:"+lineNumber);
                    commitContext.addInstanceToCommit(badgeRLSostitutivi);
                    //elementsOfFlusso.put(badgeRLSostitutivi.getSerialNumberBadgeRL()+"_"+sequence, badgeRLSostitutivi);
                    sequence++;

                    lineNumber++;

                }catch(FFPojoException e){

                    returnStatus=false;
                    message=message+"\nreason: the record , at number of line "+lineNumber+", with content:"+line +" is invalid"
                            +"\nparser exception:"+e;
                    break;
                }

            }
            textFileReader.close();

        }catch(Exception ex){
            returnStatus=false;
            message=message
                    +"\nreason: file not found exception:"+ex;
        }

        if(!message.contains("reason")){
            returnStatus=true;
            message="\nprocessed "+lineNumber+" lines of badgeRLSostitutivi records ";
            dataManager.commit(commitContext);

        }

        setMessage(message);
        return returnStatus;
    }

}