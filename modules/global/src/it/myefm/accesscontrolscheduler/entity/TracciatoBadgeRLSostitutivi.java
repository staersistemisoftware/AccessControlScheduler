package it.myefm.accesscontrolscheduler.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.github.ffpojo.metadata.positional.annotation.PositionalField;
import com.github.ffpojo.metadata.positional.annotation.PositionalRecord;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|serialNumberBadgeRL")
@Table(name = "ACCESSCONTROLSCHEDULER_TRACCIATO_BADGE_RL_SOSTITUTIVI")
@Entity(name = "accesscontrolscheduler$TracciatoBadgeRLSostitutivi")
@PositionalRecord
public class TracciatoBadgeRLSostitutivi extends StandardEntity implements IFlusso {
    private static final long serialVersionUID = -4994326860747358209L;

    @Column(name = "SERIAL_NUMBER_BADGE_RL", length = 16)
    @PositionalField(initialPosition = 1, finalPosition = 16)
    protected String serialNumberBadgeRL;

    @Column(name = "TIPOLOGIA_TESSERA_BADGE_RL", length = 1)
    @PositionalField(initialPosition = 17, finalPosition = 17)
    protected String tipologiaTesseraBadgeRL;

    @Column(name = "DESCRIZIONE_TIPOLOGIA_BADGE")
    protected String descrizioneTipologiaBadge;

    @Temporal(TemporalType.DATE)
    @Column(name = "TIME_STAMP")
    protected Date timeStamp;

    public void setSerialNumberBadgeRL(String serialNumberBadgeRL) {
        this.serialNumberBadgeRL = serialNumberBadgeRL;
    }

    public String getSerialNumberBadgeRL() {
        return serialNumberBadgeRL;
    }

    public void setTipologiaTesseraBadgeRL(String tipologiaTesseraBadgeRL) {
        this.tipologiaTesseraBadgeRL = tipologiaTesseraBadgeRL;
    }

    public String getTipologiaTesseraBadgeRL() {
        return tipologiaTesseraBadgeRL;
    }

    public void setDescrizioneTipologiaBadge(String descrizioneTipologiaBadge) {
        this.descrizioneTipologiaBadge = descrizioneTipologiaBadge;
    }

    public String getDescrizioneTipologiaBadge() {
        return descrizioneTipologiaBadge;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String toString(){
        String out="\n\n-------------------------------------"
                +"\nserialNumberBadgeRL: "+                                           serialNumberBadgeRL
                +"\ntipologiaTesseraBadgeRL: "+                                       tipologiaTesseraBadgeRL
                +"\ndescrizioneTipologiaBadge: "+                                     descrizioneTipologiaBadge
                +"\ntimeStamp:"+ timeStamp;

        return out;
    }


}