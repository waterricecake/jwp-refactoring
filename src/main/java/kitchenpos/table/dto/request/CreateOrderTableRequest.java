package kitchenpos.table.dto.request;

public class CreateOrderTableRequest {

    private Integer numberOfGuests;

    private CreateOrderTableRequest() {
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }
}
