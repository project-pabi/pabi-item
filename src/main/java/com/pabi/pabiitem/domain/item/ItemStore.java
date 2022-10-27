package com.pabi.pabiitem.domain.item;

public interface ItemStore {

  long createItem(ItemCommand.ItemCreateRequest command);

  void updateItem(Item item, ItemCommand.ItemUpdateRequest command);

  void deleteItem(Long id);

}
