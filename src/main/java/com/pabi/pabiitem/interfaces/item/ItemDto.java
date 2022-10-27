package com.pabi.pabiitem.interfaces.item;

import com.pabi.pabiitem.domain.item.AuctionType;
import com.pabi.pabiitem.domain.item.DirectTradeLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

public class ItemDto {

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @ApiModel(value = "경매 물품 생성 Request")
  @Valid
  public static class ItemCreateRequest{
    @NotNull
    @NotBlank
    @Size(min = 1, max = 50, message = "제목은 50자를 넘을 수 없습니다.")
    @ApiModelProperty(value = "제목", required = true)
    private String title;

    @ApiModelProperty(value = "상태")
    private List<String> state;

    @ApiModelProperty(value = "키워드")
    private List<String> keyword;

    @NotNull
    @NotBlank
    @Length(max = 1500, message = "내용은 1500자를 넘을 수 없습니다.")
    @ApiModelProperty(value = "상세내용", required = true)
    private String content;

    @ApiModelProperty(value = "경매방식", required = true)
    private AuctionType auctionType;

    @NotNull
    @ApiModelProperty(value = "시작가", required = true)
    private Long startPrice;
    @ApiModelProperty(value = "구매가", required = false)
    private Long endPrice;
    @ApiModelProperty(value = "직거래장소", required = true)
    private DirectTradeLocation tradeLocation;
  }

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @ApiModel(value = "경매 물품 변경 Request")
  public static class ItemUpdateRequest{
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50, message = "제목은 50자를 넘을 수 없습니다.")
    @ApiModelProperty(value = "제목", required = true)
    private String title;

    @ApiModelProperty(value = "상태")
    private List<String> state;

    @ApiModelProperty(value = "키워드")
    private List<String> keyword;

    @NotNull
    @NotBlank
    @Length(max = 1500, message = "내용은 1500자를 넘을 수 없습니다.")
    @ApiModelProperty(value = "상세내용", required = true)
    private String content;

    @ApiModelProperty(value = "경매방식", required = true)
    private AuctionType auctionType;

    @NotNull
    @ApiModelProperty(value = "시작가", required = true)
    private Long startPrice;
    @ApiModelProperty(value = "구매가", required = false)
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
    private String title;
    @ApiModelProperty(value = "상태")
    private List<String> state;
    @ApiModelProperty(value = "키워드")
    private List<String> keyword;
    @ApiModelProperty(value = "상세설명", required = true)
    private String content;
    @ApiModelProperty(value = "경매방식", required = true)
    private AuctionType auctionType;
    @ApiModelProperty(value = "시작가", required = true)
    private Long startPrice;
    @ApiModelProperty(value = "구매가")
    private Long endPrice;
    @ApiModelProperty(value = "직거래장소", required = true)
    private DirectTradeLocation tradeLocation;

  }
}
