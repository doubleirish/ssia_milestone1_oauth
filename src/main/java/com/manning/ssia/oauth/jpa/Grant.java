package com.manning.ssia.oauth.jpa;

import lombok.Data;

import javax.persistence.*;

/*
create table if not exists GRANT (
    ID INT auto_increment   primary key,
    GRANT VARCHAR(50) not null,
    CLIENT_ID INT not null,
    constraint GRANT_CLIENT_ID_FK
        foreign key (CLIENT_ID) references CLIENT (ID)
);
*/
@Data
@Entity
public class Grant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String grant;
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client ;

    public Grant() {
    }

    @Override
    public String toString() {
        return "Grant{" +
                "id=" + id +
                ", grant='" + grant + '\'' +
                '}';
    }
}
