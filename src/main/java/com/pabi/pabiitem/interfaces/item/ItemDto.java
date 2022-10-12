package com.pabi.pabiitem.interfaces.item;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ItemDto {

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
  }
}
