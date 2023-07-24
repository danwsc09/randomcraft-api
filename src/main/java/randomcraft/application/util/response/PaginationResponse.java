package randomcraft.application.util.response;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PaginationResponse<T, C> {
    private long total = 0;
    private boolean hasNextPage = false;
    private List<C> items = new ArrayList<>();

    public PaginationResponse(Page<T> page) {
        hasNextPage = page.hasNext();
        total = page.getTotalElements();
    }

    public PaginationResponse(Page<T> page, List<C> itemsList) {
        hasNextPage = page.hasNext();
        total = page.getTotalElements();
        items = itemsList;
    }

    public void setItems(List<C> itemsList) {
        items = itemsList;
    }
}
