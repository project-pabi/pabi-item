package com.pabi.pabiitem.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemState {
  CLEAN("깨끗해요"),
  NEW("새거에요"),
  NO_BOX("박스 X"),
  HAVE_BOX("박스 O"),
  HAVE_WARRANTY("보증서있어요"),
  HAVE_RECEIPT("영수증있어요"),
  NORMAL("사용감있어요"),
  OLD("오래됐어요");

  private final String value;

  public String getValue() { return this.value; }
}
