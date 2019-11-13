package api_TrasportiLogistic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Truck {
    @Getter
    private GoodsKind goodsTransported;
    @Getter
    private double capacity;
    @Getter @Setter
    private LocalDateTime freeFrom;

    /**
     * BUILDER
     * @param goods type it can carry
     * @param cap quantity of Goods it can carry
     */
    private Truck(GoodsKind goods, double cap){
        goodsTransported = goods;
        capacity = cap;
        freeFrom = LocalDateTime.now();
    }

    /**
     * @param goods type it can carry
     * @param cap quantity of Goods it can carry
     * @return a new Truck, ready to go
     */
    Truck BuyTruck(GoodsKind goods, double cap){
        return new Truck(goods, cap);
    }

    /**
     * @return type of Goods it can carry
     */
    GoodsKind GoodsTransported(){ return getGoodsTransported(); }

    /**
     * @return quantity of Goods it can carry
     */
    double Capacity(){ return getCapacity(); }

    /**
     * @return date from witch is ready
     */
    LocalDateTime IsFreeFrom(){ return getFreeFrom(); }

    /**
     * The truck is loaded, it will be free again after this booking
     * @param date when current booking ends
     */
    void LoadGoods(LocalDateTime date){ setFreeFrom(date); }

    /**
     * The truck is unloaded, it is free for a new booking
     */
    void UnloadGoods(){ setFreeFrom(LocalDateTime.now()); }
}
