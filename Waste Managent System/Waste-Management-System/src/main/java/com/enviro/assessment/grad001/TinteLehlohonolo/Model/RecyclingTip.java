package com.enviro.assessment.grad001.TinteLehlohonolo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Recycling Tips")
@Entity

public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Recycling tip can not be empty!")
    @Column(name = "recycling_Id")
    private String recyclingTip;

    @ManyToOne
    @JoinColumn(name = "waste_category_Id")
    private WasteCategory wasteCategory;

    public @NotBlank(message = "Recycling tip can not be empty!") String getRecyclingTip() {
        return recyclingTip;
    }

    public void setRecyclingTip(@NotBlank(message = "Recycling tip can not be empty!") String recyclingTip) {
        this.recyclingTip = recyclingTip;
    }
}
