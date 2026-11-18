package se.systementor.l10.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokemon_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "nickname", nullable = false, length = 100)
    private String nickname;

    @Column(name = "max_hp", nullable = false)
    private Integer maxHp;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    protected Pokemon() {
        // Krävs av JPA.
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public String getType() {
        return type;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return String.format("%s (%d HP) [%s]", name, maxHp, type);
    }
}
