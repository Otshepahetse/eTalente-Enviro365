package com.enviro.assessment.grad001.TinteLehlohonolo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Waste Category")
@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Waste Category can not be empty!")
    @Column(name = "wasteCategory_Id")
    private String wasteCategory;

    @NotBlank(message = "Waste item can not be empty!")
    @Column(name = "wasteItem_Id")
    private String wasteItem;

    @NotBlank(message = "Waste Description can not be empty!")
    private String wasteDescription;

    @OneToMany(mappedBy = "wasteCategory",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RecyclingTip>recyclingTips;

    @OneToMany(mappedBy = "wasteCategory",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DisposalGuideline>disposalGuidelines;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Waste Category can not be empty!") String getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(@NotBlank(message = "Waste Category can not be empty!") String wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public @NotBlank(message = "Waste item can not be empty!") String getWasteItem() {
        return wasteItem;
    }

    public void setWasteItem(@NotBlank(message = "Waste item can not be empty!") String wasteItem) {
        this.wasteItem = wasteItem;
    }

    public @NotBlank(message = "Waste Description can not be empty!") String getWasteDescription() {
        return wasteDescription;
    }

    public void setWasteDescription(@NotBlank(message = "Waste Description can not be empty!") String wasteDescription) {
        this.wasteDescription = wasteDescription;
    }

    public List<RecyclingTip> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<RecyclingTip> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }

    public List<DisposalGuideline> getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(List<DisposalGuideline> disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }
}
