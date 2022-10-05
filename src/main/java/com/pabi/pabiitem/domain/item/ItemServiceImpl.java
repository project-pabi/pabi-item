package com.pabi.pabiitem.domain.item;

import com.pabi.pabiitem.domain.item.ItemInfo.Main;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {

  private final ItemReader itemReader;
  private final ItemMapper itemMapper;

  @Override
  @Transactional(readOnly = true)
  public List<Main> getItemList() {
    return itemMapper.of(itemReader.getItemList());
  }
}
