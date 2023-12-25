package org.tz;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;



@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Obj {
    @JsonProperty("OBJECTID")
    private Integer objectId; // идентификатор адреса
    @JsonProperty("NAME")
    private String name; // название адреса
    @JsonProperty("TYPENAME")
    private String typeName; // тип адреса
    @JsonProperty("STARTDATE")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate startDate; // начало действия адреса
    @JsonProperty("ENDDATE")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate endDate; // окончание действия адреса
    @JsonProperty("ISACTUAL")
    private String isActual; // актуальность адреса
    @JsonProperty("ISACTIVE")
    private String isActive; // активность адреса


    @Override
    public String toString() {
        return objectId +
                ": " + name + " " +
                 typeName;
    }

}
