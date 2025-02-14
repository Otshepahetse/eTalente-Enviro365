package com.enviro.assessment.grad001.TinteLehlohonolo.Service;

import com.enviro.assessment.grad001.TinteLehlohonolo.Model.DisposalGuideline;
import com.enviro.assessment.grad001.TinteLehlohonolo.Model.WasteCategory;
import com.enviro.assessment.grad001.TinteLehlohonolo.Repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.TinteLehlohonolo.Repository.WasteCategoryRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class DisposalGuidelineService {
    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public DisposalGuideline addDisposalGuideline( @Valid @NotNull DisposalGuideline disposalGuideline){
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    public List<DisposalGuideline>getAllDisposalGuidelines(){
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline getDisposalGuidelineById(Long id){
        return disposalGuidelineRepository.findById(id).orElseThrow(()->new RuntimeException("Disposal Guideline not found by ID: "+id));
    }

    public List<DisposalGuideline>getDisposalGuidelineByWasteCategoryId(Long wasteCategoryId){
        return disposalGuidelineRepository.findByWasteCategoryId(wasteCategoryId);
    }

    public DisposalGuideline updateDisposalGuideline(Long id,@Valid @NotNull DisposalGuideline updatedDisposalGuideline){
        DisposalGuideline existingDisposalGuideline = disposalGuidelineRepository.findById(id).orElseThrow(()->new RuntimeException("Disposal Guideline not found by ID: "+id));
        existingDisposalGuideline.setDisposalGuideline(updatedDisposalGuideline.getDisposalGuideline());

        return disposalGuidelineRepository.save(existingDisposalGuideline);
    }

    public void deleteDisposalGuideline(Long id){
        DisposalGuideline existingDisposalGuideline = disposalGuidelineRepository.findById(id).orElseThrow(()->new RuntimeException("Disposal Guideline not found by ID: "+id));
        disposalGuidelineRepository.delete(existingDisposalGuideline);
    }

}
