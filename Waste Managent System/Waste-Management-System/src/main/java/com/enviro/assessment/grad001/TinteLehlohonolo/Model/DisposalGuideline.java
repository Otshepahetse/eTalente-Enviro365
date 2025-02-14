package com.enviro.assessment.grad001.TinteLehlohonolo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Disposal Guidelines")
@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The disposal guideline can not be empty!")
    private String disposalGuideline;

    @ManyToOne
    @JoinColumn(name = "waste_category_Id",nullable = false)
    private WasteCategory wasteCategory;

    public @NotBlank(message = "The disposal guideline can not be empty!") String getDisposalGuideline() {
        return disposalGuideline;
    }

    public void setDisposalGuideline(@NotBlank(message = "The disposal guideline can not be empty!") String disposalGuideline) {
        this.disposalGuideline = disposalGuideline;
    }
}
