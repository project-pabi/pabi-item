package com.pabi.pabiitem.domain.item;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;


public class ItemInfo {

  @Getter
  @AllArgsConstructor
  public static class Main {

    private Long id;
    private String name;
    private List<String> state;
    private List<String> keyword;
    private String explanation;
  }
}