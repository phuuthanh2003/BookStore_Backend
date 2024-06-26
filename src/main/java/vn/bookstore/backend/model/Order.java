package vn.bookstore.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "purchase_address", columnDefinition = "nvarchar(512)")
    private String purchaseAddress;

    @Column(name = "delivery_address", columnDefinition = "nvarchar(512)")
    private String deliveryAddress;

    @Column(name = "total_price_book")
    private double totalPriceBook;

    @Column(name = "shipping_price")
    private double shippingPrice;

    @Column(name = "payment_price")
    private double paymentPrice;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> orderItems;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinColumn(name = "payment_id")
    @JsonBackReference
    private Payment payment;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinColumn(name = "shipment_id")
    @JsonBackReference
    private Shipment shipment;
}
