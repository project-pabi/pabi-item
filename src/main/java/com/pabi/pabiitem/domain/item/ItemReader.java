package com.pabi.pabiitem.domain.item;

import java.util.List;

public interface ItemReader {

  List<Item> getItemList();

  Item getItem(Long id);
}
