package it.myefm.accesscontrolscheduler.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ReadTracciatoBadgeRLSostitutiviCron implements java.util.concurrent.Callable {

    private static Logger log = LoggerFactory.getLogger(ReadTracciatoBadgeRLSostitutiviCron.class);

    @Override
    public Object call() throws Exception {

        log.info("Enter in ReadTracciatoBadgeRLSostitutiviCron ++++++++++++++++++++++++++++++++++++++++++");

        String fileName="badgerlsostitutivi.txt";
        String path="C:/Users/DavideP/workspace/ZFixedLengthTest_FFPOJO/in";

        testReadBadgeRLSostitutivi(path,fileName);

        return null;
    }

    public static void testReadBadgeRLSostitutivi(String path,String fileName) {

        Date start=new Date();
        log.info("Start computing at :"+start);
        String fileNameWithPath=path+"/"+fileName;

        Factory factory=new Factory();
        factory.setTypeOfCA(Helper.VAM);

        if(factory.readBadgeRLSostitutiviFromText(fileNameWithPath)){
            log.info("\n"+new Date()+" file "+fileNameWithPath+" successfully parsed"+factory.getMessage());
        }else{
            log.info("\n"+factory.getMessage());
        }

        Date end=new Date();
        log.info("End computing in :"+(end.getTime()-start.getTime())/1000L+" secs");

    }
}
