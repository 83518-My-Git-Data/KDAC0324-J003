package com.washease.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClothTypeMaterialMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mappingId;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private ClothType clothType;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private ClothMaterial clothMaterial;
}
