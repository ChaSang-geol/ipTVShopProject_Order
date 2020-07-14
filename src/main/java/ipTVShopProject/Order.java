package ipTVShopProject;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String status;
    private Long productId;
    private String productName;
    private String installationAddress;
    private Long customerId;
    private String orderDate;

    @PostPersist
    public void onPostPersist(){

        if(this.getStatus().equals("JOINORDED")){
            System.out.println("00000000000JOINORDED000000000000");
            JoinOrdered joinOrdered = new JoinOrdered();
            BeanUtils.copyProperties(this, joinOrdered);
            joinOrdered.publishAfterCommit();
        }else if(this.getStatus().equals("ORDERCANCELED")){
            System.out.println("00000000000ORDERCANCELED000000000000");
            OrderCanceled orderCanceled = new OrderCanceled();
            orderCanceled.setStatus("ORDERCANCELED");
            orderCanceled.publishAfterCommit();
        }else if(this.getStatus().equals("ORDERCANCELREJECTED")){
            System.out.println("000000000ORDERCANCELREJECTED00000000000000");
            OrderCancelRejected orderCancelRejected = new OrderCancelRejected();
            orderCancelRejected.setStatus("ORDERCANCELREJECTED");
            orderCancelRejected.publishAfterCommit();
        }else if(this.getStatus().equals("JOINORDERCOMPLETE")){
            System.out.println("00000000000000JOINORDERCOMPLETE000000000");
            JoinOrderCompleted joinOrderCompleted = new JoinOrderCompleted();
            joinOrderCompleted.setStatus("JOINORDERCOMPLETE");
            joinOrderCompleted.publishAfterCommit();

        }



//        joinOrdered.setId(this.getId());
//        joinOrdered.setStatus(this.getStatus());
//        joinOrdered.setProductId(this.getProductId());
//        System.out.println("00000000000000000000000");
//        if("1001".equals(this.getProductId())){
//            joinOrdered.setProductName("인터넷");
//            System.out.println("1111111111111111");
//        }else if("1002".equals(this.getProductId())){
//            joinOrdered.setProductName("인터넷+BTV");
//            System.out.println("222222222222222222222222");
//        }
//
//        //joinOrdered.setProductName(this.getProductName());
//        joinOrdered.setInstallationAddress(this.getInstallationAddress());
//        joinOrdered.setCustomerId(this.getCustomerId());
//        System.out.println("333333333333333333333333333");



    }

    @PostUpdate
    public void onPostUpdate(){

        CancelOrdered cancelOrdered = new CancelOrdered();
        BeanUtils.copyProperties(this, cancelOrdered);
        cancelOrdered.publishAfterCommit();


        OrderCanceled orderCanceled = new OrderCanceled();
        BeanUtils.copyProperties(this, orderCanceled);
        orderCanceled.publishAfterCommit();


        OrderCancelRejected orderCancelRejected = new OrderCancelRejected();
        BeanUtils.copyProperties(this, orderCancelRejected);
        orderCancelRejected.publishAfterCommit();


        JoinOrderCompleted joinOrderCompleted = new JoinOrderCompleted();
        BeanUtils.copyProperties(this, joinOrderCompleted);
        joinOrderCompleted.publishAfterCommit();

//        if("CANCELORDERED".equals(this.getStatus())){
//            CancelOrdered cancelOrdered = new CancelOrdered();
//
//            cancelOrdered.setId(this.getId());
//            cancelOrdered.setStatus(this.getStatus());
//            cancelOrdered.setProductId(this.getProductId());
//            cancelOrdered.setProductName(this.getProductName());
//            cancelOrdered.setInstallationAddress(this.getInstallationAddress());
//            cancelOrdered.setCustomerId(this.getCustomerId());
//            cancelOrdered.setOrderDate(this.getOrderDate());
//
//            cancelOrdered.publishAfterCommit();
//
//        }else if("ORDERCANCELED".equals(this.getStatus())){
//            OrderCanceled orderCanceled = new OrderCanceled();
//
//            orderCanceled.setStatus(this.getStatus());
//
//            orderCanceled.publishAfterCommit();
//
//        }else if("ORDERCANCELREJECTED".equals(this.getStatus())){
//            OrderCancelRejected orderCancelRejected = new OrderCancelRejected();
//
//            orderCancelRejected.setStatus(this.getStatus());
//
//            orderCancelRejected.publishAfterCommit();
//
//        }else if("JOINORDERCOMPLETE".equals(this.getStatus())){
//            JoinOrderCompleted joinOrderCompleted = new JoinOrderCompleted();
//
//            joinOrderCompleted.setId(this.getId());
//            joinOrderCompleted.setStatus(this.getStatus());
//
//            joinOrderCompleted.publishAfterCommit();
//
//        }


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(String installationAddress) {
        this.installationAddress = installationAddress;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }




}
