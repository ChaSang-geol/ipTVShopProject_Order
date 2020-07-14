package ipTVShopProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


@RestController
 public class OrderController {

  @Autowired
  OrderRepository orderRepository;

  @RequestMapping(method=RequestMethod.PATCH, path="/Orders")
  public void orderCancel(@RequestParam(value="orderId", required=false, defaultValue="0") Long orderId) {

   Optional<Order> orders = orderRepository.findById(orderId);
   orders.get().setId(orderId);
   orders.get().setStatus("CANCELORDERED");
   orderRepository.save(orders.get());
  }


 }
