package com.pabi.pabiitem.interfaces.item;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ItemDto {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class ItemResponse {

    private Long id;
    private String name;
    private List<String> state;
    private List<String> keyword;
    private String explanation;
  }
}
