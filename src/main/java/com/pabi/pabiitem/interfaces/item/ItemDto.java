package com.pabi.pabiitem.interfaces.item;

import com.pabi.pabiitem.domain.item.AuctionType;
import com.pabi.pabiitem.domain.item.DirectTradeLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ItemDto {

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @ApiModel(value = "경매 물품 기본 Request")
  public static class ItemRequest{
    @ApiModelProperty(value = "이름", required = true)
    private String name;
    @ApiModelProperty(value = "상태", required = true)
    private List<String> state;
    @ApiModelProperty(value = "키워드", required = true)
    private List<String> keyword;
    @ApiModelProperty(value = "상세설명", required = true)
    private String explanation;
    @ApiModelProperty(value = "경매방식", required = true)
    private AuctionType auctionType;
    @ApiModelProperty(value = "시작가", required = true)
    private Long startPrice;
    @ApiModelProperty(value = "구매가", required = true)
    private Long endPrice;
    @ApiModelProperty(value = "직거래장소", required = true)
    private DirectTradeLocation tradeLocation;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  @ApiModel(value = "경매 물픔 기본 Response ")
  public static class ItemResponse {


    @ApiModelProperty(value = "PK ID", required = true)
    private Long id;
    @ApiModelProperty(value = "이름", required = true)
    private String name;
    @ApiModelProperty(value = "상태", required = true)
    private List<String> state;
    @ApiModelProperty(value = "키워드", required = true)
    private List<String> keyword;
    @ApiModelProperty(value = "상세설명", required = true)
    private String explanation;
    @ApiModelProperty(value = "경매방식", required = true)
    private AuctionType auctionType;
    @ApiModelProperty(value = "시작가", required = true)
    private Long startPrice;
    @ApiModelProperty(value = "구매가", required = true)
    private Long endPrice;
    @ApiModelProperty(value = "직거래장소", required = true)
    private DirectTradeLocation tradeLocation;

  }
}
