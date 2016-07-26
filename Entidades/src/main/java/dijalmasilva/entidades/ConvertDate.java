/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.entidades;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author dijalma
 */
@Converter(autoApply = true)
public class ConvertDate implements AttributeConverter<LocalDate, Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDate x) {
        return Date.valueOf(x);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date y) {
        return y.toLocalDate();
    }
    
}
