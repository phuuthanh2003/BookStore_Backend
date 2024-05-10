package vn.bookstore.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name", columnDefinition = "nvarchar(255)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "nvarchar(255)")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private char gender;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "purchase_address", columnDefinition = "nvarchar(255)")
    private String purchaseAddress;

    @Column(name = "delivery_address", columnDefinition = "nvarchar(255)")
    private String deliveryAddress;

    @Column(name = "is_activated")
    private boolean isActivated;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "avatar", columnDefinition = "nvarchar(MAX)")
    @Lob
    private String avatar;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JsonManagedReference
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JsonManagedReference
    private List<WishList> wishlists;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Role> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JsonManagedReference
    private List<Order> orders;
}
