package com.pabi.pabiitem.domain.item;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Embeddable
@Setter(PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class DirectTradeLocation {

  private String lat;
  private String lng;
  private String address;
  private String oldAddress;
}
