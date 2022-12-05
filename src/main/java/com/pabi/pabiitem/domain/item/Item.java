package com.pabi.pabiitem.domain.item;

import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import java.util.List;
import java.util.UUID;
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
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PROTECTED)
@TypeDefs({
    @TypeDef(name = "string-list", typeClass = ListArrayType.class),
    @TypeDef(name = "enum-list", typeClass = EnumArrayType.class)
})
public class Item {

  @Column(unique = true)
  private String uuid = UUID.randomUUID().toString();

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Length(max = 100)
  private String title;

  @Type(
      type = "com.vladmihalcea.hibernate.type.array.ListArrayType",
      parameters = {
          @Parameter(
              name = ListArrayType.SQL_ARRAY_TYPE,
              value = "item_state"
          )
      }
  )
  @Column(columnDefinition = "item_state[]")
  private List<ItemState> state;

  @Type(type = "string-list")
  @Column(columnDefinition = "text[]")
  private List<String> keyword;

  @Length(max = 3000)
  private String content;

  @Enumerated(EnumType.STRING)
  private AuctionType auctionType;

  @Enumerated(EnumType.STRING)
  private ItemCategory itemCategory;

  private Long startPrice;

  private Long endPrice;

  @Embedded
  private DirectTradeLocation tradeLocation;

  public static Item createItem(ItemCommand.ItemCreateRequest command) {
    Item item = new Item();
    item.setTitle(command.getTitle());
    item.setAuctionType(command.getAuctionType());
    item.setItemCategory(command.getItemCategory());
    item.setContent(command.getContent());
    item.setState(command.getState());
    item.setKeyword(command.getKeyword());
    item.setStartPrice(command.getStartPrice());
    item.setEndPrice(command.getEndPrice());
    item.setTradeLocation(command.getTradeLocation());
    return item;
  }

  public void update(ItemCommand.ItemUpdateRequest command) {
    this.title = command.getTitle();
    this.tradeLocation = command.getTradeLocation();
    this.content = command.getContent();
    this.startPrice = command.getStartPrice();
    this.state = command.getState();
  }
}
