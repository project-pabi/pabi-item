package com.pabi.pabiitem.domain.item;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ItemCommand {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class ItemCreateRequest{

    private String title;
    private List<String> state;
    private List<String> keyword;
    private String content;
    private AuctionType auctionType;
    private Long startPrice;
    private Long endPrice;
    private DirectTradeLocation tradeLocation;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  public static class ItemUpdateRequest{

    private String id;
    private String title;
    private List<String> state;
    private List<String> keyword;
    private String content;
    private AuctionType auctionType;
    private Long startPrice;
    private Long endPrice;
    private DirectTradeLocation tradeLocation;
  }
}
