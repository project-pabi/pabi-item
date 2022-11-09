package com.pabi.pabiitem.domain.item;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class ItemCommand {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class ItemCreateRequest{

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50, message = "제목은 50자를 넘을 수 없습니다.")
    private String title;
    private List<ItemState> state;
    private List<String> keyword;
    @NotNull
    @NotBlank
    @Length(max = 1500, message = "내용은 1500자를 넘을 수 없습니다.")
    private String content;
    private AuctionType auctionType;
    private ItemCategory itemCategory;
    @NotNull
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
