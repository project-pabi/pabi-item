package com.pabi.pabiitem.domain.item;

import java.util.List;

public interface ItemService {

  List<ItemInfo.Main> getItemList();

  long createItem(ItemCommand.ItemCreateRequest command);

  void updateItem(Long id, ItemCommand.ItemUpdateRequest command);

  void deleteItem(Long id);
}
