package com.pabi.pabiitem.domain.item;

public interface ItemStore {

  long createItem(ItemCommand.ItemRequest command);

  void updateItem(Item item, ItemCommand.ItemRequest command);

  void deleteItem(Long id);

}
