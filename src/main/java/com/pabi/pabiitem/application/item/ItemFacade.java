package com.pabi.pabiitem.application.item;

import com.pabi.pabiitem.domain.item.ItemInfo.Main;
import com.pabi.pabiitem.domain.item.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemFacade {

  private final ItemService itemService;

  public List<Main> getItemList() {
    return itemService.getItemList();
  }
}
