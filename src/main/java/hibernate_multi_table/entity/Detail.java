package hibernate_multi_table.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Detail {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "empDetail", cascade = CascadeType.ALL)
    private Employee employee;


    public Detail(String city, int phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
