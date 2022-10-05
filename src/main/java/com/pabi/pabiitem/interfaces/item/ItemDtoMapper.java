package com.pabi.pabiitem.interfaces.item;

import com.pabi.pabiitem.domain.item.ItemInfo.Main;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ItemDtoMapper {

  List<ItemDto.ItemResponse> of(List<Main> info);
}
