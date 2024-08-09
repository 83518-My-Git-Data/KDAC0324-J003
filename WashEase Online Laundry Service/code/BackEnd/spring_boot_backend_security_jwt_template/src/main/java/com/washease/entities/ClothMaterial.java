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
public class ClothMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id", nullable = false)
    private Long materialId;

    @Column(nullable = false)
    private String materialName;

    @OneToMany(mappedBy = "clothMaterial")
    private List<ClothTypeMaterialMapping> clothTypeMaterialMappings;
}

