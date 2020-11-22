package udemy.entity;

import javax.persistence.*;

@MappedSuperclass
public class KeyEntity {

    @Id
    @Column(name = "PK", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;


}
