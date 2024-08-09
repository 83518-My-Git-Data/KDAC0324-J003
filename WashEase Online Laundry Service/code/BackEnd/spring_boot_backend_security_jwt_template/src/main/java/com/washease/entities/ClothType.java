package com.washease.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClothType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", nullable = false)
    private Long typeId;

    @Column(nullable = false)
    private String clothTypeName;

    @OneToMany(mappedBy = "clothType")
    private List<ClothTypeMaterialMapping> clothTypeMaterialMappings;
}
