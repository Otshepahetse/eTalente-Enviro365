package com.enviro.assessment.grad001.TinteLehlohonolo.Service;

import com.enviro.assessment.grad001.TinteLehlohonolo.Model.RecyclingTip;
import com.enviro.assessment.grad001.TinteLehlohonolo.Model.WasteCategory;
import com.enviro.assessment.grad001.TinteLehlohonolo.Repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.TinteLehlohonolo.Repository.WasteCategoryRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.*;

import java.util.List;

@Validated
@Service
public class RecyclingTipService {
    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public RecyclingTip addRecyclingTip(@Valid @NotNull RecyclingTip recyclingTip){
        return recyclingTipRepository.save(recyclingTip);
    }

    public List<RecyclingTip>getAllRecyclingTips(){
        return recyclingTipRepository.findAll();
    }

    public RecyclingTip getRecyclingTipById(Long id){
        return recyclingTipRepository.findById(id).orElseThrow(()->new RuntimeException("Recycling tip was not found by ID: "+ id));
    }

    public List<RecyclingTip> getRecyclingTipByWasteCategoryId(Long wasteCategoryId){
        return recyclingTipRepository.findByWasteCategoryId(wasteCategoryId);
    }

    public RecyclingTip updateRecyclingTip(Long id,@Valid @NotNull RecyclingTip updatedRecyclingTip){
        RecyclingTip existingRecyclingTip = recyclingTipRepository.findById(id).orElseThrow(()->new RuntimeException("Recycling Tip can not be found by ID: "+id));

        existingRecyclingTip.setRecyclingTip(updatedRecyclingTip.getRecyclingTip());
        return recyclingTipRepository.save(existingRecyclingTip);
    }

    public void deleteRecyclingTip(Long id){
        RecyclingTip existingRecyclingTip = recyclingTipRepository.findById(id).orElseThrow(()-> new RuntimeException("Recycling Tip not found with ID: "+id));

        recyclingTipRepository.delete(existingRecyclingTip);
    }
}
