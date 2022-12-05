package com.pabi.pabiitem.application.item;

import com.pabi.pabiitem.domain.item.ItemCommand;
import com.pabi.pabiitem.domain.item.ItemInfo;
import com.pabi.pabiitem.domain.item.ItemService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemFacade {

  private final ItemService itemService;

  public List<ItemInfo.Main> getItemList() {
    return itemService.getItemList();
  }

  public long createItem(String uuid, @Valid ItemCommand.ItemCreateRequest command){
    return itemService.createItem(command, uuid);
  }

  public void updateItem(Long id, ItemCommand.ItemUpdateRequest command) {
    itemService.updateItem(id, command);
  }

  public void deleteItem(Long id) {
    itemService.deleteItem(id);
  }



}
