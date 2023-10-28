package kitchenpos.table.dto.request;

import java.util.List;

public class CreateTableGroupRequest {

    private Long id;
    private List<OrderTableRequest> orderTables;

    private CreateTableGroupRequest() {
    }

    public Long getId() {
        return id;
    }

    public List<OrderTableRequest> getOrderTables() {
        return orderTables;
    }
}
