package houseware.learn.spring.batch.case04;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class AirportFieldSetMapper implements FieldSetMapper<Airport> {

    public Airport mapFieldSet(FieldSet fieldSet) throws BindException {

        Airport airport = new Airport();
        airport.setIata(fieldSet.readString("IATA"));
        airport.setName(fieldSet.readString("NAME"));
        airport.setCity(fieldSet.readString("CITY"));
        airport.setCountry(fieldSet.readString("COUNTRY"));
        airport.setLat(fieldSet.readBigDecimal("LAT"));
        airport.setLon(fieldSet.readBigDecimal("LON"));
        airport.setAlt(fieldSet.readBigDecimal("ALT"));
        return airport;
    }

}
