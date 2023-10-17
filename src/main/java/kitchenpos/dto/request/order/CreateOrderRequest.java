package kitchenpos.dto.request.order;

import java.util.List;
import kitchenpos.dto.OrderLineItemsDto;

public class CreateOrderRequest {

    private Long  orderTableId;
    private List<OrderLineItemsDto> orderLineItems;

    public Long getOrderTableId() {
        return orderTableId;
    }

    public List<OrderLineItemsDto> getOrderLineItems() {
        return orderLineItems;
    }
}
