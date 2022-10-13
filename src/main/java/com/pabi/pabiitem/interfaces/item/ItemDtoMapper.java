package com.pabi.pabiitem.interfaces.item;

import com.pabi.pabiitem.domain.item.ItemCommand;
import com.pabi.pabiitem.domain.item.ItemInfo;
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

  ItemCommand.ItemRequest of(ItemDto.ItemRequest request);
  List<ItemDto.ItemResponse> of(List<ItemInfo.Main> info);
}
