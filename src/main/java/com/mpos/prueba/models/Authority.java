package com.mpos.prueba.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mpos.prueba.enums.EAuthorityName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authority_mpos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 50)
    @Enumerated(EnumType.STRING)
    private EAuthorityName name;

    @JsonIgnore
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<User> users;

}