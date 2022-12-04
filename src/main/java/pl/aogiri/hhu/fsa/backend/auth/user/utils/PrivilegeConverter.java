package pl.aogiri.hhu.fsa.backend.auth.user.utils;


import pl.aogiri.hhu.fsa.backend.auth.user.enums.Privilege;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PrivilegeConverter implements AttributeConverter<Privilege, String> {

    @Override
    public String convertToDatabaseColumn(Privilege attribute) {
        return attribute.name();
    }

    @Override
    public Privilege convertToEntityAttribute(String dbData) {
        return Privilege.valueOf(dbData);
    }
}
