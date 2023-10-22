package kitchenpos.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import kitchenpos.dto.request.product.CreateProductRequest;
import kitchenpos.dto.response.ProductResponse;
import kitchenpos.util.ObjectCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("상품 테스트")
class ProductServiceTest extends ServiceTest {

    @Autowired
    private ProductService productService;

    @DisplayName("상품을 생성한다")
    @Test
    void create()
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final int newProductId = productService.list().size() + 1;
        final CreateProductRequest request = ObjectCreator.getObject(CreateProductRequest.class, "test", BigDecimal.valueOf(100));

        // when
        final ProductResponse actual = productService.create(request);

        // then
        assertThat(actual.getId()).isEqualTo(newProductId);
    }

    @DisplayName("상품 가격이 음수일 시 실패한다")
    @Test
    void create_FailPrice()
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final CreateProductRequest request = ObjectCreator.getObject(CreateProductRequest.class, "test", BigDecimal.valueOf(-1));

        // when
        assertThatThrownBy(() -> productService.create(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 목록을 조회한다")
    @Test
    void list() {
        // given & when
        final List<ProductResponse> actual = productService.list();

        // then
        assertThat(actual).hasSize(2);
    }
}
