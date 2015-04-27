package houseware.learn.spring.batch.case04;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.math.BigDecimal;

/**
 * @author fphilip@houseware.es
 */
@Data
@Entity(name = "airports")
public class Airport {

    @Id
    @Column
    private String iata;
    @Column
    private String icao;
    @Column
    private String name;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private BigDecimal lat;
    @Column
    private BigDecimal lon;
    @Column
    private BigDecimal alt;
}
