package com.pabi.pabiitem.domain.item;

import java.util.List;

public interface ItemService {

  List<ItemInfo.Main> getItemList();

  long createItem(ItemCommand.ItemRequest command);

  void updateItem(Long id, ItemCommand.ItemRequest command);

  void deleteItem(Long id);
}
