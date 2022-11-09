package br.com.pagseguro.servicelayer.mapper;

import br.com.pagseguro.servicelayer.controller.response.BillsResponse;
import br.com.pagseguro.servicelayer.model.BillsModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BillsMapper {
    BillsMapper INSTANCE = Mappers.getMapper(BillsMapper.class);

    BillsResponse modelToResponse(BillsModel billsModel);

}
