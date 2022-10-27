package shoponlineapi.dto;

import lombok.Data;
import shoponlineapi.enlity.OrderService;

import java.util.List;

@Data
public class ErrorDTO {
    private String message;
    private List<String> messageList;
    private OrderService orderService;
}
