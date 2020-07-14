package ipTVShopProject;

import ipTVShopProject.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @StreamListener(KafkaProcessor.INPUT)
    public void onEvent(@Payload String message) {

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverJoinCompleted_JoinCompletionNotify(@Payload JoinCompleted joinCompleted){

        if(joinCompleted.isMe() && joinCompleted.getStatus()!=null){

            System.out.println("111111111111111111111111111111111111111111111" );

            Order order = new Order();
            order.setStatus(joinCompleted.getStatus());
            orderRepository.save(order);
            System.out.println("##### listener JoinCompletionNotify status : " + joinCompleted.getStatus());

        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelNotAccepted_OrderCancelImpossible(@Payload OrderCancelNotAccepted orderCancelNotAccepted){

        if(orderCancelNotAccepted.isMe() && orderCancelNotAccepted.getStatus()!=null){

            System.out.println("22222222222222222222222222222222222222222222" );

            Order order = new Order();
            //order.setCustomerId(orderCancelNotAccepted.);
            order.setInstallationAddress(orderCancelNotAccepted.getInstallationAddress());
            //order.setOrderDate(orderCancelNotAccepted.);
            //order.setProductId(orderCancelNotAccepted.getp);
            //order.setProductName(orderCancelNotAccepted.);
            order.setStatus(orderCancelNotAccepted.getStatus());
            order.setId(orderCancelNotAccepted.getId());
            orderRepository.save(order);



            System.out.println("##### listener OrderCancelImpossible status : " + orderCancelNotAccepted.getStatus());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelAccepted_OrderCancelAccept(@Payload OrderCancelAccepted orderCancelAccepted){

        if(orderCancelAccepted.isMe() && orderCancelAccepted.getStatus()!=null){

            System.out.println("333333333333333333333333333333333333333333" );

            Order order = new Order();
            //order.setCustomerId(orderCancelAccepted.getcu);
            order.setInstallationAddress(orderCancelAccepted.getInstallationAddress());
            //order.setOrderDate(orderCancelAccepted.);
            //order.setProductId(orderCancelAccepted.getp);
            //order.setProductName(orderCancelAccepted.);
            order.setStatus(orderCancelAccepted.getStatus());
            order.setId(orderCancelAccepted.getId());
            orderRepository.save(order);

            System.out.println("##### listener OrderCancelAccept status : " + orderCancelAccepted.getStatus());
            System.out.println("##### listener OrderCancelAccept status : " + orderCancelAccepted.toJson());
        }
    }

}
