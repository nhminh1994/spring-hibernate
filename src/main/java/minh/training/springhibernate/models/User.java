package minh.training.springhibernate.models;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.springframework.security.core.GrantedAuthority;
@Entity
@Table(name = "users", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String username;
  private String password;
  private Boolean enabled;
  public User() {
  }
  public User(final String username, final String password, final Boolean enabled) {
    this.username = username;
    this.password = password;
    this.enabled = enabled;
  }
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  public Integer getId() {
    return this.id;
  }
  public void setId(final Integer id) {
    this.id = id;
  }
  @Column(name = "username", unique = true, length = 45)
  public String getUsername() {
    return this.username;
  }
  public void setUsername(final String username) {
    this.username = username;
  }
  @Column(name = "password")
  public String getPassword() {
    return this.password;
  }
  public void setPassword(final String password) {
    this.password = password;
  }
  @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1)")
  public Boolean getEnabled() {
    return this.enabled;
  }
  public void setEnabled(final Boolean enabled) {
    this.enabled = enabled;
  }
  
  @Transient
  public List<GrantedAuthority> getAuthorities() {
    return new ArrayList<GrantedAuthority>();
  }
}
