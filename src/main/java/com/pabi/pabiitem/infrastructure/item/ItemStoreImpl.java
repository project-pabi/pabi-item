package com.pabi.pabiitem.infrastructure.item;

import com.pabi.pabiitem.domain.item.Item;
import com.pabi.pabiitem.domain.item.ItemCommand;
import com.pabi.pabiitem.domain.item.ItemStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemStoreImpl implements ItemStore {

  private final ItemRepository itemRepository;


  @Override
  public long createItem(ItemCommand.ItemRequest command) {
    Item commandItem = Item.createItem(command);
    Item item = itemRepository.save(commandItem);
    return item.getId();
  }

  @Override
  public void updateItem(Item item, ItemCommand.ItemRequest command) {
    item.update(command);
  }

  @Override
  public void deleteItem(Long id) {
    itemRepository.deleteById(id);
  }
}
