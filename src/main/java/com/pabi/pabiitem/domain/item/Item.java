package com.pabi.pabiitem.domain.item;

import com.pabi.pabiitem.domain.item.ItemCommand.ItemRequest;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PROTECTED)
@TypeDef(name = "string-list", typeClass = ListArrayType.class)
public class Item {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  private String name;

  @Type(type = "string-list")
  @Column(columnDefinition = "text[]", nullable = false)
  private List<String> state;

  @Type(type = "string-list")
  @Column(columnDefinition = "text[]", nullable = false)
  private List<String> keyword;

  @Length(max = 3000)
  private String explanation;

  @Enumerated(EnumType.STRING)
  private AuctionType auctionType;

  private Long startPrice;

  private Long endPrice;

  //directTransPlace 직거래 장소 객체로 추후 추가
  @Embedded
  private DirectTradeLocation tradeLocation;

  public static Item createItem(ItemCommand.ItemRequest command) {
    Item item = new Item();
    item.setName(command.getName());
    item.setAuctionType(command.getAuctionType());
    item.setExplanation(command.getExplanation());
    item.setState(command.getState());
    item.setKeyword(command.getKeyword());
    item.setStartPrice(command.getStartPrice());
    item.setEndPrice(command.getEndPrice());
    item.setTradeLocation(command.getTradeLocation());
    return item;
  }

  public void update(ItemRequest command) {
    this.name = command.getName();
    this.tradeLocation = command.getTradeLocation();
    this.explanation = command.getExplanation();
    this.startPrice = command.getStartPrice();
  }
}
