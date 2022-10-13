package com.pabi.pabiitem.domain.item;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {

  private final ItemReader itemReader;
  private final ItemStore itemStore;
  private final ItemMapper itemMapper;

  @Override
  @Transactional(readOnly = true)
  public List<ItemInfo.Main> getItemList() {
    return itemMapper.of(itemReader.getItemList());
  }

  @Override
  @Transactional
  public long createItem(ItemCommand.ItemRequest command) {
    return itemStore.createItem(command);
  }

  @Override
  @Transactional
  public void updateItem(Long id, ItemCommand.ItemRequest command) {
    Item item = itemReader.getItem(id);
    itemStore.updateItem(item, command);
  }

  @Override
  @Transactional
  public void deleteItem(Long id) {
    itemStore.deleteItem(id);
  }


}
