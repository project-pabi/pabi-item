package com.pabi.pabiitem.infrastructure.item;

import com.pabi.pabiitem.domain.item.Item;
import com.pabi.pabiitem.domain.item.ItemReader;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemReaderImpl implements ItemReader {

  private final ItemRepository itemRepository;

  @Override
  public List<Item> getItemList() {
    List<Item> all = itemRepository.findAll();
    return all;
  }
}
