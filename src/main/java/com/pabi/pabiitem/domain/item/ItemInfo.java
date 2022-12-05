package com.pabi.pabiitem.domain.item;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;


public class ItemInfo {

  @Getter
  @AllArgsConstructor
  public static class Main {

    private Long id;
    private String title;
    private List<ItemState> state;
    private List<String> keyword;
    private String content;
    private AuctionType auctionType;
    private ItemCategory itemCategory;
    private Long startPrice;
    private Long endPrice;
    private DirectTradeLocation tradeLocation;
  }
}
