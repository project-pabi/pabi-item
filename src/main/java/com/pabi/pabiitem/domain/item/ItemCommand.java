package com.pabi.pabiitem.domain.item;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ItemCommand {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class ItemRequest{

    private String name;
    private List<String> state;
    private List<String> keyword;
    private String explanation;
    private AuctionType auctionType;
    private Long startPrice;
    private Long endPrice;
    private DirectTradeLocation tradeLocation;
  }
}
