package com.pabi.pabiitem.domain.item;

import com.pabi.pabiitem.interfaces.item.ItemDto;
import java.util.List;

public interface ItemService {

  List<ItemInfo.Main> getItemList();

  long createItem(ItemCommand.ItemCreateRequest command, String uuid);

  void updateItem(Long id, ItemCommand.ItemUpdateRequest command);

  void deleteItem(Long id);

  ItemDto.ItemKafkaRequest send(String topic, ItemDto.ItemKafkaRequest itemDto);
}
