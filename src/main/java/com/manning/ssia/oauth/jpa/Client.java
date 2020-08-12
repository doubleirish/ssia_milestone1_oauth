package com.manning.ssia.oauth.jpa;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Client {
  @Id
  private Integer id;
  private String name;
  private String secret;
  @Column(name = "redirect_uri")
  private String redirectUri;
  private String scope;

  @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<Grant> grants;


}
